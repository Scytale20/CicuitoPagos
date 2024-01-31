package com.WICO.CircuitoDePagos.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "ordenes_de_pago")
@Entity(name = "OrdenDePago")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrdenDePago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private LocalDate fechaEmision;
    private String concepto;
    private String tipoDePago;
    private Double subtotal;
    private Double total;
    private Integer numeroDeOrden;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "proveedor_cuit", referencedColumnName = "cuit")
    private Proveedor proveedor;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="orden_factura",
            joinColumns = @JoinColumn(name = "orden_id"),
            inverseJoinColumns = @JoinColumn(name = "factura_id")
    )
    private List<Factura> facturas = new ArrayList<>();


    public void setProveedor(Proveedor proveedor){
        this.proveedor = proveedor;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }


}
