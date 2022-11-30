package cl.generationc2.web.controllers;

import javax.persistence.NamedStoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.generationc2.web.models.Usuario;
import cl.generationc2.web.services.UsuarioServiceImpl;

@Controller
@RequestMapping("/registro")
//http://localhost:8080/registro
public class RegistroController {
	
	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;
	
	//http://localhost:8080/registro/usuario
	//capturar la url y...
	@RequestMapping("/usuario")
	public String mostrarFormulario() {
		//desplegar el jsp (controlador)
		return "registro.jsp";
	}
	
	//el usuario llena el formulario (vista)
	//el usuario envia el formulario (vista)
	//capturar la url,
	
	
	@RequestMapping("/formulario")
	//capturar los parametros @RequestParam
	public String guardarFormulario(@RequestParam ("nombre")String nombre,
			@RequestParam ("apellido")String apellido,
			@RequestParam ("nick")String nick,
			@RequestParam ("correo")String correo,
			@RequestParam ("pass")String pass,
			@RequestParam ("pass")String pass2) {
		
		System.out.println(nombre+" "+apellido+ " "+nick+" "+ correo+" "+pass);
		//instanciar a un objeto
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setNick(nick);
		usuario.setCorreo(correo);
		usuario.setPassword(pass);
		usuario.setPassword2(pass2);
		
		usuarioServiceImpl.guardarUsuario(usuario);
		return "index.jsp";
	}
	//enviar a la base de datos
}
