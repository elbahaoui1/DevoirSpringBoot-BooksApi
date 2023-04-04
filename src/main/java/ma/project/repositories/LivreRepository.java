package ma.project.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.project.entities.Auteur;
import ma.project.entities.Livre;
import ma.project.entities.Personne;

@Repository
public interface LivreRepository extends JpaRepository<Livre, Integer> {

	Livre findByIsbn(String isbn);

	List<Livre> findByAuteur(Auteur auteur);

	Livre findById(int id);

	Livre save(Livre livre);

	// @Query("SELECT EntityClass;Table t FROM Livre WHERE dateEdition Between %?1%
	// AND %?2% ")
	//List<Livre> findAllByDateEditionBetween(Date date1, Date date2);

	@Query("SELECT l FROM Livre l WHERE l.dateEdition Between :date1 and :date2")
	public List<Livre> findAllByDateEditionBetween(@Param("date1") Date date1,@Param("date2") Date date2);

}
