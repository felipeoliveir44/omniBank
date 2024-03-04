drop procedure if exists spListarClientes;
DELIMITER $$ 

create procedure spListarClientes(
    pnome varchar (255)
)

BEGIN -- Início

IF (pnome != '' ) THEN
-- Instruções TSQL
 SELECT * from tbcliente where nome LIKE CONCAT('%',
pnome , '%');
ELSE
 SELECT * from tbcliente;
END IF;

END $$

DELIMITER ;