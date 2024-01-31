package com.WICO.CircuitoDePagos.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name="proveedores")
@Entity(name="Proveedor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long codigo;
    private String razonSocial;
    private String cuit;
    private String domicilio;
    private String condicionIva;

    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Factura> factura = new ArrayList<>();

    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<OrdenDePago> ordenesDePago = new ArrayList<>();

}
