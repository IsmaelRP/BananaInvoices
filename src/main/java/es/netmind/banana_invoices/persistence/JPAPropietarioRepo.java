package es.netmind.banana_invoices.persistence;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import es.netmind.banana_invoices.models.Propietario;

public class JPAPropietarioRepo implements IPropietarioRepo {
    
	@PersistenceContext
    private EntityManager em;

    @Override
    public List<Propietario> findAll() {
        Query query = em.createQuery("SELECT e FROM Propietario e");
        return (List<Propietario>) query.getResultList();
    }

    @Override
    @Transactional
    public Propietario save(Propietario prop) {
        em.persist(prop);
        return prop;
    }
	
}
