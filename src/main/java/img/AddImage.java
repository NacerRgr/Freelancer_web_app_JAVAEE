package img;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import javaBeans.afficherbesoin;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.List;

import daos.DaoAuthentification;
import daos.DaoClient;
import daos.DaoFactory;
import daos.DaoProfessionnel;

/**
 * Servlet implementation class AddImage
 */
@MultipartConfig
public class AddImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoClient daoClient;
	private DaoAuthentification daoauthentification;
	private DaoProfessionnel daoProfessionnel;
	private List<afficherbesoin> listBesoins;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddImage() {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("in do post method of add Image servlet ");
	    Part file=request.getPart("cvP");
	    String imageFileName=file.getSubmittedFileName(); //pour obtenir le nom d'image sans son chemin
	System.out.println("Selected Image File Name :"+imageFileName);
	String uploadPath="C:/eclipse-workspace/projetjee/WebContent/images/"+imageFileName;
	System.out.println("Upload Path"+uploadPath);
	//upload l'image sélectionnée dans le dossier images
	try {
		
		FileOutputStream fos=new FileOutputStream(uploadPath);
	    InputStream is=file.getInputStream();
	    byte[] data=new byte[is.available()];
	    is.read(data);
	    fos.write(data);
	    fos.close();
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	Connection connection=null;
	PreparedStatement stmt;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjee", "root", "ensias2022");

		// ouverture de la session
				HttpSession session1 = request.getSession();
				// stocker le cin d'un professionnel dans une session

				String cinPP = (String) session1.getAttribute("cinP");
				
				String query="Update professionnel set Cv=? WHERE cin=?";
				stmt=connection.prepareStatement(query);
				stmt.setString(1, imageFileName);
				stmt.setString(2, cinPP);
				int row=stmt.executeUpdate();
				if(row>0)
				{
					System.out.println("Image added into databases successfully.");
				}else {
					System.out.println("failed to upload image.");
					
				}
	    
	
				this.getServletContext().getRequestDispatcher("/contProf?act=afficherCvProffesionnel").forward(request,response);

	}catch(Exception e)
	{
		System.out.println(e);
	}
	//********************************
	//getting database connection
	//Connection connection=null;
	//PreparedStatement stmt;
	/*try {
	
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjee", "root", "ensias2022");

String query="Update professionnel set Cv=? WHERE cin='LE27553'";
stmt=connection.prepareStatement(query);
stmt.setString(1, imageFileName);
int row=stmt.executeUpdate();
if(row>0)
{
	System.out.println("Image added into databases successfully.");
}else {
	System.out.println("failed to upload image.");
	
}

	}catch(Exception e)
	{
		System.out.println(e);
	} */
	}
	

}
