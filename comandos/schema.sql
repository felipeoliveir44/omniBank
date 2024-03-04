create database omnibank;

use omnibank;

create table tbcliente (
id int auto_increment primary key,
nome varchar (255),
cpf char(11) unique,
email varchar (255),
telefone char (11)
);

create table tbcartao (
id int auto_increment primary key,
numero char(16) unique,
validade varchar(7),
cvv char(3),
limite DECIMAL(10, 2),
statusCartao varchar (9),
id_cliente int,
FOREIGN KEY (id_cliente) REFERENCES tbcliente(id)
);

CREATE TABLE tbcategoria (
    id INT PRIMARY KEY,
    nome VARCHAR(50)
);

CREATE TABLE tbcompra (
    ID INT PRIMARY KEY,
    valor DECIMAL(10, 2),
    dataCompra DATETIME,
    estabelecimento VARCHAR(100),
    categoria VARCHAR(50),
    id_cartao int,
    id_categoria INT,
    FOREIGN KEY (id_cartao) REFERENCES tbcartao(id),
    FOREIGN KEY (id_categoria) REFERENCES tbcategoria(id)
);

