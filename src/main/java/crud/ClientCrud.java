package crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.*;

public class ClientCrud {
	
	private Connection connection;
	private client client;
	

	public void insererClient(String cin, String prenom, String nom) throws SQLException {
		String sql = "INSERT INTO Clients (CIN, prenom, nom) VALUES (?, ?, ?)";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1, cin);
		preparedStatement.setString(2, prenom);
		preparedStatement.setString(3, nom);
		
		int rowsInserted = preparedStatement.executeUpdate();
		
		if (rowsInserted > 0) {
		    System.out.println("Nouveau client a été ajouté");
		}
	}
	
	public client selectClientByCin(String cin) throws SQLException{
		String sql = "SELECT * FROM Clients Where cin = ?";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1, cin);
		
		ResultSet result = preparedStatement.executeQuery();
		String prenom=null;
		String nom=null;
		while(result.next()) {
		 prenom = result.getString(2);
		 nom = result.getString(3);
		}
		return new client(cin,nom,prenom);
	}
	
	
	public void deleteClient(String cin) throws SQLException {
		String sql = "DELETE FROM Clients WHERE CIN=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, cin);
		
		int rowsDeleted = statement.executeUpdate();
		if (rowsDeleted > 0) {
			System.out.println("Client a été bien supprimé !");
		}
	}
	

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public client getClient() {
		return client;
	}


	public void setClient(client client) {
		this.client = client;
	}
}
