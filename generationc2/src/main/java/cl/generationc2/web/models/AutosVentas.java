package cl.generationc2.web.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "autos_ventas")
public class AutosVentas {
	//Tabla relacional para agregar columnas adicionales
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // con esto el ID será autoincrementable
	private Long id;

	private Integer cantidad;
	private Float valorUnitario;
	private Float total; //cantidad * valorUnitario
	
	//Relacion ManyToMany = 2 relaciones ManyToOne
	
	//1 ManyToOne
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="auto_id")
	private Auto auto;
	
	//2 ManyToOne
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="venta_id")
	private Venta venta;
	
	//para la incersion de un registro
	@Column(updatable=false) //una vez insertado el dato, no se puede modificar
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
		
	//para modificar un registro
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;

	public AutosVentas() {
		super();
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
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Float getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public Auto getAuto() {
		return auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	
	
}
