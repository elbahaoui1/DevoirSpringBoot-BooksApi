package ma.project.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import ma.project.entities.Auteur;
import ma.project.entities.Personne;
import ma.project.services.AuteurService;
import ma.project.services.PersonneService;

@RestController
@RequestMapping("/auteurs")
public class AuteurController {

	@Autowired
	AuteurService auteurService;
	@Autowired
	PersonneService personneService;

	@PostMapping("/save")
	public void Save(@RequestBody Auteur a) {
		  auteurService.save(a);
	}

	@PostMapping("/update")
	public void Modify(@RequestBody Auteur t) {
		auteurService.Save(t);
	}

	@DeleteMapping("/delete/{id}")
	public void Delete(@PathVariable int id) {
		auteurService.Delete(id);

	}

	@GetMapping("/{cin}")
	public Auteur findById(@PathVariable String cin) {
		// TODO Auto-generated method stub
		return auteurService.findByCin(cin);
	}
	
	// http://localhost:8080/auteurs/dateNaissance?date=1999-06-01
	@GetMapping("/dateNaissance")
	public List<Auteur> findByDateNaissance(@RequestParam(name = "date") Date date) {
		return auteurService.findByDateNaissance(date);
	}
	@GetMapping("/all")
	public List<Auteur> findAll() {
		return auteurService.findall();
	}
}
