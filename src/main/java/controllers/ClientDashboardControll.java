package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import beans.BesoinBean;
import daos.BesoinDao;
import daos.DaoException;
import daos.DaoFactory;
import daos.ProfessionnelDao;

/**
 * Servlet implementation class ClientDashboardControll
 */

public class ClientDashboardControll extends HttpServlet {

	private ProfessionnelDao professionnelDao;
	private BesoinDao besoinDao;
	private String choice;
	private int idB;
	private String cin;
	
	
	public void init() {
		DaoFactory daoFactory = DaoFactory.getInstance();
		this.professionnelDao = daoFactory.getPofessionnels();
		this.besoinDao = daoFactory.getBesoins();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		choice = (String) request.getParameter("choice");

		if (choice == null) {
			choice = "";
		}

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
					
					System.out.println(besoin);
					request.setAttribute("besoin", besoin);
					request.getRequestDispatcher("ClientViews/modifierBesoin.jsp").forward(request, response);
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
		System.out.println("titre = " + (String) request.getParameter("titre"));

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

			
		case "modifierOk" : try {
				this.besoinDao.modifier(new BesoinBean((String) request.getParameter("titre"),
						(String) request.getParameter("description"), (String) request.getParameter("montant"), "",
						cin, (String) request.getParameter("categorie"), idB));
				request.setAttribute("professionnels", this.professionnelDao.lister());
				request.getRequestDispatcher("ClientViews/ClientDash.jsp").forward(request, response);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		
	}

}
