
use db202312190523
go

drop table permissao_usuario
go
drop table usuario

go
create table usuario(
	codigo int not null primary key,
	nome_usuario varchar(50) not null,
	senha varchar(25) not null,
	constraint unique_usuariousuario_nome_usuario unique (nome_usuario)
)
go
create table permissao_usuario(
	codigo int not null primary key,
	codigo_usuario int not null foreign key references usuario (codigo),
	nome_permissao varchar(50) not null
)



go



insert into usuario (codigo, nome_usuario, senha) values (1, 'usuario01', 'senha01')
go
insert into usuario (codigo, nome_usuario, senha) values (2, 'usuario02', 'senha02')
go
insert into usuario (codigo, nome_usuario, senha) values (3, 'usuario03', 'senha03')
go

insert into permissao_usuario (codigo, codigo_usuario, nome_permissao) values (1, 1, 'cadastro')
go
insert into permissao_usuario (codigo, codigo_usuario, nome_permissao) values (2, 2, 'consulta')
go
insert into permissao_usuario (codigo, codigo_usuario, nome_permissao) values (3, 3, 'cadastro')
go
insert into permissao_usuario (codigo, codigo_usuario, nome_permissao) values (4, 3, 'consulta')
go
