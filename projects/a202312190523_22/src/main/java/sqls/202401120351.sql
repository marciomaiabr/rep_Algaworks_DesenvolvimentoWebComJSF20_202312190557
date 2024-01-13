
use db202312190523
go

drop table permissao_usuario
go
drop table usuario

go
create table usuario(
	nome_usuario varchar(50) not null primary key,
	senha varchar(25) not null
)
go
create table permissao_usuario(
	nome_permissao varchar(50) not null,
	nome_usuario varchar(50) not null foreign key references usuario (nome_usuario)
)



go



insert into usuario (nome_usuario, senha) values ('usuario01', 'senha01')
go
insert into usuario (nome_usuario, senha) values ('usuario02', 'senha02')
go
insert into usuario (nome_usuario, senha) values ('usuario03', 'senha03')
go
insert into usuario (nome_usuario, senha) values ('usuario04', 'senha04')
go

insert into permissao_usuario (nome_usuario, nome_permissao) values ('usuario01', 'cadastro')
go
insert into permissao_usuario (nome_usuario, nome_permissao) values ('usuario02', 'consulta')
go
insert into permissao_usuario (nome_usuario, nome_permissao) values ('usuario03', 'cadastro')
go
insert into permissao_usuario (nome_usuario, nome_permissao) values ('usuario03', 'consulta')
go
