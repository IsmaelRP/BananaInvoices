package es.netmind.banana_invoices.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recibo")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Recibo {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column
    private Long propietario;
	
	@Column
    private Date fecha_emision;
	
	@Column
    private Date fecha_vencimiento;
	
	@Column
    private String nombre_contacto;
	
	@Column
    private String direccion_contacto;
	
	@Column
    private String direccion_envio;
	
	@Column
    private String nombre_producto;
	
	@Column
    private int cantidad;
	
	@Column
    private float precio_unitario;
	
	@Column
    private double base_imponible;
	
	@Column
    private float impuestos;
	
	@Column
    private double total;
	
	@Column
    private boolean estado;
	
	@Column
    private boolean valido;

}
