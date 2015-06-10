package com.lison.dao.impl;

import org.springframework.stereotype.Repository;

import com.lison.dao.IRoleDao;
import com.lison.model.Role;

@Repository("roleDao")
public class RoleDaoImpl extends AbstractDao<Role> implements IRoleDao {

	public RoleDaoImpl() {
		super(Role.class);
	}

}
