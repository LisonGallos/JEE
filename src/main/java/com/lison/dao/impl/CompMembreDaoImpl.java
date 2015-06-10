package com.lison.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.lison.dao.ICompMembreDao;
import com.lison.model.CompMembre;
import com.lison.model.Competition;
import com.lison.model.Membre;

@Repository("compMembreDao")
public class CompMembreDaoImpl extends AbstractDao<CompMembre> implements ICompMembreDao {

	public CompMembreDaoImpl() {
		super(CompMembre.class);
	}

	public void creerCompMembre(final CompMembre pCompMembre) {
		this.persist(pCompMembre);
	}

	public List<CompMembre> membresParComp(final Competition competition) {
		final StringBuilder hqlBuilder = new StringBuilder();

		hqlBuilder.append("from CompMembre cm ");
		hqlBuilder.append("where cm.competition.ID = :idComp ");
		hqlBuilder.append("order by cm.membre.nom");

		final TypedQuery<CompMembre> query1 = getEntityManager().createQuery(hqlBuilder.toString(), CompMembre.class);

		query1.setParameter("idComp", competition.getID());

		List<CompMembre> result = query1.getResultList();
		// If we found it, we just return it
		if (result != null && !result.isEmpty()) {
			System.out.println("liste pleine");
			return result;
		}
		return null;
	}

	public List<CompMembre> mbParCpExist(final Competition competition, final Membre membre) {
		final StringBuilder hqlBuilder = new StringBuilder();

		hqlBuilder.append("from CompMembre cm ");
		hqlBuilder.append("where cm.competition.ID = :IdComp ");
		hqlBuilder.append("and cm.membre.ID = :IdMem ");

		final TypedQuery<CompMembre> query1 = getEntityManager().createQuery(hqlBuilder.toString(), CompMembre.class);

		query1.setParameter("IdComp", competition.getID());
		query1.setParameter("IdMem", membre.getID());

		List<CompMembre> result = query1.getResultList();
		if (result != null && !result.isEmpty()) {
			System.out.println("liste pleine");
			return result;
		}
		return null;
	}

}
