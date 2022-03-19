package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AcompteCrud {
	
	private Connection connection;

	public void insererAcompte(int idPaiement, boolean payer, String date) throws SQLException {
		String sql = "INSERT INTO Acomptes (id_paiement, payer, date) VALUES (?, ?, ?)";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setInt(1, idPaiement);
		preparedStatement.setBoolean(2, payer);
		preparedStatement.setString(3, date);
		
		int rowsInserted = preparedStatement.executeUpdate();
		
		if (rowsInserted > 0) {
		    System.out.println("un nouveau acompte a été ajouté");
		}
	}
	
	 public void upadateAcompteStatus(boolean payer, int idPaiement) throws SQLException {
	    	
	    	String sql = "UPDATE Acompte SET payer=? WHERE id_paiement=?";
	    	
	    	PreparedStatement statement = connection.prepareStatement(sql);
	    	statement.setBoolean(1, payer);
	    	statement.setInt(2, idPaiement);
	    	
	    	int rowsUpdated = statement.executeUpdate();
	    	if (rowsUpdated > 0) {
	    		System.out.println("l'état a été bien modifiée!");
	    	}
	    }
	
	
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	
	
}
