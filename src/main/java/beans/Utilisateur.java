package beans;

public class Utilisateur {

	protected String cin , nom , prenom , email , ville , adresse , motdepasse , sexe , numTel;

	public Utilisateur(String cin, String nom, String prenom, String email, String ville, String adresse,
			String motdepasse, String sexe, String numTel) {
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.ville = ville;
		this.adresse = adresse;
		this.motdepasse = motdepasse;
		this.sexe = sexe;
		this.numTel = numTel;
	}
	
	public Utilisateur() {
		
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getMotdepasse() {
		return motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	
	
	
	
	
}
