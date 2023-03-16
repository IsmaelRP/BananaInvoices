package es.netmind.banana_invoices.dto;

import java.util.Date;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class PropietarioDTO {
	
	private Long pid;
    private String nombre;
    private String email;
    private String telefono;
    private int seccion;
    
}
