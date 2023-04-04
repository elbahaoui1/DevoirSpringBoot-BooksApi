package ma.project.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.project.entities.Auteur;


@Repository
public interface AuteurRepository extends JpaRepository<Auteur, Integer> {
	
	Auteur findByCin(String cin);
	@Query("SELECT a FROM Auteur a WHERE a.dateNaissance Like :date")
	public List<Auteur> findByDateNaissance(@Param("date") Date date);
	Auteur findById(int id);
	
	

}
