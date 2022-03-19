package services;

import java.sql.Connection;
import java.sql.SQLException;

import crud.ClientCrud;
import crud.DBConnection;
import crud.DemandeCrud;
import crud.PaiementCrud;
import crud.ReservationCrud;

public class GestionDeReservation {
	
	private DBConnection connection;
	private ReservationCrud reservationCrud;
	private PaiementCrud paiementCrud;
	
	public void initGestionDeReservation() {
		if(connection == null) {
		connection = new DBConnection();
		reservationCrud = new ReservationCrud();
		paiementCrud = new PaiementCrud();
		reservationCrud.setConnection(connection.getConnection());
		paiementCrud.setConnection(connection.getConnection());
		}
	}

	public void etudeEtatDeReservationParTypeDePaiement(String type_paiement, int id_voyage, String id_client) throws SQLException {
		initGestionDeReservation();
		if(type_paiement.equals("paiement normal")) {
			reservationCrud.insererReservation(false, id_voyage, id_client);
		}else {
			reservationCrud.insererReservation(true, id_voyage, id_client);
		}
	}
	
	public void majEtatPaiementNormalApresVersement(String payer,String cin, int id_voyage) throws SQLException{
		initGestionDeReservation();
		if(payer.equals("payer")){
			paiementCrud.updatePaiementStat(true, cin, id_voyage);
		}
	
	}
}
