package daos;

import java.beans.Statement;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

import javaBeans.afficherservice;
import javaBeans.categoriesservices;
import javaBeans.evaluationProf;
import javaBeans.inviClientP;
import javaBeans.professionel;
import javaBeans.professionelAvis;
import javaBeans.service;

public class ProfessionnelDaoImpl implements DaoProfessionnel {
	private DaoFactory daoFactory;

	public ProfessionnelDaoImpl(DaoFactory daoFactory) {
		super();
		this.daoFactory = daoFactory;
	}

	// afficher les professionnels

	@Override
	public List<professionel> lister() throws DaoException {
		List<professionel> professionels = new ArrayList<professionel>();
		Connection connexion = null;
		java.sql.Statement statement = null;
		ResultSet resultat = null;

		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT * FROM professionnel;");

			while (resultat.next()) {
				String cin = resultat.getString("cin");
				String nom = resultat.getString("nom");
				String prenom = resultat.getString("prenom");
				String email = resultat.getString("email");
				String ville = resultat.getString("ville");
				String adresse = resultat.getString("adresse");
				String numTel = resultat.getString("numTel");
				String sexe = resultat.getString("sexe");
				String cv = resultat.getString("Cv");
				String surMoi = resultat.getString("surMoi");

				professionel PROFESSIONNEL = new professionel();
				PROFESSIONNEL.setCin(cin);

				PROFESSIONNEL.setNom(nom);
				PROFESSIONNEL.setPrenom(prenom);
				PROFESSIONNEL.setEmail(email);
				PROFESSIONNEL.setVille(ville);
				PROFESSIONNEL.setAdresse(adresse);
				PROFESSIONNEL.setCv(cv);
				PROFESSIONNEL.setSexe(sexe);
				PROFESSIONNEL.setSurMoi(surMoi);
				PROFESSIONNEL.setNumTel(numTel);

				professionels.add(PROFESSIONNEL);

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
		return professionels;
	}

	// ajouter un professionnel
	@Override
	public void ajouter(professionel var) throws DaoException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		// TODO Auto-generated method stub
		try {

			connexion = daoFactory.getConnection();

			preparedStatement = connexion.prepareStatement(
					"INSERT INTO professionnel (cin,nom,prenom,email,ville,adresse,motdepasse,numTel,sexe,surMoi,Cv) VALUES(?,?,?,?,?,?,?,?,?,?,?);");
			// affecter les valeurs enregistrer au professionnel
			preparedStatement.setString(1, var.getCin());
			preparedStatement.setString(2, var.getNom());
			preparedStatement.setString(3, var.getPrenom());
			preparedStatement.setString(4, var.getEmail());
			preparedStatement.setString(5, var.getVille());

			preparedStatement.setString(6, var.getAdresse());
			preparedStatement.setString(7, var.getMotdepasse());
			preparedStatement.setString(8, var.getNumTel());
			preparedStatement.setString(9, var.getSexe());
			preparedStatement.setString(10, var.getSurMoi());
			preparedStatement.setString(11, var.getCv());

			preparedStatement.executeUpdate();
			connexion.commit();

			System.out.println("Objet requête créé avec succès !");
			// update de la base de données
			// t= statement.executeUpdate("Update noms set prenom='Rahma' WHERE
			// prenom='Asmahan';");
			// System.out.println ( "Modofocation faite aec succès!" );
			// duppression de la base de données
			// t= statement.executeUpdate("delete from noms WHERE nom='ERRAGRAGY';");
			// System.out.println( "Suppression faite avec succès!" );
			/* Lancement d'une requête d'écriture */

		} catch (SQLException e) {
			System.out.println("erreur d'insertion! <br/>" + e.getMessage());

		}

	}

	// deleter un professionnel

	@Override
	public void delete(String idC) throws DaoException {
		// TODO Auto-generated method stub
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		try {

			connexion = daoFactory.getConnection();

			preparedStatement = connexion.prepareStatement("delete from professionnel WHERE cin='" + idC + "';");
			// affecter les valeurs enregistrer au professionnel

			preparedStatement.executeUpdate();
			connexion.commit();

			System.out.println("Objet supprimer avec succès !");

		} catch (SQLException e) {
			System.out.println("erreur d'insertion! <br/>" + e.getMessage());

		}

	}

