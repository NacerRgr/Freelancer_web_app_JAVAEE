package javaServletMysql;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import javaBeans.client;
import javaBeans.professionel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import daos.DaoAuthentification;
import daos.DaoException;
import daos.DaoFactory;
import daos.DaoProfessionnel;

/**
 * Servlet implementation class controlleur
 */
public class controlleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoAuthentification daoauthentification;
	private DaoProfessionnel daoProfessionnel;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public controlleur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() throws ServletException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		this.daoauthentification = daoFactory.getClientDao();
		this.daoProfessionnel = (DaoProfessionnel) daoFactory.getProfessionnelDao();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	// this.getServletContext().getRequestDispatcher( "/index.jsp" ).forward(
	// request, response );
	// }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("act");

		// authentification client
		switch (action) {
		case "authentificationC":
			String login = request.getParameter("login");
			String mdp = request.getParameter("pwd");
			request.setAttribute("login", login);
			request.setAttribute("mdp", mdp);

			System.out.println(login);

			int resu = 0;
			try {
				resu = daoauthentification.connecterC(login, mdp);
				System.out.println("resu=" + resu);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (resu == 1) {
				System.out.println("ok");
				this.getServletContext().getRequestDispatcher("/WEB-INF/principale.jsp").forward(request, response);

			} else {
				System.out.println("la valeur de res" + resu);
				this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				break;

			}

			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			break;
		// authentification Administrateur

		case "authentificationA":
			String loginA = request.getParameter("login");
			String mdpA = request.getParameter("pwd");
			request.setAttribute("loginA", loginA);
			request.setAttribute("mdpA", mdpA);

			System.out.println(loginA);

			int resul = 0;
			try {
				resul = daoauthentification.connecterA(loginA, mdpA);
				System.out.println("resu=" + resul);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (resul == 1) {
				System.out.println("ok");
				try {
					// prour stocker la liste des professionneles dans l'attribut afficherprof
					List<professionel> afficherprof = daoProfessionnel.lister();
					request.setAttribute("listeProfessionnel", afficherprof); // envoyer cette liste à la page
																				// principale de l'affichage des
																				// professionnels quyi est
																				// principaleA.jsp
					this.getServletContext().getRequestDispatcher("/afficherProfessionnel.jsp").forward(request,
							response);

				} catch (DaoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				System.out.println("la valeur de res" + resul);
				this.getServletContext().getRequestDispatcher("/index.html").forward(request, response);
				break;

			}

			break;

		// Ajouter un professionnel
		case "ajouterProf":
			System.out.println("ajouterProfessionnel");
			professionel professionnel = new professionel();

			// récuperation des valeurs enregistrer dans le form ajouter
			professionnel.setCin(request.getParameter("cinP"));
			professionnel.setNom(request.getParameter("nomP"));
			professionnel.setPrenom(request.getParameter("prenomP"));
			professionnel.setVille(request.getParameter("villeP"));
			professionnel.setAdresse(request.getParameter("adresseP"));
			professionnel.setMotdepasse(request.getParameter("mdpP"));
			professionnel.setNumTel(request.getParameter("numTelP"));
			professionnel.setSexe(request.getParameter("sexeP"));
			professionnel.setSurMoi(request.getParameter("surMoiP"));
			professionnel.setCv(request.getParameter("CvP"));
			professionnel.setEmail(request.getParameter("emailP"));

			System.out.println("cin=" + professionnel.getCin());

			// appeler à la fonction de l'interface DaoProfessionnel pour ajouter un
			// professionnel
			try {
				this.daoProfessionnel.ajouter(professionnel);
				// prour stocker la liste des professionneles dans l'attribut afficherprof
				List<professionel> afficherprof = daoProfessionnel.lister();
				request.setAttribute("listeProfessionnel", afficherprof); // envoyer cette liste à la page principale de
																			// l'affichage des professionnels quyi est
																			// principaleA.jsp
				this.getServletContext().getRequestDispatcher("/afficherProfessionnel.jsp").forward(request, response);

			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		// afficher un professionnel
		case "afficherProf":

			break;

		// modifier un professionnel
		case "modifierProf":
			professionel professionnell = new professionel();
			// récuperation des valeurs enregistrer dans le form ajouter
			//professionnell.setCin(request.getParameter("m"));
			professionnell.setNom(request.getParameter("nomPmodi"));
			professionnell.setPrenom(request.getParameter("prenomPmodi"));
			professionnell.setVille(request.getParameter("villePmodi"));
			professionnell.setAdresse(request.getParameter("adressPmodi"));
			//professionnell.setMotdepasse(request.getParameter("mdp"));
			professionnell.setNumTel(request.getParameter("numPmodi"));
			//professionnell.setSexe(request.getParameter("sexe"));
			professionnell.setSurMoi(request.getParameter("surmoiPmodi"));
			//professionnell.setCv(request.getParameter("cv"));
			professionnell.setEmail(request.getParameter("emailPmodi"));
			HttpSession session1 = request.getSession();
			// stocker le cin d'un professionnel dans une session

			String cinPP1 = (String) session1.getAttribute("cinP");
			professionnell.setCin(cinPP1);
			
			
			        
			try {
				this.daoProfessionnel.modifier(professionnell);
				// ouverture de la session
				HttpSession session = request.getSession();
				// stocker le cin d'un professionnel dans une session

				String cinPP = (String) session.getAttribute("cinP");
				

				// rechrche les infos d'un professionnel
				List<professionel> unProf = daoProfessionnel.listerUnprofessionnel(cinPP);
				session.setAttribute("unProf", unProf);
				this.getServletContext().getRequestDispatcher("/profiP.jsp").forward(request, response);
				break;

			} catch (DaoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

			
			
			
			
			
			
			
			
			

		// supprimer un professionnel
		case "supprimerProf":
			String cin = request.getParameter("s");
			System.out.println("cin=" + cin);
			try {
				this.daoProfessionnel.delete(cin);
				// prour stocker la liste des professionneles dans l'attribut afficherprof
				List<professionel> afficherprof = daoProfessionnel.lister();
				request.setAttribute("listeProfessionnel", afficherprof); // envoyer cette liste à la page principale de
																			// l'affichage des professionnels quyi est
																			// principaleA.jsp
				this.getServletContext().getRequestDispatcher("/afficherProfessionnel.jsp").forward(request, response);

			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
			
			

		}
	}

}
