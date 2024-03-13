create table tbcartao (

id bigint auto_increment primary key not null,
numero char(16) unique not null,
validade varchar(7) not null,
cvv char(3) not null,
limite DECIMAL(10, 2) not null,
statusCartao tinyint not null,
id_cliente bigint not null,
FOREIGN KEY (id_cliente) REFERENCES tbcliente(id)
);