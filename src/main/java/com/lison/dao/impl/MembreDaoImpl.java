package com.lison.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.lison.dao.IMembreDao;
import com.lison.model.Association;
import com.lison.model.Competition;
import com.lison.model.Membre;

@Repository("membreDao")
public class MembreDaoImpl extends AbstractDao<Membre> implements IMembreDao {

	public MembreDaoImpl() {
		super(Membre.class);
	}

	public void creerMembre(final Membre pMembre) {
		this.persist(pMembre);
	}

	public List<Membre> listeMembreValideDesc(final Membre membre) {

		final StringBuilder hqlBuilder = new StringBuilder();
		TypedQuery<Membre> query1 = null;

		if (membre.getResponsabilite().getID() == 3) {
			hqlBuilder.append("from Membre mb ");
			hqlBuilder.append("where (mb.compte_valide = 1 or mb.compte_valide = 3) ");
			hqlBuilder.append("and mb.association.ID = :idAsso ");
			hqlBuilder.append("order by mb.date_inscription desc");

			query1 = getEntityManager().createQuery(hqlBuilder.toString(), Membre.class);

		} else {
			if (membre.getResponsabilite().getID() == 4) {

				hqlBuilder.append("from Membre mb ");
				hqlBuilder.append("where mb.compte_valide = 1 ");
				hqlBuilder.append("order by mb.date_inscription desc");
				query1 = getEntityManager().createQuery(hqlBuilder.toString(), Membre.class);
			}
		}
		query1.setParameter("idAsso", membre.getAssociation().getID());
		List<Membre> result = query1.getResultList();

		if (result != null && !result.isEmpty()) {
			System.out.println("liste membre desc est nulle");
			return result;
		}
		return null;
	}

	public List<Membre> login(final String nom, final String password) {
		final StringBuilder hqlBuilder = new StringBuilder();

		hqlBuilder.append("from Membre mb ");
		hqlBuilder.append("where mb.nom = :nom and mb.password = :password");

		final TypedQuery<Membre> query1 = getEntityManager().createQuery(hqlBuilder.toString(), Membre.class);

		query1.setParameter("nom", nom);
		query1.setParameter("password", password);
		List<Membre> result = query1.getResultList();

		if (result != null && !result.isEmpty()) {
			System.out.println("liste membre desc est nulle");
			return result;
		}
		return null;
	}

	public List<Membre> membreParRegionCp(final Competition competition, final Association association) {
		final StringBuilder hqlBuilder = new StringBuilder();

		hqlBuilder.append("from Membre mb ");
		hqlBuilder.append("where mb.competition.ID = :competition and mb.association.region.ID = :association");

		final TypedQuery<Membre> query1 = getEntityManager().createQuery(hqlBuilder.toString(), Membre.class);

		query1.setParameter("competition", competition.getID());
		query1.setParameter("association", association.getID());
		List<Membre> result = query1.getResultList();

		if (result != null && !result.isEmpty()) {
			System.out.println("liste membre desc OK");
			return result;
		}
		return null;
	}

	public List<Membre> membreParAsso(final Association association) {
		final StringBuilder hqlBuilder = new StringBuilder();

		hqlBuilder.append("from Membre mb ");
		hqlBuilder.append("where mb.association.ID = :association ");
		hqlBuilder.append("order by mb.nom ");

		final TypedQuery<Membre> query1 = getEntityManager().createQuery(hqlBuilder.toString(), Membre.class);

		query1.setParameter("association", association.getID());
		List<Membre> result = query1.getResultList();

		if (result != null && !result.isEmpty()) {
			System.out.println("liste membre desc OK");
			return result;
		}
		return null;
	}
}
