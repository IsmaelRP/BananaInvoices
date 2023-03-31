package com.netmind.banana_invoices_resourceserver.model;

import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
@ToString(exclude = "recibos")
@Entity
@Table(name = "propietario")
public class Propietario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;
    @Column
    @NonNull
    private String nombre;
    @Column
    @NonNull
    private String email;
    @Column
    @NonNull
    private String telefono;
    @Column
    @NonNull
    private int seccion;

    @OneToMany(mappedBy = "propietario", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Recibo> recibos;
}
