package cl.generationc2.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.generationc2.web.services.RolServiceImpl;

@RestController
public class RolApiRestController {
	
	@Autowired
	private RolServiceImpl rolServiceImpl;
	
	//@RequestMapping("/obtener/rol")
	
	
}
