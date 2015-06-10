package com.lison.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lison.dao.impl.RoleDaoImpl;
import com.lison.model.Role;
import com.lison.service.IServiceRole;

@Service("roleService")
public class RoleServiceImpl implements IServiceRole {
	
	@Autowired
	private RoleDaoImpl roleDao;	

	public List<Role> findAll() {
		return roleDao.findAll();
	}

	public Role find(Object id) {
		return roleDao.find(id);
	}
}