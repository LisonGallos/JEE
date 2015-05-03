package AssociationJEE.model;

import java.util.Collection;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



public class Competition {
	
	@Id
	@GeneratedValue
	private int ID;
	
	private String nom;
	private int id_membre;
	private int points;
	
	@ManyToMany
    private Collection<Membre> membres ;
	
	public Competition(int iD2, String nom2, int id_membre2, int points2) {
		this.ID = iD2;
		this.nom = nom2;
		this.id_membre = id_membre2;
		this.points = points2;
	}

	public Collection<Membre> setMembres() {
		return membres; 
	}
	
	public void setMembres(Collection<Membre> membres) {
		this.membres = membres; 
	}	 

	@ManyToMany
    private Collection<Performance> performances ;
	
	public Collection<Performance> getPerformances() {
		return performances; 
	}
	
	public void setPerformances(Collection<Performance> performances) {
		this.performances = performances; 
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
	
	public int getId_membre() {
		return id_membre;
	}
	
	public void setId_membre(int id_membre) {
		this.id_membre = id_membre;
	}	
	
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
}
