package beans;

public class ProgresProf {

	private String nom , prenom , empploie , progres  = "en cours" , commentaire;
	private String cin ; 
	
	

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public ProgresProf(String nom, String prenom, String empploie, String progres, String commentaire, String cin) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.empploie = empploie;
		this.progres = progres;
		this.commentaire = commentaire;
		this.cin = cin;
	}

	public ProgresProf(String nom, String prenom, String empploie, String progres, String cin) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.empploie = empploie;
		this.progres = progres;
		this.cin = cin;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public ProgresProf() {
		super();
	}

	public ProgresProf(String nom, String prenom, String empploie, String progres) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.empploie = empploie;
		this.progres = progres;
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

	public String getEmpploie() {
		return empploie;
	}

	public void setEmpploie(String empploie) {
		this.empploie = empploie;
	}

	public String getProgres() {
		return progres;
	}

	public void setProgres(String progres) {
		this.progres = progres;
	}
	
	
	
}
