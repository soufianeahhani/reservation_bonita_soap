package crud;

import java.sql.SQLException;

import entities.Voyage;
import entities.client;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBConnection connection = new DBConnection();
		client  client = new client("AE90707", "yassine", "souissi");
		//ClientCrud clientCrud = new ClientCrud();
		//clientCrud.setConnection(connection.getConnection());
		 VoyageCrud voyageCrud = new VoyageCrud();
		 //System.out.println("heree");
		 voyageCrud.setConnection(connection.getConnection());
		try {
			//clientCrud.insererClient(client.getCin(), client.getName(), client.getPrenom());
			//client c = clientCrud.selectClientByCin("AE90707");
			//clientCrud.deleteClient("AE90707");
			//System.out.println(c.getName()+" "+c.getPrenom());;
			
			Voyage v = voyageCrud.selectVoyageByVilleAndDate("sale", "rabat", "2022-02-24");
			System.out.println(v);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
