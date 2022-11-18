package cl.generationc2.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.generationc2.web.models.Pais;
import cl.generationc2.web.services.PaisServiceImpl;

@RestController
@RequestMapping("/pais")
public class PaisApiRestController {
	//El api es la interfaz que yo pongo a disposicion para ejecutarlo en otras aplicaciones
	
	@Autowired
	private PaisServiceImpl paisServiceImpl;
	
	@RequestMapping("/guardar")
	public Pais guardarPais(@RequestBody Pais pais) {
		return paisServiceImpl.guardarPais(pais);
	}
	
}
