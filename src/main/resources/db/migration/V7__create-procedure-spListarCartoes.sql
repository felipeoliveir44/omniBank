drop procedure if exists spListarCartoes;
DELIMITER $$

create procedure spListarCartoes(
)

BEGIN -- Início

    SELECT
        c.numero AS Numero,
        cl.nome AS Cliente,
        c.limite AS Limite,
        c.validade as Validade
    FROM tbcartao c
    INNER JOIN tbcliente cl ON c.id_cliente = cl.id;

END $$

DELIMITER ;