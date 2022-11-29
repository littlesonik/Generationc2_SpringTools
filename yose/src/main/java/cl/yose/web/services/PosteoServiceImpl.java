package cl.yose.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.yose.web.models.Posteo;
import cl.yose.web.repositories.PosteoRepository;


@Service
public class PosteoServiceImpl implements PosteoService {
	@Autowired
	public PosteoRepository posteoRepository;
	
	@Override
	public Posteo guardarPosteo(Posteo posteo) {
		return posteoRepository.save(posteo);
	}
	
	@Override
	public String eliminarPosteo(Long id) {
		Boolean existe = posteoRepository.existsById(id);

		if (existe) {
			posteoRepository.deleteById(id);
		} else {
			return "Usuario no existe en la tabla";
		}

		existe = posteoRepository.existsById(id);
		if (existe) {
			return "Publicacion no eliminada";
		}

		return "Se ha eliminado tu publicacion";
	}

	@Override
	public String actualizarPosteo(Posteo posteo) {
		Boolean existe = posteoRepository.existsById(posteo.getId());
		// validion si existe en base de datos
		if (existe) {
			posteoRepository.save(posteo);
			return "Publicacion actualizada con exito";
		}

		return "Publicacion no actualizada";
	}
	
	@Override
	public Posteo obtenerPosteo(Long id) {
		Boolean existe= posteoRepository.existsById(id);
		
		if(existe) {
			Posteo post= posteoRepository.findById(id).get();
			return post;
		}
		return null;
	}

	public List<Posteo> listaPosteo() {
		
		return posteoRepository.findAll();
	}
	
	
}