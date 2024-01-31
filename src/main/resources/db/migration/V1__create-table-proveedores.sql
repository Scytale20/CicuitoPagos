create table proveedores(

    id bigint not null auto_increment,
    codigo bigint not null,
    razon_social VARCHAR(100) NOT NULL,
    cuit VARCHAR(11) NOT NULL UNIQUE,
    domicilio VARCHAR(100) NOT NULL,
    condicion_IVA VARCHAR (50) NOT NULL,

    primary key(id)
);
