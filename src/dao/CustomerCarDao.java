package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerCarDao {
	
	private Connection connection;
	
	private final String CREATE_CUSTOMERS_LIST_QUERY = "SELECT * FROM customers";
	
	// This connection need to be done at any DAO class to be able to connect to the Connection class.
	public CustomerCarDao() {
		connection = DBCarConnection.getConnection();
	}
	
	public void getCustomer() throws SQLException {
		ResultSet rs = connection.prepareStatement(CREATE_CUSTOMERS_LIST_QUERY).executeQuery();
			while (rs.next()) {
				System.out.println("Full Name: " + rs.getString(3) + " " + rs.getString(4));
			}
	}
	
	
	
}
