
CREATE TABLE tbcompra (

    id bigint PRIMARY KEY auto_increment not null,
    valor DECIMAL(10, 2) not null,
    data_compra DATETIME not null,
    estabelecimento VARCHAR(100) not null,
    categoria VARCHAR(50) not null,
    id_cartao bigint not null,
    id_categoria bigint not null,
    FOREIGN KEY (id_cartao) REFERENCES tbcartao(id),
    FOREIGN KEY (id_categoria) REFERENCES tbcategoria(id)
);