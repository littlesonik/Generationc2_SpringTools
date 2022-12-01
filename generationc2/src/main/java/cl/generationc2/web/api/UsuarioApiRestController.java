package cl.generationc2.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.generationc2.web.models.Rol;
import cl.generationc2.web.models.Usuario;
import cl.generationc2.web.services.UsuarioServiceImpl;

@RestController
public class UsuarioApiRestController {
	@Autowired
	//Se hace uso de los metodos a los que se menciona (Inyeccion de metodos)
	private UsuarioServiceImpl usuarioServiceImpl;
	
	
	//http://localhost:8080/guardar/usuario
	@RequestMapping("/guardar/usuario")
	public String guardarUsuario (@RequestBody Usuario usuario) {
		//El requestBody va a capturar los datos desde el cuerpo de la peticion
		/*
		 	{
		 	nombre: "Ivan",
		 	correo: "a@a.cl",
		 	password: "secret"
		 	}
		 * */
		Boolean resultado = usuarioServiceImpl.guardarUsuario(usuario);
		if(resultado) {//si es verdadero
			return "Insertado correctamente"; //enviar a una vista
		}else {
			return "Error al crear usuario";
		}

	}
	
	
	//http://localhost:8080/eliminar/usuario
	@RequestMapping("/eliminar/usuario")
	public String eliminarUsuario(@RequestParam(value="id",required = false) Long id) {
	// llamando al metodo eliminar en el service
	return usuarioServiceImpl.eliminarUsuario(id);
	}
	
	
	@RequestMapping("/actualizar/usuario")
	public String actualizarUsuario(@RequestBody Usuario usuario) {
		//validación logica
		if(usuario.getId()!=null) {
			
			return usuarioServiceImpl.actualizarUsuario(usuario);
		}
		return "no se actualizará ningún Usuario";
	}
	
	@RequestMapping("/obtener/usuario")
	public Usuario obtenerUsuario (@RequestParam(value="id",required = true) Long id) {
		//llamando al metodo eliminar en el service
		return usuarioServiceImpl.obtenerUsuario(id);
	}
	
	//listar todos los usuarios
	@GetMapping("/listar/usuarios") //funciona igual que el requestmapping, solo que se limita a las peticiones get
	public List<Usuario> obtenerListaUsuarios(){
		return usuarioServiceImpl.obtenerListaUsuarios();
	}
	
}
