create table tbcliente (
id bigint auto_increment primary key not null,
nome varchar (255) not null,
cpf char(11) unique not null,
email varchar (255) not null,
telefone char (11) not null
);