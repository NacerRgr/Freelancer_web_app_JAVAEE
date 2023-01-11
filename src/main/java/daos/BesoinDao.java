package daos;

import java.util.List;

import beans.BesoinBean;


public interface BesoinDao {

	
	

    public List<BesoinBean> lister() throws DaoException;
    public void ajouter(BesoinBean var) throws DaoException;
    public void delete(int idBesoin , String cin) throws DaoException;
    public void modifier(BesoinBean var) throws DaoException;
    public List<BesoinBean> listerBesoinClient(String cin) throws DaoException;


}


