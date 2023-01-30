package daos;

import java.util.List;

import beans.ServiceBean;

public interface ServiceDao {

    public List<ServiceBean> lister() throws DaoException;
    public void delete(int id ) throws DaoException;
    public void accepter(int id) throws DaoException;
	
}
