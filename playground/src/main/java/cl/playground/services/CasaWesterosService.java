package cl.playground.services;

import java.util.List;

import cl.playground.models.CasaWesteros;

public interface CasaWesterosService {
	
	public CasaWesteros guardarCasa(CasaWesteros casa);
	
	public CasaWesteros obtenerCasa(Long id);
	
	public String actualizarCasa (CasaWesteros casa);
	
	public String eliminarCasa (Long id);
	
	public List<CasaWesteros> ListaCasas();

}
