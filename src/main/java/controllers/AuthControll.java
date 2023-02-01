package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import beans.AdminBean;
import beans.ClientBean;
import beans.ProfessionnelBean;
import daos1.AdminDao;
import daos1.ClientDao;
import daos1.DaoException;
import daos1.DaoFactory;
import daos1.ProfessionnelDao;

/**
 * Servlet implementation class AuthControll
 */
public class AuthControll extends HttpServlet {

	private String choix;
	private ClientDao client;
	private AdminDao admin;
	private ProfessionnelDao prof;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public void init() {
		DaoFactory daoFactory = DaoFactory.getInstance();
		this.client = daoFactory.getClients();
		this.admin = daoFactory.getAdmins();
		this.prof = daoFactory.getPofessionnels();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		this.choix = request.getParameter("authenticate");
//
//		if(choix==null) {
//			choix = "";
//		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.choix = request.getParameter("authenticate");
		String pwd = request.getParameter("pwd");
		String login = request.getParameter("login");
		if (choix == null || pwd == null || login == null) {
			choix = "";
			pwd = "";
			login = "";

		}

		switch (choix) {

		case "admin":

			try { 
				AdminBean admin = new AdminBean();
				int res = this.admin.Authenticate(login, pwd);
				if (res == 1) {
					admin = this.admin.chercher(login, pwd);
					HttpSession AdminSession = request.getSession();
					AdminSession.setAttribute("admin", admin);
					System.out.println(admin.getNom());
					response.sendRedirect("AdminDashbaord");
				} else {
					response.sendRedirect("RegistrationLogin.jsp");

				}
			} catch (DaoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			break;
		case "client":
			try {
				
				ClientBean clientT = new ClientBean();
				int res1 = this.client.Authenticate(login, pwd);
				
				if (res1 == 1) {
					clientT  = this.client.chercher(login, pwd);

					HttpSession ClientSession   = request.getSession();
					ClientSession.setAttribute("client", clientT);
					response.sendRedirect("ClientDashboardControll");
				} else {
					response.sendRedirect("RegistrationLogin.jsp");

				}
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

		case "clientSignup":

			String cin = request.getParameter("cin"), nom = request.getParameter("nom"),
					prenom = request.getParameter("prenom"), email = request.getParameter("login"),
					numTel = request.getParameter("numTel"), adresse = request.getParameter("adresse"),
					motdepasse = request.getParameter("pwd"), sexe = request.getParameter("sexe"),
					ville = request.getParameter("ville");

			try {
				ClientBean client = new ClientBean(cin, nom, prenom, email, ville, adresse, motdepasse, sexe, numTel);
				this.client.ajouter(client);
				response.sendRedirect("RegistrationLogin.jsp");
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

		case "profSignup":

			String cin1 = request.getParameter("cin"), nom1 = request.getParameter("nom"),
			prenom1 = request.getParameter("prenom"), email1 = request.getParameter("login"),
			numTel1 = request.getParameter("numTel"), adresse1 = request.getParameter("adresse"),
			motdepasse1 = request.getParameter("pwd"), sexe1 = request.getParameter("sexe"),
			ville1 = request.getParameter("ville");
	String emploie1 = request.getParameter("emploie");
	String surmoi = request.getParameter("surmoi");
			System.out.println("surmoi ="+surmoi);
			
			try {
				ProfessionnelBean prof = new ProfessionnelBean(cin1,nom1,prenom1,email1,ville1,adresse1,motdepasse1,sexe1,numTel1,emploie1,surmoi);
				this.prof.ajouter(prof);
				response.sendRedirect("RegistrationLogin.jsp");
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

		}

	}

}
