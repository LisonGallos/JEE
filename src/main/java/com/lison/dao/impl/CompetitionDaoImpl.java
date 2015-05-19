package com.lison.dao.impl;

import org.springframework.stereotype.Repository;

import com.lison.dao.ICompetitionDao;
import com.lison.dao.IMembreDao;
import com.lison.model.Competition;

@Repository("competitionDao")
public class CompetitionDaoImpl extends AbstractDao<Competition> implements ICompetitionDao{
	
	public CompetitionDaoImpl() {
		super(Competition.class);
	}
	
}
