package com.lison.service;

import java.util.List;

import com.lison.model.Competition;

public interface ICompetitionService {

	List<Competition> findAll();

	void creerCompetition(Competition competition);

	Competition find(Object id);

	List<Competition> listeCompetitionASC();
}
