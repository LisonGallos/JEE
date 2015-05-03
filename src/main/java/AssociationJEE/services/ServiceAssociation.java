package AssociationJEE.services;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import AssociationJEE.model.Association;
import AssociationJEE.dao.IAssociationDao;

@Service
public class ServiceAssociation implements IServiceAssociation {
	
	@Autowired
	private IAssociationDao dao;
	
	@Transactional(readOnly=true)
	public List<Association> rechercherAssociations() throws SQLException, ParseException {
		return dao.findAllAssociations();
	}
}