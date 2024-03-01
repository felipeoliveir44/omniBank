DELIMITER $$ 

create procedure spListarClientes()

BEGIN -- Início

select * from tbclientes;

END $$

DELIMITER ;