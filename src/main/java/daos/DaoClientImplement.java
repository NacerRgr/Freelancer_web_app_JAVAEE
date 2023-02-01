//les méthodes de client
package daos;
import java.beans.Statement;
import java.util.Collections;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

import javaBeans.professionel;

import java.util.List;

import javaBeans.afficherbesoin;
import javaBeans.besoin;
import javaBeans.client;

public class DaoClientImplement implements DaoClient{
	  private DaoFactory daoFactory ;

		public DaoClientImplement(DaoFactory daoFactory) {
			super();
			this.daoFactory = daoFactory;
		}

	@Override
	public List<afficherbesoin> AfficherBesoins() throws DaoException {
		List<afficherbesoin> besoinClient = new ArrayList<afficherbesoin>();

		//List<client> besoinClient = new ArrayList<client>();
		//List<besoin> clientbesoin = new ArrayList<besoin>();

		Connection connexion = null;
		java.sql.Statement statement = null;
		ResultSet resultat = null;

		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT * FROM client c ,besoin b  where c.cin=b.cin;");

			while (resultat.next()) {

				String cin = resultat.getString("cin");
				

				String nom = resultat.getString("nom");
				

				String prenom = resultat.getString("prenom");
			

				String email = resultat.getString("email");
				String ville = resultat.getString("ville");
				String adresse = resultat.getString("adresse");
				String motdepasse = resultat.getString("motdepasse");

				String numTel=resultat.getString("numTel");
				String sexe=resultat.getString("sexe");
			
				
				
			

				int idBesoin=resultat.getInt("idBesoin");
				
				String titreBesoin = resultat.getString("titreBesoin");
				
				String description = resultat.getString("description");
				float prixApayer=resultat.getFloat("prixApayer");
				String Statut = resultat.getString("Status");
				String cinB = resultat.getString("b.cin");//cin de client
				//création d'un objet sur lequel on va  stocker ces attributs
				afficherbesoin affichebesoin=new afficherbesoin();
				affichebesoin.setCin(cin);//cin de client
				affichebesoin.setNom(nom);
				affichebesoin.setPrenom(prenom);
				affichebesoin.setEmail(email);
				affichebesoin.setVille(ville);
				affichebesoin.setAdresse(adresse);
				affichebesoin.setSexe(sexe);
				affichebesoin.setNumTel(numTel);
				affichebesoin.setIdBesoin(idBesoin);
				affichebesoin.setTitreBesoin(titreBesoin);
				affichebesoin.setDescription(description);
				affichebesoin.setPrixApayer(prixApayer);
				affichebesoin.setStatut(Statut);
				affichebesoin.setCinB(cinB);//cin référebce au client
				affichebesoin.setMotdepasse(motdepasse);
				//affecter ces valeurs à une liste	
				besoinClient.add(affichebesoin);
			}
		} catch (SQLException e) {
			throw new DaoException("Impossible de communiquer avec la base de données");
		} finally {
			try {
				if (connexion != null) {
					connexion.close();
				}
			} catch (SQLException e) {
				throw new DaoException("Impossible de communiquer avec la base de données");
			}
		}
		return besoinClient;
	}
