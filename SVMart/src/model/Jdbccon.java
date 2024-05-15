package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbccon {
	private static Connection con = null;

	public Jdbccon() {
		String driverName = "org.postgresql.Driver";
		String url = "jdbc:postgresql://192.168.110.48:5432/plf_training";
		String user = "plf_training_admin";
		String password = "pff123";
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		System.out.println("cnnection created");

	}

	public Connection getCon() {
		if (Jdbccon.con == null) {
			new Jdbccon();
		}

		return con;
	}

}