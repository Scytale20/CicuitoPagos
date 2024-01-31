package com.WICO.CircuitoDePagos.controller;

import com.WICO.CircuitoDePagos.model.Factura;
import com.WICO.CircuitoDePagos.model.OrdenDePago;
import com.WICO.CircuitoDePagos.model.Proveedor;
import com.WICO.CircuitoDePagos.service.FacturaService;
import com.WICO.CircuitoDePagos.service.OrdenesDePagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/op")
public class OrdenDePagoController {

    @Autowired
    OrdenesDePagoService OpService;

    @GetMapping
    public List<OrdenDePago> listadoOrdenesDePago(){
        return OpService.verOrdenesDePago();
    }

    @GetMapping("/{opId}")
    public ResponseEntity<OrdenDePago> OrdenesDePagoPorId(@PathVariable Long ordenDePagoId){
        OrdenDePago ordenDePago =  OpService.ordenDePagPorId(ordenDePagoId);


        return ordenDePago != null
                ? ResponseEntity.ok(ordenDePago)
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/opcuit/{cuit}")
    public ResponseEntity<List<OrdenDePago>> ordenesDePagoPorCuit(@PathVariable String cuit){
        List<OrdenDePago> ordenDePago =  OpService.ordenesDePagoPorCuit(cuit);


        return !ordenDePago.isEmpty()
                ? ResponseEntity.ok(ordenDePago)
                : ResponseEntity.notFound().build();
    }

    @PostMapping("/registrarOP")
    public ResponseEntity<OrdenDePago> registrarOrdenDePago(@RequestBody OrdenDePago ordenDePago){

        // Obtener el proveedor por CUIT desde el cuerpo del JSON
        String cuit = ordenDePago.getProveedor().getCuit();
        Proveedor proveedor = OpService.obtenerProveedorPorCuit(cuit);

        // Validar si el proveedor existe
        if (proveedor == null) {
            return ResponseEntity.notFound().build();
        }

        // Asociar el proveedor a la OP
        ordenDePago.setProveedor(proveedor);

        // Asociar la factura a la OP desde el cuerpo del JSON
        if (ordenDePago.getFacturas() != null && !ordenDePago.getFacturas().isEmpty()) {
            Long facturaId = ordenDePago.getFacturas().get(0).getId();
            Factura factura = OpService.obtenerFacturaPorId(facturaId);

            // Validar si la factura existe
            if (factura == null) {
                return ResponseEntity.notFound().build();
            }

            ordenDePago.getFacturas().clear(); // Limpiar facturas existentes
            ordenDePago.getFacturas().add(factura);
        }

        // Registrar la OP
        OrdenDePago nuevaOrdenDePago = OpService.registrarOrdenDePago(ordenDePago);
        return ResponseEntity.ok(nuevaOrdenDePago);
    }

}
