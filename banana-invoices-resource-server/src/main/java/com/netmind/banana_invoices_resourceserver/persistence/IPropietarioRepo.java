package com.netmind.banana_invoices_resourceserver.persistence;

import java.util.List;

import com.netmind.banana_invoices_resourceserver.model.Propietario;

public interface IPropietarioRepo {
    public List<Propietario> findAll();
    public Propietario save(Propietario prop);
    Propietario findById(Long propId);
}
