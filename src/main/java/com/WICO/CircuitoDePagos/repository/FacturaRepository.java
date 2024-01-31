package com.WICO.CircuitoDePagos.repository;

import com.WICO.CircuitoDePagos.model.Factura;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
    List<Factura> findByProveedor_Cuit(String cuit);
}
