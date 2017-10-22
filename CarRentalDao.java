package com.ul.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ul.project.constants.CarRentalConstants;
import com.ul.project.dto.CarDetail;

public class CarRentalDao implements ICarRentalDao{

	@Override
	public Connection gettingConnection() {
		Connection connection =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+CarRentalConstants.DATABASE_NAME,
					CarRentalConstants.DATABASE_USERNAME,CarRentalConstants.DATABASE_PASSWORD);
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}


	@Override
	public void savingUser(String name,String username,String password,String email,String number) throws SQLException {
		Connection connection = gettingConnection();
		String insertSql = "INSERT INTO USERDETAIL  (name, username, password, email, number) VALUES (?, ?, ?, ?,?)";
		PreparedStatement preapredStatement = connection.prepareStatement(insertSql);
		preapredStatement.setString(1, name);
		preapredStatement.setString(2, username);
		preapredStatement.setString(3, password);
		preapredStatement.setString(4, email);
		preapredStatement.setString(5, number);
		preapredStatement.executeUpdate();
	}

	@Override
	public int gettingUserId() throws SQLException {
		int idForUser = 0;
		Connection connection = gettingConnection();
		Statement statement = connection.createStatement();
		String getIdSql = "SELECT * FROM USERDETAIL ORDER BY id DESC LIMIT 1";
		ResultSet rs = statement.executeQuery(getIdSql);
		while(rs.next()){
			idForUser =  rs.getInt("id");
		}
		return idForUser;
	}


	@Override
	public String validatingUser(String username,HttpServletRequest request) throws SQLException {
		Connection connection = gettingConnection();
		String passowrd =null;
		Statement statement = connection.createStatement();
		String getIdSql = "SELECT * FROM USERDETAIL where username = '"+username+"'";
		ResultSet rs = statement.executeQuery(getIdSql);
		while(rs.next()){
			passowrd =  rs.getString("password");
			HttpSession session = request.getSession();
			session.setAttribute("userEmail", rs.getString("email"));
		}
		return passowrd;
	}


	@Override
	public void savingFeebdback(String title, String description) throws SQLException {
		Connection connection = gettingConnection();
		String insertSql = "INSERT INTO FEEDBACK  (title, description) VALUES (?,?)";
		PreparedStatement preapredStatement = connection.prepareStatement(insertSql);
		preapredStatement.setString(1, title);
		preapredStatement.setString(2, description);
		preapredStatement.executeUpdate();

	}


	@Override
	public void addingNewCar(String cname, String cmodel, String cseat, String cprice, String cshareType)
			throws SQLException {
		Connection connection = gettingConnection();
		String insertSql = "INSERT INTO CARDETAIL (name, model, seat, price,share,status) VALUES (?, ?, ?, ?,?,?)";
		PreparedStatement statement = connection.prepareStatement(insertSql);
		statement.setString(1, cname);
		statement.setString(2, cmodel);
		statement.setInt(3, Integer.parseInt(cseat));
		statement.setDouble(4, Double.parseDouble(cprice));
		statement.setString(5, cshareType);
		statement.setString(6, "UnBooked");

		statement.executeUpdate();

	}


	@Override
	public int gettingCarId() throws SQLException {
		int idForCar = 0;
		Connection connection = gettingConnection();
		Statement statement = connection.createStatement();
		String getIdSql = "SELECT * FROM CARDETAIL ORDER BY id DESC LIMIT 1";
		ResultSet rs = statement.executeQuery(getIdSql);
		while(rs.next()){
			idForCar =  rs.getInt("id");
		}
		return idForCar;
	}


	@Override
	public CarDetail gettingCarDetails(String id) throws SQLException {
		Connection connection = gettingConnection();
		Statement statement = connection.createStatement();
		String selectSql = "SELECT * FROM CARDETAIL where id = '"+id+"'";
		ResultSet rs = statement.executeQuery(selectSql);
		CarDetail carDetail = null;
		while(rs.next()){

			carDetail = new CarDetail();
			carDetail.setId(rs.getInt("id"));
			carDetail.setName(rs.getString("name"));
			carDetail.setModel(rs.getString("model"));
			carDetail.setSeat(rs.getInt("seat"));
			carDetail.setPrice(rs.getInt("price"));
			carDetail.setShare(rs.getString("share"));
			carDetail.setStatus(rs.getString("status"));

		}

		return carDetail;
	}


	@Override
	public void bookingCar(String bookingCarId) throws SQLException {
		Connection connection = gettingConnection();
		String bookingSql = "INSERT INTO CARBOOKING (carid) VALUES (?)";
		PreparedStatement statement = connection.prepareStatement(bookingSql);
		statement.setString(1, bookingCarId);
		statement.executeUpdate();
		String updateSql = "UPDATE CARDETAIL SET status = ? WHERE id = ?";
		statement = connection.prepareStatement(updateSql);
		statement.setString(1, "Booked");
		statement.setString(2, bookingCarId);
		statement.executeUpdate();

	}


	@Override
	public int gettingbookingId() throws SQLException {
		int bookingId = 0;
		Connection connection = gettingConnection();
		Statement statement = connection.createStatement();
		String getIdSql = "SELECT * FROM CARBOOKING  ORDER BY bookid DESC LIMIT 1";
		ResultSet rs = statement.executeQuery(getIdSql);
		while(rs.next()){
			bookingId =  rs.getInt("bookid");
		}
		return bookingId;
	}

}