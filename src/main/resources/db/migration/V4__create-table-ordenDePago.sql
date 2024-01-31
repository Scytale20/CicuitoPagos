create table ordenes_de_pago(
    id bigint not null auto_increment,
    nombre VARCHAR(255),
    fecha_emision DATE,
    concepto VARCHAR(255),
    tipo_de_pago VARCHAR(255),
    subtotal DOUBLE,
    total DOUBLE,
    numero_de_orden INT,
    proveedor_cuit VARCHAR(20),
    FOREIGN KEY (proveedor_cuit) REFERENCES proveedores(cuit),

    primary key(id)

    );

create table orden_factura(
    orden_id BIGINT,
    factura_id BIGINT,
    PRIMARY KEY (orden_id, factura_id),
    FOREIGN KEY (orden_id) REFERENCES ordenes_de_pago(id),
    FOREIGN KEY (factura_id) REFERENCES Facturas(id)

);