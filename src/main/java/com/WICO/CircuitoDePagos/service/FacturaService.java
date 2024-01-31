package com.WICO.CircuitoDePagos.service;

import com.WICO.CircuitoDePagos.model.Factura;
import com.WICO.CircuitoDePagos.model.Proveedor;
import com.WICO.CircuitoDePagos.repository.FacturaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaService implements IFacturaService{

    @Autowired
    FacturaRepository factRepo;
    @Override
    public List<Factura> verFacturas() {
        return factRepo.findAll();
    }

    @Override
    public Factura ingresaFactura(Factura factura) {
        return factRepo.save(factura);
    }

    @Override
    public Factura facturaPorId(Long facturaId) {
        Optional<Factura> facturaOptional = factRepo.findById(facturaId);
        if(facturaOptional.isPresent()){
            Factura factura = facturaOptional.get();
            Proveedor proveedor = factura.getProveedor();
            return factura;
        }else{
            throw new EntityNotFoundException("Factura no encontrada con id" + facturaId);
        }
    }

    @Override
    public List<Factura> facturasPorCuit(String cuit) {
        return factRepo.findByProveedor_Cuit(cuit);
    }
}
