package cl.playground.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import cl.playground.models.CasaWesteros;
import cl.playground.services.CasaWesterosServiceImpl;

@RestController
public class CasaWesterosApiRestController {
	
	@Autowired
	CasaWesterosServiceImpl casaWServiceImpl;
	
	@RequestMapping("/guardar/casa")
	public CasaWesteros guardarCasa (@RequestBody CasaWesteros casa) {
		return casaWServiceImpl.guardarCasa(casa);
	}
	
	@RequestMapping("/obtener/casa")
	public CasaWesteros obtenerCasa(@RequestParam(value = "id", required=true) Long id) {
		return casaWServiceImpl.obtenerCasa(id);
	}
	
	@RequestMapping("/listar/casas")
	public List<CasaWesteros> listarCasas(){
		return casaWServiceImpl.ListaCasas();
	}

}
