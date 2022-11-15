package cl.generationc2.web.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

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
	private String correo;
	
	@NotNull
	private String password;
	
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
