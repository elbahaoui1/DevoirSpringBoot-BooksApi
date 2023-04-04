package ma.project.entities;


import java.util.Date;
import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
@DiscriminatorValue("AU")
public class Auteur extends Personne{

	
	private String email;
	@ManyToMany
	@JoinTable(
			name="Livre_Auteur", joinColumns = {@JoinColumn(name="Auteur_id")}, inverseJoinColumns = {@JoinColumn(name="Livre_id")})
	private List<Livre> livre;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Livre> getLivre() {
		return livre;
	}
	public void setLivre(List<Livre> livre) {
		this.livre = livre;
	}
	public Auteur() {
		super();
	}
	public Auteur(String nom, String prenom, String cin, java.util.Date date, String email) {
		super(nom, prenom, cin, date);
		this.email = email;
		
	}
	
	
	
	
}
