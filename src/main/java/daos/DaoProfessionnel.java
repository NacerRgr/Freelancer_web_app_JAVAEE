package daos;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javaBeans.afficherservice;
import javaBeans.evaluationProf;
import javaBeans.inviClientP;
import javaBeans.professionel;
import javaBeans.professionelAvis;


public interface DaoProfessionnel {
	    public List<professionel> lister() throws DaoException;
	    public void ajouter(professionel var) throws DaoException;
	    public void delete(String cin) throws DaoException;
	    public void modifier(professionel p) throws DaoException, SQLException;
	    public void ajouterService(String titre,String desc,float prix,String categories,String cinPro) throws DaoException;
		public List<afficherservice> afficherServices(String cinp) throws Exception;
		public List<professionel> listerUnprofessionnel(String cinp) throws DaoException;
		public void deleteService(int idbesoin) throws DaoException;
		public void modifierService(afficherservice listservice) throws DaoException, SQLException;
	    List<afficherservice>champServicesmodifier(String cinPP,int idbesoin) throws DaoException, SQLException ; 
	    public List<professionel> listerProfilProfessionnel(String cinp) throws DaoException;
        public void modifierCvProfessionnel(String path,String cinp ) throws DaoException, SQLException, IOException;
		public List<String> afficherCvProf(String cinPp) throws Exception;
	    public void EvaluerClient(String cinClient, int nbreEtoileC,String cinProf,String description ) throws DaoException;
	    public void invitationsC(String cinP,int idB) throws DaoException;//envoyer l'invitation à un client par professionnel 
		public List<inviClientP> afficherOffreClient(String cinPro) throws DaoException;
		 public void accepetClient(String path,String cinp ) throws DaoException, SQLException, IOException;
		public void deleteInvitation(String cinc, String cinp);
		public void ajouterProfEvaluation(String cinc, String cinp);
		public List<evaluationProf> mesClientP(String cinP) throws DaoException;
		public void FinaliserProf(String cinC, String cinP);
		public List<evaluationProf> monClientP(String cinc) throws DaoException;
		public List<professionelAvis> avisProfSurClient(String cinclient) throws DaoException;
		void invitationC(String cinP, int idB) throws DaoException;
		
}
