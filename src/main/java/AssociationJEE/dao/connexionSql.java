package AssociationJEE.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class connexionSql  {
	Statement st;
	
	public Statement ConnexionBase() throws SQLException{
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			st=con.createStatement();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
		return st;
	}
}
