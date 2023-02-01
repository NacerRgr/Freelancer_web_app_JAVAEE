package daos1;

import java.util.List;

import beans.ClientBean;
import beans.EvaluationClient;
import beans.ProgresProf;
import beans.mesInvitations;

public interface ClientDao {

    public List<ClientBean> lister() throws DaoException;
    public void ajouter(ClientBean var) throws DaoException;
    public void delete1(String cin) throws DaoException;
    public void modifier(ClientBean var) throws DaoException;
    public List<mesInvitations> afficher(String cinClient) throws DaoException; 
    public void inviter(String cinC , String cinP) throws DaoException;
    public List<ProgresProf> Progres(String CinClient) throws DaoException;
    public void Evaluer(EvaluationClient eva) throws DaoException;
    public void supprimerInvitationProfessionnel(int id)throws DaoException;
    public void AccepterDemande(String cinClient , String cinProf) throws DaoException;
    public ClientBean listerUn(String cin) throws DaoException;
	public int Authenticate(String email , String mdp) throws DaoException;
	public void SignIn(ClientBean user) throws DaoException;
	public ClientBean chercher(String email , String mdp) throws DaoException;
}
