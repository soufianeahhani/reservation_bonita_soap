package crud;
import java.sql.*;

public class DBConnection {
	

	final String URL = "jdbc:mysql://localhost:3306/gestionreservation";
	final String username = "root";
	final String password = "";
	private Connection connection;
	
	public Connection getConnection() {
		
		try {
			Class<?> c = Class.forName("com.mysql.cj.jdbc.Driver"); 
			Driver pilote = (Driver)c.newInstance() ;
		    DriverManager.registerDriver(pilote);
		    
			connection = DriverManager.getConnection(URL, username, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	   return connection;
	   
	}
}
