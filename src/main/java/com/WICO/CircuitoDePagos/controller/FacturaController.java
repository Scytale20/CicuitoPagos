package com.WICO.CircuitoDePagos.controller;

import com.WICO.CircuitoDePagos.model.Factura;
import com.WICO.CircuitoDePagos.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facturas")
public class FacturaController {

    @Autowired
    FacturaService factService;

    @GetMapping
    public List<Factura> listadoFacturas(){
        return factService.verFacturas();
    }

    @GetMapping("/{facturaId}")
    public ResponseEntity<Factura> facturasPorId(@PathVariable Long facturaId){
        Factura factura =  factService.facturaPorId(facturaId);


        return factura != null
                ? ResponseEntity.ok(factura)
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/cuit/{cuit}")
    public ResponseEntity<List<Factura>> facturaPorCuit(@PathVariable String cuit){
        List<Factura> factura =  factService.facturasPorCuit(cuit);


        return !factura.isEmpty()
                ? ResponseEntity.ok(factura)
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Factura registrarFactura(@RequestBody Factura factura){
        return factService.ingresaFactura(factura);
    }

}
