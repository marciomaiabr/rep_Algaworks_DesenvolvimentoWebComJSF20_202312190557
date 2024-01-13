
use master;
go
drop database db202312190523;
go
create database db202312190523;
go
use db202312190523;
go
create table Pessoa (
codigo int not null identity(1,1) primary key,
nome varchar(150)
)
go
drop table Lancamento
go
create table Lancamento (
codigo int not null identity(1,1) primary key,
tipo varchar(10),
codigo_pessoa int not null foreign key references Pessoa (codigo),
descricao varchar(100),
valor numeric(12,2),
data_vencimento date,
pago integer DEFAULT 1 NOT NULL,
data_pagamento date
)
go
select * from Pessoa
go
select * from Lancamento
