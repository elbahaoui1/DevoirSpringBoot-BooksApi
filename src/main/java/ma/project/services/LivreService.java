package ma.project.services;
import ma.project.repositories.*;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.project.dao.IDAO;
import ma.project.entities.Auteur;
import ma.project.entities.Livre;
import ma.project.repositories.LivreRepository;

@Service
public class LivreService implements IDAO<Livre> {

	@Autowired
	LivreRepository livreRepository;

	@Autowired
	AuteurRepository auteurRepository;

	@Override
	public Livre Save(Livre t) {
		// TODO Auto-generated method stub
		return livreRepository.save(t);
	}

	@Override
	public void Modify(Livre t) {
		livreRepository.save(t);

	}

	@Override
	public void Delete(int id) {
		Livre livre = livreRepository.findById(id);
		livreRepository.delete(livre);
	}

	@Override
	public Livre findById(int id) {
		// TODO Auto-generated method stub
		return livreRepository.findById(id);
	}

	public List<Livre> findAllByDateEditionBetween(Date date1, Date date2) {
		return livreRepository.findAllByDateEditionBetween(date1, date2);
	}

	public List<Livre> findByAuteur(int id) {
		Auteur auteur = auteurRepository.findById(id);
		List<Livre> livres = livreRepository.findByAuteur(auteur);
		return livres;
	}
	public List<Livre> findAll() {
		return livreRepository.findAll();
	}

}
