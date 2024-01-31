package com.WICO.CircuitoDePagos.repository;

import com.WICO.CircuitoDePagos.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
    Proveedor findByCuit(String cuit);
}
