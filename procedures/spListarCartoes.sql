drop procedure if exists spListarCartoes;
DELIMITER $$  

create procedure spListarCartoes(
    pcpf varchar (255)
)

BEGIN -- Início

if (pcpf != '') then 
SELECT
        c.numero AS Numero,
        cl.nome AS Cliente,
        c.limite AS Limite,
        c.validade as Validade
    FROM tbcartao c
    INNER JOIN tbcliente cl ON c.id_cliente = cl.id WHERE cl.cpf = pcpf;

else 
    SELECT
        c.numero AS Numero,
        cl.nome AS Cliente,
        c.limite AS Limite,
        c.validade as Validade
    FROM tbcartao c
    INNER JOIN tbcliente cl ON c.id_cliente = cl.id;
    end if;

END $$

DELIMITER ;