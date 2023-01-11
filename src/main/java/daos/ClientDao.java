package daos;

import java.util.List;

import beans.ClientBean;

public interface ClientDao {

    public List<ClientBean> lister() throws DaoException;
    public void ajouter(ClientBean var) throws DaoException;
    public void delete(String cin) throws DaoException;
    public void modifier(ClientBean var) throws DaoException;
}
