//pour l'authentification d'admin et de client
package daos;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.http.HttpSession;
import javaBeans.client;

public class ClientDaoImpl implements DaoAuthentification{

	  private DaoFactory daoFactory ;

	    public ClientDaoImpl(DaoFactory daoFactory){
	        this.daoFactory = daoFactory;
	    }

	  
//authentification client
	@Override
	public int connecterC(String mail, String mdp) throws DaoException {
		Connection connexion = null;
	      java.sql.Statement statement = null;
	      ResultSet resultat = null;
	      int res = 0;
	      System.out.printf("dkhalna n connecter");
		  try {
			  
	            connexion = daoFactory.getConnection();
	            statement = connexion.createStatement();

	            resultat = statement.executeQuery("SELECT * FROM client WHERE email='"+mail+"' and motdepasse='"+mdp+"';");

	            if (resultat.next()) {
	            res=1;	

	            }else {
	            	res=0;
	            }
	        } catch (SQLException e) {
	        	System.out.println( "Erreur de recherche <br/>"
	                    + e.getMessage() );
	        }
		return res;
		
	}


	@Override
	public void inscrire(client var) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	//authentification Admin
	@Override
	public int connecterA(String email, String mdp) throws DaoException {
		// TODO Auto-generated method stub
		Connection connexion = null;
	      java.sql.Statement statement = null;
	      ResultSet resultat = null;
	      int res = 0;
	      System.out.printf("dkhalna n connecter");
		  try {
			  
	            connexion = daoFactory.getConnection();
	            statement = connexion.createStatement();

	            resultat = statement.executeQuery("SELECT * FROM admin WHERE email='"+email+"' and motdepasse='"+mdp+"';");

	            if (resultat.next()) {
	            res=1;	

	            }else {
	            	res=0;
	            }
	        } catch (SQLException e) {
	        	System.out.println( "Erreur de recherche <br/>"
	                    + e.getMessage() );
	        }
		return res;
	}


	//authentification Professionnel
	@Override
	public int connecterP(String email, String mdp) throws DaoException {
		// TODO Auto-generated method stub
		Connection connexion = null;
	      java.sql.Statement statement = null;
	      ResultSet resultat = null;
	      int res = 0;
	      System.out.printf("dkhalna n connecter de professionnel");
		  try {
			  
	            connexion = daoFactory.getConnection();
	            statement = connexion.createStatement();

	            resultat = statement.executeQuery("SELECT * FROM professionnel WHERE email='"+email+"' and motdepasse='"+mdp+"';");

	            if (resultat.next()) {
	            res=1;	

	            }else {
	            	res=0;
	            }
	        } catch (SQLException e) {
	        	System.out.println( "Erreur de recherche <br/>"
	                    + e.getMessage() );
	        }
		return res;
	}

//recuperer cin de professionnel
	@Override
	public String recupererCin(String email, String mdp) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
				Connection connexion = null;
			      java.sql.Statement statement = null;
			      ResultSet resultat = null;
			      String cinP = null;
			      System.out.printf("dkhalna n connecter de professionnel");
				  try {
					  
			            connexion = daoFactory.getConnection();
			            statement = connexion.createStatement();

			            resultat = statement.executeQuery("SELECT * FROM professionnel WHERE email='"+email+"' and motdepasse='"+mdp+"';");;
			            while (resultat.next()) {
							 cinP = resultat.getString("cin");
					            System.out.println("cinP="+cinP);


			            }
			        	
			        } catch (SQLException e) {
			        	System.out.println( "Erreur de recherche <br/>"
			                    + e.getMessage() );
			        }
				return cinP;
		
		
	
	}

}
