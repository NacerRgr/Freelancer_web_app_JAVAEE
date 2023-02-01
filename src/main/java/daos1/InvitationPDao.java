package daos1;

import java.util.List;

import beans.InvitationP;

public interface InvitationPDao {

	public List<InvitationP> lister(String cinClient) throws DaoException;
	public void deleteInb(int id) throws DaoException;
	

}
