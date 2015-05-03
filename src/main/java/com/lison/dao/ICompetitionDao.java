
package com.lison.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.lison.model.Competition;

public interface ICompetitionDao {

    List<Competition> findAllCompetitions() throws SQLException, ParseException;
}