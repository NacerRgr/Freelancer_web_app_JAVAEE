package beans;

public class ClientBean extends Utilisateur{

	public ClientBean(String cin, String nom, String prenom, String email, String ville, String adresse,
			String motdepasse, String sexe, String numTel) {
		super(cin, nom, prenom, email, ville, adresse, motdepasse, sexe, numTel);
	}
	
	
	public ClientBean() {
		super();
	}
}
