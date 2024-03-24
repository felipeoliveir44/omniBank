drop procedure if exists spRealizarCompra;
DELIMITER $$

create procedure spRealizarCompra(
    pValor decimal (10,2),
    pDataCompra datetime,
    pCategoria varchar (50),
    pEstabelecimento varchar (100),
    pIdCartao bigint
)

BEGIN -- Início

    declare idCategoria bigint;
    select id into @idCategoria from tbcategoria where nome = pCategoria;


    insert  into tbcompra(valor, data_compra, estabelecimento, categoria, id_cartao, id_categoria) values (pValor, pDataCompra, pEstabelecimento, pCategoria, pIdCartao, @idCategoria);
END $$

DELIMITER ;