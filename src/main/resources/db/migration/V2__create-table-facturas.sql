
CREATE TABLE facturas (
    id bigint AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    fecha_emision DATE,
    fecha_vencimiento DATE,
    concepto VARCHAR(255),
    cantidad DOUBLE,
    unidad_medida VARCHAR(50),
    precio_unitario DOUBLE,
    subtotal DOUBLE,
    alicuota_iva DOUBLE,
    total_factura DOUBLE,
    numero_factura DOUBLE,
    letra_factura VARCHAR(1),
    proveedor_cuit VARCHAR(20),
    FOREIGN KEY (proveedor_cuit) REFERENCES proveedores(cuit)
);
