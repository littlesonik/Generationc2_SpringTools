package cl.generationc2.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.generationc2.web.dto.AutoDTO;
import cl.generationc2.web.models.Auto;
import cl.generationc2.web.models.Usuario;
import cl.generationc2.web.services.AutoServiceImpl;
import cl.generationc2.web.services.UsuarioServiceImpl;

@RestController
@RequestMapping("/api2")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class AutoApiRestController {
	@Autowired
	private AutoServiceImpl autoServiceImpl;
	
	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;
	
	@RequestMapping("/guardar/auto")
	public Auto guardarAuto(@RequestBody Auto auto,
			@RequestParam(value="usuarioId",required = false) Long usuarioId) {
		
		Usuario usuario = usuarioServiceImpl.obtenerUsuario(usuarioId);
		auto.setUsuario(usuario);
		
		return autoServiceImpl.guardarAuto(auto);
	}

	@RequestMapping("/obtener/auto")
	public Auto obtenerAuto (@RequestParam(value="id",required = true) Long id) {
		return autoServiceImpl.obtenerAuto(id);
	}
	
	@RequestMapping(value = "/autos/getall", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<AutoDTO> autosGetAll() {
		
		return autoServiceImpl.listarAutos();
	}
	
	@RequestMapping(value = "/eliminar/auto", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<AutoDTO> eliminarAuto(@RequestParam(value="id",required = false) Long id) {
		
		autoServiceImpl.eliminarAuto(id);
		
		return autoServiceImpl.listarAutos();
	}

}
