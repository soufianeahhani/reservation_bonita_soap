package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Paiement;
import entities.Voyage;
import entities.client;

public class PaiementCrud {
	
	private Connection conn;
	
   public void insertPaiement(String type, boolean payer, String date,String cin, int id_voyage) throws SQLException { 
	   
	String sql = "INSERT INTO Paiements  (type, payer, date, cin, id_voyage) VALUES (?, ?, ?, ?, ?)";
	
	PreparedStatement statement = conn.prepareStatement(sql);
	statement.setString(1, type);
	statement.setBoolean(2, payer);
	statement.setString(3, date); 
	statement.setString(4, cin); 
	statement.setInt(5, id_voyage); 

	 
	int rowsInserted = statement.executeUpdate();
	if (rowsInserted > 0) {
	    System.out.println("Un nouveau paiement a été bien ajouté!");
	}
	  }
	
	public void updatePaiementByEtat(boolean payer, int id) throws SQLException {
		 String sql = "UPDATE Paiement SET payer=? WHERE id=?";
		 
		 PreparedStatement statement = conn.prepareStatement(sql);
	
		 statement.setBoolean(1, payer);
		 
		 int rowsUpdated = statement.executeUpdate();
		 
		 if (rowsUpdated > 0) {
	 		System.out.println("l'état a été bien modifiée!");
	 	}
	
		 
	}

	public void updatePaiementType(String type, int id) throws SQLException {
		 String sql = "UPDATE Paiements SET type=? WHERE id=?";
		 
		 PreparedStatement statement = conn.prepareStatement(sql);
		
		 statement.setString(1,type);
		 
		 int rowsUpdated = statement.executeUpdate();
		 
		 if (rowsUpdated > 0) {
	 		System.out.println("l'état a été bien modifiée!");
	 	}	
		 
	}
	
	public Paiement selectPaiement(String cin,int id_voyage) throws SQLException{
		String sql = "SELECT * FROM Paiements Where cin = ? and id_voyage=?";

		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		
		preparedStatement.setString(1, cin);
		preparedStatement.setInt(2, id_voyage);
		
		ResultSet result = preparedStatement.executeQuery();
		
		Paiement p = new Paiement();
		
		while(result.next()) {
		 p.setId(result.getInt(1));
		 p.setType(result.getString(2));
		 p.setPayer(result.getBoolean(3));
		 p.setDate(result.getString(4));
		 p.setCin(result.getString(5));
		 p.setId_voyage(result.getInt(6));
		}
		return p;
	}
	
	public void updatePaiementStat(boolean payer,String cin, int id_voyage) throws SQLException {
		 Paiement p = selectPaiement(cin, id_voyage);	
		 if(p.getId() != 0) {
		 String sql = "UPDATE Paiements SET payer=? WHERE id=? AND id_voyage=?";
		 
		 PreparedStatement statement = conn.prepareStatement(sql);
		
		 statement.setBoolean(1, payer);
		 statement.setString(2, cin);
		 statement.setInt(3, id_voyage);
		 
		 int rowsUpdated = statement.executeUpdate();
		 
		 if (rowsUpdated > 0) {
	 		System.out.println("l'état a été bien modifiée!");
	 		}	
		 }
	}

	public void setConnection(Connection connection) {
		// TODO Auto-generated method stub
		conn = connection;
	}
	
	
}
