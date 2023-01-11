package beans;

public class ProfessionnelBean extends Utilisateur {

	private String emploie ;
	private String surMoi;
	
	public ProfessionnelBean(String cin, String nom, String prenom, String email, String ville, String adresse,
			String motdepasse, String sexe, String numTel , String emploie , String surMoi) {
		super(cin, nom, prenom, email, ville, adresse, motdepasse, sexe, numTel);
		this.emploie = emploie;
		this.surMoi = surMoi ;
	
	}
	
	

	
	public String getSurMoi() {
		return surMoi;
	}




	public void setSurMoi(String surMoi) {
		this.surMoi = surMoi;
	}




	public ProfessionnelBean() {
		super();
	}


	public String getEmploie() {
		return emploie;
	}


	public void setEmploie(String emploie) {
		this.emploie = emploie;
	}


	@Override
	public String toString() {
		return "ProfessionnelBean [cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", ville="
				+ ville + ", adresse=" + adresse + ", motdepasse=" + motdepasse + ", sexe=" + sexe + ", numTel="
				+ numTel + ", getCin()=" + getCin() + ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom()
				+ ", getEmail()=" + getEmail() + ", getVille()=" + getVille() + ", getAdresse()=" + getAdresse()
				+ ", getMotdepasse()=" + getMotdepasse() + ", getSexe()=" + getSexe() + ", getNumTel()=" + getNumTel()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}
