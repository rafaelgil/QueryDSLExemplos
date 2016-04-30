drop table  cliente if exists;
drop table  produto if exists;
drop table  venda if exists;
drop table  vendaproduto if exists;

create table cliente(
	id int,
	nome varchar(100),
	cpf varchar(11),
	telefone varchar(20),
	constraint pk_cliente primary key (id) 
);

create table produto(
	id int,
	descricao varchar(100),
	constraint pk_produto primary key (id) 
);

create table venda(
	id int,
	lancamento date,
	cliente int,
	constraint pk_venda primary key (id),
	constraint fk_venda_cleinte foreign key (cliente) references cliente (id) 
);

create table vendaproduto(
	id int,
	venda int,
	produto int,
	quantidade DECIMAL(20, 2),
	valor DECIMAL(20, 2),
	constraint pk_vendaproduto primary key (id),
	constraint fk_vendaproduto_venda foreign key (venda) references venda (id),
	constraint fk_vendaproduto_produto foreign key (produto) references produto (id),
);

