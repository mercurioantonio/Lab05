package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection; 
import java.sql.SQLException;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectDB {
	
	// check user e password
	static private final String jdbcUrl = "jdbc:mysql://localhost/dizionario?user=root&password=root";

	static private HikariDataSource ds = null;
	
	public static Connection getConnection() {
		
		if(ds == null) {
			ds = new HikariDataSource();
			
			ds.setJdbcUrl(jdbcUrl);
//			ds.setUsername("root");
//			ds.setPassword("root");
		}

		try {
				Connection connection = ds.getConnection();
				return connection;

		} catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException("Cannot get a connection " + jdbcUrl, e);
		}
	}

}
