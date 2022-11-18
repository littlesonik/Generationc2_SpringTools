package cl.generationc2.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.generationc2.web.models.Pais;
import cl.generationc2.web.repositories.PaisRepository;

@Service
public class PaisServiceImpl implements PaisService{

	@Autowired
	private PaisRepository paisRepository;
	
	@Override
	public Pais guardarPais(Pais pais) {
		return paisRepository.save(pais);
	}


}
