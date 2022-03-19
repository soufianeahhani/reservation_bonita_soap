package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.client;
import entities.demande;

public class DemandeCrud {
	private Connection connection;

	public void insererDemande(String idClient, int idVoyage, int idPaiement, String status) throws SQLException {
		String sql = "INSERT INTO Demandes (id_client, id_voyage, id_paiement, status) VALUES (?, ?, ?, ?)";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1, idClient);
		preparedStatement.setInt(2, idVoyage);
		preparedStatement.setInt(3, idPaiement);
		preparedStatement.setString(4, status);
		System.out.println("inside 	");
		int rowsInserted = preparedStatement.executeUpdate();
		
		if (rowsInserted > 0) {
		    System.out.println("Nouvelle demande a été ajouté");
		}
	}
	
	public demande selectDemandesByClientAndVoyage(String cin, int id_voyage) throws SQLException{
		String sql = "SELECT * FROM Demandes Where id_client = ? and id_voyage = ?";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1, cin);
		preparedStatement.setInt(2, id_voyage);
		
		ResultSet result = preparedStatement.executeQuery();
		
		demande d = new demande();
		
		while(result.next()) {
		 d.setId(result.getInt(1));
		 d.setCin_client(result.getString(2));
		 d.setId_voyage(result.getInt(3));
		 d.setStatus(result.getBoolean(4));
		}
		
		return d;
	}
	
	
	
    public void upadateDemandeStatus(String status, String idClient, int idVoyage) throws SQLException {
    	
    	String sql = "UPDATE Demandes SET status=? WHERE id_client=? AND id_voyage=?";
    	
    	PreparedStatement statement = connection.prepareStatement(sql);
    	
    	statement.setString(1, status);
    	statement.setString(2, idClient);
    	statement.setInt(3, idVoyage);
    	
    	int rowsUpdated = statement.executeUpdate();
    	if (rowsUpdated > 0) {
    		System.out.println("l'état a été bien modifiée!");
    	}
    }
	
    public void upadateDemandePaiement(int id_paiement, String idClient, int idVoyage) throws SQLException {
    	
    	String sql = "UPDATE Demandes SET id_paiement=? WHERE id_client=? AND id_voyage=?";
    	
    	PreparedStatement statement = connection.prepareStatement(sql);
    	statement.setInt(1, id_paiement);
    	statement.setString(2, idClient);
    	statement.setInt(3, idVoyage);
    	
    	int rowsUpdated = statement.executeUpdate();
    	if (rowsUpdated > 0) {
    		System.out.println("le paiement a été bien modifiée!");
    	}
    }
    
    

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	

}
