package com.lison.service;

import java.util.List;

import com.lison.model.Association;

public interface IServiceAssociation {

	List<Association> findAll();

	Association find(Object id);
}