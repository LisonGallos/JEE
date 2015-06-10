package com.lison.dao;

import java.util.List;

import com.lison.model.CompMembre;
import com.lison.model.Competition;
import com.lison.model.Performance;

public interface IPerformanceDao extends IAbstractDao<Performance> {

	void creerPerformance(final Performance pPerformance);

	List<Performance> membreRegionPerfCp(CompMembre compMenbre, Competition competition);

	List<Performance> membrePerfDesc();

	List<Performance> membrePerfCp(Competition competition);

}