package cl.generationc2.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registro")
//http://localhost:8080/registro
public class RegistroController {
	
	//http://localhost:8080/registro/usuario
	//capturar la url y
	@RequestMapping("/usuario")
	public String mostrarFormulario() {
		//desplegar el jsp (controlador)
		return "registro.jsp";
	}
	
	
	//el usuario llena el formulario (vista)
	//el usuario envia el formulario (vista)
	//capturar la url,
	//capturar los parametros
	//enviar a la base de datos
}
