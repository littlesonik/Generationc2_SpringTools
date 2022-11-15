package cl.generationc2.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.generationc2.web.models.Usuario;
import cl.generationc2.web.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	//En esta clase ocurre toda la lógica de negocio del sistema web
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		
		return usuarioRepository.save(usuario);
		
	}

}
