package AssociationJEE.services;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import AssociationJEE.model.Association;

public interface IServiceAssociation {
	
	List<Association> rechercherAssociations() throws SQLException, ParseException ;
}