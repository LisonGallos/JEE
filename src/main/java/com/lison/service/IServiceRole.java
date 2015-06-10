package com.lison.service;
import java.util.List;

import com.lison.model.Role;

public interface IServiceRole {
	
	List<Role> findAll();
	
	Role find(Object id);
}