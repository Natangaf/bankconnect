INSERT INTO "company" ("cnpj", "name", "address", "telephone", "deposit_fee","withdrawal_fee", "balance")
VALUES ('12345678901234', 'Empresa A', 'Rua Principal, 123', '9876543210', 0.05,0.5, 10000.00);

INSERT INTO "client" ("cpf", "name", "address", "telephone","account_value", "company_user_id")
VALUES
    (12312312301, 'alex', 'rua 1', 11944444444,100.2, 1),
    (12312312302, 'natan', 'rua 2', 11944444442,2000, 1);
