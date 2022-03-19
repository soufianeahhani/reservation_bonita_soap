package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Voyage;
import entities.client;

public class VoyageCrud {
	
	private Connection connection;

	public Voyage selectVoyageByVilleAndDate(String villeDepart, String VilleArrive, String Date) throws SQLException{
		String sql = "SELECT * FROM Voyages Where ville_depart = ? and ville_arrive = ? and date = ?";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1, villeDepart);
		preparedStatement.setString(2, VilleArrive);
		preparedStatement.setString(3, Date);
	
		ResultSet result = preparedStatement.executeQuery();
		
		Voyage voyage = null;
		
		while(result.next()) {
		 		  voyage = new Voyage(result.getInt(1),result.getString(2),result.getString(3),result.getString(4));

		}
		return voyage;
	}
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
