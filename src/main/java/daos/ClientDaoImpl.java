package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.ClientBean;
import beans.Utilisateur;

public class ClientDaoImpl implements ClientDao {

	private DaoFactory daoFactory;
	
	public ClientDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<ClientBean> lister() throws DaoException {
		List<ClientBean> clients = new ArrayList<ClientBean>();
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;

		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT *  FROM client;");

			while (resultat.next()) {
				String cin = resultat.getString("cin");
				String nom = resultat.getString("nom");
				String prenom = resultat.getString("prenom");
				String email = resultat.getString("email");
				String ville = resultat.getString("ville");
				String adresse = resultat.getString("adresse");

				ClientBean client =  new ClientBean();
				client.setCin(cin);
				client.setNom(nom);
				client.setPrenom(prenom);
				client.setEmail(email);
				client.setVille(ville);
				client.setAdresse(adresse);

				clients.add(client);

			}
		} catch (SQLException e) {
			throw new DaoException("Impossible de communiquer avec la base de données ou il y a un probleme dans la methode lister 1");
		} finally {
			try {
				if (connexion != null) {
					connexion.close();
				}
			} catch (SQLException e) {
				throw new DaoException("Impossible de communiquer avec la base de données ou il y a un probleme dans la methode lister 2");
			}
		}
		return clients;

	}

	@Override
	public void ajouter(ClientBean var) throws DaoException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion
					.prepareStatement("INSERT INTO client(cin,nom,prenom,email,ville,adresse,motdepasse,sexe,numTel) VALUES(?,?,?,?,?,?,?,?,?);");
			preparedStatement.setString(1, var.getCin());
			preparedStatement.setString(2, var.getNom());
			preparedStatement.setString(3, var.getPrenom());
			preparedStatement.setString(4, var.getEmail());
			preparedStatement.setString(5, var.getVille());
			preparedStatement.setString(6, var.getAdresse());
			preparedStatement.setString(7, var.getMotdepasse());
			preparedStatement.setString(8, var.getSexe());
			preparedStatement.setString(9, var.getNumTel());

			preparedStatement.executeUpdate();
			connexion.commit();

		} catch (SQLException e) {
			throw new DaoException("Impossible de communiquer avec la base de données");
		} finally {
			try {
				if (connexion != null) {
					connexion.rollback();
				}
			} catch (SQLException e) {
				throw new DaoException("Impossible de communiquer avec la base de données");
			}
		}		
	}

	@Override
	public void delete(String cin) throws DaoException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("delete from client where cin = ?;");
			preparedStatement.setString(1, cin);

			preparedStatement.executeUpdate();
			connexion.commit();

		} catch (SQLException e) {
			throw new DaoException("Impossible de communiquer avec la base de données");
		} finally {
			try {
				if (connexion != null) {
					connexion.rollback();
				}
			} catch (SQLException e) {
				throw new DaoException("Impossible de communiquer avec la base de données");
			}
		}		
	}

	@Override
	public void modifier(ClientBean var) throws DaoException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("update client set nom = ? , prenom = ? , ville = ?  , email = ? ,  adresse = ?  , motdepasse = ? , sexe = ? , numTel = ?   where cin = ?;");
			preparedStatement.setString(1, var.getNom());
			preparedStatement.setString(2, var.getPrenom());
			preparedStatement.setString(3, var.getVille());
			preparedStatement.setString(4, var.getEmail());
			preparedStatement.setString(5, var.getAdresse());
			preparedStatement.setString(6, var.getMotdepasse());
			preparedStatement.setString(7, var.getSexe());
			preparedStatement.setString(8, var.getNumTel());

			preparedStatement.setString(9, var.getCin());

			preparedStatement.executeUpdate();
			connexion.commit();

		} catch (SQLException e) {
			throw new DaoException("Impossible de communiquer avec la base de données ou un probleme dans la methode modifier 1");
		} finally {
			try {
				if (connexion != null) {
					connexion.rollback();
				}
			} catch (SQLException e) {
				throw new DaoException("Impossible de communiquer avec la base de données  ou un probleme dans la methode modifier 2");
			}
		}
	}		


	
	
	
}
	
	
	


