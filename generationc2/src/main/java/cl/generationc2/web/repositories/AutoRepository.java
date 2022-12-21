package cl.generationc2.web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.generationc2.web.models.Auto;

@Repository
public interface AutoRepository extends JpaRepository<Auto, Long>{

	Auto findByMarca(String marca);
	
	//logica de manipulacion de datos (CRUD+)
	
	/**JPQL**/
	//obtener una lista de autos por marca
	@Query("SELECT a FROM Auto a WHERE a.marca = ?1")
	List<Auto> findAllByMarca(String marca);
	
	//obtener una lista de autos por marca y color
	@Query("SELECT a FROM Auto a WHERE a.marca = ?1 and a.color = ?2")
	List<Auto> findAllByMarcaAndColor(String marca, String color);
	
	//Búsqueda de los autos por id del usuario
	@Query("SELECT a FROM Auto a WHERE a.usuario.id = ?1") //usario.id, porque dentro del usuario, buscamos su id
	List <Auto> findAllByUsuario(long id);
	
	//query comun
	@Query(value="select * from autos a where a.marca = ?1", nativeQuery=true) //usamos una query nativa
	List<Auto> findAllByMarcaComun(String marca);
}
