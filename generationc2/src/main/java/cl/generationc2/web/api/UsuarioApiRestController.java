package cl.generationc2.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.generationc2.web.models.Usuario;
import cl.generationc2.web.services.UsuarioServiceImpl;

@RestController
public class UsuarioApiRestController {
	@Autowired
	//Se hace uso de los metodos a los que se menciona (Inyeccion de metodos)
	private UsuarioServiceImpl usuarioServiceImpl;
	
	//http://localhost:8080/guardar/usuario
	@RequestMapping("/guardar/usuario")
	public Usuario guardarUsuario (@RequestBody Usuario usuario) {
		//El requestBody va a capturar los datos desde el cuerpo de la peticion
		/*
		 	{
		 	nombre: "Ivan",
		 	correo: "a@a.cl",
		 	password: "secret"
		 	}
		 * */
		return usuarioServiceImpl.guardarUsuario(usuario);
		
	}
	
}
