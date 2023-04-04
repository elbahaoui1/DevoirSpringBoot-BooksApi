package ma.project;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import ma.project.entities.Auteur;
import ma.project.services.AuteurService;

@SpringBootApplication
public class DevoirSpringApplication extends SpringBootServletInitializer {
	@Autowired
	static	AuteurService auteurService;

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(DevoirSpringApplication.class, args);
		
//		LivreAuteurTest lat = new LivreAuteurTest();
//		lat.testLivreAuteurMethod();
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(DevoirSpringApplication.class);
	}
}
