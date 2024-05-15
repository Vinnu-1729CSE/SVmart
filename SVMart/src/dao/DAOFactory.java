package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DAOFactory {
	private static final String DB_PROPERTIES_FILE = "/db.properties";

	public static Connection getProductDAO() throws ClassNotFoundException {
		Properties properties = new Properties();
		try (InputStream input = DAOFactory.class.getResourceAsStream(DB_PROPERTIES_FILE)) {
			properties.load(input);

			// Get database connection details from properties file
			String url = properties.getProperty("db.url");
			String username = properties.getProperty("db.username");
			String password = properties.getProperty("db.password");
			String driver = properties.getProperty("db.driver");

			// Create database connection
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(url, username, password);

			// Return ProductDAOImpl instance with database connection
			return connection;
		} catch (IOException | SQLException e) {
			e.printStackTrace();
			// Handle exception (e.g., log error, throw RuntimeException)
			throw new RuntimeException("Failed to initialize ProductDAO", e);
		}
	}
}
