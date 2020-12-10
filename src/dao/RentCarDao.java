package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class RentCarDao {
	
	private Connection connection;
	private TimerentCarDao timerentCarDao;
	private CustomerCarDao customerCarDao;
	private final String CREATE_NEW_CAR_QUERY= "INSERT INTO rentcars(car_make, car_model, "
			+ "car_year, car_miles ) VALUES (?, ?, ?, ?)";
	private final String UPDATE_CAR_MILES = "UPDATE rentcars SET car_miles = (car_miles + ?) WHERE id = ?";
	private final String DELETE_CAR_BY_ID_QUERY = "DELETE FROM rentcars WHERE id = ?";
	
	// This connection need to be done at any DAO class to be able to connect to the Connection class.
	public RentCarDao() {
		connection = DBCarConnection.getConnection();
	}
	
	public void createNewCar(String carMake, String carModel, int carYear, int carMiles) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_CAR_QUERY);
		ps.setString(1, carMake);
		ps.setString(2, carModel);
		ps.setInt(3, carYear);
		ps.setInt(4, carMiles);
		
		ps.executeUpdate();

		System.out.println("one car Added ");
	}
		
	public void updateMiles(int returnMiles, int carRecordId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_CAR_MILES);
		int sum = 10;
		returnMiles = returnMiles + sum;
		System.out.println(returnMiles);
		
		ps.setInt(1, returnMiles);
		ps.setInt(2, carRecordId);
		
		ps.executeUpdate();
		
		System.out.println("Miles updated! ");

		
	}

	public void deleteCarById(int id) throws SQLException {
		timerentCarDao.deleteCarById(id);
		customerCarDao.deleteCarById(id);
		PreparedStatement ps = connection.prepareStatement(DELETE_CAR_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}

	
}
