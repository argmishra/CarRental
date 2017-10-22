package com.ul.project.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.ul.project.dto.CarDetail;

public interface ICarRentalDao {
	
	public Connection gettingConnection();
	
	public void savingUser (String name,String username,String password,String email,String number ) throws SQLException;
	
	public int gettingUserId () throws SQLException;

	public String validatingUser (String username,HttpServletRequest request) throws SQLException;
	
	public void savingFeebdback(String title,String description)throws SQLException;
	
	public void addingNewCar (String cname,String cmodel,String cseat,String cprice,String cshareType) throws SQLException;
	
	public int gettingCarId () throws SQLException;
	
	public CarDetail gettingCarDetails(String id) throws SQLException;
	
	public void bookingCar(String id) throws SQLException;
	
	public int gettingbookingId () throws SQLException;



}
