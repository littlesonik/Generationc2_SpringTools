package cl.generationc2.web.services;

import cl.generationc2.web.models.Auto;

public interface AutoService {
	
	public Auto guardarAuto(Auto auto);
	
	public Auto obtenerAuto (Long id);

}
