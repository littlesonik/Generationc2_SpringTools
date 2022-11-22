package cl.generationc2.web.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="roles")
@Getter //Crea los getters directamente
@Setter //Crea los setters
@AllArgsConstructor //Crea el constructor con todos los parametros
@NoArgsConstructor //Crea el constructor vacío
@ToString
public class Rol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//con esto el ID será autoincrementable
	private Long id;
	
	private String nombre;
	private String descripcion;
	
	//ManyToMany
	//@JsonIgnore	
	@ManyToMany (mappedBy = "roles", fetch = FetchType.LAZY)
	private List <Usuario> usuarios;
	
	//incersion de un registro
	@Column(updatable=false) //una vez insertado el dato, no se puede modificar
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
		
	//modificar un registro
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
		
	// Atributos de control
	// agregar fecha antes de insertar
	@PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
		 
	// antes de actualizar un dato, agrega la fecha.
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
}
