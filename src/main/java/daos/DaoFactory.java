package daos;

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

		DaoFactory instance = new DaoFactory("jdbc:mysql://localhost:3306/pro", "root", "password");
		return instance;
	}

	public Connection getConnection() throws SQLException {
		Connection coonexion = DriverManager.getConnection(url, username, password);
		coonexion.setAutoCommit(false);
		return coonexion;
	}

	public DaoAuthentification getClientDao() {

		return new ClientDaoImpl(this);

	}
	//pour faire appel à l'interface getProfessionnelDao et utiliser ses méthodes
	public DaoProfessionnel getProfessionnelDao() {

		return new ProfessionnelDaoImpl(this);

	}
	public DaoClient getClientBesoinDao() {

		return new DaoClientImplement(this);

	}

}