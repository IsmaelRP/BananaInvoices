package com.netmind.banana_invoices_resourceserver.controller;

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

import com.netmind.banana_invoices_resourceserver.model.Propietario;
import com.netmind.banana_invoices_resourceserver.model.Recibo;
import com.netmind.banana_invoices_resourceserver.persistence.JPAIReciboRepo;
import com.netmind.banana_invoices_resourceserver.persistence.JPAPropietarioRepo;

@RestController
@RequestMapping("/propietarios")
public class PropietarioServerController {

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
	public ResponseEntity<Propietario> asociaPropietario(@RequestParam Long idPropietario,
			@RequestParam Long idRecibo) {

		Recibo r = reciboRepository.findById(idRecibo);
		Propietario p = repository.findById(idPropietario);
		r.setPropietario(p);

		reciboRepository.save(r);
		return new ResponseEntity<Propietario>(p, HttpStatus.CREATED);

	}
}