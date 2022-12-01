package cl.generationc2.web.services;

import java.util.List;

import cl.generationc2.web.models.Usuario;

public interface UsuarioService {
	//Definir metodos para el CRUD del usuario
	public Boolean guardarUsuario(Usuario usuario);
	//Este metodo va a recibir un Usuario
	
	public String eliminarUsuario(Long id);
	
	public String actualizarUsuario(Usuario usuario);
	
	public Usuario obtenerUsuario(Long id);
	
	//listar todos los usuarios
	public List<Usuario> obtenerListaUsuarios();
	
	//login
	public Boolean ingresoUsuario(String email, String password);
}
