package cl.generationc2.web.controllers;

import javax.persistence.NamedStoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	//http://localhost:8080/registro/usuarioGET
	//capturar la url y...
	@GetMapping("/usuario") //Despliego el jsp
	public String mostrarFormulario() {
		//desplegar el jsp (controlador)
		return "registro.jsp";
	}
	
	//el usuario llena el formulario (vista)
	//el usuario envia el formulario (vista)
	//capturar la url,
	
	//http://localhost:8080/registro/usuarioPOST
	@PostMapping("/usuario") //Capturo los datos en el controlador
	//capturar los parametros @RequestParam
	public String guardarFormulario(@RequestParam ("nombre")String nombre,
			@RequestParam ("apellido")String apellido,
			@RequestParam ("nick")String nick,
			@RequestParam ("correo")String correo,
			@RequestParam ("pass")String pass,
			@RequestParam ("pass2")String pass2,
			Model model //Permite traspasar informacion desde el backend hacia el frontend
			) {
		
		if(pass.equals(pass2)) {	
			System.out.println(nombre+" "+apellido+ " "+nick+" "+ correo+" "+pass);
			//instanciar a un objeto usuario
			Usuario usuario = new Usuario();
			usuario.setNombre(nombre);
			usuario.setApellido(apellido);
			usuario.setNick(nick);
			usuario.setCorreo(correo);
			usuario.setPassword(pass);
			usuario.setPassword2(pass2);
		
			//enviando a base de datos
			Boolean resultado = usuarioServiceImpl.guardarUsuario(usuario);
			if (resultado) { //si es verdadero
				model.addAttribute("msgOk", "Registro exitoso!");
				return "login.jsp"; //enviar a una vista
			}else {
				model.addAttribute("msgError", "El correo ya se encuentra registrado");
				return "registro.jsp";
			}
		}else {//si el password es distinto
			model.addAttribute("msgError", "Asegurate que las contraseñas sean idénticas");
			return "registro.jsp";
		}
	}
	
	//desplegar jsp de login http://localhost:8080/registro/login
	@GetMapping("/login") //El getmapping se utiliza solo para peticiones de ruta y parametros (se dan los parametros por URL)
	public String login() {
		return "login.jsp";
	}
	
	//capturar el email y password
	@PostMapping("/login") //El postmapping se solicita la ruta pero con parametros ocultos
	public String ingresoUsuario (@RequestParam("email") String email,
	@RequestParam("pass") String pass,
	Model model) {
		//System.out.println(email +" "+pass);
		//llamando al metodo
		Boolean resultadoLogin = usuarioServiceImpl.ingresoUsuario(email, pass);
		
		if(resultadoLogin) {//resultadoLogin true == login correcto
			//ir a una ruta interna http://localhost:8080/home
			return "redirect:/home";
		}else {
			model.addAttribute("msgError", "Por favor verifica tus datos ingresados");
			return "login.jsp";
		}
	}
}