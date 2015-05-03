package AssociationJEE.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

public class Membre {
	
	@Id
	@GeneratedValue
	private int ID;

	private String nom;
	private String prenom;
	private String email;
	private String password;
	private boolean compte_valide;
	private String responsabilite;
	private Date date_inscription;
	private Date date_naissance; 
	private int id_asso;
	
	
	@ManyToMany(mappedBy="performances")
    private Collection<Performance> performances ;
	
	public Membre(int iD2, String nom2, String prenom2, String email2,
			String password2, boolean compte_valide2, String responsabilite2,
			Date date_inscription2, Date date_naissance2, int id_asso2) {
		this.ID = iD2;
		this.nom = nom2;
		this.prenom = prenom2;
		this.email = email2;
		this.password = password2;
		this.compte_valide = compte_valide2;
		this.responsabilite = responsabilite2;
		this.date_inscription = date_inscription2;
		this.date_naissance = date_naissance2;
		this.id_asso = id_asso2;
	}

	public Collection<Performance> getPerformances() {
		return performances;
	}
	
	public void setPerformances(Collection<Performance> performances) {
		this.performances = performances;
	}
	
	public int getID() {
		return ID;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId_asso() {
		return id_asso;
	}
	public void setId_asso(int id_asso) {
		this.id_asso = id_asso;
	}
	public boolean getCompte_valide() {
		return compte_valide;
	}
	public void setCompte_valide(boolean compte_valide) {
		this.compte_valide = compte_valide;
	}
	public String getResponsabilite() {
		return responsabilite;
	}
	public void setResponsabilite(String responsabilite) {
		this.responsabilite = responsabilite;
	}
	public Date getDate_inscription() {
		return date_inscription;
	}
	public void setDate_inscription(Date date_inscription) {
		this.date_inscription = date_inscription;
	}
	public Date getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}
}
