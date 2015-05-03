package AssociationJEE.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.sql.Statement;

import AssociationJEE.model.Competition;
import AssociationJEE.model.Membre;

public class ICompetitionDao implements CompetitionDao {

	
	public List<Competition> findAllCompetitions() throws SQLException, ParseException {
		connexionSql connexion = null;
		final List<Competition> competitions = null;
		ResultSet rs;
		Competition competition;
		Statement st;
		
		st = connexion.ConnexionBase();
		
		if(st != null){

			String query = "select * from Membre";
			rs = st.executeQuery(query);
		}else rs = null;

		while(rs.next()){
			
			int ID = Integer.parseInt(rs.getString(1));
			String Nom = rs.getString(2);
			int id_membre = Integer.parseInt(rs.getString(3)); 
			int points = Integer.parseInt(rs.getString(4)); 
			
			competition = new Competition(ID, Nom, id_membre, points);
			
			
			competitions.add(competition);
		}

		return competitions;
	}
	
	public void insertCompetition(Competition competition) throws SQLException {
		connexionSql connexion = null;
		ResultSet rs;
		DateFormat df;
		Statement st;
		int flag;
		
		st = connexion.ConnexionBase();
		
		if(st != null){

			String query = "insert into competition(Nom, id_membre, points) values('"+competition.getNom()+"','"+competition.getId_membre()+"','"+competition.getPoints()+"')";
					
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
}
