package cl.generationc2.web.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//El RestController responde a peticiones externas de otros sistemas
//El Controller responde al mismo sistema

@RestController
@RequestMapping("/api")
public class ApiRestController {

	@RequestMapping("/hola")
	// http://localhost:8080/api/hola
	public String hola() {
		return "hola api";
	}

	// http://localhost:8080/api/edad/42
	@RequestMapping("/edad/{edad}")
	// el {} indica que es un valor que irá cambiando en el tiempo
	public String rutaDinamica(@PathVariable("edad") int edad) {
		return "capturando edad:" + edad;
	}

	// PathVariable sirve para capturar un valor dinámico
	// http://localhost:8080/api/nombre/{nombre}
	@RequestMapping("/nombre/{nombre}")
	public String rutaDinamica(@PathVariable("nombre") String nombre) {
		return "capturando nombre:" + nombre;
	}

	// http://localhost:8080/api/
	@RequestMapping("/{dia}/{mes}/{año}")
	public String rutaDinamica(@PathVariable("dia") int dia, @PathVariable("mes") String mes,
			@PathVariable("año") int año) {
		return "capturando fecha: " + dia + " " + mes + " " + año;
	}

	// http://localhost:8080/api/usario?usuarioId=1
	// en este caso estamos pasando un parametro
	// peticion de tipo GET

	@RequestMapping("/usuario")
	//capturo el parametro, y con el false indico que no es requerido
	public String parametro(@RequestParam(value = "usuarioid", required = false) Integer id) {
		// int, long y float, el valor por default es 0, nunca null.
		// Integer, Float, Long... objetos si pueden ser nulos
		if (id == null) {
			return "parametro no existe";
		} else {
			return "parametro por get " + id;
		}
	}

	//http://localhost:8080/api/usuario2?usuarioId=1&nombre=israel
	@RequestMapping("/usuario2")
	public String parametro2(@RequestParam(value = "usuarioid", required = false) Integer id,
			@RequestParam(value = "nombre", required = false) String nombre) {

		if (id == null) {
			return "parametro no existe";
		} else {
			return "parametro por get " + id + " nombre: " + nombre;
		}
	}

}
