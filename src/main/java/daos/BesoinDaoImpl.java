package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.BesoinBean;

public class BesoinDaoImpl  implements BesoinDao{

	private DaoFactory daoFactory;

	public BesoinDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<BesoinBean> lister() throws DaoException {
		List<BesoinBean> Besoins = new ArrayList<BesoinBean>();
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;

		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT idBesoin , titreBesoin , description , prixApayer , Status , cin , nomCategorie  FROM besoin;");

			while (resultat.next()) {
				int IdBesoin  = resultat.getInt("idBesoin");
				String titreBesoin = resultat.getString("titreBesoin");
				String description = resultat.getString("description");
				Float prix = resultat.getFloat("prixApayer");
				String Status = resultat.getString("Status");
				String cinClient = resultat.getString("cin");
				String nomCategorie  =  resultat.getString("nomCategorie");
				
				BesoinBean Besoin =  new BesoinBean();
				 Besoin.setIdBesoin(IdBesoin);
				 Besoin.setTitre(titreBesoin);
				 Besoin.setDescription(description);
				 Besoin.setPrix(Float.toString(prix));
				 Besoin.setCin(cinClient);
				 Besoin.setCategoirie(nomCategorie);
				 Besoin.setStatus(Status);
				 
				 Besoins.add(Besoin);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connexion != null) {
					connexion.close();
				}
			} catch (SQLException e) {
				throw new DaoException("Impossible de communiquer avec la base de données ou il y a un probleme dans la methode lister Besoin 2");
			}
		}
		return Besoins;

	}

	@Override
	public void ajouter(BesoinBean var) throws DaoException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion
					.prepareStatement("INSERT INTO besoin(titreBesoin,description,prixApayer,cin) VALUES(?,?,?,?);");
			preparedStatement.setString(1, var.getTitre());
			preparedStatement.setString(2, var.getDescription());
			preparedStatement.setString(3, var.getPrix());
			preparedStatement.setString(4, var.getCin());
		
			preparedStatement.executeUpdate();
			connexion.commit();

		} catch (SQLException e) {
			throw new DaoException("Impossible de communiquer avec la base de données tale besoin method ajout 1 ");
		} finally {
			try {
				if (connexion != null) {
					connexion.rollback();
				}
			} catch (SQLException e) {
				throw new DaoException("Impossible de communiquer avec la base de données  tale besoin method ajout 2");
			}
		}				
	}

	@Override
	public void delete(int idBesoin, String cin) throws DaoException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("delete from besoin  where idBesoin = ? and cin = ?;");
			preparedStatement.setInt(1, idBesoin);
			preparedStatement.setString(2,cin);
			
			preparedStatement.executeUpdate();
			connexion.commit();

		} catch (SQLException e) {
			throw new DaoException("Impossible de communiquer avec la base de données  table besoin method delete 1 ");
		} finally {
			try {
				if (connexion != null) {
					connexion.rollback();
				}
			} catch (SQLException e) {
				throw new DaoException("Impossible de communiquer avec la base de données  table besoin method delete 2");
			}
		}				
	}

	@Override
	public void modifier(BesoinBean var) throws DaoException {

		
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("update besoin set titreBesoin = ? , description = ? , prixApayer = ?     where idBesoin = ? and  cin = ?;");
			preparedStatement.setString(1, var.getTitre());
			preparedStatement.setString(2, var.getDescription());
			preparedStatement.setString(3, var.getPrix());
			preparedStatement.setInt(4, var.getIdBesoin());
			preparedStatement.setString(5, var.getCin());


			preparedStatement.executeUpdate();
			connexion.commit();

		} catch (SQLException e) {
			throw new DaoException("Impossible de communiquer avec la base de données ou un probleme dans la methode modifier besoin  1");
		} finally {
			try {
				if (connexion != null) {
					connexion.rollback();
				}
			} catch (SQLException e) {
				throw new DaoException("Impossible de communiquer avec la base de données  ou un probleme dans la methode modifier  besoin 2");
			}
		}
		
	}

	
	
	
	@Override
	public List<BesoinBean> listerBesoinClient(String cin) throws DaoException {
		List<BesoinBean> Besoins = new ArrayList<BesoinBean>();
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;

		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT idBesoin , titreBesoin , description , prixApayer , Status , cin , nomCategorie  FROM besoin where cin = '"+cin+"';");

			while (resultat.next()) {
				int IdBesoin  = resultat.getInt("idBesoin");
				String titreBesoin = resultat.getString("titreBesoin");
				String description = resultat.getString("description");
				Float prix = resultat.getFloat("prixApayer");
				String Status = resultat.getString("Status");
				String cinClient = resultat.getString("cin");
				String nomCategorie  =  resultat.getString("nomCategorie");
				
				BesoinBean Besoin =  new BesoinBean();
				 Besoin.setIdBesoin(IdBesoin);
				 Besoin.setTitre(titreBesoin);
				 Besoin.setDescription(description);
				 Besoin.setPrix(Float.toString(prix));
				 Besoin.setCin(cinClient);
				 Besoin.setCategoirie(nomCategorie);
				 Besoin.setStatus(Status);
				 
				 Besoins.add(Besoin);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connexion != null) {
					connexion.close();
				}
			} catch (SQLException e) {
				throw new DaoException("Impossible de communiquer avec la base de données ou il y a un probleme dans la methode lister Besoin 2");
			}
		}
		return Besoins;

	}
	
	
	
	
}
