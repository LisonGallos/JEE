package com.lison.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.lison.dao.IPerformanceDao;
import com.lison.model.CompMembre;
import com.lison.model.Competition;
import com.lison.model.Performance;

@Repository("performanceDao")
public class PerformanceDaoImpl extends AbstractDao<Performance> implements IPerformanceDao {

	public PerformanceDaoImpl() {
		super(Performance.class);
	}

	public void creerPerformance(final Performance pPerformance) {
		this.persist(pPerformance);
	}

	public List<Performance> membreRegionPerfCp(final CompMembre compMenbre, final Competition competition) {
		final StringBuilder hqlBuilder = new StringBuilder();

		hqlBuilder.append("from Performance pf ");
		hqlBuilder.append("where pf.membre.association.region = :compMenbre and pf.points <> ' ' ");
		hqlBuilder.append("and pf.competition.ID= :competition ");
		hqlBuilder.append("order by pf.membre.nom, pf.points desc");

		final TypedQuery<Performance> query1 = getEntityManager().createQuery(hqlBuilder.toString(), Performance.class);

		query1.setParameter("compMenbre", compMenbre.getmembre().getAssociation().getRegion());
		query1.setParameter("competition", competition.getID());
		List<Performance> result = query1.getResultList();

		// If we found it, we just return it
		if (result != null && !result.isEmpty()) {
			System.out.println("liste membre desc OK");
			return result;
		}
		return null;
	}

	public List<Performance> membrePerfCp(final Competition competition) {
		final StringBuilder hqlBuilder = new StringBuilder();

		hqlBuilder.append("from Performance pf ");
		hqlBuilder.append("where pf.competition.ID = :competId and pf.points <> ' ' ");

		final TypedQuery<Performance> query1 = getEntityManager().createQuery(hqlBuilder.toString(), Performance.class);

		query1.setParameter("competId", competition.getID());
		List<Performance> result = query1.getResultList();

		// If we found it, we just return it
		if (result != null && !result.isEmpty()) {
			System.out.println("liste membre desc OK");
			return result;
		}
		return null;
	}

	public List<Performance> membrePerfDesc() {
		final StringBuilder hqlBuilder = new StringBuilder();

		hqlBuilder.append("from Performance pf ");
		hqlBuilder.append("order by pf.membre.ID asc");

		final TypedQuery<Performance> query1 = getEntityManager().createQuery(hqlBuilder.toString(), Performance.class);

		List<Performance> result = query1.getResultList();

		// If we found it, we just return it
		if (result != null && !result.isEmpty()) {
			System.out.println("liste performance desc OK");
			return result;
		}
		return null;
	}
}
