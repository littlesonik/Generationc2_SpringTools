package cl.generationc2.web.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
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
	public Boolean guardarUsuario(Usuario usuario) {
		
		//Validar el usuario (email)
		Usuario retornoUsuario = usuarioRepository.findByCorreo(usuario.getCorreo());
		//System.out.println(retornoUsuario.getCorreo());
		if(retornoUsuario == null) {			
			//1234 --> 1234384347sdh2373
			String passHashed = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
			//Con esto encriptamos o "hasheamos" el password
			usuario.setPassword(passHashed); //reemplazando el valor de password por el hash
			
			usuarioRepository.save(usuario);
			return true;
		}		
		return false;	
	}

	@Override
	public String eliminarUsuario(Long id) {
		Boolean existe = usuarioRepository.existsById(id);
		
		if(existe) {
			//elimino el usuario pasando el id (pk)
			usuarioRepository.deleteById(id);
		}else {
			return "Usuario no existe en la tabla";
		}
		
		existe = usuarioRepository.existsById(id);
		
		//si es distinto de nulo, no fue eliminado
		if(existe) {
			return "Usuario no eliminado";
		}
		return "El usuario fue eliminado";
	}
	//Cuando un usuario es eliminado de la base de datos es un borrado físico
	//por eso la id continúa (es auto incrementable) y no lo inserta nuevamente en el 1, etc.

	@Override
	public String actualizarUsuario(Usuario usuario) {
		
		Boolean existe = usuarioRepository.existsById(usuario.getId());
		
		if(existe) {
			usuarioRepository.save(usuario);
			return "Usuario actualizado";
		}
		return "Usuario creado";
	}

	@Override
	public Usuario obtenerUsuario(Long id) {
		Boolean existe = usuarioRepository.existsById(id);
		if(existe) {
			Usuario user = usuarioRepository.findById(id).get();
			return user;
		}
		return null;
	}

	//listar todos los usuarios
	@Override
	public List<Usuario> obtenerListaUsuarios() {
		// obtener todos los usuarios
		return usuarioRepository.findAll();
	}

	@Override
	public Boolean ingresoUsuario(String email, String password) {
		System.out.println(email +" "+password); //validando que se estén pasando los datos hacia el impl
		Usuario usuario = usuarioRepository.findByCorreo(email);
		if(usuario!= null) {//existe el usuario en BD
			//return BCrypt.checkpw(password, usuario.getPassword()); CAMINO CORTO (clean code)
			
			//comparar contraseñas
			boolean confirmarPwd = BCrypt.checkpw(password, usuario.getPassword());
			
			if(confirmarPwd) {//si confirmarPwd true == el password que ingresa el usuario y el que está en BD son iguales
				return true;
			}else {
				return false;
			}
		}else{//no existe el email en BD
			return false;
		}
	}

	@Override
	public Usuario obtenerUsuarioEmail(String email) {
		
		return usuarioRepository.findByCorreo(email);
	}

}
