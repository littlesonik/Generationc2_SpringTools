package cl.playground.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "casasWesteros")
public class CasaWesteros {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nombre;
	
	@NotNull
	private String territorio;
	
	private String tierras;
	
	@NotNull
	private String emblema;
	
	@NotNull
	private String lema;
	
	public CasaWesteros() {
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

	public String getTerritorio() {
		return territorio;
	}

	public void setTerritorio(String territorio) {
		this.territorio = territorio;
	}

	public String getTierras() {
		return tierras;
	}

	public void setTierras(String tierras) {
		this.tierras = tierras;
	}

	public String getEmblema() {
		return emblema;
	}

	public void setEmblema(String emblema) {
		this.emblema = emblema;
	}

	public String getLema() {
		return lema;
	}

	public void setLema(String lema) {
		this.lema = lema;
	}
	
	
}
