package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.ServiceBean;

public class ServiceDaoImpl implements ServiceDao {
	
	private DaoFactory daoFactory;

	public ServiceDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<ServiceBean> lister() throws DaoException {
		List<ServiceBean> Services = new ArrayList<ServiceBean>();
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;

		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT s.idService ,  s.titreService , s.description , s.prix  , s.Status , C.nomCategories  , p.nom , p.prenom  FROM service s , professionnel  p , categoriesservices C where s.cin = p.cin and C.idC = s.idC ;");

			while (resultat.next()) {
				String titreBesoin = resultat.getString("titreService");
				String description = resultat.getString("description");
				Float prix = resultat.getFloat("prix");
				String nomCategorie  =  resultat.getString("nomCategories");
				String nomClient = resultat.getString("nom");
				String prenomClient = resultat.getString("prenom");
				int id = resultat.getInt("idService");
				String Status = resultat.getString("Status");
				ServiceBean service =  new ServiceBean();
				
				 service.setTitre(titreBesoin);
				 service.setDescription(description);
				 service.setPrix(Float.toString(prix));
				 service.setCategoirie(nomCategorie);
				 service.setNom(nomClient);
				 service.setPrenom(prenomClient);
				 service.setIdBesoin(id);
				 service.setStatus(Status);
				 Services.add(service);

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
		return Services;
	}

	@Override
	public void delete(int id) throws DaoException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("delete from service  where idService = ? ;");
			preparedStatement.setInt(1, id);
			
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
	public void accepter(int id) throws DaoException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("update besoin set Status  = ? where idService = ?");
			preparedStatement.setString(1, "accepter");
			preparedStatement.setInt(2, id);
			

			preparedStatement.executeUpdate();
			connexion.commit();

		} catch (SQLException e) {
			throw new DaoException("Impossible de communiquer avec la base de données ou un probleme dans la methode modifier service  111");
		} finally {
			try {
				if (connexion != null) {
					connexion.rollback();
				}
			} catch (SQLException e) {
				throw new DaoException("Impossible de communiquer avec la base de données  ou un probleme dans la methode modifier  service2 2");
			}
		}		
	}
	
}
