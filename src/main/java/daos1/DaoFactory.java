package daos1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {


    private String url;
    private String username;
    private String password;

    DaoFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static DaoFactory getInstance() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        	
        }

        DaoFactory instance = new DaoFactory(
                "jdbc:mysql://localhost:3306/pro", "root", "password");
        return instance;
    }

    public Connection getConnection() throws SQLException {
        Connection coonexion = DriverManager.getConnection(url, username, password);
        coonexion.setAutoCommit(false);
        return coonexion;
    }


    public ClientDao getClients() {

        return new ClientDaoImpl(this);

    }
    
    public ProfessionnelDao getPofessionnels() {
        return new ProfessionnelDaoImpl(this);

    }


    public BesoinDao getBesoins() {
    	return new BesoinDaoImpl(this);
    }
    
    
    
    public InvitationPDao getInvitaionP() {
    	return new InvitaionPdaoImpl(this);
    }
    
    
    public AvisClientsDao getAvisClient() {
    	return new AvisClientDaoImpl(this);
    }
    
    public ServiceDao getServices()
    {
    	return  new ServiceDaoImpl(this);
    }    

    public AdminDao getAdmins() {
    	return new AdminDaoImpl(this);
    }
}
