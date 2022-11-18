package cl.generationc2.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.generationc2.web.api.RolApiRestController;
import cl.generationc2.web.models.Rol;
import cl.generationc2.web.repositories.RolRepository;

@Service
public class RolServiceImpl implements RolService{

	@Autowired
	private RolRepository rolRepository;
	
	@Override
	public Rol obtenerRol(Long id) {
		return rolRepository.findById(id).get();
	}

	
	
}
