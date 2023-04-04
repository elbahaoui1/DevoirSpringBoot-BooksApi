package ma.project.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.project.dao.IDAO;
import ma.project.entities.Auteur;
import ma.project.entities.Livre;
import ma.project.entities.Personne;
import ma.project.repositories.AuteurRepository;
import ma.project.repositories.LivreRepository;
import ma.project.repositories.PersonneRepository;

@Service
public class AuteurService implements IDAO<Auteur> {

	@Autowired
	AuteurRepository auteurRepository;

	@Autowired
	LivreRepository livreRepository;
	
	@Autowired
	PersonneRepository personneRepository;

	public void LivreToAuteur(int idAuteur, int idLivre) {
		Auteur auteur = auteurRepository.findById(idAuteur);
	    Livre livre = livreRepository.findById(idLivre);
	    if (auteur != null && livre != null) {
	        List<Livre> livres = auteur.getLivre();
	        if (!livres.contains(livre)) {
	            livres.add(livre);
	            auteur.setLivre(livres);
	            auteurRepository.save(auteur);
	        }
	        List<Auteur> auteurs = livre.getAuteur();
	        if (!auteurs.contains(auteur)) {
	            auteurs.add(auteur);
	            livre.setAuteur(auteurs);
	            livreRepository.save(livre);
	        }
	    }
	}

	@Override
	public Auteur Save(Auteur t) {
		// TODO Auto-generated method stub
		Personne personne = personneRepository.save(t);
	    return auteurRepository.findById(personne.getId());
	}
	
	
	public void save(Auteur t) {
		// TODO Auto-generated method stub
		
	    personneRepository.save(t);
	}
	


	@Override
	public void Modify(Auteur t) {
		auteurRepository.save(t);
	}

	public void DeleteByCin(String cin) {
		Auteur auteur = auteurRepository.findByCin(cin);
		auteurRepository.delete(auteur);

	}

	@Override
	public void Delete(int id) {
		Auteur auteur = auteurRepository.findById(id);
		personneRepository.delete(auteur);

	}

	@Override
	public Auteur findById(int id) {
		// TODO Auto-generated method stub
		return auteurRepository.findById(id);
	}
	
	public Auteur findByCin(String cin) {
		// TODO Auto-generated method stub
		return auteurRepository.findByCin(cin);
	}

	public List<Auteur> findByDateNaissance(Date date) {
		return auteurRepository.findByDateNaissance(date);
	}
	
	public List<Auteur> findall() {
		// TODO Auto-generated method stub
		return auteurRepository.findAll();
	}
	
	

}
