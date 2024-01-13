
use db202312190523
go

drop table permissao_usuario
go
drop table usuario

go
create table usuario(
	nome_usuario varchar(50) not null primary key,
	senha varchar(50) not null
)
go
create table permissao_usuario(
	nome_permissao varchar(50) not null,
	nome_usuario varchar(50) not null foreign key references usuario (nome_usuario)
)



go



insert into usuario (nome_usuario, senha) values ('usuario01', CONVERT(VARCHAR(32), HashBytes('MD5', 'senha01'), 2))
go
insert into usuario (nome_usuario, senha) values ('usuario02', CONVERT(VARCHAR(32), HashBytes('MD5', 'senha02'), 2))
go
insert into usuario (nome_usuario, senha) values ('usuario03', CONVERT(VARCHAR(32), HashBytes('MD5', 'senha03'), 2))
go
insert into usuario (nome_usuario, senha) values ('usuario04', CONVERT(VARCHAR(32), HashBytes('MD5', 'senha04'), 2))
go

insert into permissao_usuario (nome_usuario, nome_permissao) values ('usuario01', 'cadastro')
go
insert into permissao_usuario (nome_usuario, nome_permissao) values ('usuario02', 'consulta')
go
insert into permissao_usuario (nome_usuario, nome_permissao) values ('usuario03', 'cadastro')
go
insert into permissao_usuario (nome_usuario, nome_permissao) values ('usuario03', 'consulta')
go
