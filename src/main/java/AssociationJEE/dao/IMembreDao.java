package AssociationJEE.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.sql.Statement;

import AssociationJEE.model.Membre;

public class IMembreDao implements MembreDao {

	
	public List<Membre> findAllMembres() throws SQLException, ParseException {
		connexionSql connexion = null;
		final List<Membre> membres = null;
		ResultSet rs;
		Membre membre;
		DateFormat df;
		Statement st;
		
		st = connexion.ConnexionBase();
		
		if(st != null){

			String query = "select * from Membre";
			rs = st.executeQuery(query);
		}else rs = null;

		while(rs.next()){
			df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			
			int ID = Integer.parseInt(rs.getString(1));
			String nom = rs.getString(2);
			String prenom = rs.getString(3);
			String email = rs.getString(4);
			String password = rs.getString(5);
			boolean compte_valide = Boolean.parseBoolean(rs.getString(6));
			String responsabilite = rs.getString(7);
			Date date_inscription = df.parse(rs.getString(8));
			Date date_naissance = df.parse(rs.getString(9));
			int id_asso = Integer.parseInt(rs.getString(10));
			
			membre = new Membre(ID, nom, prenom, email, password, compte_valide, responsabilite, 
					date_inscription, date_naissance, id_asso);
			
			
			membres.add(membre);
		}

		return membres;
	}
	
	public void insertMembre(Membre membre) throws SQLException {
		connexionSql connexion = null;
		ResultSet rs;
		DateFormat df;
		Statement st;
		int flag;
		
		st = connexion.ConnexionBase();
		
		if(st != null){

			String query = "insert into Membre(nom, prenom, email, password, compte_valide, responsabilite,	date_inscription, date_naissance, id_asso) values('"+membre.getNom()+"','"+membre.getPrenom()+"','"+membre.getEmail()+"','"+membre.getPassword()+"','"+membre.getCompte_valide()+"','"+membre.getResponsabilite()+"','"+membre.getDate_inscription()+"','"+membre.getDate_naissance()+"','"+membre.getId_asso()+"')";
					
			flag=st.executeUpdate(query);
					
			if(flag==1){
				System.out.println("Added!");
			}else{
				System.out.println("Failed");
			}
			
		}else {
			System.out.println("Impossible de se connecter à la BDD");
		}

	}
	
	public void updateMembreValide(Membre membre) throws SQLException {
		connexionSql connexion = null;
		Statement st;
		int flag;
		
		st = connexion.ConnexionBase();
		
		if(st != null){

			String query = "update Membre set compte_valide = '"+membre.getCompte_valide()+"')";;
			flag = st.executeUpdate(query);
			if(flag==1){
				System.out.println("Added!");
			}else{
				System.out.println("Failed");
			}
		}else{
			
			System.out.println("Impossible de se connecter à la BDD");			
		}
	}
}
