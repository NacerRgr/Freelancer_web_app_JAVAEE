package daos1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.AdminBean;
import beans.ClientBean;
import beans.Utilisateur;

public class AdminDaoImpl implements AdminDao {

	private DaoFactory daoFactory;
	public AdminDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	
	@Override
	public AdminBean listerUn(String cin) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int Authenticate(String email, String mdp) throws DaoException {
		Connection connexion = null;
	      java.sql.Statement statement = null;
	      ResultSet resultat = null;
	      int res = 0 ;
		  try {
			  
	            connexion = daoFactory.getConnection();
	            statement = connexion.createStatement();

	            resultat = statement.executeQuery("SELECT * FROM admin WHERE email='"+email+"' and motdepasse='"+mdp+"';");

	            if (resultat.next()) {
	            	res = 1 ;
	            }
	            
	        } catch (SQLException e) {
	        	System.out.println( "Erreur de recherche professionnel<br/>"
	                    + e.getMessage() );
	        }
		return res;
	}

	@Override
	public void SignIn(AdminBean user) throws DaoException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public AdminBean chercher(String email, String mdp) throws DaoException {
		Connection connexion = null;
		java.sql.Statement statement = null;
		ResultSet resultat = null;
		AdminBean client = new AdminBean();

		try {

			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			System.out.println("nom");

			resultat = statement
					.executeQuery("SELECT * FROM admin WHERE email='" + email + "' and motdepasse='" + mdp + "';");

			while (resultat.next()) {

				String cin = resultat.getString("cin");
				String nom = resultat.getString("nom");
				String prenom = resultat.getString("prenom");
				String email1 = resultat.getString("email");
				String ville = resultat.getString("ville");
				String adresse = resultat.getString("adresse");

				client.setCin(cin);
				client.setNom(nom);
				client.setPrenom(prenom);
				client.setEmail(email1);
				client.setVille(ville);
				client.setAdresse(adresse);
				
				System.out.println("nom11"+nom);

			}

		} catch (SQLException e) {
			System.out.println("Erreur de recherche client<br/>" + e.getMessage());
		}
		return client;
	}

}
