drop procedure if exists spCadastrarCliente;
DELIMITER $$ 

create procedure spCadastrarCliente(
pnome varchar (255),
pcpf char (11),
pemail varchar (255),
ptelefone varchar (20))

BEGIN -- Início

insert into tbcliente (nome, cpf, email, telefone) values (pnome, pcpf, pemail, ptelefone);
END $$

DELIMITER ;