	// modifier un professionnel
	@Override
	public void modifier(professionel p) throws DaoException, SQLException {
		// TODO Auto-generated method stub
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		connexion = daoFactory.getConnection();

		preparedStatement = connexion
				.prepareStatement("Update professionnel set nom='" + p.getNom() + "',prenom='" + p.getPrenom() + "',email='"
						+ p.getEmail() + "',ville='" + p.getVille() + "',adresse='" + p.getAdresse() +"',numTel='" + p.getNumTel() +"',surMoi='"
						+ p.getSurMoi() +"'WHERE cin='"+ p.getCin() + "';");
		// affecter les valeurs enregistrer au professionnel

		preparedStatement.executeUpdate();
		connexion.commit();

	}

	// ajouter service
	@Override
	public void ajouterService(String titre, String desc, float prix, String categories, String cinPro)
			throws DaoException {
		// TODO Auto-generated method stub
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		int t = 0;
		// TODO Auto-generated method stub
		try {

			connexion = daoFactory.getConnection();
			int categories1 = Integer.parseInt(categories);

			preparedStatement = connexion
					.prepareStatement("INSERT INTO service (titreService,description,prix,cin,idC) VALUES(?,?,?,?,?);");
			// affecter les valeurs enregistrer au professionnel
			preparedStatement.setString(1, titre);
			preparedStatement.setString(2, desc);
			preparedStatement.setFloat(3, prix);
			// String statut="attent";
			// preparedStatement.setString(4, statut);// si l'admin accepte devient oui ou
			// non

			preparedStatement.setString(4, cinPro);
			preparedStatement.setInt(5, categories1);

			preparedStatement.executeUpdate();
			connexion.commit();

		} catch (SQLException e) {
			System.out.println("erreur d'insertion! <br/>" + e.getMessage());

		}

	}

	// afficher services

