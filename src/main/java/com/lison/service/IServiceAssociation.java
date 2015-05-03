package com.lison.service;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.lison.model.Association;

public interface IServiceAssociation {
	
	List<Association> rechercherAssociations() throws SQLException, ParseException ;
}