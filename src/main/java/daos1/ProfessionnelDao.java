package daos1;

import java.util.List;

import beans.ClientBean;
import beans.ProfessionnelBean;

public interface ProfessionnelDao {

	public List<ProfessionnelBean> lister() throws DaoException;

	public List<ProfessionnelBean> listerSelonChoix(String description, String emploie, String Ville)
			throws DaoException;

	public void ajouter(ProfessionnelBean var) throws DaoException;

	public void delete(String cin) throws DaoException;

	public void modifier(ProfessionnelBean var) throws DaoException;

	public ProfessionnelBean listerUn(String cin) throws DaoException;



	public boolean Authenticate(String email, String mdp) throws DaoException;

	public void SignIn(ProfessionnelBean user) throws DaoException;

}
