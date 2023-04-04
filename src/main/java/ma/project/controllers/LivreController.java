package ma.project.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.project.entities.Auteur;
import ma.project.entities.Livre;
import ma.project.entities.Personne;
import ma.project.services.AuteurService;
import ma.project.services.LivreService;

@RestController
@RequestMapping("/livres")
public class LivreController {

	@Autowired
	LivreService livreService;
	@Autowired
	AuteurService auteurService;

	@PostMapping("/save")
	public Livre save(@RequestBody Livre livre) {
		if (livre.getIsbn() == null || livre.getTitre() == null) {
			throw new IllegalArgumentException("ISBN and title are required.");
		}

		// TODO: Add more validation if needed
		return livreService.Save(livre);
	}

	@PostMapping("/affect/livre/{idLivre}/toAuteur/{idAuteur}")

	public void LivreToAuteur(@PathVariable int idLivre, @PathVariable int idAuteur) {
		auteurService.LivreToAuteur(idLivre, idAuteur);
	}

	@PutMapping("/update")
	public void Modify(@RequestBody Livre t) {
		livreService.Modify(t);

	}

	@DeleteMapping("/delete/{id}")
	public void Delete(@PathVariable int id) {

		livreService.Delete(id);
	}

	@GetMapping("/{id}")

	public Livre findById(@PathVariable int id) {
		// TODO Auto-generated method stub
		return livreService.findById(id);
	}
	
//http://localhost:8080/livres/BetweenDates?date1=1999-06-01&date2=2001-01-01

	@GetMapping("/BetweenDates")
	public List<Livre> findAllByDateEditionBetween(
			@RequestParam("date1") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date1,
			@RequestParam("date2") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date2) {
		return livreService.findAllByDateEditionBetween(date1, date2);
	}

	@GetMapping("/auteur/{id}")
	public List<Livre> findByAuteur(@PathVariable int id) {
		return livreService.findByAuteur(id);

	}

	@GetMapping("/all")
	public List<Livre> All() {
		return livreService.findAll();

	}

}
