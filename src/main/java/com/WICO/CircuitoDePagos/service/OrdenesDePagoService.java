package com.WICO.CircuitoDePagos.service;


import com.WICO.CircuitoDePagos.model.Factura;
import com.WICO.CircuitoDePagos.model.OrdenDePago;
import com.WICO.CircuitoDePagos.model.Proveedor;
import com.WICO.CircuitoDePagos.repository.FacturaRepository;
import com.WICO.CircuitoDePagos.repository.OrdenDePagoRepository;
import com.WICO.CircuitoDePagos.repository.ProveedorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenesDePagoService implements IOrdenDePagoService{

    @Autowired
    OrdenDePagoRepository OpRepo;
    @Autowired
    ProveedorRepository proveRepo;
    @Autowired
    FacturaRepository factRepo;


    @Override
    public List<OrdenDePago> verOrdenesDePago() {
        return OpRepo.findAll();
    }

    @Override
    public OrdenDePago registrarOrdenDePago(OrdenDePago ordenDePago) {
        return OpRepo.save(ordenDePago);
    }

    @Override
    public OrdenDePago ordenDePagPorId(Long ordenDePagopId) {
        Optional<OrdenDePago> OpOptional = OpRepo.findById(ordenDePagopId);
        if(OpOptional.isPresent()){
            OrdenDePago ordenDePago = OpOptional.get();
            Proveedor proveedor = ordenDePago.getProveedor();
            return ordenDePago;
        }else{
            throw new EntityNotFoundException("Factura no encontrada con id" + ordenDePagopId);
        }
    }

    @Override
    public List<OrdenDePago> ordenesDePagoPorCuit(String cuit) {
        return OpRepo.findByProveedor_Cuit(cuit);
    }

    @Override
    public Proveedor obtenerProveedorPorCuit(String cuit) {
        return proveRepo.findByCuit(cuit);
    }

    @Override
    public Factura obtenerFacturaPorId(Long facturaId) {
        Optional<Factura> facturaOptional = factRepo.findById(facturaId);
        if(facturaOptional.isPresent()){
            Factura factura = facturaOptional.get();
            Proveedor proveedor = factura.getProveedor();
            return factura;
        }else{
            throw new EntityNotFoundException("Factura no encontrada con id" + facturaId);
        }
    }
}
