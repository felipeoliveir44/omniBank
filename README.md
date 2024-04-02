# Omnibank 
[![omnicinza.webp](https://i.postimg.cc/bvhBLDBh/omnicinza.webp)](https://postimg.cc/5Xsg20J7)

## 📌 Sobre o projeto

O projeto Omnibank é um sistema de gerenciamento de clientes e cartões de crédito, no qual os gerentes de relacionamento acompanham as compras realizadas pelos clientes para oferecer vantagens de acordo com o perfil e movimentação deles.

## :gear: Funcionalidades 

As funcionalidades desse projeto são:
- Cadastro, listagem, edição e exclusão de clientes
- Cadstro e alteração de limites do cartão
- Cadastro de compras
- Relatórios por gastos de categoria e acompanhamento de clientes (Mais compras realizadas, compras de maior valor e clientes que não realizam compras)

## 💻 Tecnologias
Utilizamos as tecnologias: <br> <br>
![Java](https://img.shields.io/badge/java-%23323330.svg?style=for-the-badge&logo=java)
![Spring](https://img.shields.io/badge/spring-%23323330.svg?style=for-the-badge&logo=spring)
![Postman](https://img.shields.io/badge/postman-%23323330.svg?style=for-the-badge&logo=postman)

# 🔗 Rotas da nossa API

Aqui listamos as principais rotas da nossa API.

| Rota             | Descrição                                          
|----------------------|-----------------------------------------------------
| <kbd>/cliente</kbd>     | Principal rota para realizar o CRUD de clientes
| <kbd>/cartoes</kbd>     | Principal rota para realizar o CRUD de cartões
| <kbd>/compra</kbd>     | Rota para cadastrar uma nova compra
| <kbd>/relatorio</kbd>     | Principal rota para listar os relatorios

### Clientes
 ```
[POST] /cadastrar - Rota para realizar um novo cadastro de um cliente
[GET] /listar - Rota para listar todos os clientes
[GET] /listar/${cpf} - Rota para listar um cliente através do CPF
[PUT] /atualizar - Rota para atualizar os dados do cliente
[DELETE] /desativar/${id} - Rota para realizar a exclusão lógica de um cliente
[PUT] /ativar/${id} - Rota para ativar um cliente 
```
### Cartões
 ```
[POST] /cadastrar - Rota para realizar um novo cadastro de um cartão
[GET] /listar - Rota para listar todos os cartões
[GET] /listar/cpf/${cpf} - Rota para listar um cartão através do CPF
[GET] /listar/numero/${numeroCartao} - Rota para listar um cartão através do número do cartão
[PUT] /atualizarStatus - Rota para atualizar o status de um cartão
[PUT] /atualizarLimite - Rota para atualizar o limite de um cartão
[POST] /visualizarFatura - Rota para listar a fatura de um cartão
```
### Compra
 ```
[POST] /cadastrar - Rota para realizar uma nova compra
```
### Relatórios
 ```
[POST] /gastosCategoria - Rota para listar os gastos por categoria
[GET] /mais-compras - Rota para listar os clientes que possuem mais compras em determinado mês
[POST] /maiorValor - Rota para listar as compras com maior valor
[POST] /semCompras - Rota para listar os clientes que não possuem compras em determinado mês
```





## :rocket: Instalação
Para realizar a instalação e execução do nosso projeto Java com Spring, siga os passos abaixo:

### Pré-requisitos

Antes de prosseguir, certifique-se de ter o Java Development Kit (JDK) e o Apache Maven instalados em sua máquina.

- JDK: Certifique-se de ter o JDK (Java Development Kit) instalado. Você pode verificar a versão do JDK usando o comando java -version no terminal ou prompt de comando.
- Maven: O Apache Maven é uma ferramenta de automação de compilação e gerenciamento de dependências para projetos Java. Certifique-se de tê-lo instalado. Você pode verificar a versão do Maven usando o comando mvn -version no terminal ou prompt de comando.

### Instalação
1. Clone o repositorio
```
https://github.com/felipeoliveir44/omniBank.git
```
2. Navegue até o diretório do projeto clonado:
```
cd project
```
3. Utilize o Maven para compilar o projeto e baixar as dependências necessárias:
```
mvn clean install
```
4. Após concluir o processo de compilação e download das dependências, você pode iniciar o servidor Spring Boot usando o seguinte comando:
```
mvn spring-boot:run
```
## 👤 Autores

Este projeto foi realizado por: 
- [Arthur Florence](https://github.com/arthurflorence)
- [Ingrid Lima](https://github.com/IngridLimaa)
- [Leticia Lima](https://github.com/leticiajlima)
- [Luiz Felipe](https://github.com/felipeoliveir44)
- [Nathalya Lima](https://github.com/Nathalya09)

## Para acessar o front-end do nosso projeto:
[![Omnibank-frontend](https://img.shields.io/badge/Omnibank_frontend-1d1d1d?style=for-the-badge&logo=github&logoColor=fff)](https://github.com/leticiajlima/project)
   