	@Override
	public List<afficherservice> afficherServices(String cinp) throws Exception {
		// TODO Auto-generated method stub
		List<afficherservice> listeService = new ArrayList<afficherservice>();
		Connection connexion = null;
		java.sql.Statement statement = null;
		ResultSet resultat = null;

		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery(
					"SELECT * FROM service s , categoriesservices c, professionnel p where p.cin=s.cin and s.idC=c.idC and p.cin='"+cinp+"';");
			
			
			while (resultat.next()) {
				String cin = resultat.getString("p.cin");
				String idS = resultat.getString("s.idService");
				int idService =Integer.parseInt(idS);
				String titreS = resultat.getString("s.titreService");
				String description = resultat.getString("s.description");
				float prix = resultat.getFloat("s.prix");
				String categorie = resultat.getString("c.nomCategories");

				afficherservice afficherserv = new afficherservice();
				afficherserv.setCin(cin);
				afficherserv.setIdService(idService);
				afficherserv.setCategorie(categorie);
				afficherserv.setTitreS(titreS);
				afficherserv.setDescription(description);
				afficherserv.setPrix(prix);
				listeService.add(afficherserv);

			

			}
		} catch (SQLException e) {
			throw new DaoException("Impossible de communiquer avec la base de données 1");
		} finally {
			try {
				if (connexion != null) {
					connexion.close();
				}
			} catch (SQLException e) {
				throw new DaoException("Impossible de communiquer avec la base de données2");
			}
		}
		return listeService;
	}
 
	
	
	//lister un professionnel à partir de son cin
	@Override
	public List<professionel> listerUnprofessionnel(String cinp) throws DaoException {
		// TODO Auto-generated method stub
		List<professionel> professionels = new ArrayList<professionel>();
		Connection connexion = null;
		java.sql.Statement statement = null;
		ResultSet resultat = null;

		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT * FROM professionnel where cin='"+cinp+"';");

			while (resultat.next()) {
				String cin = resultat.getString("cin");
				String nom = resultat.getString("nom");
				String prenom = resultat.getString("prenom");
				String email = resultat.getString("email");
				String ville = resultat.getString("ville");
				String adresse = resultat.getString("adresse");
				String motdepasse = resultat.getString("motdepasse");
				String numtel = resultat.getString("numTel");
				String sexe = resultat.getString("sexe");
				String surMoi=resultat.getString("surMoi");
				professionel PROFESSIONNEL = new professionel();
				PROFESSIONNEL.setCin(cin);
				PROFESSIONNEL.setNom(nom);
				PROFESSIONNEL.setPrenom(prenom);
				PROFESSIONNEL.setEmail(email);
				PROFESSIONNEL.setVille(ville);
				PROFESSIONNEL.setAdresse(adresse);
				PROFESSIONNEL.setMotdepasse(motdepasse);
				PROFESSIONNEL.setNumTel(numtel);
				PROFESSIONNEL.setSexe(sexe);
				PROFESSIONNEL.setSurMoi(surMoi);
				
				professionels.add(PROFESSIONNEL);

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
		return professionels;
	}

	
	
	//supprimer un service 
	@Override
	public void deleteService(int idbesoin) throws DaoException {
		// TODO Auto-generated method stub
				Connection connexion = null;
				PreparedStatement preparedStatement = null;
				try {

					connexion = daoFactory.getConnection();

					preparedStatement = connexion.prepareStatement("delete from service WHERE idService='" + idbesoin + "';");
					// affecter les valeurs enregistrer au professionnel

					preparedStatement.executeUpdate();
					connexion.commit();

					System.out.println("Objet supprimer avec succès !");

				} catch (SQLException e) {
					System.out.println("erreur d'insertion! <br/>" + e.getMessage());

				}

		
	}

	
	//modifier un service
	@Override
	public void  modifierService(afficherservice listservice) throws DaoException, SQLException {
		// TODO Auto-generated method stub
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
	
		int t=0;
	
	

		
		 try { 
			
			 
			 connexion = daoFactory.getConnection();
			 
		      System.out.println( "titre!"+listservice.getTitreS());
		      System.out.println( "description !" +listservice.getDescription());
		      System.out.println( "prix !" +listservice.getPrix());
		
            String cat=listservice.getCategorie();
            int cate=Integer.parseInt(cat);
			System.out.println( "idC from sql ="+cat );	

		 
		
			preparedStatement = connexion.prepareStatement("Update service set titreService='"+listservice.getTitreS()+"',description='"+listservice.getDescription()+"',prix='"+listservice.getPrix()+"',idC='"+cate+"' WHERE idService='"+listservice.getIdService()+"';");
			//preparedStatement = connexion.prepareStatement("Update service set titreService='fatima',description='fati',prix='"+234+"',idC='"+3+"' WHERE idService='"+31+"';");

			preparedStatement.executeUpdate();
			connexion.commit();
		
		 
		 } catch ( SQLException e ) {
      	System.out.println( "erreur de modification! <br/>"
                + e.getMessage() );
		

    }
		
	}

	// selectionner le service à modifier pour le professionnel ayant fait l'authentification
	@Override
	public List<afficherservice> champServicesmodifier(String cinPP, int idbesoin) throws DaoException {
		// TODO Auto-generated method stub
		List<afficherservice> listeService = new ArrayList<afficherservice>();
		Connection connexion = null;
		java.sql.Statement statement = null;
		ResultSet resultat = null;

		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery(
					"SELECT * FROM service s , categoriesservices c, professionnel p where p.cin=s.cin and s.idC=c.idC and p.cin='"+cinPP+"' and idService='"+idbesoin+"';");
			
			
			while (resultat.next()) {
				String cin = resultat.getString("p.cin");
				String idS = resultat.getString("s.idService");
				int idService =Integer.parseInt(idS);
				String titreS = resultat.getString("s.titreService");
				String description = resultat.getString("s.description");
				float prix = resultat.getFloat("s.prix");
				String categorie = resultat.getString("c.nomCategories");

				afficherservice afficherserv = new afficherservice();
				afficherserv.setCin(cin);
				afficherserv.setIdService(idService);
				afficherserv.setCategorie(categorie);
				afficherserv.setTitreS(titreS);
				afficherserv.setDescription(description);
				afficherserv.setPrix(prix);
				listeService.add(afficherserv);

			

			}
		} catch (SQLException e) {
			throw new DaoException("Impossible de communiquer avec la base de données 1");
		} finally {
			try {
				if (connexion != null) {
					connexion.close();
				}
			} catch (SQLException e) {
				throw new DaoException("Impossible de communiquer avec la base de données2");
			}
		}
		return listeService;
	}
