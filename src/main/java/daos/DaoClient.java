//les méthodes ont la relation avec le client

package daos;

import java.util.List;

import javaBeans.afficherbesoin;
import javaBeans.client;


public interface DaoClient {
	 public List<afficherbesoin> AfficherBesoins() throws DaoException;
	// chercher un client à partir de dashboard
	 public  List<afficherbesoin> chercherClient(String titreBesoin,String ville) throws DaoException;
	// chercher un client à partir de id de son besoin
		 public  List<afficherbesoin> chercherClient(int cinClieent) throws DaoException;


}
