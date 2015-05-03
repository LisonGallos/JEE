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
import AssociationJEE.model.Performance;

public class IPerformanceDao implements PerformanceDao {

	
	public List<Performance> findAllPerformances() throws SQLException, ParseException {
		connexionSql connexion = null;
		final List<Performance> performances = null;
		ResultSet rs;
		Performance performance;
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
			String intitule = rs.getString(2);
			int points = Integer.parseInt(rs.getString(3));
			Date date_performance = df.parse(rs.getString(4));
			int id_membre = Integer.parseInt(rs.getString(5));
			int id_competition = Integer.parseInt(rs.getString(6));
			
			performance = new Performance(ID, intitule, points, date_performance, id_membre, id_competition);
			
			
			performances.add(performance);
		}

		return performances;
	}
	
	public void insertPerformance(Performance performance) throws SQLException {
		connexionSql connexion = null;
		ResultSet rs;
		DateFormat df;
		Statement st;
		int flag;
		
		st = connexion.ConnexionBase();
		
		if(st != null){

			String query = "insert into Performance(intitule, points, date_performance, id_membre, id_competition) values('"+performance.getIntitule()+"','"+performance.getPoints()+"','"+performance.getDate_performance()+"','"+performance.getId_membre()+"','"+performance.getId_competition()+"')";
					
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