//lister un professionnel à partir con cin pour afficher ses infos dans son profil
	@Override
	public List<professionel> listerProfilProfessionnel(String cinp) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	
	//modifier un cv càd modifier l'image qui se considère cv 
	@Override
	public void modifierCvProfessionnel(String path, String cinp) throws DaoException, SQLException, IOException {
		// TODO Auto-generated method stub		
		Connection connexion = null;
		PreparedStatement stmt = null;
	
		 try { 
			 connexion = daoFactory.getConnection(); 
			// String query = ;	
			 String query="Update professionnel set Cv=? WHERE cin=?";
				stmt=connexion.prepareStatement(query);
				stmt.setString(1, path);
				stmt.setString(2, cinp);
				int row=stmt.executeUpdate();
				if(row>0)
				{
					System.out.println("Image added into databases successfully.");
				}else {
					System.out.println("failed to upload image.");
					
				}
	    
		 
		 } catch ( SQLException e ) {
      	System.out.println( "erreur de modification! <br/>"
                + e.getMessage() );
		

    }
		
	}

	
	//zfficher le cv d'un professionnel
	@Override
	public List<String> afficherCvProf(String cinPp){
		// TODO Auto-generated method stub
		List<String> cv = new ArrayList<String>();
		Connection connexion = null;
		java.sql.Statement statement = null;
		ResultSet resultat = null;

		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT * FROM professionnel p where p.cin='"+cinPp+"';");
			
			
			while (resultat.next()) {
				String image = resultat.getString("p.Cv");
				cv.add(image);
				
			}
		} catch (SQLException e) {
			System.out.println( "erreur de récupperation de cv! <br/>"
	                + e.getMessage() );
		}
			
		return cv;
	}

	//methode d'évaluation d'un client par le professionnel
	@Override
	public void EvaluerClient(String cinClient, int nbreEtoileC, String cinProf,String description) throws DaoException {
		// TODO Auto-generated method stub
		
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		int t = 0;
		// TODO Auto-generated method stub
		try {

			connexion = daoFactory.getConnection();

			//preparedStatement = connexion.prepareStatement(
					//"INSERT INTO evaluation (cinClient,cinProf,nbrEtoileP) VALUES(?,?,?);");
			
			preparedStatement = connexion
      				.prepareStatement("Update evaluation set nbrEtoileC='"+nbreEtoileC+"',description='"+description+"'  WHERE cinClient='"+ cinClient + "'"
      						+ "and cinProf='"+cinProf+"' and nbrEtoileP!=0;");
			preparedStatement.executeUpdate();
			connexion.commit();
		
	} catch (SQLException e) {
		System.out.println("erreur d'insertion! <br/>" + e.getMessage());

	}
	
	}
//méthode d'envoi d'invitation par le professionnel au client pour travailler
	@Override
	public void invitationC(String cinP, int idB) throws DaoException 
	{
		// TODO Auto-generated method stub
		
				Connection connexion = null;
				PreparedStatement preparedStatement = null;
				int t = 0;
				// TODO Auto-generated method stub
				try {

					connexion = daoFactory.getConnection();

					preparedStatement = connexion.prepareStatement(
							"INSERT INTO invitationP (cinPro,idB) VALUES(?,?);");
					// affecter les valeurs enregistrer au professionnel
					preparedStatement.setString(1,cinP );
					preparedStatement.setInt(2, idB);
					
					
					

					preparedStatement.executeUpdate();
					connexion.commit();
				
			} catch (SQLException e) {
				System.out.println("erreur d'insertion! <br/>" + e.getMessage());

			}	
		
	}
