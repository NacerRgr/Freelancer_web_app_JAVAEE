package daos;

import java.util.List;

import beans.ProfessionnelBean;

public interface ProfessionnelDao {

	public List<ProfessionnelBean> lister() throws DaoException;
	public List<ProfessionnelBean>  listerSelonChoix(String description , String  emploie , String Ville ) throws DaoException;
    public void ajouter(ProfessionnelBean var) throws DaoException;
    public void delete(String cin) throws DaoException;
    public void modifier(ProfessionnelBean var) throws DaoException;
	public ProfessionnelBean  listerUn(String cin) throws DaoException;

    
}
