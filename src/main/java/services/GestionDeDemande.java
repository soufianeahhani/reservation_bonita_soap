package services;

import java.sql.SQLException;

import crud.ClientCrud;
import crud.DBConnection;
import crud.DemandeCrud;

public class GestionDeDemande {
	private DBConnection connection;
	private ClientCrud clientCrud;
	private DemandeCrud demandeCrud;
	
	public void initGestionDeDemande() {
		if(connection == null) {
			connection = new DBConnection();
			clientCrud = new ClientCrud();
			demandeCrud = new DemandeCrud();
			clientCrud.setConnection(connection.getConnection());
			demandeCrud.setConnection(connection.getConnection());
		}
	}
	public int ouvrirUneDemande(String cin,int id_voyage, int id_paiement, String status) throws SQLException {
		initGestionDeDemande();
		demandeCrud.insererDemande(cin, id_voyage, id_paiement, status);
		
		return demandeCrud.selectDemandesByClientAndVoyage(cin,id_voyage).getId();
	}
	
	public void updateDemande(String cin,int id_voyage, int id_paiement, String status) throws SQLException{
		initGestionDeDemande();
		if(demandeCrud.selectDemandesByClientAndVoyage(cin,id_voyage).getId() != 0) {
			demandeCrud.upadateDemandeStatus("annulé", cin, id_voyage);
		}else {			
			ouvrirUneDemande(cin, id_voyage, id_paiement, status);
		}
		
	}
	
	public void annulerdemande(String idClient, int idVoyage ) throws SQLException {
		initGestionDeDemande();
		System.out.println(idClient+" "+" "+ idVoyage);
		demandeCrud.upadateDemandeStatus("annulé", idClient, idVoyage);
	}

}
