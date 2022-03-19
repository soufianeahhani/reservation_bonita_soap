package entities;

public class reservation {
	
	private int id;
	private boolean finalise;
	private int id_voyage;
	private String cin_client;
	
	public reservation(int id, boolean finalise, int id_voyage, String cin_client) {
		this.id = id;
		this.finalise = finalise;
		this.id_voyage = id_voyage;
		this.cin_client = cin_client;
	}

	public boolean estFinalisee() {
		return finalise;
	}

	public void setFinalise(boolean finalise) {
		this.finalise = finalise;
	}

	public int getId_voyage() {
		return id_voyage;
	}

	public void setId_voyage(int id_voyage) {
		this.id_voyage = id_voyage;
	}

	public String getCin_client() {
		return cin_client;
	}

	public void setCin_client(String cin_client) {
		this.cin_client = cin_client;
	}
	
	
	

}
