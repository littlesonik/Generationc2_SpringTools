package cl.yose.web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.yose.web.models.Categoria;
import cl.yose.web.models.Posteo;
import cl.yose.web.services.CategoriaServiceImpl;
import cl.yose.web.services.PosteoServiceImpl;

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	PosteoServiceImpl posteoServiceImpl;
	
	@Autowired
	CategoriaServiceImpl categoriaServiceImpl;
	
	@GetMapping("")
	public String home(Model model) {
		List<Categoria> listaCategorias = categoriaServiceImpl.listaCategorias();
		
		model.addAttribute("categorias", listaCategorias);
		return "home.jsp";
	}
	
	@PostMapping("")
	public String buscarCategoria(@RequestParam ("detalleCategoria") String detalle, Model model) {
		
		List<Categoria> listaCategorias = new ArrayList<Categoria>(); //lista vacía
		Categoria categoria = categoriaServiceImpl.obtenerCategoriaDetalle(detalle);
		listaCategorias.add(categoria); //agregando categoria a la lista
		model.addAttribute("categorias", listaCategorias); //pasar la lista de autos al JSP
		
		//lista para el selector
		//List<Categoria> listaSelectCategorias= categoriaServiceImpl.listaCategorias();
		//model.addAttribute("listaSelectCategorias", listaSelectCategorias);
		return "home.jsp";
	}
	
	@PostMapping("/post")
	public String guardarPosteo(@RequestParam("titulo") String titulo, 
			@RequestParam("texto") String texto,
			@RequestParam("url") String url,
			Model model) {
		Posteo posteo= new Posteo();
		posteo.setTitulo(titulo);
		posteo.setTexto(texto);
		posteo.setUrl(url);
		
		posteoServiceImpl.guardarPosteo(posteo);
		
		model.addAttribute(posteo);
		return "home.jsp";
	}
	
	
	
}
