	 	package ma.project.entities;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Livre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	public String isbn;
	public String titre;
	@Temporal(TemporalType.DATE)
	public Date dateEdition;
	@ManyToMany

	@JoinTable(name = "Livre_Auteur", joinColumns = { @JoinColumn(name = "Livre_id") }, inverseJoinColumns = {
			@JoinColumn(name = "Auteur_id") })
	@JsonIgnore
	public List<Auteur> auteur;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Date getDateEdition() {
		return dateEdition;
	}

	public void setDateEdition(Date dateEdition) {
		this.dateEdition = dateEdition;
	}

	public List<Auteur> getAuteur() {
		return auteur;
	}

	public void setAuteur(List<Auteur> auteur) {
		this.auteur = auteur;
	}

	public Livre() {
		super();
	}

}
