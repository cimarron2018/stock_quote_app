package edu.arielperez.advancedjava.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * A class that contains database related utility methods.
 */
public class DatabaseUtils {

	// JDBC driver name and database URL
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/stocks?autoReconnect=true&useSSL=false";

	// Database credentials
	private static final String USER = "aperez";
	private static final String PASS = "locura";

	/**
	 * Configure a connection to a database.
	 * 
	 * @return a Connection A connection (session) with a specific database.
	 * @throws DatabaseConnectionException
	 */
	public static Connection getConnection() throws DatabaseConnectionException {
		Connection connection = null;

		try {
			Class.forName(JDBC_DRIVER);
		} catch (Exception e) {
			throw new DatabaseConnectionException("Could load db drive " + JDBC_DRIVER + " - " + e.getMessage(), e);
		}

		try {
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			throw new DatabaseConnectionException("Could not connect to database " + DB_URL + " - " + e.getMessage(),
					e);
		}

		return connection;
	}

}
