package com.WICO.CircuitoDePagos.service;

import com.WICO.CircuitoDePagos.model.Proveedor;

import java.util.List;

public interface IProveedorService {

    public List<Proveedor> verProveedor();

    public Proveedor crearProveedor(Proveedor proveedor);

    public Proveedor proveedorPorCuit(String cuit);
}
