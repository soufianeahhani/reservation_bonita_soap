package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReservationCrud {
	
	private Connection connection;

	public void insererReservation(boolean finaliser, int idVoyage, String idClient) throws SQLException {
		String sql = "INSERT INTO Reservations (finaliser, id_voyage, id_client) VALUES (?, ?, ?)";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setBoolean(1, finaliser);
		preparedStatement.setInt(2, idVoyage);
		preparedStatement.setString(3, idClient);

	
		
		int rowsInserted = preparedStatement.executeUpdate();
		
		if (rowsInserted > 0) {
		    System.out.println("Nouvelle reservation a été ajouté");
		}
	}

	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}


	
}
