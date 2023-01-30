package beans;

public class AvisClientsbean {

	
	private String nom , prenom , description , progrestache ;
	private int nbrEtoileProf ;
	public AvisClientsbean() {
		super();
	}
	public AvisClientsbean(String nom, String prenom, int nbrEtoileProf) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.nbrEtoileProf = nbrEtoileProf;
	}
	public AvisClientsbean(String nom, String prenom, String description, int nbrEtoileProf) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.description = description;
		this.nbrEtoileProf = nbrEtoileProf;
	}
	
	
	public AvisClientsbean(String nom, String prenom, String description, String progrestache, int nbrEtoileProf) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.description = description;
		this.progrestache = progrestache;
		this.nbrEtoileProf = nbrEtoileProf;
	}
	public String getProgrestache() {
		return progrestache;
	}
	public void setProgrestache(String progrestache) {
		this.progrestache = progrestache;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getnbrEtoileProf() {
		return nbrEtoileProf;
	}
	public void setnbrEtoileProf(int nbrEtoileProf) {
		this.nbrEtoileProf = nbrEtoileProf;
	}
	
	
	
}
