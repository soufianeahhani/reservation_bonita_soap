package entities;

public class Acompte {

	private int id;
	private int id_paiement;
	private boolean payer;
	private String date;
	
	public Acompte(int id, int id_paiement, boolean payer, String date) {
		super();
		this.id = id;
		this.id_paiement = id_paiement;
		this.payer = payer;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_paiement() {
		return id_paiement;
	}

	public void setId_paiement(int id_paiement) {
		this.id_paiement = id_paiement;
	}

	public boolean isPayer() {
		return payer;
	}

	public void setPayer(boolean payer) {
		this.payer = payer;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	
	
}
