package com.WICO.CircuitoDePagos.controller;

import com.WICO.CircuitoDePagos.model.Proveedor;
import com.WICO.CircuitoDePagos.service.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedores")
public class ProveedoresController {

    @Autowired
    private IProveedorService provService;

    @GetMapping
    public List<Proveedor> listadoProveedores(){
        return provService.verProveedor();
    }

    @PostMapping
    public Proveedor registrarProveedor(@RequestBody Proveedor proveedor){
        return provService.crearProveedor(proveedor);
    }
    @GetMapping("/porcuit/{cuit}")
    public ResponseEntity<Proveedor> proveedorPorCuit(@PathVariable String cuit){
        Proveedor proveedor = provService.proveedorPorCuit(cuit);

        return proveedor != null
                ? ResponseEntity.ok(proveedor)
                :ResponseEntity.notFound().build();
    }


}
