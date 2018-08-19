package helper.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import helper.logger.LoggerHelper;

public class DatabaseHelper {

	static Logger Log = LoggerHelper.getLogger(DatabaseHelper.class);

	private static String url = "";// Will mention this URL later
	private static String userName = "";
	private static String driverName = "";
	private static String password = "";
	private static Connection connection;
	private static DatabaseHelper instance = null;

	/**
	 * This constructor will get called from getConnection method is instance is
	 * null and then getSingleInstanceConnection method will be invoked.
	 */
	public DatabaseHelper() {
		getSingleInstanceConnection();
	}

	/**
	 * This method will actually setup connection when called from outside class.
	 * 
	 * @return
	 */
	public static DatabaseHelper getInstance() {
		if (instance == null) {
			instance = new DatabaseHelper();
		}
		return instance;
	}

	/**
	 * this method is used to setup connection between driver and DB
	 * 
	 * @return connection
	 */
	private Connection getSingleInstanceConnection() {
		try {
			Class.forName(driverName);// to make connection with datatbase
			try {
				connection = DriverManager.getConnection(url, userName, password);
				// Connection is created
				if (connection != null) {
					Log.info("Connected to database");
				}
			} catch (SQLException e) {
				Log.error("Failed to create Database connection" + e.getMessage());
			}
		} catch (ClassNotFoundException e) {
			Log.error("Driver not found" + e);
		}
		return connection;
	}

	public Connection getConnection() {
		return connection;
	}

	public static ResultSet getResultSet(String dbQuery) {
		instance = DatabaseHelper.getInstance();
		connection = instance.getConnection();
		Log.info("Executing query: " + dbQuery);
		try {
			Statement stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery(dbQuery);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}