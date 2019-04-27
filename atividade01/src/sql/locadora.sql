-- Script para criação do banco de dados

-- Tabela Usuario
drop table Usuario;

create table Usuario (
id integer not null generated always as identity (start with 1, increment by 1),
email varchar(50) not null,
cpf varchar(14) not null,
nome varchar(100) not null,
telefone varchar(14) not null,
senha varchar(100) not null,
data_nascimento varchar(50) not null,
sexo varchar(50) not null,
ativo smallint not null,
CONSTRAINT Cliente_PK PRIMARY KEY (id)
);

-- Tabela TipoUsuario
drop table TipoUsuario;

create table TipoUsuario (
id integer not null generated always as identity (start with 1, increment by 1),
email varchar(50) not null,
tipo varchar(50) not null,
constraint TipoUsuario_PK PRIMARY KEY (id)
);

-- Tabela Locadora
drop table Locadora;

create table Locadora (
id integer not null generated always as identity (start with 1, increment by 1),
nome varchar(50) not null,
email varchar(50) not null,
senha varchar(100) not null,
cnpj varchar(100) not null,
cidade varchar(100) not null,
CONSTRAINT Usuario_PK PRIMARY KEY (id)
);

-- Tabela Locacao
drop table Locacao;

create table Locacao (
id integer not null generated always as identity (start with 1, increment by 1),
cpf varchar(50) not null,
cnpj varchar(100) not null,
data varchar(50) not null,
hora varchar(10) not null,
CONSTRAINT Locacao_PK PRIMARY KEY (id)
);

select * from Locacao;