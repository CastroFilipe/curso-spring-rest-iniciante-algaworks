create sequence if not exists sq_ordemservico AS integer;

create table if not exists ordem_servico(
	id_ordemservico integer default nextval('sq_ordemservico'),
	tx_descricao varchar(255) not null,
	nu_preco money not null,
	dh_abertura timestamp not null,
	dh_finalizacao timestamp,
	en_status varchar(20) not null,
	id_cliente integer not null,
	
	constraint pk_ordemservico primary key (id_ordemservico),
	constraint fk_ordemsevico_cliente foreign key(id_cliente) references cliente(id_cliente)
);

alter sequence sq_ordemservico owned by ordem_servico.id_ordemservico;