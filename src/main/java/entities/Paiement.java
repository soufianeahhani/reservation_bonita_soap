package entities;

public class Paiement {
	
	private int id;
	private String type;
	private boolean payer;
	private String date;
	private String cin;
	private int id_voyage;
	
	
	public Paiement(int id, String type, boolean payer,String date,String cin, int id_voyage) {
		super();
		this.id = id;
		this.type = type;
		this.setPayer(payer);
		this.date = date;
		this.cin = cin;
		this.id_voyage = id_voyage;
	}

	public Paiement() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isPayer() {
		return payer;
	}

	public void setPayer(boolean payer) {
		this.payer = payer;
	}
	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public int getId_voyage() {
		return id_voyage;
	}

	public void setId_voyage(int id_voyage) {
		this.id_voyage = id_voyage;
	}

	
	
}
