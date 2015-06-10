package com.lison.service;
import java.util.List;

import com.lison.model.Valide;

public interface IServiceValide {
	
	List<Valide> findAll();
	
	Valide find(Object id);
}