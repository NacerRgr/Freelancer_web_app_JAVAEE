package servProf;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import javaBeans.afficherbesoin;
import javaBeans.afficherservice;
import javaBeans.evaluationProf;
import javaBeans.inviClientP;
import javaBeans.professionel;
import javaBeans.professionelAvis;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import daos.DaoAuthentification;
import daos.DaoClient;
import daos.DaoException;
import daos.DaoFactory;
import daos.DaoProfessionnel;

/**
 * Servlet implementation class contProf
 */
public class contProf extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoClient daoClient;
	private DaoAuthentification daoauthentification;
	private DaoProfessionnel daoProfessionnel;
	private List<afficherbesoin> listBesoins;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public contProf() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() throws ServletException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		this.daoClient = daoFactory.getClientBesoinDao();
		this.daoauthentification = daoFactory.getClientDao();
		this.daoProfessionnel = daoFactory.getProfessionnelDao();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// get
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method st
		String action = request.getParameter("act");

		switch (action) {

		// Afficer services
		case "afficherServices":

			try {
				// ouverture de la session
				HttpSession session = request.getSession();
				// stocker le cin d'un professionnel dans une session
				String cinPP = (String) session.getAttribute("cinP");
				List<afficherservice> afficherserv = daoProfessionnel.afficherServices(cinPP);
				request.setAttribute("afficherService", afficherserv);
				// ouverture de la session
				HttpSession session1 = request.getSession();
				// stocker le cin d'un professionnel dans une session

				String cinPP1 = (String) session1.getAttribute("cinP");

				// rechrche le nom et le prénom de professionnel
				List<professionel> unProf = daoProfessionnel.listerUnprofessionnel(cinPP1);
				session1.setAttribute("unProf", unProf);
				List<professionel> unprof1 = (List<professionel>) session1.getAttribute("unProf");
				request.setAttribute("unProf", unprof1);
				this.getServletContext().getRequestDispatcher("/services.jsp").forward(request, response);
				break;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// afficher un professionnel à partir de son cin
		case "afficherProfessionnel":

			try {
				// ouverture de la session
				HttpSession session = request.getSession();
				// stocker le cin d'un professionnel dans une session

				String cinPP = (String) session.getAttribute("cinP");

				// rechrche les infos d'un professionnel
				List<professionel> unProf = daoProfessionnel.listerUnprofessionnel(cinPP);
				session.setAttribute("unProf", unProf);
				this.getServletContext().getRequestDispatcher("/profiP.jsp").forward(request, response);
				break;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// afficher les besoins des clients
		case "clientBesoins":

			ArrayList listBesoins = new ArrayList<List>();

			try {
				List<afficherbesoin> listBesoins1 = daoClient.AfficherBesoins();
				request.setAttribute("listBesoins", listBesoins1);

				// ouverture de la session
				HttpSession session = request.getSession();
				// stocker le cin d'un professionnel dans une session
				String cinPP = (String) session.getAttribute("cinP");

				// rechrche le nom et le prénom de professionnel
				List<professionel> unProf = daoProfessionnel.listerUnprofessionnel(cinPP);
				session.setAttribute("unProf", unProf);
				List<professionel> unProf1 = (List<professionel>) session.getAttribute("unProf");
				request.setAttribute("unProf", unProf1);
				this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				break;
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// afficher le profil d'un client pour l'évaluer
		case "clientProf":

			String cinCl = request.getParameter("cinC");
			int cinClient = Integer.parseInt(cinCl);

			try {
				// cercher un client à partir le nom de besoin: plombier..
				List<afficherbesoin> listBesoins1 = daoClient.chercherClient(cinClient);
				System.out.println("size" + daoClient.chercherClient(cinClient).size());
				request.setAttribute("listBesoins", listBesoins1);
				// ouverture de la session
				HttpSession session = request.getSession();
				// stocker le cin d'un professionnel dans une session

				String cinPP = (String) session.getAttribute("cinP");

				// rechrche le nom et le prénom de professionnel
				List<professionel> unProf = daoProfessionnel.listerUnprofessionnel(cinPP);
				session.setAttribute("unProf", unProf);
				List<professionel> unprof1 = (List<professionel>) session.getAttribute("unProf");
				request.setAttribute("unProf", unprof1);

				this.getServletContext().getRequestDispatcher("/ProfileeClient.jsp").forward(request, response);
				break;
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// afficher Cv du professionnel
		case "afficherCvProffesionnel":

			try {
				// ouverture de la session
				HttpSession session3 = request.getSession();
				// stocker le cin d'un professionnel dans une session

				String cinPp = (String) session3.getAttribute("cinP");
				List<String> cv = daoProfessionnel.afficherCvProf(cinPp);

				request.setAttribute("cvProf", cv);

				// rechrche les infos d'un professionnel
				List<professionel> unProf = daoProfessionnel.listerUnprofessionnel(cinPp);
				session3.setAttribute("unProf", unProf);
				this.getServletContext().getRequestDispatcher("/listCvProf.jsp").forward(request, response);
				break;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// afficher les offres des clients càd les invitations des clients ayant envoyés
			// aux professionnels
		case "afficherOffreClientP":

			try {
				// ouverture de la session
				HttpSession session3 = request.getSession();
				// stocker le cin d'un professionnel dans une session

				String cinPro = (String) session3.getAttribute("cinP");
				List<inviClientP> OffreProf = daoProfessionnel.afficherOffreClient(cinPro);

				request.setAttribute("inviClient", OffreProf);

				// rechrche les infos d'un professionnel
				List<professionel> unProf = daoProfessionnel.listerUnprofessionnel(cinPro);
				session3.setAttribute("unProf", unProf);
				this.getServletContext().getRequestDispatcher("/invitationC.jsp").forward(request, response);
				break;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//afficher les clients avec lesquels le professionnel travaillé
		case "mesClients":

			try {
				// ouverture de la session
				HttpSession session3 = request.getSession();
				// stocker le cin d'un professionnel dans une session
				String cinPro1 = (String) session3.getAttribute("cinP");
				//chercher la liste des clients aveclequelles le professionnel travail avec
				List<evaluationProf> MesClients = daoProfessionnel.mesClientP(cinPro1);
				request.setAttribute("MesClients", MesClients);
				//request.setAttribute("evaluatSucces", "Evaluation a été faite avec succès");
				// rechrche les infos d'un professionnel
				List<professionel> unProf = daoProfessionnel.listerUnprofessionnel(cinPro1);
				session3.setAttribute("unProf", unProf);
				this.getServletContext().getRequestDispatcher("/MesClients.jsp").forward(request, response);
				break;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//la professionnel indique au client qu'il a finalisé la travail
		case "FinaliserProf":
			
			String cinC= request.getParameter("cinc");
			String cinP= request.getParameter("cinp");

			try {
				// ouverture de la session
				HttpSession session3 = request.getSession();
				// stocker le cin d'un professionnel dans une session
				String cinPro1 = (String) session3.getAttribute("cinP");
				//chercher la liste des clients aveclequelles le professionnel travail avec
				 daoProfessionnel.FinaliserProf(cinC,cinP);
				//chercher la liste des clients aveclequelles le professionnel travail avec
					List<evaluationProf> MesClients = daoProfessionnel.mesClientP(cinPro1);
					request.setAttribute("MesClients", MesClients);
					request.setAttribute("fintravail", "Le travail est terminé");
					
				// rechrche les infos d'un professionnel
				List<professionel> unProf = daoProfessionnel.listerUnprofessionnel(cinPro1);
				session3.setAttribute("unProf", unProf);
				this.getServletContext().getRequestDispatcher("/MesClients.jsp").forward(request, response);
				break;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

	// sous forme de post

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("act");
		String choixUser = request.getParameter("choixUtilisateur");
		
		
		switch(choixUser) {
			
		case "client" :
			 request.setAttribute("login", request.getParameter("login"));
			 request.setAttribute("pwd", request.getParameter("pwd"));

			 System.out.println("clossssssss");
			 
//			 response.sendRedirect("/AuthControll?authenticate=client");
			 request.getRequestDispatcher("/AuthControll?authenticate=client").forward(request, response);
			 break;
		
		case "admin" :
			 System.out.println("clossssssss");

//			 request.setAttribute("login", request.getParameter("login"));
//			 request.setAttribute("pwd", request.getParameter("pwd"));
//			 response.sendRedirect("/AuthControll?authenticate=admin");
			 request.getRequestDispatcher("/AuthControll").forward(request, response);
			 
			break;		
		}
		
		
		switch (action) {

		// authentification de professionnel
		case "authentification":
			String login = request.getParameter("login");
			String mdp = request.getParameter("pwd");
			request.setAttribute("login", login);
			request.setAttribute("mdp", mdp);

			int resu = 0;
			try {
				resu = daoauthentification.connecterP(login, mdp);

			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (resu == 1) {
				System.out.println("ok");
				ArrayList listBesoins = new ArrayList<List>();

				try {
					List<afficherbesoin> listBesoins1 = daoClient.AfficherBesoins();
					request.setAttribute("listBesoins", listBesoins1);

					String cinP = daoauthentification.recupererCin(login, mdp);
					System.out.println("cin professionnel=" + cinP);
					// ouverture de la session
					HttpSession session = request.getSession();
					// stocker le cin d'un professionnel dans une session
					session.setAttribute("cinP", cinP);
					String cinPP = (String) session.getAttribute("cinP");

					// rechrche le nom et le prénom de professionnel
					List<professionel> unProf = daoProfessionnel.listerUnprofessionnel(cinPP);
					session.setAttribute("unProf", unProf);
					List<professionel> unProf1 = (List<professionel>) session.getAttribute("unProf");
					request.setAttribute("unProf", unProf1);

					this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
					break;
				} catch (DaoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				System.out.println("la valeur de res" + resu);
//				this.getServletContext().getRequestDispatcher("/loginP.jsp").forward(request, response);
				break;

			}

			// Ajouter service
		case "ajouterService":
			System.out.println("ajouter services");
			// récuperation des valeurs enregistrer dans le form ajouter
			afficherservice afficherserv = new afficherservice();
			String titreS = request.getParameter("titreS");
			String categorieS = request.getParameter("categorieS");
			String descriptionS = request.getParameter("descriptionS");
			float prixS = Float.parseFloat(request.getParameter("prixS"));
			System.out.println("categorie=" + categorieS);
			System.out.println("titreS=" + titreS);

			afficherserv.setTitreS(titreS);
			afficherserv.setCategorie(categorieS);
			afficherserv.setDescription(descriptionS);
			afficherserv.setPrix(prixS);

			// appeler à la fonction de l'interface pour ajouter un
			// service
			try {
				HttpSession session = request.getSession();
				String sesscinP = (String) session.getAttribute("cinP");
				System.out.println("sesscinP=" + sesscinP);

				// appeler la méthode pour ajouter un service
				this.daoProfessionnel.ajouterService(titreS, descriptionS, prixS, categorieS, sesscinP);
				// prour stocker la liste des services dans l'attribut afficherprof
				List<afficherservice> afficherService = daoProfessionnel.afficherServices(sesscinP);

				request.setAttribute("afficherService", afficherService); // envoyer cette liste à la page principale de
																			// l'affichage des professionnels quyi est
																			// principaleA.jsp
				this.getServletContext().getRequestDispatcher("/services.jsp").forward(request, response);
				break;
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		// cherche un client à partir de dashboard professionnel
		case "chercheClient":

			String titleBesoin = request.getParameter("titreBesoin");
			String villeC = request.getParameter("villeClient");

			try {
				// cercher un client à partir le nom de besoin: plombier..
				List<afficherbesoin> listBesoins1 = daoClient.chercherClient(titleBesoin, villeC);
				System.out.println("size" + daoClient.chercherClient(titleBesoin, villeC).size());
				request.setAttribute("listBesoins", listBesoins1);
				// ouverture de la session
				HttpSession session = request.getSession();
				// stocker le cin d'un professionnel dans une session

				String cinPP = (String) session.getAttribute("cinP");

				// rechrche le nom et le prénom de professionnel
				List<professionel> unProf = daoProfessionnel.listerUnprofessionnel(cinPP);
				session.setAttribute("unProf", unProf);
				List<professionel> unprof1 = (List<professionel>) session.getAttribute("unProf");
				request.setAttribute("unProf", unprof1);

				this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				break;
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Afficer services
		case "afficherServices":

			try {
				// ouverture de la session
				HttpSession session = request.getSession();
				// stocker le cin d'un professionnel dans une session

				String cinPP = (String) session.getAttribute("cinP");
				List<afficherservice> afficherserv1 = daoProfessionnel.afficherServices(cinPP);
				request.setAttribute("afficherService", afficherserv1);
				// ouverture de la session
				HttpSession session1 = request.getSession();
				// stocker le cin d'un professionnel dans une session

				String cinPP1 = (String) session1.getAttribute("cinP");

				// rechrche le nom et le prénom de professionnel
				List<professionel> unProf = daoProfessionnel.listerUnprofessionnel(cinPP1);
				session1.setAttribute("unProf", unProf);
				List<professionel> unprof1 = (List<professionel>) session1.getAttribute("unProf");
				request.setAttribute("unProf", unprof1);
				this.getServletContext().getRequestDispatcher("/services.jsp").forward(request, response);
				break;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// supprimer un service

		case "supprimerService":

			afficherservice suppService = new afficherservice();
			// récuperation des valeurs enregistrer dans le form ajouter
			int idBesoin = Integer.parseInt(request.getParameter("cinp"));

			try {
				this.daoProfessionnel.deleteService(idBesoin);

				// List<professionel> afficherprof = daoProfessionnel.lister();

				// request.setAttribute("listeProfessionnel", afficherprof);
				this.getServletContext().getRequestDispatcher("/contProf?act=afficherServices").forward(request,
						response);
				break;
			} catch (DaoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			// modifier un service
		case "modifierService":
			// récupérer les champs saisiés dans le form
			afficherservice modifierserv = new afficherservice();
			int idService = Integer.parseInt(request.getParameter("cinp"));
			String titreSm = request.getParameter("titreSm");
			String categorieSm = request.getParameter("categorieSm");
			String descriptionSm = request.getParameter("descriptionSm");
			float prixSm = Float.parseFloat(request.getParameter("prixSm"));
			System.out.println("nxufu valeur d categorie f controlleur" + categorieSm);

			// Affecter ces champs au classe mpdifierserv
			modifierserv.setIdService(idService);
			modifierserv.setTitreS(titreSm);
			modifierserv.setCategorie(categorieSm);

			modifierserv.setDescription(descriptionSm);
			modifierserv.setPrix(prixSm);
			// ouverture de la session
			HttpSession session = request.getSession();
			// stocker le cin d'un professionnel dans une session

			String cinPro = (String) session.getAttribute("cinP");

			try {
				this.daoProfessionnel.modifierService(modifierserv);

				// ouverture de la session
				HttpSession session1 = request.getSession();
				// stocker le cin d'un professionnel dans une session

				String cinPP1 = (String) session1.getAttribute("cinP");

				// rechrche le nom et le prénom de professionnel
				List<professionel> unProf = daoProfessionnel.listerUnprofessionnel(cinPP1);
				session1.setAttribute("unProf", unProf);
				List<professionel> unprof1 = (List<professionel>) session1.getAttribute("unProf");
				request.setAttribute("unProf", unprof1);
				this.getServletContext().getRequestDispatcher("/contProf?act=afficherServices").forward(request,
						response);
				break;

			} catch (DaoException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		case "valSermodifier":

			try {
				// ouverture de la session
				HttpSession session11 = request.getSession();
				// stocker le cin d'un professionnel dans une session
				int idbesoin1 = Integer.parseInt(request.getParameter("cinp"));
				String cinPP11 = (String) session11.getAttribute("cinP");
				List<afficherservice> valservmodi = daoProfessionnel.champServicesmodifier(cinPP11, idbesoin1); // les
																												// champs
																												// de
																												// service
																												// à
																												// modifier
				request.setAttribute("afficherService", valservmodi);
				// ouverture de la session
				HttpSession session111 = request.getSession();
				// stocker le cin d'un professionnel dans une session

				String cinPP111 = (String) session111.getAttribute("cinP");

				// rechrche le nom et le prénom de professionnel
				List<professionel> unProf1 = daoProfessionnel.listerUnprofessionnel(cinPP111);
				session111.setAttribute("unProf", unProf1);
				List<professionel> unprof11 = (List<professionel>) session111.getAttribute("unProf");
				request.setAttribute("unProf", unprof11);
				this.getServletContext().getRequestDispatcher("/modifierService.jsp").forward(request, response);
				break;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				break;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// afficher les infos de professionnel encliquant sur le boutton post
		case "afficherProfession":

			try {
				// ouverture de la session
				HttpSession session1 = request.getSession();
				// stocker le cin d'un professionnel dans une session

				String cinPP = (String) session1.getAttribute("cinP");

				// rechrche les infos d'un professionnel
				List<professionel> unProf = daoProfessionnel.listerUnprofessionnel(cinPP);
				session1.setAttribute("unProf", unProf);
				this.getServletContext().getRequestDispatcher("/editProfiP.jsp").forward(request, response);
				break;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Insérer un Cv ms sous format de modifier l'image de la base de données pour
			// in professionnel
		case "ModifierCv":

			// récupérer les champs saisiés dans le form

			System.out.println("in do post method of add Image servlet ");
			Part file = request.getPart("cvP");
			System.out.println("file= " + file);

			String imageFileName = file.getSubmittedFileName(); // pour obtenir le nom d'image sans son chemin
			System.out.println("Selected Image File Name :" + imageFileName);
			String uploadPath = "C:/eclipse-workspace/projetjee/WebContent/images/" + imageFileName;
			System.out.println("Upload Path" + uploadPath);
			// ouverture de la session
			HttpSession session1 = request.getSession();
			// stocker le cin d'un professionnel dans une session
			String cinPP = (String) session1.getAttribute("cinP");
			// upload l'image sélectionnée dans le dossier images
			try {
				FileOutputStream fos = new FileOutputStream(uploadPath);
				InputStream is = file.getInputStream();
				byte[] data = new byte[is.available()];
				is.read(data);
				fos.write(data);
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				this.daoProfessionnel.modifierCvProfessionnel(imageFileName, cinPP);

				// rechrche le nom et le prénom de professionnel
				List<professionel> unProf = daoProfessionnel.listerUnprofessionnel(cinPP);
				session1.setAttribute("unProf", unProf);
				List<professionel> unprof1 = (List<professionel>) session1.getAttribute("unProf");
				request.setAttribute("unProf", unprof1);
				this.getServletContext().getRequestDispatcher("contProf?act=afficherCvProffesionnel").forward(request,
						response);
				break;

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// afficher Cv du professionnel
		case "afficherCvProffesionnel":

			try {
				// ouverture de la session
				HttpSession session3 = request.getSession();
				// stocker le cin d'un professionnel dans une session

				String cinPp = (String) session3.getAttribute("cinP");
				List<String> cv = daoProfessionnel.afficherCvProf(cinPp);

				request.setAttribute("cvProf", cv);

				// rechrche les infos d'un professionnel
				List<professionel> unProf = daoProfessionnel.listerUnprofessionnel(cinPp);
				session3.setAttribute("unProf", unProf);
				this.getServletContext().getRequestDispatcher("/listCvProf.jsp").forward(request, response);
				break;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Evaluer le client
		case "EvaluerClient":
			String descrip= request.getParameter("commentaire");
			String cincc = request.getParameter("cinc");
			String cinpp = request.getParameter("cinp");
			

			try {
				// ouverture de la session
				HttpSession session11 = request.getSession();
				// stocker le cin d'un professionnel dans une session
				String cinProfs = (String) session11.getAttribute("cinP"); // System.out.println("Le cin de
															// professionnel est "+cinProfs);
				// récupperer le nombre d'étoiles
				int nbretoileC = Integer.parseInt(request.getParameter("rating")); // System.out.println("le nombre
																					// d'étoiles seléctionné est
																					// :"+nbretoile);
				
				this.daoProfessionnel.EvaluerClient(cincc, nbretoileC, cinpp,descrip);// appel de la méthode pour évaluer
																					// le client
		       // chercher les infos de client à partir id de son besoin
			   //List<afficherbesoin> listBesoins1 = daoClient.chercherClient(cinClient);
				//System.out.println("size" + daoClient.chercherClient(cinClient).size());
				//request.setAttribute("listBesoins", listBesoins1);
				// rechrche les infos d'un professionnel
				request.setAttribute("evaluatSucces", "Evaluation a été faite avec succès");
				List<professionel> unProf = daoProfessionnel.listerUnprofessionnel(cinProfs);
				session11.setAttribute("unProf", unProf);
				this.getServletContext().getRequestDispatcher("/contProf?act=mesClients").forward(request, response);
				break;
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Envoi d'invitation par le professionnel au client pour répondre à un besoin
		case "DemandEmploi":
			String idBe = request.getParameter("idB");
			int idB = Integer.parseInt(idBe);

			try {
				// ouverture de la session
				HttpSession session11 = request.getSession();
				// stocker le cin d'un professionnel dans une session
				String cinProfs = (String) session11.getAttribute("cinP"); // System.out.println("Le cin de
																			// professionnel est "+cinProfs);

				// récuperer ID de client cinCli
				String cinclient = request.getParameter("cinCli"); // System.out.println("Le cin de client est
																	// "+cinclient);
				this.daoProfessionnel.invitationC(cinProfs, idB);// appel de la méthode pour évaluer le client
				// chercher les infos de client à partir id de son besoin
				List<afficherbesoin> listBesoins1 = daoClient.chercherClient(idB);// chercher un client à travers id
																					// d'un besoin
				System.out.println("size" + daoClient.chercherClient(idB).size());
				request.setAttribute("listBesoins", listBesoins1);
				// rechrche les infos d'un professionnel
				request.setAttribute("demandeSucces", "la demande d'emploi a été envoyée par succès");
				List<professionel> unProf = daoProfessionnel.listerUnprofessionnel(cinProfs);
				session11.setAttribute("unProf", unProf);
				this.getServletContext().getRequestDispatcher("/ProfileeClient.jsp").forward(request, response);
				break;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// afficher les offres des clients càd les invitations des clients ayant envoyés
			// aux professionnels
		case "afficherOffreClientP":

			try {
				// ouverture de la session
				HttpSession session3 = request.getSession();
				// stocker le cin d'un professionnel dans une session

				String cinPro1 = (String) session3.getAttribute("cinP");
				List<inviClientP> OffreProf = daoProfessionnel.afficherOffreClient(cinPro1);

				request.setAttribute("inviClient", OffreProf);
				request.setAttribute("deletInviC", "L'opérationne a été faite avec succès");

				// rechrche les infos d'un professionnel
				List<professionel> unProf = daoProfessionnel.listerUnprofessionnel(cinPro1);
				session3.setAttribute("unProf", unProf);
				this.getServletContext().getRequestDispatcher("/invitationC.jsp").forward(request, response);
				break;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Accepter l'invitation d'un client
		case "AccepterClient":
			

			try {
				// récuperation des valeurs enregistrer dans le form ajouter
				String cinc= request.getParameter("cinc");
				String cinp= request.getParameter("cinp");
				

			
					
				   this.daoProfessionnel.ajouterProfEvaluation(cinc,cinp);
					this.daoProfessionnel.deleteInvitation(cinc,cinp);
					// List<professionel> afficherprof = daoProfessionnel.lister();
					// request.setAttribute("listeProfessionnel", afficherprof);
					this.getServletContext().getRequestDispatcher("/contProf?act=afficherOffreClientP").forward(request,
							response);
				break;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
				
			
				
			
			//Refuser l'invitation d'un client
		case "RefuserClient":
			
			// récuperation des valeurs enregistrer dans le form ajouter
			String cinc= request.getParameter("cinc");
			String cinp= request.getParameter("cinp");
			

			try {
				this.daoProfessionnel.deleteInvitation(cinc,cinp);

				// List<professionel> afficherprof = daoProfessionnel.lister();

				// request.setAttribute("listeProfessionnel", afficherprof);
				this.getServletContext().getRequestDispatcher("/contProf?act=afficherOffreClientP").forward(request,
						response);
				break;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//afficher les clients avec lesquels le professionnel travaillé
					case "mesClients":

						try {
							// ouverture de la session
							HttpSession session3 = request.getSession();
							// stocker le cin d'un professionnel dans une session
							String cinPro1 = (String) session3.getAttribute("cinP");
							//chercher la liste des clients aveclequelles le professionnel travail avec
							List<evaluationProf> MesClients = daoProfessionnel.mesClientP(cinPro1);
							request.setAttribute("MesClients", MesClients);
							//request.setAttribute("evaluatSucces", "Evaluation a été faite avec succès");
							// rechrche les infos d'un professionnel
							List<professionel> unProf = daoProfessionnel.listerUnprofessionnel(cinPro1);
							session3.setAttribute("unProf", unProf);
							this.getServletContext().getRequestDispatcher("/MesClients.jsp").forward(request, response);
							break;
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//la professionnel indique au client qu'il a finalisé la travail
					case "FinaliserProf":
						
						String cinC= request.getParameter("cinc");
						String cinP= request.getParameter("cinp");

						try {
							// ouverture de la session
							HttpSession session3 = request.getSession();
							// stocker le cin d'un professionnel dans une session
							String cinPro1 = (String) session3.getAttribute("cinP");
							//chercher la liste des clients aveclequelles le professionnel travail avec
							 daoProfessionnel.FinaliserProf(cinC,cinP);
							//chercher la liste des clients aveclequelles le professionnel travail avec
								List<evaluationProf> MesClients = daoProfessionnel.mesClientP(cinPro1);
								request.setAttribute("MesClients", MesClients);
								request.setAttribute("fintravail", "Le travail est terminé");
								
							// rechrche les infos d'un professionnel
							List<professionel> unProf = daoProfessionnel.listerUnprofessionnel(cinPro1);
							session3.setAttribute("unProf", unProf);
							this.getServletContext().getRequestDispatcher("/MesClients.jsp").forward(request, response);
							break;
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						//Chercher les infos de client à evaluer
					case "infoClientEva":
						
						String cincEva= request.getParameter("cinc");
						String cinpev= request.getParameter("cinp");

						try {
							// ouverture de la session
							HttpSession session3 = request.getSession();
							// stocker le cin d'un professionnel dans une session
							String cinPro1 = (String) session3.getAttribute("cinP");
							
							//chercher la liste des clients aveclequelles le professionnel travail avec
								List<evaluationProf> MesClients = daoProfessionnel.monClientP(cincEva);
								request.setAttribute("MonClient", MesClients);
								request.setAttribute("cinp", cinpev);
								
								
								
								
							// rechrche les infos d'un professionnel
							List<professionel> unProf = daoProfessionnel.listerUnprofessionnel(cinPro1);
							session3.setAttribute("unProf", unProf);
							this.getServletContext().getRequestDispatcher("/EvalutClient.jsp").forward(request, response);
							break;
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
		// Envoi d'invitation par le professionnel au client pour répondre à un besoin
					case "VoirAvis":
						
						
						int idBesoin1 = Integer.parseInt(request.getParameter("idB"));

						try {
							// ouverture de la session
							HttpSession session11 = request.getSession();
							// stocker le cin d'un professionnel dans une session
							String cinProfs = (String) session11.getAttribute("cinP"); // System.out.println("Le cin de
																						// professionnel est "+cinProfs);

							// récuperer ID de client cinCli
							String cinclient = request.getParameter("cinCli"); // System.out.println("Le cin de client est
																				// "+cinclient);
							List<professionelAvis> avisProf = daoProfessionnel.avisProfSurClient(cinclient);
							request.setAttribute("avisProfC",avisProf);
							
							System.out.println("size" + daoProfessionnel.avisProfSurClient(cinclient).size());
							
							// rechrche les infos d'un professionnel
							
							List<professionel> unProf = daoProfessionnel.listerUnprofessionnel(cinProfs);
							session11.setAttribute("unProf", unProf);
							this.getServletContext().getRequestDispatcher("/AvisProfSurClient.jsp").forward(request, response);
							break;
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}


		}
	}
}

