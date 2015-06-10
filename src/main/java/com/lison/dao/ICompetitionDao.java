package com.lison.dao;

import java.util.List;

import com.lison.model.Competition;

public interface ICompetitionDao extends IAbstractDao<Competition> {

	void creerCompetition(final Competition pCompetition);

	List<Competition> listeCompetitionASC();
}