package com.WICO.CircuitoDePagos.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "facturas")
@Entity(name = "Factura")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Date fechaEmision;
    private Date fechaVencimiento;
    private String concepto;
    private Double cantidad;
    private String unidadMedida;
    private Double precioUnitario;
    private Double subtotal;
    private Double alicuotaIva;
    private Double totalFactura;
    private String numeroFactura;
    private String letraFactura;

    @ManyToOne
    @JoinColumn(name = "proveedor_cuit", referencedColumnName = "cuit")
    private Proveedor proveedor;

    @ManyToMany(mappedBy = "facturas", fetch = FetchType.LAZY)
    private List<OrdenDePago> ordenesDePago = new ArrayList<>();

}
