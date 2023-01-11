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

/**
 * Servlet implementation class AdminDashboard
 */
public class AdminDashboard extends HttpServlet {

	private ClientDao clientDao;
	private ProfessionnelDao professionnelDao;
	private BesoinDao besoinDao;
	
	
	
	public void init() {
		DaoFactory daoFactory = DaoFactory.getInstance();
		this.clientDao = daoFactory.getClients();
		this.professionnelDao = daoFactory.getPofessionnels();
		this.besoinDao = daoFactory.getBesoins();
		}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
