package cl.generationc2.web.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import cl.generationc2.web.models.Usuario;
import cl.generationc2.web.models.Venta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AutoDTO {
	
	private Long id;
	private String marca;
	private String color;
	private String nombreUsuario;
	private String apellidoUsuario;
}
