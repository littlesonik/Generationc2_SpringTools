package cl.playground.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.playground.models.CasaWesteros;

@Repository
public interface CasaWesterosRepository extends JpaRepository<CasaWesteros, Long>{

}
