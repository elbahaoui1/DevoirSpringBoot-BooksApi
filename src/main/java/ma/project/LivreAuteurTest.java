//package ma.project;
//
//
//import java.sql.Date;
//
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import ma.project.entities.Auteur;
//import ma.project.entities.Livre;
//import ma.project.services.AuteurService;
//import ma.project.services.LivreService;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class LivreAuteurTest {
//
//	@Autowired
//	private LivreService livreService;
//
//	@Autowired
//	private AuteurService auteurService;
//
//	public void testLivreAuteurMethod() {
//		try {
//		Auteur auteur = new Auteur();
//		auteur.setNom("Doe");
//		auteur.setPrenom("John");
//		auteur.setCin("123456");
//		auteur.setDateNaissance(Date.valueOf("1980-01-01"));
//		auteur.setEmail("john.doe@example.com");
//
//		Auteur savedAuteur = auteurService.Save(auteur);
//
//	
//		Livre livre = new Livre();
//		livre.setTitre("Le Seigneur des Anneaux");
//		livre.setIsbn("asdasd");
//		livre.setDateEdition(Date.valueOf("2001-01-01"));
//
//		livre.getAuteur().add(auteur);
//
//		Livre savedLivre = livreService.Save(livre);
//
//		}catch(Exception e) {
//			throw(e);
//		}
//	}
//}