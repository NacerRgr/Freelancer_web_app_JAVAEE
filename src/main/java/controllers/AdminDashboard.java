package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import beans.BesoinBean;
import beans.ClientBean;
import beans.ProfessionnelBean;
import beans.Utilisateur;
import daos.BesoinDao;
import daos.ClientDao;
import daos.ClientDaoImpl;
import daos.DaoException;
import daos.DaoFactory;
import daos.ProfessionnelDao;
import daos.ServiceDao;

/**
 * Servlet implementation class AdminDashboard
 */
public class AdminDashboard extends HttpServlet {

	private ClientDao clientDao;
	private ProfessionnelDao professionnelDao;
	private BesoinDao besoinDao;
	private ServiceDao serviceDao;
	private String choice;

	public void init() {
		DaoFactory daoFactory = DaoFactory.getInstance();
		this.clientDao = daoFactory.getClients();
		this.professionnelDao = daoFactory.getPofessionnels();
		this.besoinDao = daoFactory.getBesoins();
		this.serviceDao = daoFactory.getServices();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		choice = request.getParameter("choice");

		if (choice == null) {
			choice = "";
		}

		switch (choice) {

		case "clients":
			try {
				request.setAttribute("clients", this.clientDao.lister());
				request.setAttribute("choix", "client1");
				request.getRequestDispatcher("AdminViews/AdminDash.jsp?choice=clients").forward(request, response);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

		case "professionnels":

			try {
				request.setAttribute("professionnels", this.professionnelDao.lister());
				request.setAttribute("choix", "professionnel1");
				request.getRequestDispatcher("AdminViews/AdminDash.jsp?choice=professionnels").forward(request,
						response);

			} catch (DaoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			break;
			
			
		case "gererPubs": 
			try {
				request.setAttribute("besoins",this.besoinDao.lister2());
				request.setAttribute("services", this.serviceDao.lister());
				request.getRequestDispatcher("AdminViews/AdminGestionPubs.jsp").forward(request,response);
				
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;

		default:
			try {
				request.setAttribute("clients", this.clientDao.lister());
				request.setAttribute("choix", "client1");
				request.getRequestDispatcher("AdminViews/AdminDash.jsp?choice=home").forward(request, response);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		choice = request.getParameter("choice");

		if (choice == null) {
			choice = "";
		}

		switch (choice) {

		case "delClient":
	
			try {
				this.clientDao.delete1(request.getParameter("cinClient"));
				
				request.setAttribute("clients", this.clientDao.lister());
				request.setAttribute("choix", "client1");
				request.getRequestDispatcher("AdminViews/AdminDash.jsp?choice=clients").forward(request, response);
			} catch (DaoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			break;
			
		case "delProf":

			try {
				
				this.professionnelDao.delete(request.getParameter("cinProf"));
				request.setAttribute("professionnels", this.professionnelDao.lister());
				request.setAttribute("choix", "professionnel1");
				request.getRequestDispatcher("AdminViews/AdminDash.jsp?choice=professionnels").forward(request,response);

		
			} catch (DaoException e) {
				e.printStackTrace();
			}

			break;

		case "Accepterservice":
			try {
				this.serviceDao.accepter(Integer.parseInt(request.getParameter("idService")));
				request.setAttribute("besoins",this.besoinDao.lister2());
				request.setAttribute("services", this.serviceDao.lister());
				request.getRequestDispatcher("AdminViews/AdminGestionPubs.jsp").forward(request,response);
			} catch (NumberFormatException | DaoException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			break;
		case "delservice": 
			
			try {
				this.serviceDao.delete(Integer.parseInt(request.getParameter("idService")));
				request.setAttribute("besoins",this.besoinDao.lister2());
				request.setAttribute("services", this.serviceDao.lister());
				request.getRequestDispatcher("AdminViews/AdminGestionPubs.jsp").forward(request,response);
			} catch (NumberFormatException | DaoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "AccepterBesoin":
			try {
				this.besoinDao.Accepter(Integer.parseInt(request.getParameter("idBesoin")));
				request.setAttribute("besoins",this.besoinDao.lister2());
				request.setAttribute("services", this.serviceDao.lister());
				request.getRequestDispatcher("AdminViews/AdminGestionPubs.jsp").forward(request,response);
			} catch (NumberFormatException | DaoException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			break;
		case "delBesoin" : 
			try {
				this.besoinDao.delete1(Integer.parseInt(request.getParameter("idBesoin")));
				request.setAttribute("besoins",this.besoinDao.lister2());
				request.setAttribute("services", this.serviceDao.lister());
				request.getRequestDispatcher("AdminViews/AdminGestionPubs.jsp").forward(request,response);
			} catch (NumberFormatException | DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
			
		}
	}

}
