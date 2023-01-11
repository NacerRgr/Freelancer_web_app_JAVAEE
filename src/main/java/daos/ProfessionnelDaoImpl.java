package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.ClientBean;
import beans.ProfessionnelBean;

public class ProfessionnelDaoImpl implements ProfessionnelDao {

	private DaoFactory daoFactory;
	
	public ProfessionnelDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<ProfessionnelBean> lister() throws DaoException {
		List<ProfessionnelBean> professionnels = new ArrayList<ProfessionnelBean>();
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;

		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT *  FROM professionnel;");

			while (resultat.next()) {
				String cin = resultat.getString("cin");
				String nom = resultat.getString("nom");
				String prenom = resultat.getString("prenom");
				String email = resultat.getString("email");
				String ville = resultat.getString("ville");
				String adresse = resultat.getString("adresse");
				String empoloie = resultat.getString("emploie");
				String surMoi = resultat.getString("surMoi");
				String numTel = resultat.getString("numTel");
				String sexe = resultat.getString("sexe");
				String motdepasse = resultat.getString("motdepasse");

				ProfessionnelBean professionnel =  new ProfessionnelBean();
				professionnel.setCin(cin);
				professionnel.setNom(nom);
				professionnel.setPrenom(prenom);
				professionnel.setEmail(email);
				professionnel.setVille(ville);
				professionnel.setAdresse(adresse);
				professionnel.setEmploie(empoloie);
				professionnel.setMotdepasse(motdepasse);
				professionnel.setSurMoi(surMoi);
				professionnel.setNumTel(numTel);
				professionnel.setSexe(sexe);
				
				
				
				professionnels.add(professionnel);

			}
		} catch (SQLException e) {
			throw new DaoException("Impossible de communiquer avec la base de données ou il y a un probleme dans la methode lister professionnel 1");
		} finally {
			try {
				if (connexion != null) {
					connexion.close();
				}
			} catch (SQLException e) {
				throw new DaoException("Impossible de communiquer avec la base de données ou il y a un probleme dans la methode lister professionnel 2");
			}
		}
		return professionnels;

	}

	@Override
	public void ajouter(ProfessionnelBean var) throws DaoException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion
					.prepareStatement("INSERT INTO professionnel(cin,nom,prenom,email,ville,adresse,motdepasse,sexe,numTel,emploie) VALUES(?,?,?,?,?,?,?,?,?,?);");
			preparedStatement.setString(1, var.getCin());
			preparedStatement.setString(2, var.getNom());
			preparedStatement.setString(3, var.getPrenom());
			preparedStatement.setString(4, var.getEmail());
			preparedStatement.setString(5, var.getVille());
			preparedStatement.setString(6, var.getAdresse());
			preparedStatement.setString(7, var.getMotdepasse());
			preparedStatement.setString(8, var.getSexe());
			preparedStatement.setString(9, var.getNumTel());
			preparedStatement.setString(10, var.getEmploie());


			preparedStatement.executeUpdate();
			connexion.commit();

		} catch (SQLException e) {
			throw new DaoException("Impossible de communiquer avec la base de données 1 on update professionnelImp class");
		} finally {
			try {
				if (connexion != null) {
					connexion.rollback();
				}
			} catch (SQLException e) {
				throw new DaoException("Impossible de communiquer avec la base de données 2  on update professionnelImp class");
			}
		}		
	}

	@Override
	public void delete(String cin) throws DaoException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("delete from professionnel where cin = ?;");
			preparedStatement.setString(1, cin);

			preparedStatement.executeUpdate();
			connexion.commit();

		} catch (SQLException e) {
			throw new DaoException("Impossible de communiquer avec la base de données 1 method delete professionnelImpl");
		} finally {
			try {
				if (connexion != null) {
					connexion.rollback();
				}
			} catch (SQLException e) {
				throw new DaoException("Impossible de communiquer avec la base de données 2 method delete professionnelImpl");
			}
		}		
	}

	@Override
	public void modifier(ProfessionnelBean var) throws DaoException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("update professionnel set nom = ? , prenom = ? , ville = ?  , email = ? ,  adresse = ?  , motdepasse = ? , sexe = ? , numTel = ?  , emploie = ?  where cin = ?;");
			preparedStatement.setString(1, var.getNom());
			preparedStatement.setString(2, var.getPrenom());
			preparedStatement.setString(3, var.getVille());
			preparedStatement.setString(4, var.getEmail());
			preparedStatement.setString(5, var.getAdresse());
			preparedStatement.setString(6, var.getMotdepasse());
			preparedStatement.setString(7, var.getSexe());
			preparedStatement.setString(8, var.getNumTel());

			preparedStatement.setString(9, var.getCin());
			
			preparedStatement.setString(10, var.getEmploie());

			
			preparedStatement.executeUpdate();
			connexion.commit();

		} catch (SQLException e) {
			throw new DaoException("Impossible de communiquer avec la base de données ou un probleme dans la methode modifier 1 professionnelImpl");
		} finally {
			try {
				if (connexion != null) {
					connexion.rollback();
				}
			} catch (SQLException e) {
				throw new DaoException("Impossible de communiquer avec la base de données  ou un probleme dans la methode modifier 2 professionnelImpl");
			}
		}
	}		

}
