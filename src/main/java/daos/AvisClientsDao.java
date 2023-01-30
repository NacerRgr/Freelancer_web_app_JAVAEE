package daos;

import java.util.List;

import beans.AvisClientsbean;

public interface AvisClientsDao  {
   
	public List<AvisClientsbean> lister(String cinPro) throws DaoException;
    

	
}
