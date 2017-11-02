package com.ul.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.ul.project.dto.BookingDetail;
import com.ul.project.dto.CarDetail;
import com.ul.project.factories.DataBaseFactory;

public class CarRentalDao implements ICarRentalDao{

	@Override
	public void addingNewCar(CarDetail detail)
			throws Exception {
		Connection connection = DataBaseFactory.getConnection("mysql");
		String insertSql = "INSERT INTO CARDETAIL (name, model, seat, price,share,status) VALUES (?, ?, ?, ?,?,?)";
		PreparedStatement statement = connection.prepareStatement(insertSql);
		statement.setString(1, detail.getName());
		statement.setString(2, detail.getModel());
		statement.setString(3, detail.getSeat());
		statement.setString(4, detail.getPrice());
		statement.setString(5, detail.getShare());
		statement.setString(6, detail.getStatus());
		statement.executeUpdate();
	}


	@Override
	public int gettingCarId() throws Exception {
		int idForCar = 0;
		Connection connection = DataBaseFactory.getConnection("mysql");	
		Statement statement = connection.createStatement();
		String getIdSql = "SELECT * FROM CARDETAIL ORDER BY id DESC LIMIT 1";
		ResultSet rs = statement.executeQuery(getIdSql);
		while(rs.next()){
			idForCar =  rs.getInt("id");
		}
		return idForCar;
	}


	@Override
	public CarDetail gettingCarDetails(String id) throws Exception {
		Connection connection = DataBaseFactory.getConnection("mysql");
		Statement statement = connection.createStatement();
		String selectSql = "SELECT * FROM CARDETAIL where id = '"+id+"'";
		ResultSet rs = statement.executeQuery(selectSql);
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

		}

		return carDetail;
	}


	@Override
	public void bookingCar(String bookingCarId,BookingDetail detail) throws Exception {
		Connection connection = DataBaseFactory.getConnection("mysql");
		String bookingSql = "INSERT INTO CARBOOKING (carid,ptype) VALUES (?,?)";
		PreparedStatement statement = connection.prepareStatement(bookingSql);
		statement.setString(1, bookingCarId);
		statement.setString(2, detail.getPaymentType());
		statement.executeUpdate();
		String updateSql = "UPDATE CARDETAIL SET status = ? WHERE id = ?";
		statement = connection.prepareStatement(updateSql);
		statement.setString(1, "Booked");
		statement.setString(2, bookingCarId);
		statement.executeUpdate();

	}


	@Override
	public int gettingbookingId() throws Exception {
		int bookingId = 0;
		Connection connection = DataBaseFactory.getConnection("mysql");
		Statement statement = connection.createStatement();
		String getIdSql = "SELECT * FROM CARBOOKING  ORDER BY bookid DESC LIMIT 1";
		ResultSet rs = statement.executeQuery(getIdSql);
		while(rs.next()){
			bookingId =  rs.getInt("bookid");
		}
		return bookingId;
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


	@Override
	public void editingCar(CarDetail detail) throws Exception {
		Connection connection = DataBaseFactory.getConnection("mysql");
		String updateSql = 	"UPDATE CARDETAIL SET name='"+detail.getName()+"', model='"+detail.getModel()+"', seat='"+detail.getSeat()+"', "
				+ "price='"+detail.getPrice()+"', share='"+detail.getShare()+"', status='"+detail.getStatus()+"' WHERE id='"+detail.getId()+"'";
		Statement statement = connection.createStatement();
		statement.executeUpdate(updateSql);
		
	}


	@Override
	public int gettingCarIdfromBookingId(String id) throws Exception {
		int carId = 0;
		Connection connection = DataBaseFactory.getConnection("mysql");
		Statement statement = connection.createStatement();
		String getIdSql = "SELECT * FROM CARBOOKING WHERE bookid ='"+id+"'";
		ResultSet rs = statement.executeQuery(getIdSql);
		while(rs.next()){
			carId =  rs.getInt("carid");
		}
		return carId;
	}


	@Override
	public void updatingCarStatus(int id) throws Exception {
		Connection connection = DataBaseFactory.getConnection("mysql");
		String updateSql = 	"UPDATE CARDETAIL SET status ='UnBooked' WHERE id='"+id+"'";
		Statement statement = connection.createStatement();
		statement.executeUpdate(updateSql);
	}
	


}