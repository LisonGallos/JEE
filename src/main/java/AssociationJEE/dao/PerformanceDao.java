
package AssociationJEE.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import AssociationJEE.model.Performance;

public interface PerformanceDao {

    List<Performance> findAllPerformances() throws SQLException, ParseException;
}