package AssociationJEE.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class Performance {
	
	@Id
	@GeneratedValue
	private int ID;
	
	private String intitule;
	private int points;
	private Date date_performance;
	private int id_membre;
	private int id_competition;		


	public Performance(int iD2, String intitule2, int points2,
			Date date_performance2, int id_membre2, int id_competition2) {
		this.ID = iD2;
		this.intitule = intitule2;
		this.points = points2;
		this.date_performance = date_performance2;
		this.id_membre = id_membre2;
		this.id_competition = id_competition2;
	}

	public int getID() {
		return ID;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	
	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
	public Date getDate_performance() {
		return date_performance;
	}

	public void setDate_performance(Date date_performance) {
		this.date_performance = date_performance;
	}
	
	public int getId_membre() {
		return id_membre;
	}

	public void setId_membre(int id_membre) {
		this.id_membre = id_membre;
	}	
	
	public int getId_competition() {
		return id_competition;
	}

	public void setId_competition(int id_competition) {
		this.id_competition = id_competition;
	}
}
