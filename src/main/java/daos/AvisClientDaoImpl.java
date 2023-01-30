package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.AvisClientsbean;
import beans.ClientBean;

public class AvisClientDaoImpl implements AvisClientsDao {
	
	private DaoFactory daoFactory;
	
	public AvisClientDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<AvisClientsbean> lister(String cinPro) throws DaoException {

		List<AvisClientsbean> AvisClientsbeans = new ArrayList<AvisClientsbean>();
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;

		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("select distinct c.nom , c.prenom  ,  e.nbrEtoileP , e.description from client c , professionnel p , evaluation e where  c.cin = e.cinClient and cinProf = '"+cinPro+"' and progresP = 'fini' and e.description != '' ;");

			while (resultat.next()) {
				String nom = resultat.getString("nom");
				String prenom = resultat.getString("prenom");
				int nbrEtoile = resultat.getInt("nbrEtoileP");
				String description = resultat.getString("description");
		

				AvisClientsbean avisClient =  new AvisClientsbean();
				
				
				avisClient.setDescription(description);
				avisClient.setNom(nom);
				avisClient.setPrenom(prenom);
				avisClient.setnbrEtoileProf(nbrEtoile);
				AvisClientsbeans.add(avisClient);

			}
		} catch (SQLException e) {
			throw new DaoException("Impossible de communiquer avec la base de données ou il y a un probleme dans la methode lister 1 bd Evaluation" );
		} finally {
			try {
				if (connexion != null) {
					connexion.close();
				}
			} catch (SQLException e) {
				throw new DaoException("Impossible de communiquer avec la base de données ou il y a un probleme dans la methode lister 2 Evaluation");
			}
		}
		return AvisClientsbeans;
	}

}
