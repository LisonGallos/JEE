package com.lison.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lison.dao.ICompetitionDao;
import com.lison.model.Competition;
import com.lison.service.ICompetitionService;

@Service("competitionService")
public class CompetitionServiceImpl implements ICompetitionService {

	@Autowired
	private ICompetitionDao competitionDao;
	
	public List<Competition> findAll() {
		return competitionDao.findAll();
	}

}
