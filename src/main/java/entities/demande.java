package entities;

public class demande {
	
	private int id;
	private String cin_client;
	private int id_voyage;
	private int id_paiement;
	private boolean annulation;
	
	public demande(int id, String cin_client, int id_voyage, int id_paiement, boolean status) {
		super();
		this.setId(id);
		this.cin_client = cin_client;
		this.id_voyage = id_voyage;
		this.id_paiement = id_paiement;
		this.annulation = status;
	}

	public demande() {
		// TODO Auto-generated constructor stub
	}

	public String getCin_client() {
		return cin_client;
	}

	public void setCin_client(String cin_client) {
		this.cin_client = cin_client;
	}

	public int getId_voyage() {
		return id_voyage;
	}

	public void setId_voyage(int id_voyage) {
		this.id_voyage = id_voyage;
	}

	public int getId_paiement() {
		return id_paiement;
	}

	public void setId_paiement(int id_paiement) {
		this.id_paiement = id_paiement;
	}

	public boolean estAnnulee() {
		return annulation;
	}

	public void setStatus(boolean status) {
		this.annulation = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
