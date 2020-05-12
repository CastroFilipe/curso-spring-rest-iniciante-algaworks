--Criação da tabela Cliente
--id_cliente é do subtipo SERIAL. Usar SERIAL fará o sgbd criar uma coluna com incremento automatico.
--Internamente, ao utilizar o subtipo SERIAL, o postgres criará o id do tipo Integer e atribuirá 
--uma SEQUENCE para esse atributo. A instrução not null no atributo id_cliente é opcional pois 
--a mesma já é definida com a declaração PRIMARY KEY (id_cliente). 

--A instrução primary key constraints define que a coluna id_cliente é a chave primaria, criando assim um 
--index para a coluna. Ela é a combinação de uma constraint NOT NULL e constraint UNIQUE.
--
--Ainda temos uk_tx_email como sendo o nome dado a constraint UNIQUE para a coluna tx_email.

--create table cliente if not exists (
--	id_cliente serial not null,
--	tx_nome varchar(60) not null,
--	tx_email varchar(255) not null,
--	tx_telefone varchar(20) not null,
--	
--	constraint pk_cliente primary key (id_cliente),
--	constraint uk_tx_email unique (tx_email)
--);
--
--create table ordem_servico if not exists(
--	id_ordemservico int,
--	tx_descricao varchar(255) not null,
--	nu_preco money not null,
--	dh_abertura timestamp not null,
--	dh_finalizacao timestamp,
--	en_status varchar(20) not null,
--	id_cliente integer not null,
--	
--	constraint pk_ordemservico primary key (id_ordemservico),
--	constraint fk_ordemsevico_cliente foreign key(id_cliente) references cliente(id_cliente)
--);

--Por utilizar o SERIAL uma sequence será criada, de forma automatica, pelo sgbd. 
--Essa sequence é criada com um nome padrão, cujo nome não consegui redefinir no momento de
--criação das tabelas. Só consegui mudar o nome da sequence com o comando ALTER SEQUENCE.
--Devido a necessidade de nomear a sequence de acordo com outro padrão escolhido, o subtipo
--serial não será mais utilizado, sendo obrigado a criação manual das sequences e da vinculação com
--os IDs das tabelas para a geração sequencial de valores.

--criando a sequence
--Por padrão o valor máximo da sequence é do tamanho de um Long. A declaração "AS integer" substitui esse valor.
create sequence if not exists sq_cliente AS integer start 1 increment 1 minvalue 1;
create sequence if not exists sq_ordemservico AS integer;

create table if not exists cliente (
	id_cliente integer default nextval('sq_cliente'),
	tx_nome varchar(60) not null,
	tx_email varchar(255) not null,
	tx_telefone varchar(20) not null,
	
	constraint pk_cliente primary key (id_cliente),
	constraint uk_tx_email unique (tx_email)
);

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

--vinculando a sequence a coluna id de cada tabela. 
--Garante a exclusão da sequence, em cascata, em caso de exclusão da tabela
alter sequence sq_cliente owned by cliente.id_cliente;
alter sequence sq_ordemservico owned by ordem_servico.id_ordemservico;

--insert into cliente (tx_nome,  tx_email , tx_telefone) values('Joana dark','joana@exemplo.com', '91 9985697855');

--criação ta tabela comentário e sequence
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









