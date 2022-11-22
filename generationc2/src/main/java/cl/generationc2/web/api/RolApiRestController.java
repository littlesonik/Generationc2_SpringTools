package cl.generationc2.web.api;

import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.generationc2.web.models.Rol;
import cl.generationc2.web.models.Usuario;
import cl.generationc2.web.services.RolServiceImpl;

@RestController
public class RolApiRestController {
	
	@Autowired
	private RolServiceImpl rolServiceImpl;
	
	//@RequestMapping("/obtener/rol")
	@RequestMapping("/obtener/rol")
	public Rol obtenerUsuario(@RequestParam(value="id",required = true) Long id) {
		Rol rol = rolServiceImpl.obtenerRol(id);
		List<Usuario> usuarios = rol.getUsuarios();
		for (Usuario usuario : usuarios) {
			System.out.println(usuario.getNombre());
		}
		return rol;
	}
	
}