// chercher un client à partir de dashboard
	@Override
	public List<afficherbesoin> chercherClient(String titreBesoin, String ville) throws DaoException {
		List<afficherbesoin> besoinClient = new ArrayList<afficherbesoin>();

		//List<client> besoinClient = new ArrayList<client>();
		//List<besoin> clientbesoin = new ArrayList<besoin>();

		Connection connexion = null;
		java.sql.Statement statement = null;
		ResultSet resultat = null;

		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT * FROM client c ,besoin b  where c.cin=b.cin and b.titreBesoin='"+titreBesoin+"' and c.ville='"+ville+"';");

			while (resultat.next()) {

				String cin = resultat.getString("cin");
				System.out.println("ua jointure des tables besoin et client cin="+cin);

				String nom = resultat.getString("nom");
				System.out.println("nom="+nom);

				String prenom = resultat.getString("prenom");
				System.out.println("prenom="+prenom);

				String email = resultat.getString("email");
				String ville1 = resultat.getString("ville");
				String adresse = resultat.getString("adresse");
				String motdepasse = resultat.getString("motdepasse");

				String numTel=resultat.getString("numTel");
				String sexe=resultat.getString("sexe");
				System.out.println("sexe="+sexe);
				
				
			

				int idBesoin=resultat.getInt("idBesoin");
				System.out.println("idBesoin="+idBesoin);
				String titreBesoin1 = resultat.getString("titreBesoin");
				System.out.println("titreBesoin="+titreBesoin1);
				String description = resultat.getString("description");
				float prixApayer=resultat.getFloat("prixApayer");
				System.out.println("prixApayer="+prixApayer);
				String Statut = resultat.getString("Statut");
				String cinB = resultat.getString("b.cin");//cin de client
				//création d'un objet sur lequel on va  stocker ces attributs
				afficherbesoin affichebesoin=new afficherbesoin();
				affichebesoin.setCin(cin);//cin de client
				affichebesoin.setNom(nom);
				affichebesoin.setPrenom(prenom);
				affichebesoin.setEmail(email);
				affichebesoin.setVille(ville1);
				affichebesoin.setAdresse(adresse);
				affichebesoin.setSexe(sexe);
				affichebesoin.setNumTel(numTel);
				affichebesoin.setIdBesoin(idBesoin);
				affichebesoin.setTitreBesoin(titreBesoin1);
				affichebesoin.setDescription(description);
				affichebesoin.setPrixApayer(prixApayer);
				affichebesoin.setStatut(Statut);
				affichebesoin.setCinB(cinB);//cin référebce au client
				System.out.println("prixApayer2="+affichebesoin.getPrixApayer());

				//affecter ces valeurs à une liste	
				besoinClient.add(affichebesoin);
			}
		} catch (SQLException e) {
			throw new DaoException("Impossible de communiquer avec la base de données");
		} finally {
			try {
				if (connexion != null) {
					connexion.close();
				}
			} catch (SQLException e) {
				throw new DaoException("Impossible de communiquer avec la base de données");
			}
		}
		return besoinClient;
	}

	
//chercher le client à partir son cin en se basant sur son besoin pour évaluer le client avec qui le professionnel travaillé
	@Override
	public List<afficherbesoin> chercherClient(int cinC) throws DaoException {
		// TODO Auto-generated method stub
		List<afficherbesoin> besoinClient = new ArrayList<afficherbesoin>();

		//List<client> besoinClient = new ArrayList<client>();
		//List<besoin> clientbesoin = new ArrayList<besoin>();

		Connection connexion = null;
		java.sql.Statement statement = null;
		ResultSet resultat = null;

		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT * FROM client c ,besoin b  where c.cin=b.cin and b.idBesoin='"+cinC+"';");

			while (resultat.next()) {

				String cin = resultat.getString("cin");
				

				String nom = resultat.getString("nom");
				

				String prenom = resultat.getString("prenom");
			

				String email = resultat.getString("email");
				String ville = resultat.getString("ville");
				String adresse = resultat.getString("adresse");
				String motdepasse = resultat.getString("motdepasse");

				String numTel=resultat.getString("numTel");
				String sexe=resultat.getString("sexe");
			
				
				
			

				int idBesoin=resultat.getInt("idBesoin");
				
				String titreBesoin = resultat.getString("titreBesoin");
				
				String description = resultat.getString("description");
				float prixApayer=resultat.getFloat("prixApayer");
				String Statut = resultat.getString("Status");
				String cinB = resultat.getString("b.cin");//cin de client
				//création d'un objet sur lequel on va  stocker ces attributs
				afficherbesoin affichebesoin=new afficherbesoin();
				affichebesoin.setCin(cin);//cin de client
				affichebesoin.setNom(nom);
				affichebesoin.setPrenom(prenom);
				affichebesoin.setEmail(email);
				affichebesoin.setVille(ville);
				affichebesoin.setAdresse(adresse);
				affichebesoin.setSexe(sexe);
				affichebesoin.setNumTel(numTel);
				affichebesoin.setIdBesoin(idBesoin);
				affichebesoin.setTitreBesoin(titreBesoin);
				affichebesoin.setDescription(description);
				affichebesoin.setPrixApayer(prixApayer);
				affichebesoin.setStatut(Statut);
				affichebesoin.setCinB(cinB);//cin référebce au client

				//affecter ces valeurs à une liste	
				besoinClient.add(affichebesoin);
			}
		} catch (SQLException e) {
			throw new DaoException("Impossible de communiquer avec la base de données");
		} finally {
			try {
				if (connexion != null) {
					connexion.close();
				}
			} catch (SQLException e) {
				throw new DaoException("Impossible de communiquer avec la base de données");
			}
		}
		return besoinClient;
	}

}
