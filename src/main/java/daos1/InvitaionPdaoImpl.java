package daos1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.InvitationP;

public class InvitaionPdaoImpl implements InvitationPDao {

	private DaoFactory daoFactory;

	public InvitaionPdaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<InvitationP> lister(String cinClient) throws DaoException {

		List<InvitationP> Invitations = new ArrayList<InvitationP>();
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;

		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery(
					"SELECT  P.nom , P.prenom ,  P.emploie , P.surMoi , i.etatinvPro , i.id  , p.cin from professionnel P , besoin b , client  c , invitationp i  where P.cin = i.cinPro and b.idBesoin = i.idB and b.cin = c.cin and c.cin = '"
							+ cinClient + "'    ;");

			while (resultat.next()) {
				String nom = resultat.getString("nom");
				String prenom = resultat.getString("prenom");
				String emploie = resultat.getString("emploie");
				String surMoi = resultat.getString("surMoi");
				String etatinvPro = resultat.getString("etatinvPro");
				int id  = resultat.getInt("id");
				String cinPro = resultat.getString("cin");
				InvitationP invitationp = new InvitationP();

				invitationp.setEmploie(emploie);
				invitationp.setEtatinvPro(etatinvPro);
				invitationp.setNom(nom);
				invitationp.setPrenom(prenom);
				invitationp.setSurMoi(surMoi);
				invitationp.setIdIntivtationP(id);
				invitationp.setCin(cinPro);
				Invitations.add(invitationp);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connexion != null) {
					connexion.close();
				}
			} catch (SQLException e) {
				throw new DaoException(
						"Impossible de communiquer avec la base de données ou il y a un probleme dans la methode lister invitation 2");
			}
		}
		return Invitations;

	}

	@Override
	public void deleteInb(int id) throws DaoException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = daoFactory.getConnection();
			System.out.println("Im here" + id);

			preparedStatement = connexion.prepareStatement("delete from invitationp where id = ?;");
			preparedStatement.setInt(1, id);

			
			preparedStatement.executeUpdate();
			connexion.commit();

		} catch (SQLException e) {
			throw new DaoException("Impossible de communiquer avec la base de données");
		} finally {
			try {
				if (connexion != null) {
					connexion.rollback();
				}
			} catch (SQLException e) {
				throw new DaoException("Impossible de communiquer avec la base de données");
			}
		}		
		
	}
}
