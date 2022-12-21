package cl.generationc2.web.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.generationc2.web.dto.AutoDTO;
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


	@Override
	public List<Auto> obtenerListaAutos() {
		
		return autoRepository.findAll();
	}

	@Override
	public Auto obtenerAutoMarca(String marca) {
		return autoRepository.findByMarca(marca);
	}


	public void eliminarAuto(Long id) {
		autoRepository.deleteById(id);
		System.out.println("pasando por eliminar auto" + id);
		
	}
	
	public List<AutoDTO> listarAutos() {
		List<Auto> autos = autoRepository.findAll();
		List<AutoDTO> autosDTO = new ArrayList<AutoDTO>();
		for (Auto auto : autos) {
			AutoDTO autoDTO = new AutoDTO();
			autoDTO.setId(auto.getId());
			autoDTO.setColor(auto.getColor());
			autoDTO.setMarca(auto.getMarca());
			autosDTO.add(autoDTO);
			
		}
		return autosDTO;
	}

}