//afficher les invitations envoyés par le client au professionnel
@Override
public List<inviClientP> afficherOffreClient(String cinPro) throws DaoException {
	List<inviClientP>  afficheOffreClient= new ArrayList<inviClientP>();
	Connection connexion = null;
	java.sql.Statement statement = null;
	ResultSet resultat = null;

	try {
		connexion = daoFactory.getConnection();
		statement = connexion.createStatement();
		resultat = statement.executeQuery(
				"SELECT distinct c.nom , c.prenom ,i.cinC,i.cinP  FROM client AS c ,  invitationc AS i , professionnel as p  WHERE c.cin  = i.cinC  AND i.cinP='"+cinPro+"';");
		
		
		while (resultat.next()) {

			
			String nom=resultat.getString("nom");
			String prenom=resultat.getString("prenom");
			String cinc=resultat.getString("cinC");
			String cinp=resultat.getString("cinP");

			inviClientP afficherOffre = new inviClientP();
	
		
			afficherOffre.setNomC(nom);
			afficherOffre.setPrenomC(prenom);
			afficherOffre.setCinC(cinc);
			afficherOffre.setCinP(cinp);
			
			
			afficheOffreClient.add(afficherOffre);

		

		}
	} catch (SQLException e) {
		throw new DaoException("Impossible de communiquer avec la base de données 1");
	} finally {
		try {
			if (connexion != null) {
				connexion.close();
			}
		} catch (SQLException e) {
			throw new DaoException("Impossible de communiquer avec la base de données2");
		}
	}
	return afficheOffreClient;
}

@Override
public void accepetClient(String path, String cinp) throws DaoException, SQLException, IOException {
	// TODO Auto-generated method stub
	
}

//supprimer l'invitation envoyée par le client au professionnel
@Override
public void deleteInvitation(String cinc, String cinp) {
	// TODO Auto-generated method stub
	Connection connexion = null;
	PreparedStatement preparedStatement = null;
	
	try {

		connexion = daoFactory.getConnection();

		preparedStatement = connexion.prepareStatement("delete from invitationc WHERE cinC='" + cinc + "'and cinP='" + cinp + "';");
		
		// affecter les valeurs enregistrer au professionnel

		preparedStatement.executeUpdate();
		connexion.commit();

		System.out.println("Objet supprimer avec succès !");

	} catch (SQLException e) {
		System.out.println("erreur d'insertion! <br/>" + e.getMessage());

	}

	
}
//Accepter l'invitation en ajoutant le client à la table evaluation
@Override
public void ajouterProfEvaluation(String cinc, String cinp) {
	Connection connexion = null;
	PreparedStatement preparedStatement = null;
	int t = 0;
	// TODO Auto-generated method stub
	try {

		connexion = daoFactory.getConnection();

		preparedStatement = connexion.prepareStatement(
				"INSERT INTO evaluation (cinClient,cinProf) VALUES(?,?);");
		// affecter les valeurs enregistrer au professionnel
		preparedStatement.setString(1, cinc);
		preparedStatement.setString(2, cinp);
	

		preparedStatement.executeUpdate();
		connexion.commit();


	} catch (SQLException e) {
		System.out.println("erreur d'insertion! <br/>" + e.getMessage());

	}
	
}
//affichage des clients affectés au professionnel
@Override
public List<evaluationProf> mesClientP(String cinP ) throws DaoException {
	// TODO Auto-generated method stub
			List<evaluationProf> mesClient = new ArrayList<evaluationProf>();
			Connection connexion = null;
			java.sql.Statement statement = null;
			ResultSet resultat = null;

			try {
				connexion = daoFactory.getConnection();
				statement = connexion.createStatement();
				resultat = statement.executeQuery(
						"SELECT * from evaluation e,client c where e.cinClient=c.cin and cinProf='"+cinP+"';");
				
				
				while (resultat.next()) {
					String cinc = resultat.getString("e.cinClient");
					String cinp = resultat.getString("e.cinProf");
					String nom = resultat.getString("c.nom");
					String prenom = resultat.getString("c.prenom");
					String progresp = resultat.getString("progresP");
					int nbrEtoilep=resultat.getInt("nbrEtoileP");
					int nbrEtoilec=resultat.getInt("nbrEtoileC");
					String description = resultat.getString("description");
					
					

					evaluationProf evaluationprof = new evaluationProf();
					evaluationprof.setCinProf(cinp);
					evaluationprof.setCinClient(cinc);
					evaluationprof.setNom(nom);
					evaluationprof.setPrenom(prenom);
					evaluationprof.setProgresP(progresp);
					evaluationprof.setNbrEtoileC(nbrEtoilec);
					evaluationprof.setNbrEtoileP(nbrEtoilep);
					evaluationprof.setDescription(description);
					mesClient.add(evaluationprof);
				
					

				}
			
			} catch (SQLException e) {
				throw new DaoException("Impossible de communiquer avec la base de données 1");
			} finally {
				try {
					if (connexion != null) {
						connexion.close();
					}
				} catch (SQLException e) {
					throw new DaoException("Impossible de communiquer avec la base de données2");
				}
			}
			return mesClient;
}
//la methode indique que le prof envoie au client qu'il a finalisé le travail
              @Override
              public void FinaliserProf(String cinC, String cinP) {
            	  Connection connexion = null;
          		PreparedStatement preparedStatement = null;
          		try{

          		connexion = daoFactory.getConnection();

          		preparedStatement = connexion
          				.prepareStatement("Update evaluation set progresP='terminer' WHERE cinClient='"+ cinC + "'and cinProf='"+cinP+"';");
          		// affecter les valeurs enregistrer au professionnel

          		preparedStatement.executeUpdate();
          		connexion.commit();
                }catch (SQLException e) {
	             System.out.println("erreur d'insertion! <br/>" + e.getMessage());
                  }
                }

              
         //Chercher les infos de client à évaluer par le professionnel
			@Override
			public List<evaluationProf> monClientP(String cinc) throws DaoException {
				// TODO Auto-generated method stub
				List<evaluationProf> monClient = new ArrayList<evaluationProf>();
				Connection connexion = null;
				java.sql.Statement statement = null;
				ResultSet resultat = null;

				try {
					connexion = daoFactory.getConnection();
					statement = connexion.createStatement();
					resultat = statement.executeQuery("SELECT * from client where cin='"+cinc+"';"); 
					
					
					while (resultat.next()) {
						String cin = resultat.getString("cin");

						String nom = resultat.getString("nom");
						String prenom = resultat.getString("prenom");
						String  email= resultat.getString("email");
	
						evaluationProf evaluationprof = new evaluationProf();
				    	evaluationprof.setCinClient(cin);
						evaluationprof.setNom(nom);
						evaluationprof.setPrenom(prenom);
						monClient.add(evaluationprof);
					}} catch (SQLException e) {
						throw new DaoException("Impossible de communiquer avec la base de données 1");
					} finally {
						try {
							if (connexion != null) {
								connexion.close();
							}
						} catch (SQLException e) {
							throw new DaoException("Impossible de communiquer avec la base de données2");
						}
					}
				return monClient;
			}

			@Override
			public void invitationsC(String cinP, int idB) throws DaoException {
				// TODO Auto-generated method stub
				
			}
