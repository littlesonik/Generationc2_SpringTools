package cl.yose.web.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "imagenes")
public class Imagen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String ruta;
	

	// --------------------------------------------------------
	// REGISTRO Y MODIFICACION DE FECHAS
	// para la incersion de un registro
	@Column(updatable = false) // una vez insertado el dato, no se puede modificar
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	// para modificar un registro
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	public Imagen() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getRuta() {
		return ruta;
	}


	public void setRuta(String ruta) {
		this.ruta = ruta;
	}


	// Atributos de control
	// agregar la fecha antes de insertar
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	// antes de actualizar un dato, le agrega la fecha.
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}
