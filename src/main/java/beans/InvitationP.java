package beans;

public class InvitationP {
	
	

	
	private String etatinvPro;
	private String nom , prenom , emploie , surMoi , cin  ;
	private int idIntivtationP ;
	
	
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public InvitationP(String etatinvPro, String nom, String prenom, String emploie, String surMoi, String cin,
			int idIntivtationP) {
		super();
		this.etatinvPro = etatinvPro;
		this.nom = nom;
		this.prenom = prenom;
		this.emploie = emploie;
		this.surMoi = surMoi;
		this.cin = cin;
		this.idIntivtationP = idIntivtationP;
	}
	public String getEtatinvPro() {
		return etatinvPro;
	}
	public void setEtatinvPro(String etatinvPro) {
		this.etatinvPro = etatinvPro;
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
	public String getEmploie() {
		return emploie;
	}
	public void setEmploie(String emploie) {
		this.emploie = emploie;
	}

	public InvitationP() {
		super();
	}
	public InvitationP(String etatinvPro, String nom, String prenom, String emploie, String surMoi) {
		super();
		this.etatinvPro = etatinvPro;
		this.nom = nom;
		this.prenom = prenom;
		this.emploie = emploie;
		this.surMoi = surMoi;
	}
	
	public InvitationP( String nom, String prenom, String emploie, String surMoi) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.emploie = emploie;
		this.surMoi = surMoi;
	}
	public String getSurMoi() {
		return surMoi;
	}
	public void setSurMoi(String surMoi) {
		this.surMoi = surMoi;
	}
	public InvitationP(String etatinvPro, String nom, String prenom, String emploie, String surMoi,
			int idIntivtationP) {
		super();
		this.etatinvPro = etatinvPro;
		this.nom = nom;
		this.prenom = prenom;
		this.emploie = emploie;
		this.surMoi = surMoi;
		this.idIntivtationP = idIntivtationP;
	}
	public int getIdIntivtationP() {
		return idIntivtationP;
	}
	public void setIdIntivtationP(int idIntivtationP) {
		this.idIntivtationP = idIntivtationP;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
