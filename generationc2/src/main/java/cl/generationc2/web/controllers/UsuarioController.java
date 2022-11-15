package cl.generationc2.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsuarioController {
	
	//Capturar las rutas
	//https://localhost:8080/
	@RequestMapping("/")
	public String getUsuario() {
		System.out.println("Metodo de obtener usuario");
		return "index.jsp";
	}
	
	////https://localhost:8080/home
	@RequestMapping("/home")
	public String home() {
		System.out.println("en el metodo home");
		return "Dentro de home";
	}
	
}
