package cl.generationc2.web.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//con esto el ID será autoincrementable
	private Long id; //bigint
	
	@NotNull
	@Size(min=3, max=15, message= "Error en el ingreso de datos") //tamaño min y max que debiera tener ese atributo
	private String nombre;
	
	@NotNull
	@Size(min=3, max=15, message= "Error en el ingreso de datos") //tamaño min y max que debiera tener ese atributo
	private String apellido;
	
	@NotNull
	private String correo;
	
	@NotNull
	private String password;
	
	
	@JsonIgnore //permite eliminar el error de la recursividad
	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	//Relación OneToOne
	//CascadeType.ALL: si elimino un usuario, se debe borrar la relación con auto y la informacion de auto asociada al usuario.
	//Fetchtype.LAZY: si busco informacion del usuario, me traerá SOLO la referencia del auto, pero no su informacion.
	private Auto auto;
	
	//Relacion OneToMany (un Usuario tiene muchas direcciones)
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Direccion> direcciones;
	
	//ManyToMany
	@JsonIgnore	
	@ManyToMany (fetch = FetchType.EAGER)
	@JoinTable(
			name="roles_usuarios", //nombre de la tabla relacional que se va a crear
			joinColumns = @JoinColumn(name = "usuario_id"), //BUENA PRACTICA, agregar primera columna con el nombre del objeto en el que la creas
			inverseJoinColumns = @JoinColumn(name = "rol_id")
			)
		private List<Rol> roles;
	/*select *
	from roles_usuarios
	inner join roles on roles.id = roles_usuarios.roles_id --> esta query sería el JOINCOLUMNS
	inner join usuario on usuario.id= roles_usuarios.usuario_id --> esta query sería el INVERSEJOINCOLUMNS
	*/
	
	@Transient //Para que esta columna no sea considerada en la creacion de la tabla
	private String password2;
	private String nick;
	
	@Range(min=40, max= 300, message= "Peso fuera de rango")
	private Float peso;
	
	//para la incersion de un registro
	@Column(updatable=false) //una vez insertado el dato, no se puede modificar
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	//para modificar un registro
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	public Usuario() {
		super();
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Auto getAuto() {
		return auto;
	}


	public void setAuto(Auto auto) {
		this.auto = auto;
	}


	public List<Direccion> getDirecciones() {
		return direcciones;
	}


	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}


	public List<Rol> getRoles() {
		return roles;
	}


	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}


	public String getPassword2() {
		return password2;
	}


	public void setPassword2(String password2) {
		this.password2 = password2;
	}


	public String getNick() {
		return nick;
	}


	public void setNick(String nick) {
		this.nick = nick;
	}


	public Float getPeso() {
		return peso;
	}


	public void setPeso(Float peso) {
		this.peso = peso;
	}


	// Atributos de control
	// agregar la fecha antes de insertar
	 @PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	 
	 // antes de actualizar un dato, le agrega la fecha.
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }

}