//afficher les avis des professionnels sur un client
			@Override
			public List<professionelAvis> avisProfSurClient(String cinclient) throws DaoException {
				List<professionelAvis> profAvisClient = new ArrayList<professionelAvis>();
				Connection connexion = null;
				java.sql.Statement statement = null;
				ResultSet resultat = null;

				try {
					connexion = daoFactory.getConnection();
					statement = connexion.createStatement();
					resultat = statement.executeQuery("select p.nom , p.prenom, e.descriptionP,e.nbrEtoileC from client c,professionnel p,evaluation e where c.cin=e.cinClient and p.cin=e.cinProf "
							+ "                                                and e.cinClient='"+cinclient+"';"); 
					
					
					while (resultat.next()) {
						

						String nom = resultat.getString("nom");
						String prenom = resultat.getString("prenom");
						String description=resultat.getString("descriptionP");
						int etoilesC=resultat.getInt("nbrEtoileC");
	
						professionelAvis avisprof = new professionelAvis();
						
						avisprof.setNomP(nom);
						avisprof.setPrenomP(prenom);
						avisprof.setEtoileC(etoilesC);
						avisprof.setDescription(description);
						
						profAvisClient.add(avisprof);
					}} catch (SQLException e) {
						throw new DaoException("Impossible de communiquer avec la base de données 1");
					} finally {
						try {
							if (connexion != null) {
								connexion.close();
							}
						} catch (SQLException e) {
							throw new DaoException("Impossible de communiquer avec la base de données2");
						}
					}
				return profAvisClient;
			}
              }

