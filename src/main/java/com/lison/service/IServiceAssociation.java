package com.lison.service;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.lison.model.Association;
import com.lison.model.Performance;

public interface IServiceAssociation {
	
	List<Association> findAll();
}