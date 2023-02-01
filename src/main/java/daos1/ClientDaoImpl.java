package daos1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.ClientBean;
import beans.EvaluationClient;
import beans.ProgresProf;
import beans.Utilisateur;
import beans.mesInvitations;

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

				ClientBean client = new ClientBean();
				client.setCin(cin);
				client.setNom(nom);
				client.setPrenom(prenom);
				client.setEmail(email);
				client.setVille(ville);
				client.setAdresse(adresse);

				clients.add(client);

			}
		} catch (SQLException e) {
			throw new DaoException(
					"Impossible de communiquer avec la base de données ou il y a un probleme dans la methode lister 1");
		} finally {
			try {
				if (connexion != null) {
					connexion.close();
				}
			} catch (SQLException e) {
				throw new DaoException(
						"Impossible de communiquer avec la base de données ou il y a un probleme dans la methode lister 2");
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
			preparedStatement = connexion.prepareStatement(
					"INSERT INTO client(cin,nom,prenom,email,ville,adresse,motdepasse,sexe,numTel) VALUES(?,?,?,?,?,?,?,?,?);");
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
	public void delete1(String cin) throws DaoException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("delete from client where cin = ?;");
			preparedStatement.setString(1, cin);

			preparedStatement.executeUpdate();
			connexion.commit();

		} catch (SQLException e) {
			throw new DaoException("Impossible de communiquer avec la base de données 11xxx1");
		} finally {
			try {
				if (connexion != null) {
					connexion.rollback();
				}
			} catch (SQLException e) {
				throw new DaoException("Impossible de communiquer avec la base de données 222");
			}
		}
	}

	@Override
	public void modifier(ClientBean var) throws DaoException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement(
					"update client set nom = ? , prenom = ? , ville = ?  , email = ? ,  adresse = ?  , motdepasse = ? , sexe = ? , numTel = ?   where cin = ?;");
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
			throw new DaoException(
					"Impossible de communiquer avec la base de données ou un probleme dans la methode modifier 1");
		} finally {
			try {
				if (connexion != null) {
					connexion.rollback();
				}
			} catch (SQLException e) {
				throw new DaoException(
						"Impossible de communiquer avec la base de données  ou un probleme dans la methode modifier 2");
			}
		}
	}

	@Override
	public List<mesInvitations> afficher(String cinClient) throws DaoException {

		List<mesInvitations> MesInvitaions = new ArrayList<mesInvitations>();
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;

		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery(
					"select p.nom , p.prenom , p.emploie , i.EtatInvitation , i.id from professionnel p , invitationc i  where p.cin = i.cinP and i.cinC='"
							+ cinClient + "';");

			while (resultat.next()) {

				String nom = resultat.getString("nom");
				String prenom = resultat.getString("prenom");
				String emploie = resultat.getString("emploie");
				String etat = resultat.getString("EtatInvitation");
				int id = resultat.getInt("id");
				mesInvitations inv = new mesInvitations();
				inv.setNom(nom);
				inv.setPrenom(prenom);
				inv.setFonction(emploie);
				inv.setEtatInv(etat);
				inv.setId(id);
				MesInvitaions.add(inv);

			}
		} catch (SQLException e) {
			throw new DaoException(
					"Impossible de communiquer avec la base de données ou il y a un probleme dans la methode afficher 1");
		} finally {
			try {
				if (connexion != null) {
					connexion.close();
				}
			} catch (SQLException e) {
				throw new DaoException(
						"Impossible de communiquer avec la base de données ou il y a un probleme dans la methode afficher 2");
			}
		}

		return MesInvitaions;
	}

	@Override
	public void inviter(String cinC, String cinP) throws DaoException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion
					.prepareStatement("INSERT INTO invitationc(cinC,cinP) VALUES('" + cinC + "','" + cinP + "');");

			preparedStatement.executeUpdate();
			connexion.commit();

		} catch (SQLException e) {
			throw new DaoException("Impossible de communiquer avec la base de données inviter() 1");
		} finally {
			try {
				if (connexion != null) {
					connexion.rollback();
				}
			} catch (SQLException e) {
				throw new DaoException("Impossible de communiquer avec la base de données inviter() 2 ");
			}
		}

	}

	@Override
	public List<ProgresProf> Progres(String CinClient) throws DaoException {

		List<ProgresProf> ProgresProfs = new ArrayList<ProgresProf>();
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;

		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery(
					"select p.nom , p.prenom , p.emploie , p.cin , e.progresP , e.description from professionnel p , evaluation  e  where p.cin = e.cinProf and e.cinClient='"
							+ CinClient + "';");

			while (resultat.next()) {

				String nom = resultat.getString("nom");
				String prenom = resultat.getString("prenom");
				String emploie = resultat.getString("emploie");
				String progres = resultat.getString("progresP");
				String cin = resultat.getString("cin");
				String commentaire = resultat.getString("description");
				ProgresProf progress = new ProgresProf();
				progress.setNom(nom);
				progress.setPrenom(prenom);
				progress.setEmpploie(emploie);
				progress.setProgres(progres);
				progress.setCin(cin);
				progress.setCommentaire(commentaire);
				ProgresProfs.add(progress);

			}
		} catch (SQLException e) {
			throw new DaoException(
					"Impossible de communiquer avec la base de données ou il y a un probleme dans la methode afficher 1");
		} finally {
			try {
				if (connexion != null) {
					connexion.close();
				}
			} catch (SQLException e) {
				throw new DaoException(
						"Impossible de communiquer avec la base de données ou il y a un probleme dans la methode afficher 2");
			}
		}

		return ProgresProfs;
	}

	@Override
	public void Evaluer(EvaluationClient eva) throws DaoException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion
					.prepareStatement("update evaluation set nbrEtoileP = ? , description = ?   where cinProf = '"
							+ eva.getCinProf() + "' and cinClient = '" + eva.getCinClient() + "';");
			preparedStatement.setString(1, eva.getNbrEtoileP());
			preparedStatement.setString(2, eva.getDesc());
			System.out.println("im here");

			preparedStatement.executeUpdate();
			connexion.commit();

		} catch (SQLException e) {
			throw new DaoException(
					"Impossible de communiquer avec la base de données ou un probleme dans la methode modifier 1");
		} finally {
			try {
				if (connexion != null) {
					connexion.rollback();
				}
			} catch (SQLException e) {
				throw new DaoException(
						"Impossible de communiquer avec la base de données  ou un probleme dans la methode modifier 2");
			}
		}
	}

	@Override
	public void supprimerInvitationProfessionnel(int id) throws DaoException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("delete from invitationc where id = ?;");
			preparedStatement.setInt(1, id);

			preparedStatement.executeUpdate();
			connexion.commit();

		} catch (SQLException e) {
			throw new DaoException("Impossible de communiquer avec la base de données invitationc 1 ");
		} finally {
			try {
				if (connexion != null) {
					connexion.rollback();
				}
			} catch (SQLException e) {
				throw new DaoException("Impossible de communiquer avec la base de données invitationc 2");
			}
		}
	}

	@Override
	public void AccepterDemande(String cinClient, String cinProf) throws DaoException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("INSERT INTO evaluation(cinClient,cinProf) VALUES(?,?);");
			preparedStatement.setString(1, cinClient);
			preparedStatement.setString(2, cinProf);

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
	public ClientBean listerUn(String cin) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int Authenticate(String email, String mdp) throws DaoException {
		Connection connexion = null;
		java.sql.Statement statement = null;
		ResultSet resultat = null;
		int res = 0;

		try {

			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			System.out.println("nom");

			resultat = statement
					.executeQuery("SELECT * FROM client WHERE email='" + email + "' and motdepasse='" + mdp + "';");

			while (resultat.next()) {

				System.out.println("nom" + resultat.getString("nom"));
				res = 1;
			}

		} catch (SQLException e) {
			System.out.println("Erreur de recherche client<br/>" + e.getMessage());
		}
		return res;
	}

	@Override
	public void SignIn(ClientBean user) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public ClientBean chercher(String email, String mdp) throws DaoException {
		Connection connexion = null;
		java.sql.Statement statement = null;
		ResultSet resultat = null;
		ClientBean client = new ClientBean();

		try {

			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			System.out.println("nom");

			resultat = statement
					.executeQuery("SELECT * FROM client WHERE email='" + email + "' and motdepasse='" + mdp + "';");

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

			}

		} catch (SQLException e) {
			System.out.println("Erreur de recherche client<br/>" + e.getMessage());
		}
		return client;
	}

}
