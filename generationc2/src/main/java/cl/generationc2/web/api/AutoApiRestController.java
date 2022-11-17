package cl.generationc2.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.generationc2.web.models.Auto;
import cl.generationc2.web.models.Usuario;
import cl.generationc2.web.services.AutoServiceImpl;
import cl.generationc2.web.services.UsuarioServiceImpl;

@RestController
public class AutoApiRestController {
	@Autowired
	private AutoServiceImpl autoServiceImpl;
	
	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;
	
	@RequestMapping("/guardar/auto")
	public Auto guardarUsuario(@RequestBody Auto auto,
			@RequestParam(value="usuarioId",required = false) Long usuarioId) {
		
		Usuario usuario = usuarioServiceImpl.obtenerUsuario(usuarioId);
		auto.setUsuario(usuario);
		
		return autoServiceImpl.guardarAuto(auto);
	}

	@RequestMapping("/obtener/auto")
	public Auto obtenerAuto (@RequestParam(value="id",required = true) Long id) {
		return autoServiceImpl.obtenerAuto(id);
	}
}
