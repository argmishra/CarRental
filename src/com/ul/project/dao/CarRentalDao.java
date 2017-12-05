package com.ul.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.ul.project.dto.BookingDetail;
import com.ul.project.dto.CarDetail;
import com.ul.project.factories.DataBaseFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class CarRentalDao.
 */
public class CarRentalDao implements ICarRentalDao{

	/** The data base factory. */
	DataBaseFactory dataBaseFactory = DataBaseFactory.getInstance();

	/* (non-Javadoc)
	 * @see com.ul.project.dao.ICarRentalDao#addingNewCar(com.ul.project.dto.CarDetail)
	 */
	@Override
	public void addingNewCar(CarDetail detail)
			throws Exception {
		Connection connection = dataBaseFactory.getConnection("mysql");
		String insertSql = "INSERT INTO CARDETAIL (name, model, seat, price,share,status,cartype) VALUES (?, ?, ?, ?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(insertSql);
		statement.setString(1, detail.getName());
		statement.setString(2, detail.getModel());
		statement.setString(3, detail.getSeat());
		statement.setInt(4, detail.getPrice());
		statement.setString(5, detail.getShare());
		statement.setString(6, detail.getStatus());
		statement.setString(7,detail.getCarType() );
		statement.executeUpdate();
	}


	/* (non-Javadoc)
	 * @see com.ul.project.dao.ICarRentalDao#gettingCarId()
	 */
	@Override
	public int gettingCarId() throws Exception {
		int idForCar = 0;
		Connection connection = dataBaseFactory.getConnection("mysql");	
		Statement statement = connection.createStatement();
		String getIdSql = "SELECT * FROM CARDETAIL ORDER BY id DESC LIMIT 1";
		ResultSet rs = statement.executeQuery(getIdSql);
		while(rs.next()){
			idForCar =  rs.getInt("id");
		}
		return idForCar;
	}


	/* (non-Javadoc)
	 * @see com.ul.project.dao.ICarRentalDao#gettingCarDetails(java.lang.String)
	 */
	@Override
	public CarDetail gettingCarDetails(String id) throws Exception {
		Connection connection = dataBaseFactory.getConnection("mysql");
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
			carDetail.setPrice(rs.getInt("price"));
			carDetail.setShare(rs.getString("share"));
			carDetail.setStatus(rs.getString("status"));
			carDetail.setCarType(rs.getString("cartype"));

		}

		return carDetail;
	}


	/* (non-Javadoc)
	 * @see com.ul.project.dao.ICarRentalDao#bookingCar(java.lang.String, com.ul.project.dto.BookingDetail)
	 */
	@Override
	public void bookingCar(String bookingCarId,BookingDetail detail) throws Exception {
		Connection connection = dataBaseFactory.getConnection("mysql");
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


	/* (non-Javadoc)
	 * @see com.ul.project.dao.ICarRentalDao#gettingbookingId()
	 */
	@Override
	public int gettingbookingId() throws Exception {
		int bookingId = 0;
		Connection connection = dataBaseFactory.getConnection("mysql");
		Statement statement = connection.createStatement();
		String getIdSql = "SELECT * FROM CARBOOKING  ORDER BY bookid DESC LIMIT 1";
		ResultSet rs = statement.executeQuery(getIdSql);
		while(rs.next()){
			bookingId =  rs.getInt("bookid");
		}
		return bookingId;
	}


	/* (non-Javadoc)
	 * @see com.ul.project.dao.ICarRentalDao#gettingAllAvailableCars()
	 */
	@Override
	public ArrayList<CarDetail> gettingAllAvailableCars() throws Exception {
		Connection connection = dataBaseFactory.getConnection("mysql");
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
			carDetail.setPrice(rs.getInt("price"));
			carDetail.setShare(rs.getString("share"));
			carDetail.setStatus(rs.getString("status"));

			cdlist.add(carDetail);
		}
		return cdlist;
	}


	/* (non-Javadoc)
	 * @see com.ul.project.dao.ICarRentalDao#editingCar(com.ul.project.dto.CarDetail)
	 */
	@Override
	public void editingCar(CarDetail detail) throws Exception {
		Connection connection = dataBaseFactory.getConnection("mysql");
		String updateSql = 	"UPDATE CARDETAIL SET name='"+detail.getName()+"', model='"+detail.getModel()+"', seat='"+detail.getSeat()+"', "
				+ "price='"+detail.getPrice()+"', share='"+detail.getShare()+"', status='"+detail.getStatus()+"' WHERE id='"+detail.getId()+"'";
		Statement statement = connection.createStatement();
		statement.executeUpdate(updateSql);

	}


	/* (non-Javadoc)
	 * @see com.ul.project.dao.ICarRentalDao#gettingCarIdfromBookingId(java.lang.String)
	 */
	@Override
	public int gettingCarIdfromBookingId(String id) throws Exception {
		int carId = 0;
		Connection connection = dataBaseFactory.getConnection("mysql");
		Statement statement = connection.createStatement();
		String getIdSql = "SELECT * FROM CARBOOKING WHERE bookid ='"+id+"'";
		ResultSet rs = statement.executeQuery(getIdSql);
		while(rs.next()){
			carId =  rs.getInt("carid");
		}
		return carId;
	}


	/* (non-Javadoc)
	 * @see com.ul.project.dao.ICarRentalDao#updatingCarStatus(int)
	 */
	@Override
	public void updatingCarStatus(int id) throws Exception {
		Connection connection = dataBaseFactory.getConnection("mysql");
		String updateSql = 	"UPDATE CARDETAIL SET status ='UnBooked' WHERE id='"+id+"'";
		Statement statement = connection.createStatement();
		statement.executeUpdate(updateSql);
	}



}