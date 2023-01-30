package beans;

public class mesInvitations {

	private String nom , prenom , fonction , etatInv = "en cours" ;
	private int id;

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public mesInvitations(String nom, String prenom, String fonction, String etatInv, int id) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.fonction = fonction;
		this.etatInv = etatInv;
		this.id = id;
	}

	public mesInvitations(String nom, String prenom, String fonction, String etatInv) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.fonction = fonction;
		this.etatInv = etatInv;
	}

	public mesInvitations(String nom, String prenom, String fonction) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.fonction = fonction;
	}

	
	
	
	public mesInvitations() {
		super();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public String getEtatInv() {
		return etatInv;
	}

	public void setEtatInv(String etatInv) {
		this.etatInv = etatInv;
	}
	
	
	
	
	
	
}
