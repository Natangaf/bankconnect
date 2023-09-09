# BankConnect

BankConnect é um sistema de gerenciamento financeiro para empresas e clientes. Ele permite que as empresas gerenciem seus saldos, transações e clientes. Os clientes podem usar o sistema para fazer depósitos e saques, bem como visualizar seus saldos e transações.

## Instalação

Para instalar o BankConnect, você precisará do seguinte:

- Java 19 ou superior
- Maven

Para instalar o Java, siga as instruções no site da Oracle. Para instalar o Maven, siga as instruções no site do Maven.

Para instalar o BankConnect, execute o seguinte comando:

```
mvn install
```

Claro, aqui está o README para o seu projeto em formato Markdown:

Markdown

# BankConnect

BankConnect é um sistema de gerenciamento financeiro para empresas e clientes. Ele permite que as empresas gerenciem seus saldos, transações e clientes. Os clientes podem usar o sistema para fazer depósitos e saques, bem como visualizar seus saldos e transações.

## Uso

Para usar o BankConnect, você precisará criar um banco de dados e configurar o projeto.

Para criar um banco de dados, você pode usar qualquer ferramenta de gerenciamento de banco de dados. Para configurar o projeto, você precisará editar o arquivo application.properties.

Depois de configurar o projeto, você pode iniciar o servidor executando o seguinte comando:

```
mvn spring-boot:run
```

O sistema estará disponível na porta 8080.

## APIs
O BankConnect fornece uma API REST para acessar os dados do sistema. A API é documentada no arquivo api.yaml.

## Exemplos

Aqui estão alguns exemplos de como usar o BankConnect:

Para fazer um depósito, você pode usar a seguinte solicitação HTTP:

## POST /companies/1/clients/2/deposits

```
Content-Type: application/json

{

"value": 100.00

}
```

- Para fazer um saque, você pode usar a seguinte solicitação HTTP:

## POST /companies/1/clients/2/withdrawals
```
Content-Type: application/json

{
"value": 50.00
}
```

- Para visualizar o saldo de um cliente, você pode usar a seguinte solicitação HTTP:

## GET /companies/1/clients/2/balance

## Recursos adicionais

Mais informações sobre o BankConnect estão disponíveis no site do projeto:

https://github.com/Natangaf/bankconnect

Espero que isso ajude!
