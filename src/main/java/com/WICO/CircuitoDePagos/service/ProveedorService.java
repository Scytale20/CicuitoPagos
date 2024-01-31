package com.WICO.CircuitoDePagos.service;

import com.WICO.CircuitoDePagos.model.Proveedor;
import com.WICO.CircuitoDePagos.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService implements IProveedorService {

    @Autowired
    ProveedorRepository provRepo;

    @Override
    public List<Proveedor> verProveedor() {
        return provRepo.findAll();
    }

    @Override
    public Proveedor crearProveedor(Proveedor proveedor) {
        return provRepo.save(proveedor);
    }

    @Override
    public Proveedor proveedorPorCuit(String cuit) {
        return provRepo.findByCuit(cuit);
    }
}
