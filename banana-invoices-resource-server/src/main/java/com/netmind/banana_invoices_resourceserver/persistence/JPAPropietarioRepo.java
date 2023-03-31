package com.netmind.banana_invoices_resourceserver.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.netmind.banana_invoices_resourceserver.model.Propietario;

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

    @Override
    @Transactional
    public Propietario findById(Long id) {
        return em.find(Propietario.class, id);
    }
}
