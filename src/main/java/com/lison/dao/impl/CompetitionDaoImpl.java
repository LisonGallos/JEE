package com.lison.dao.impl;

import org.springframework.stereotype.Repository;

import com.lison.model.Competition;

@Repository("competitionDao")
public class CompetitionDaoImpl extends AbstractDao<Competition> {
	
	public CompetitionDaoImpl() {
		super(Competition.class);
	}
	
}
