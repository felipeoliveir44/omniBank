drop procedure if exists spListarClientes;
DELIMITER $$
CREATE PROCEDURE spListarClientes()
BEGIN
    SELECT * FROM tbcliente;

END $$
DELIMITER ;