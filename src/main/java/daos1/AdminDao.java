package daos1;

import beans.AdminBean;
import beans.Utilisateur;

public interface AdminDao {
	public AdminBean listerUn(String cin) throws DaoException;
	public int Authenticate(String email , String mdp) throws DaoException;
	public void SignIn(AdminBean user) throws DaoException;
	public AdminBean chercher(String email,String mdp)throws DaoException;
}
