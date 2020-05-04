create sequence if not exists sq_cliente AS integer start 1 increment 1 minvalue 1;

create table if not exists cliente (
	id_cliente integer default nextval('sq_cliente'),
	tx_nome varchar(60) not null,
	tx_email varchar(255) not null,
	tx_telefone varchar(20) not null,
	
	constraint pk_cliente primary key (id_cliente),
	constraint uk_tx_email unique (tx_email)
);

alter sequence sq_cliente owned by cliente.id_cliente;