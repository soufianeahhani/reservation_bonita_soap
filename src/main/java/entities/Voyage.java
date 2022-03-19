package entities;

public class Voyage {
	
	public int id;
	public String date;
	 
	public String ville_depart;
	public String ville_arrive;
	
	public Voyage(int id,  String ville_depart, String ville_arrive,String date ) {
		super();
		this.id = id;
		this.date = date;
		 
		this.ville_depart = ville_depart;
		this.ville_arrive = ville_arrive;
	}

	public Voyage() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

 
 
	public String getVille_depart() {
		return ville_depart;
	}

	public void setVille_depart(String ville_depart) {
		this.ville_depart = ville_depart;
	}

	public String getVille_arrive() {
		return ville_arrive;
	}

	public void setVille_arrive(String ville_arrive) {
		this.ville_arrive = ville_arrive;
	}
	
	
	
	
}
