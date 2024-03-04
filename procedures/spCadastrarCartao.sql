drop procedure if exists spCadastrarCartao;
DELIMITER $$ 

create procedure spCadastrarCartao(
    pidCliente int,
    plimite decimal (10,2)
)

BEGIN -- Início
    DECLARE numeroCartao VARCHAR(16);
    declare cvvCartao char(3);
    DECLARE validadeCartao VARCHAR(7);
    
    
    -- Gerar número de cartão aleatório
    SET numeroCartao = SET v_numero_cartao = LPAD(FLOOR(CAST(RAND() * 9999999999999999 AS UNSIGNED)), 16, '0');

    SET cvvCartao = LPAD(FLOOR(RAND() * 999), 3, '0');
    
    -- Calcular validade do cartão (4 anos e 6 meses à frente)
    SET validadeCartao = DATE_FORMAT(DATE_ADD(DATE_ADD(NOW(), INTERVAL 4 YEAR), INTERVAL 6 MONTH), '%m/%Y');

insert into tbcartao (numero, validade, cvv, limite, statusCartao, id_cliente) values (numeroCartao, validadeCartao, cvvCartao, plimite, 'Ativo', pidCliente);
END $$

DELIMITER ;