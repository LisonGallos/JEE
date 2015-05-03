package com.lison.dao.impl;

import org.springframework.stereotype.Repository;

import com.lison.dao.IPerformanceDao;
import com.lison.model.Performance;

@Repository("performanceDao")
public class PerformanceDaoImpl extends AbstractDao<Performance> implements IPerformanceDao {

	public PerformanceDaoImpl() {
		super(Performance.class);
	}
}
