package com.netmind.banana_invoices_resourceserver.persistence;

import java.util.List;

import com.netmind.banana_invoices_resourceserver.model.Recibo;

public interface IReciboRepo {
    public List<Recibo> findAll();

    public Recibo save(Recibo recibo);

    Recibo findById(Long id);
}
