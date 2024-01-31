package com.WICO.CircuitoDePagos.repository;

import com.WICO.CircuitoDePagos.model.Factura;
import com.WICO.CircuitoDePagos.model.OrdenDePago;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdenDePagoRepository extends JpaRepository<OrdenDePago, Long> {
    List<OrdenDePago> findByProveedor_Cuit(String cuit);
}
