
create table Usuario (
id integer not null generated always as identity (start with 1, increment by 1),
email varchar(50) not null,
cpf varchar(50) not null,
NOME varchar(100) not null,
telefone integer not null,
senha varchar(100) not null,
sexo varchar(1) not null,
ativo smallint not null,
CONSTRAINT Cliente_PK PRIMARY KEY (id)
);

create table TipoUsuario (
id integer not null generated always as identity (start with 1, increment by 1),
email varchar(50) not null,
tipo varchar(50) not null,
constraint TipoUsuario_PK PRIMARY KEY (id)
);

create table Locadora (
id integer not null generated always as identity (start with 1, increment by 1),
email varchar(50) not null,
senha varchar(100) not null,
cnpj varchar(100) not null,
cidade varchar(100) not null,
CONSTRAINT Usuario_PK PRIMARY KEY (id)
);

create table Locacao (
cpf varchar(50) not null,
cnpj varchar(100) not null
);


