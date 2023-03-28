package es.netmind.banana_invoices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.netmind.banana_invoices.models.Propietario;
import es.netmind.banana_invoices.models.Recibo;
import es.netmind.banana_invoices.persistence.JPAIReciboRepo;
import es.netmind.banana_invoices.persistence.JPAPropietarioRepo;

@RestController
@RequestMapping("/propietarios")
public class PropietarioServiceController {

	@Autowired
	JPAPropietarioRepo repository;
	
	@Autowired
	JPAIReciboRepo reciboRepository;
	

	@PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Propietario> addPropietario(@RequestBody Propietario propietario) {
		repository.save(propietario);
		return new ResponseEntity<Propietario>(propietario, HttpStatus.CREATED);

    }
	
	@GetMapping(value = "/asocia", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Propietario> asociaPropietario(@RequestParam Long idPropietario, @RequestParam Long idRecibo) {
		
		Recibo r = reciboRepository.findById(idRecibo);
		Propietario p = repository.findById(idPropietario);
		r.setPropietario(p);
		
		reciboRepository.save(r);
		return new ResponseEntity<Propietario>(p, HttpStatus.CREATED);

		
    }
	
	
}
