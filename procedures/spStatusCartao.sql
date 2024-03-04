drop procedure if exists spStatusCartao;
DELIMITER $$  

create procedure spStatusCartao(
    pidCliente int,
    pidCartao int,
    pstatus varchar (9)
)

BEGIN -- Início

IF (pstatus != 'Ativo' ) THEN
-- Instruções TSQL
    update tbcartao c inner join tbcliente cl ON c.id_cliente = cl.id set statusCartao = 'Cancelado'  where c.id_cliente = pidCliente and c.id = pidCartao;
ELSE
 update tbcartao c inner join tbcliente cl ON c.id_cliente = cl.id set statusCartao = 'Ativo'  where c.id_cliente = pidCliente and c.id = pidCartao;
END IF;

END $$

DELIMITER ;

