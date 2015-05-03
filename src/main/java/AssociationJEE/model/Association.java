package AssociationJEE.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Association {
	
	@Id
	@GeneratedValue
	private int ID;
	
	private String nom;
	private String region;
	

	public Association(int iD2, String nom2, String region2) {
		this.ID = iD2;
		this.nom = nom2;
		this.region = region2;				
	}
	
	public int getID() {
		return ID;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getRegion() {
		return region;
	}
	
	public void setRegion(String region) {
		this.region = region;
	}
}
