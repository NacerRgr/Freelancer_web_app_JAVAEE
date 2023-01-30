package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import beans.BesoinBean;
import beans.EvaluationClient;
import daos.AvisClientsDao;
import daos.BesoinDao;
import daos.ClientDao;
import daos.DaoException;
import daos.DaoFactory;
import daos.InvitationPDao;
import daos.ProfessionnelDao;

/**
 * Servlet implementation class ClientDashboardControll
 */

public class ClientDashboardControll extends HttpServlet {

	private ProfessionnelDao professionnelDao;
	private BesoinDao besoinDao;
	private String choice;
	private int idB;
	private ClientDao client;
	private String cin;

	private InvitationPDao invitationDao;

	private AvisClientsDao avisclient;

	public void init() {
		DaoFactory daoFactory = DaoFactory.getInstance();
		this.professionnelDao = daoFactory.getPofessionnels();
		this.besoinDao = daoFactory.getBesoins();
		this.invitationDao = daoFactory.getInvitaionP();
		this.avisclient = daoFactory.getAvisClient();
		this.client = daoFactory.getClients();
		cin = "";

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		choice = (String) request.getParameter("choice");

//		System.out.println(choice);

		if (choice == null) {
			choice = "";
		}

		System.out.println(choice);

		switch (choice) {

		case "":
			try {
				request.setAttribute("professionnels", this.professionnelDao.lister());
				request.getRequestDispatcher("ClientViews/ClientDash.jsp").forward(request, response);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "mesBesoins":
			try {
				request.setAttribute("mesBesoins", this.besoinDao.listerBesoinClient("k6343"));
				System.out.println("size of mes besoins " + this.besoinDao.listerBesoinClient("k6343").size());
				request.getRequestDispatcher("ClientViews/mesBesoins.jsp").forward(request, response);

			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

			break;

		case "supprimer":

			try {
				this.besoinDao.delete(Integer.parseInt(request.getParameter("idB")), request.getParameter("cin"));
				request.setAttribute("professionnels", this.professionnelDao.lister());
				request.getRequestDispatcher("ClientViews/ClientDash.jsp").forward(request, response);
			} catch (NumberFormatException | DaoException e) {
				e.printStackTrace();
			}

			break;

		case "modifier":
			this.idB = Integer.parseInt(request.getParameter("idB"));
			cin = request.getParameter("cin");
			BesoinBean besoin = new BesoinBean((String) request.getParameter("titre"),
					(String) request.getParameter("description"), (String) request.getParameter("prix"), "",
					request.getParameter("cin"), (String) request.getParameter("categorie"),
					Integer.parseInt(request.getParameter("idB")));

			request.setAttribute("besoin", besoin);
			request.getRequestDispatcher("ClientViews/modifierBesoin.jsp").forward(request, response);
			break;

		case "chercher":

			try {

				request.setAttribute("professionnels", this.professionnelDao.listerSelonChoix(
						request.getParameter("desc"), request.getParameter("emploie"), request.getParameter("ville")));
				request.getRequestDispatcher("ClientViews/ClientDash.jsp").forward(request, response);

			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

		case "mesDemandes":

			try {
				request.setAttribute("mesDemandes", this.invitationDao.lister("k6343"));
				
				request.getRequestDispatcher("ClientViews/mesDemandes.jsp").forward(request, response);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "mesInvitaitons":

			try {
				request.setAttribute("Invitations", this.client.afficher("k6343"));

				System.out.println(this.client.afficher("k6343").size());

				request.getRequestDispatcher("ClientViews/invitation.jsp").forward(request, response);

			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

		case "mesProfessionnels":

			try {
				request.setAttribute("progres", this.client.Progres("k6343"));
				request.getRequestDispatcher("ClientViews/mesProfessionnels.jsp").forward(request, response);

			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		choice = (String) request.getParameter("choice");
//		System.out.println("titre = " + (String) request.getParameter("titre"));
		
		System.out.println("idInv"+request.getParameter("idInvitation"));


		if (choice == null) {
			choice = "";
		}
		switch (choice) {
		case "creer":
			try {
				this.besoinDao.ajouter(new BesoinBean((String) request.getParameter("titre"),
						(String) request.getParameter("description"), (String) request.getParameter("montant"), "",
						"k6343", (String) request.getParameter("categorie"), 0));
				request.setAttribute("professionnels", this.professionnelDao.lister());
				request.getRequestDispatcher("ClientViews/ClientDash.jsp").forward(request, response);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "modifierOk":
			try {
				this.besoinDao.modifier(new BesoinBean((String) request.getParameter("titre"),
						(String) request.getParameter("description"), (String) request.getParameter("montant"), "", cin,
						(String) request.getParameter("categorie"), idB));
				request.setAttribute("professionnels", this.professionnelDao.lister());
				request.getRequestDispatcher("ClientViews/ClientDash.jsp").forward(request, response);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		case "profil":

			String cinProf = request.getParameter("cin");
			cin = cinProf;
			try {

				request.setAttribute("professionnel1", professionnelDao.listerUn(cinProf));

				request.setAttribute("Evaluation", this.avisclient.lister(cinProf));
				request.setAttribute("active","disabled");

				request.getRequestDispatcher("ClientViews/profilProf.jsp").forward(request, response);

			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

		case "offrir":

			System.out.println(choice);
			System.out.println(request.getParameter("cinP"));

			try {
				this.client.inviter("k6343", request.getParameter("cinP"));
				request.setAttribute("professionnels", this.professionnelDao.lister());
				request.getRequestDispatcher("ClientViews/ClientDash.jsp").forward(request, response);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

			

		case "evaluerprof":
			
			cin= request.getParameter("cinPro");
			
			request.setAttribute("active","");

			
			try {

				request.setAttribute("professionnel1", professionnelDao.listerUn(cin));

				request.setAttribute("Evaluation", this.avisclient.lister(cin));

				request.getRequestDispatcher("ClientViews/profilProf.jsp").forward(request, response);

			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			break;
			
		case "noter" : 
			
			EvaluationClient eva = new EvaluationClient("k6343",cin,request.getParameter("rate"),request.getParameter("commentaire"));
			System.out.println(eva);
			try {
				
				System.out.println("rate"+request.getParameter("rate"));
				this.client.Evaluer(eva);
				
				request.setAttribute("professionnels", this.professionnelDao.lister());
				request.getRequestDispatcher("ClientViews/ClientDash.jsp").forward(request, response);
				
				
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			break;
			
		case "rejeterInv" : 
			
			System.out.println(request.getParameter("idInvitationP"));
			int id= Integer.parseInt(request.getParameter("idInvitationP"));
			try {
				this.invitationDao.deleteInb(id);
				request.setAttribute("professionnels", this.professionnelDao.lister());
				request.getRequestDispatcher("ClientViews/ClientDash.jsp").forward(request, response);
			} catch (NumberFormatException | DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
			
		case "supprimerInv" : 
			try {
				this.client.supprimerInvitationProfessionnel(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("professionnels", this.professionnelDao.lister());
				request.getRequestDispatcher("ClientViews/ClientDash.jsp").forward(request, response);
			} catch (NumberFormatException | DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
			
		case "AccepterInv":
			
			try {
				this.client.AccepterDemande("k6343", request.getParameter("idInvitationP"));
				request.setAttribute("professionnels", this.professionnelDao.lister());
				request.getRequestDispatcher("ClientViews/ClientDash.jsp").forward(request, response);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			break;
		}

	}

}
