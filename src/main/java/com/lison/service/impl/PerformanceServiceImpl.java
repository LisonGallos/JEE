package com.lison.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lison.dao.IPerformanceDao;
import com.lison.model.Performance;
import com.lison.service.IPerformanceService;

@Service("performanceDaoService")
public class PerformanceServiceImpl implements IPerformanceService {

	@Autowired
	private IPerformanceDao performanceDao;
	
	public List<Performance> findAll() {
		return performanceDao.findAll();
	}

}
