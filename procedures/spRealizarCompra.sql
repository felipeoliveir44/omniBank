drop procedure if exists spRealizarCompra;
DELIMITER $$  

create procedure spRealizarCompra(
    pCartao varchar (16),
    pValor decimal (10,2),
    pCategoria varchar (50),
    pEstabelecimento varchar (100)
)

BEGIN -- Início
	declare idCartao bigint;
	declare idCategoria bigint;
	insert into tbcategoria(nome) values (pCategoria);


	select id into @idCartao from tbcartao where numero = pCartao;
	select id into @idCategoria from tbcategoria where nome = pCategoria;


    

    insert  into tbcompra(valor, dataCompra, estabelecimento, categoria, id_cartao, id_categoria) values (pValor, now(), pEstabelecimento, pCategoria, @idCartao, @idCategoria);
END $$

DELIMITER ;
