package cl.playground.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.playground.models.CasaWesteros;
import cl.playground.repositories.CasaWesterosRepository;

@Service
public class CasaWesterosServiceImpl implements CasaWesterosService{

	@Autowired
	CasaWesterosRepository casaWRepository;
	
	@Override
	public CasaWesteros guardarCasa(CasaWesteros casa) {
		return casaWRepository.save(casa);
	}

	@Override
	public CasaWesteros obtenerCasa(Long id) {
		Boolean existe = casaWRepository.existsById(id);
		if(existe) {
			CasaWesteros casa = casaWRepository.findById(id).get();
			return casa;
		}
		return null;
	}

	@Override
	public List<CasaWesteros> ListaCasas() {
		return casaWRepository.findAll();
	}

	@Override
	public String actualizarCasa(CasaWesteros casa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminarCasa(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
