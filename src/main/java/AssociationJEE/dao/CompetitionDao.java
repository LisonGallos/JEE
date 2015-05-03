
package AssociationJEE.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import AssociationJEE.model.Competition;

public interface CompetitionDao {

    List<Competition> findAllCompetitions() throws SQLException, ParseException;
}