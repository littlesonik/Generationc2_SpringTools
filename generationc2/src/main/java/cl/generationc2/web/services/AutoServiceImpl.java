package cl.generationc2.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.generationc2.web.models.Auto;
import cl.generationc2.web.models.Usuario;
import cl.generationc2.web.repositories.AutoRepository;

@Service
public class AutoServiceImpl implements AutoService{

	@Autowired
	private AutoRepository autoRepository;
	
	
	@Override
	public Auto guardarAuto(Auto auto) {
		return autoRepository.save(auto);
	}


	@Override
	public Auto obtenerAuto(Long id) {
		Boolean existe = autoRepository.existsById(id);
		if(existe) {
			Auto auto = autoRepository.findById(id).get();
			return auto;
		}
		return null;
	}

}
