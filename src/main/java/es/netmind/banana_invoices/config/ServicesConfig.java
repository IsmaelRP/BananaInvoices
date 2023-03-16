package es.netmind.banana_invoices.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.netmind.banana_invoices.persistence.IPropietarioRepo;
import es.netmind.banana_invoices.services.IInventario;
import es.netmind.banana_invoices.services.InventarioImpl;

@Configuration
public class ServicesConfig {

	@Autowired
	IPropietarioRepo propietarioRepo;
	
	@Bean
	public IInventario getInventario() {
		InventarioImpl inventario = new InventarioImpl();
		inventario.setPropietariosRepo(propietarioRepo);
		return inventario;
	}


}
