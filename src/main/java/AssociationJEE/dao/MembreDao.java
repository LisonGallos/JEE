
package AssociationJEE.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import AssociationJEE.model.Membre;

public interface MembreDao {

    List<Membre> findAllMembres() throws SQLException, ParseException;
    void insertMembre(Membre membre) throws SQLException;
    void updateMembreValide(Membre membre) throws SQLException;
}