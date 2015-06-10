package com.lison.service;

import java.util.List;

import com.lison.model.CompMembre;
import com.lison.model.Competition;
import com.lison.model.Performance;

public interface IPerformanceService {
	
	List<Performance> findAll();
	
	void creerPerformance(Performance performance);

	Performance find(Object id);

	List<Performance> membreRegionPerfCp(CompMembre compMenbre, Competition competition);

	List<Performance> membrePerfDesc();

	List<Performance> membrePerfCp(Competition competition);
}
