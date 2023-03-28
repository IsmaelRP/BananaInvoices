package es.netmind.banana_invoices.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import es.netmind.banana_invoices.models.Recibo;
import es.netmind.banana_invoices.models.User;
import es.netmind.banana_invoices.persistence.JPAIReciboRepo;

@RestController
@RequestMapping("/recibos")
public class ReciboServiceController {
	
	@Autowired
	JPAIReciboRepo repository;
	
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Recibo>> getAllRecibos() {
        List<Recibo> recibos = repository.findAll();
        return new ResponseEntity<>(recibos, HttpStatus.OK);
    }
	
	@PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Recibo> addRecibo(@RequestBody Recibo recibo) {
		
		//if (repository.findById(recibo.getId()) == null) {
			repository.save(recibo);
			return new ResponseEntity<Recibo>(recibo, HttpStatus.CREATED);
		//}

    }
	
	

}




