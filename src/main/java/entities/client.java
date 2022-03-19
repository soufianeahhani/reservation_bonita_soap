package entities;

public class client {
	
	private String cin;
	private String name;
	private String prenom;
	
	public client(String cin, String name, String prenom) {
		this.cin = cin;
		this.name = name;
		this.prenom = prenom;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
}
