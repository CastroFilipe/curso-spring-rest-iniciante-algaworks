--Cria��o da tabela Cliente
--id_cliente � do subtipo SERIAL. Usar SERIAL far� o sgbd criar uma coluna com incremento automatico.
--Internamente, ao utilizar o subtipo SERIAL, o postgres criar� o id do tipo Integer e atribuir� 
--uma SEQUENCE para esse atributo. A instru��o not null no atributo id_cliente � opcional pois 
--a mesma j� � definida com a declara��o PRIMARY KEY (id_cliente). 

--A instru��o primary key constraints define que a coluna id_cliente � a chave primaria, criando assim um 
--index para a coluna. Ela � a combina��o de uma constraint NOT NULL e constraint UNIQUE.
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

--Por utilizar o SERIAL uma sequence ser� criada, de forma automatica, pelo sgbd. 
--Essa sequence � criada com um nome padr�o, cujo nome n�o consegui redefinir no momento de
--cria��o das tabelas. S� consegui mudar o nome da sequence com o comando ALTER SEQUENCE.
--Devido a necessidade de nomear a sequence de acordo com outro padr�o escolhido, o subtipo
--serial n�o ser� mais utilizado, sendo obrigado a cria��o manual das sequences e da vincula��o com
--os IDs das tabelas para a gera��o sequencial de valores.

--criando a sequence
--Por padr�o o valor m�ximo da sequence � do tamanho de um Long. A declara��o "AS integer" substitui esse valor.
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
--Garante a exclus�o da sequence, em cascata, em caso de exclus�o da tabela
alter sequence sq_cliente owned by cliente.id_cliente;
alter sequence sq_ordemservico owned by ordem_servico.id_ordemservico;

--insert into cliente (tx_nome,  tx_email , tx_telefone) values('Joana dark','joana@exemplo.com', '91 9985697855');

--cria��o ta tabela coment�rio e sequence
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









