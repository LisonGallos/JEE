
package AssociationJEE.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import AssociationJEE.model.Association;
import AssociationJEE.model.Membre;

public interface AssociationDao {

    List<Association> findAllAssociations() throws SQLException, ParseException;
}