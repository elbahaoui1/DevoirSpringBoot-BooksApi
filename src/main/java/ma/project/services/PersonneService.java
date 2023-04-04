package ma.project.services;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.project.dao.IDAO;
import ma.project.entities.Personne;
import ma.project.repositories.PersonneRepository;

@Service

public class PersonneService implements IDAO<Personne>{

	
	@Autowired
	
	PersonneRepository personneRepository ;
	@Override
	public Personne Save(Personne t) {
		// TODO Auto-generated method stub
		return personneRepository.save(t);
	}

	@Override
	public void Modify(Personne t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Personne findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
}
