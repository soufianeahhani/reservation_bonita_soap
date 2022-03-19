package services;
import java.sql.Connection;
import java.sql.SQLException;

import crud.*;
import entities.Paiement;

public class GestionAcompte {
	
	private PaiementCrud paiementCrud;
	private AcompteCrud acompteCrud; 
	private DBConnection connection;
	private DemandeCrud demandeCrud;
	
	public void initGestionAcompte() {
		if(connection == null) {
		connection = new DBConnection();
		acompteCrud = new AcompteCrud();
		paiementCrud = new PaiementCrud();
		demandeCrud = new DemandeCrud();
		acompteCrud.setConnection(connection.getConnection());
		paiementCrud.setConnection(connection.getConnection());
		demandeCrud.setConnection(connection.getConnection());
		}
	}
 
	
	public void insererAcompte(boolean payer,String date,String cin,String type, int id_voyage) throws SQLException {
		initGestionAcompte();
	
			if(type.equals("paiement normal")) {
			 payer = true;
			}else {
			 payer = false;
			}
			
			paiementCrud.insertPaiement(type, payer, date, cin, id_voyage);	
			Paiement p = paiementCrud.selectPaiement(cin, id_voyage);		
			acompteCrud.insererAcompte(p.getId(), payer, date);
			demandeCrud.upadateDemandePaiement(p.getId(),cin, id_voyage);
			
	}

}
