package com.WICO.CircuitoDePagos.service;

import com.WICO.CircuitoDePagos.model.Factura;
import com.WICO.CircuitoDePagos.model.OrdenDePago;
import com.WICO.CircuitoDePagos.model.Proveedor;

import java.util.List;

public interface IOrdenDePagoService {

    List<OrdenDePago> verOrdenesDePago();

    OrdenDePago registrarOrdenDePago(OrdenDePago ordenDePago);

    OrdenDePago ordenDePagPorId(Long ordenDePagopId);

    List<OrdenDePago> ordenesDePagoPorCuit(String cuit);

    Proveedor obtenerProveedorPorCuit(String cuit);

    Factura obtenerFacturaPorId(Long facturaId);
}
