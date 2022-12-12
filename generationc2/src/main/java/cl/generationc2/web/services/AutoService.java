package cl.generationc2.web.services;

import java.util.List;

import cl.generationc2.web.models.Auto;

public interface AutoService {
	
	public Auto guardarAuto(Auto auto);
	public Auto obtenerAuto(Long id);
	public List<Auto> obtenerListaAutos();
	public Auto obtenerAutoMarca(String marca);
}
