create database omnibank;

use omnibank;

create table tbclientes(
id bigint PRIMARY KEY auto_increment, nome varchar (255), 
cpf char(11),
email varchar (255),
telefone varchar (20));

CREATE TABLE tbcartao (
numero CHAR(16) primary key,
validade DATE,
cvv CHAR(3),
limite DECIMAL(10, 2),
status ENUM('ATIVO', 'CANCELADO'));
    
create table tbcompra (
valor DECIMAL(10, 2),
dataCompra date,
estabelecimento varchar (255),
categoria varchar (255));

