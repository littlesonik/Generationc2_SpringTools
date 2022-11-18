package cl.generationc2.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.generationc2.web.models.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long>{
	//Es un conector a la base de datos

}
