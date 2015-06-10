package com.lison.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.lison.dao.ICompetitionDao;
import com.lison.model.Competition;

@Repository("competitionDao")
public class CompetitionDaoImpl extends AbstractDao<Competition> implements ICompetitionDao {

	public CompetitionDaoImpl() {
		super(Competition.class);
	}

	public void creerCompetition(final Competition pCompetition) {
		this.persist(pCompetition);
	}

	public List<Competition> listeCompetitionASC() {
		final StringBuilder hqlBuilder = new StringBuilder();

		hqlBuilder.append("from Competition cp ");
		hqlBuilder.append("order by cp.nom asc");

		final TypedQuery<Competition> query1 = getEntityManager().createQuery(hqlBuilder.toString(), Competition.class);

		List<Competition> result = query1.getResultList();

		if (result != null && !result.isEmpty()) {
			System.out.println("liste competition asc OK");
			return result;
		}
		return null;
	}
}
