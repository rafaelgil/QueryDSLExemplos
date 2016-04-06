insert into cliente (id, nome, cpf, telefone) values (1, 'Joao',  '88478954715', '4499981212');
insert into cliente (id, nome, cpf, telefone) values (2, 'Maria', '87412547154', '4499664488');
insert into cliente (id, nome, cpf, telefone) values (3, 'Pedro', '84848487877', '4499881245');
insert into cliente (id, nome, cpf, telefone) values (4, 'Jose',  '35345654654', '4499753214');
insert into cliente (id, nome, cpf, telefone) values (5, 'Ana',   '88784842258', '4499656867');
insert into cliente (id, nome, cpf, telefone) values (6, 'Ana Maria', '87425836514', '4466774411');

insert into produto (id, descricao) values (1, 'Notebook Acer');
insert into produto (id, descricao) values (2, 'HD externo 1TB');
insert into produto (id, descricao) values (3, 'Smartphone Samsung Galaxy S7');
insert into produto (id, descricao) values (4, 'Smartphone Motorola Moto X');
insert into produto (id, descricao) values (5, 'Smart TV LED Ultra HD 48 4K Samsung');
insert into produto (id, descricao) values (6, 'Smart TV LED Ultra HD 50 4K Philips');
insert into produto (id, descricao) values (7, 'Bicicleta Mountain Bike Ozark');
insert into produto (id, descricao) values (8, 'Liquidificador Power Black 2 velocidades L-28 - Mondial');
insert into produto (id, descricao) values (9, 'Purificador de Agua IBBL Mio Branco');

insert into venda (id, lancamento, cliente) values (1, '2016-01-20', 1);
insert into vendaproduto (id, venda, produto, quantidade, valor) values (1, 1, 9, 3, 215.25);
insert into vendaproduto (id, venda, produto, quantidade, valor) values (2, 1, 2, 1, 369.57);
insert into vendaproduto (id, venda, produto, quantidade, valor) values (3, 1, 7, 1, 1500.00);

insert into venda (id, lancamento, cliente) values (2, '2016-01-25', 4);
insert into vendaproduto (id, venda, produto, quantidade, valor) values (4, 2, 3, 1, 3999.99);

insert into venda (id, lancamento, cliente) values (3, '2016-01-25', 5);
insert into vendaproduto (id, venda, produto, quantidade, valor) values (5, 3, 4, 1, 1499.99);
insert into vendaproduto (id, venda, produto, quantidade, valor) values (6, 3, 1, 1, 3357.48);
