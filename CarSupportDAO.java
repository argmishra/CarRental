package com.ul.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.ul.project.dto.BookingDetail;
import com.ul.project.dto.CarDetail;
import com.ul.project.dto.FeedbackDetail;
import com.ul.project.dto.UserDetail;
import com.ul.project.factories.DataBaseFactory;

public class CarSupportDAO implements  ICarSupportDAO {

	@Override
	public void savingFeebdback(FeedbackDetail feedback) throws Exception {
		Connection connection = DataBaseFactory.getConnection("mysql");
		String insertSql = "INSERT INTO FEEDBACK  (title, description) VALUES (?,?)";
		PreparedStatement preapredStatement = connection.prepareStatement(insertSql);
		preapredStatement.setString(1, feedback.getTitle());
		preapredStatement.setString(2, feedback.getDescription());
		preapredStatement.executeUpdate();
		
	}

	@Override
	public ArrayList<BookingDetail> gettingBookingHistory() throws Exception {
		Connection connection = DataBaseFactory.getConnection("mysql");
		Statement stmt = connection.createStatement();
		String sql = "SELECT * FROM CARBOOKING";
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList<BookingDetail> blist = new ArrayList<BookingDetail>();
		BookingDetail bdetail = null;
		while(rs.next()){
			bdetail = new BookingDetail();
			bdetail.setCardid(rs.getString("carid"));
			bdetail.setBookingid(rs.getString("bookid"));
			bdetail.setPaymentType(rs.getString("ptype"));
			blist.add(bdetail);
		}
		return blist;
	}
	
	@Override
	public ArrayList<UserDetail> gettingAllAvailableUsers() throws Exception {
		Connection connection = DataBaseFactory.getConnection("mysql");
		Statement stmt = connection.createStatement();
		String sql = "SELECT * FROM USERDETAIL";
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList<UserDetail> ulist = new ArrayList<UserDetail>();
		UserDetail udetail = null;
		while(rs.next()){
			udetail = new UserDetail();
			udetail.setName(rs.getString("name"));
			udetail.setUsername(rs.getString("username"));
			udetail.setEmail(rs.getString("email"));
			udetail.setNumber(rs.getString("number"));
			ulist.add(udetail);
		}
		return ulist;
	}

	@Override
	public ArrayList<FeedbackDetail> gettingAllAvailableFeedbacks() throws Exception {
		Connection connection = DataBaseFactory.getConnection("mysql");
		Statement stmt = connection.createStatement();
		String sql = "SELECT * FROM FEEDBACK";
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList<FeedbackDetail> fblist = new ArrayList<FeedbackDetail>();
		FeedbackDetail fbdetail = null;
		while(rs.next()){
			fbdetail = new FeedbackDetail();
			fbdetail.setTitle(rs.getString("title"));
			fbdetail.setDescription(rs.getString("description"));
			fblist.add(fbdetail);
		}
		return fblist;
	}

	@Override
	public ArrayList<CarDetail> gettingAllAvailableCars() throws Exception {
		Connection connection = DataBaseFactory.getConnection("mysql");
		Statement stmt = connection.createStatement();
		String sql = "SELECT * FROM CARDETAIL";
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList<CarDetail> cdlist = new ArrayList<CarDetail>();
		CarDetail carDetail = null;
		while(rs.next()){
			carDetail = new CarDetail();
			carDetail.setId(rs.getInt("id"));
			carDetail.setName(rs.getString("name"));
			carDetail.setModel(rs.getString("model"));
			carDetail.setSeat(rs.getString("seat"));
			carDetail.setPrice(rs.getString("price"));
			carDetail.setShare(rs.getString("share"));
			carDetail.setStatus(rs.getString("status"));

			cdlist.add(carDetail);
		}
		return cdlist;
	}

	public static void resetBookingStatus() throws Exception{
		Connection connection = DataBaseFactory.getConnection("mysql");
		String updateSql = 	"UPDATE CARDETAIL SET status='UnBooked'";
		Statement statement = connection.createStatement();
		statement.executeUpdate(updateSql);
		
	}

}
