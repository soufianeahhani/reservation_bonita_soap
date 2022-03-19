package services;

import java.sql.SQLException;

import crud.DBConnection;
import crud.VoyageCrud;
import entities.Voyage;

public class GestionDeVoyage {
	
		private DBConnection dbconn;
		private VoyageCrud voyageCrud;
		
	public Voyage propositionDeVoyage(String date,String villedepart, String villearrive) throws SQLException {
		 dbconn = new DBConnection();
		 voyageCrud=new VoyageCrud();
		 //System.out.println("heree");
		 voyageCrud.setConnection(dbconn.getConnection());
		 String vd = villedepart;
		 String va = villearrive;
		 String data = date;
		Voyage v = voyageCrud.selectVoyageByVilleAndDate(villedepart, villearrive, date);	
		return v;
	}
}
