package com.lison.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lison.dao.IPerformanceDao;
import com.lison.model.CompMembre;
import com.lison.model.Competition;
import com.lison.model.Performance;
import com.lison.service.IPerformanceService;

@Service("performanceDaoService")
public class PerformanceServiceImpl implements IPerformanceService {

	@Autowired
	private IPerformanceDao performanceDao;

	public List<Performance> findAll() {
		return performanceDao.findAll();
	}

	public void creerPerformance(final Performance performance) {
		// Performance performance = new Performance();
		//
		// performance.setIntitule(intitule);
		// performance.setPoints(points);
		// performance.setDate_performance(date_performance);
		// // performance.setid_membre(membre.getID());
		// performance.setcompetition(competition);
		// performance.setmembre(membre);
		// // performance.(competition.getID());

		performanceDao.creerPerformance(performance);
	}

	public Performance find(final Object id) {
		return performanceDao.find(id);
	}

	public List<Performance> membreRegionPerfCp(final CompMembre compMenbre, final Competition competition) {
		return performanceDao.membreRegionPerfCp(compMenbre, competition);
	}

	public List<Performance> membrePerfDesc() {
		return performanceDao.membrePerfDesc();
	}

	public List<Performance> membrePerfCp(final Competition competition) {
		// TODO Auto-generated method stub
		return performanceDao.membrePerfCp(competition);
	}
}
