package cl.generationc2.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.generationc2.web.models.Auto;

@Repository
public interface AutoRepository extends JpaRepository<Auto, Long>{

	Auto findByMarca(String marca);

}
