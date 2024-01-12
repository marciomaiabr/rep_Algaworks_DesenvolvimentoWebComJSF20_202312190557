
drop TABLE permissao_usuario;

drop TABLE usuario;

CREATE TABLE usuario (
  nome_usuario varchar(15) NOT NULL,
  senha varchar(50) DEFAULT NULL,
  PRIMARY KEY (nome_usuario)
);

CREATE TABLE permissao_usuario (
  nome_usuario varchar(15) NOT NULL,
  nome_permissao varchar(15) NOT NULL,
  PRIMARY KEY (nome_usuario,nome_permissao),
  CONSTRAINT permissao_usuario_ibfk_1 FOREIGN KEY (nome_usuario) REFERENCES usuario (nome_usuario)
);



insert into usuario (nome_usuario, senha) values ('usuario01', md5('senha01'));

insert into usuario (nome_usuario, senha) values ('usuario02', md5('senha02'));

insert into usuario (nome_usuario, senha) values ('usuario03', md5('senha03'));

insert into usuario (nome_usuario, senha) values ('usuario04', md5('senha04'));

insert into permissao_usuario (nome_usuario, nome_permissao) values ('usuario01', 'cadastro');

insert into permissao_usuario (nome_usuario, nome_permissao) values ('usuario02', 'consulta');

insert into permissao_usuario (nome_usuario, nome_permissao) values ('usuario03', 'cadastro');

insert into permissao_usuario (nome_usuario, nome_permissao) values ('usuario03', 'consulta')
