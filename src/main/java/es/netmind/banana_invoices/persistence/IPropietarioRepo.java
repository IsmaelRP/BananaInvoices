package es.netmind.banana_invoices.persistence;

import es.netmind.banana_invoices.models.Propietario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPropietarioRepo {
	
    public List<Propietario> findAll();
    public Propietario save(Propietario prop);
}
