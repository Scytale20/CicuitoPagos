package com.WICO.CircuitoDePagos.service;

import com.WICO.CircuitoDePagos.model.Factura;
import com.WICO.CircuitoDePagos.model.Proveedor;

import java.util.List;

public interface IFacturaService{

    public List<Factura> verFacturas();

    public Factura ingresaFactura(Factura factura);

    public Factura facturaPorId(Long facturaId);

    public List<Factura> facturasPorCuit(String cuit);


}
