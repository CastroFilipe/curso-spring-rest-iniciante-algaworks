create sequence if not exists seq_comentario as integer;

create table if not exists comentario (
	id_comentario integer default nextval('seq_comentario'),
	tx_descricao text not null,
	dh_envio timestamp not null,
	id_ordemservico integer not null,
	
	constraint pk_comentario primary key (id_comentario),
	constraint fk_comentario_ordemservico foreign key(id_ordemservico) references ordem_servico(id_ordemservico)
);

alter sequence seq_comentario owned by comentario.id_comentario;