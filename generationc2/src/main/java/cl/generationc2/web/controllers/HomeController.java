package cl.generationc2.web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.generationc2.web.models.Auto;
import cl.generationc2.web.services.AutoServiceImpl;

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	AutoServiceImpl autoServiceImpl;
	
	@GetMapping("")
	public String home(Model model) {
		
		//obtener y almacenar en variable
		List<Auto> listaAutos = autoServiceImpl.obtenerListaAutos();
		//pasar lista de autos
		model.addAttribute("autos", listaAutos);
		
		//lista para el selector
		List<Auto> listaSelectAutos= autoServiceImpl.obtenerListaAutos();
		model.addAttribute("listaSelectAutos", listaSelectAutos);
		return "home.jsp";
	}
	
	
	@PostMapping("")
	public String buscarAuto(@RequestParam ("autoSeleccionado") long id, Model model) {
		
		List<Auto> listaAutos = new ArrayList<Auto>(); //lista vacía
		Auto auto =autoServiceImpl.obtenerAuto(id);
		listaAutos.add(auto); //agregando el auto a la lista
		model.addAttribute("autos", listaAutos); //pasar la lista de autos al JSP
		
		//lista para el selector
		List<Auto> listaSelectAutos= autoServiceImpl.obtenerListaAutos();
		model.addAttribute("listaSelectAutos", listaSelectAutos);
		return "home.jsp";
	}
	
	@PostMapping("/nav")
	public String buscarMarca(@RequestParam ("marca") String marca, Model model) {
		
		List<Auto> listaAutos = new ArrayList<Auto>(); //lista vacía
		Auto auto =autoServiceImpl.obtenerAutoMarca(marca);
		listaAutos.add(auto); //agregando el auto a la lista
		model.addAttribute("autos", listaAutos); //pasar la lista de autos al JSP
		
		//lista para el selector
		List<Auto> listaSelectAutos= autoServiceImpl.obtenerListaAutos();
		model.addAttribute("listaSelectAutos", listaSelectAutos);
		return "home.jsp";
	}
}
