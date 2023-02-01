package daos;

import javaBeans.client;
//import javaBeans.utilisateur;

public interface DaoAuthentification {

	public int connecterC(String email, String mdp) throws DaoException;
	public int connecterA(String email, String mdp) throws DaoException;
	public int connecterP(String email, String mdp) throws DaoException;
	public String recupererCin(String email, String mdp);



	public void inscrire(client var) throws DaoException;
}
