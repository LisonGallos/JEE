package AssociationJEE.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.List;
import java.sql.Statement;

import AssociationJEE.model.Association; 

public class IAssociationDao implements AssociationDao {

	 
	public List<Association> findAllAssociations() throws SQLException, ParseException {
		connexionSql connexion = null;
		final List<Association> associations = null;
		ResultSet rs;
		Association association;
		Statement st; 
		
		st = connexion.ConnexionBase();
		
		if(st != null){

			String query = "select * from Association";
			rs = st.executeQuery(query);
		}else rs = null;

		while(rs.next()){
			
			int ID = Integer.parseInt(rs.getString(1));
			String nom = rs.getString(2);
			String region = rs.getString(3);
			
			association = new Association(ID, nom, region);
			
			
			associations.add(association);
		}

		return associations;
	}
}
