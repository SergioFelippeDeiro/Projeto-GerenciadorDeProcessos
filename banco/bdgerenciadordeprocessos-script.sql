drop database if exists BdGerenciadorDeProcessos;

create database if not exists BdGerenciadorDeProcessos
default character set utf8
default collate utf8_general_ci;

use BdGerenciadorDeProcessos;

drop table if exists processo;
create table if not exists processo (
  id bigint not null auto_increment primary key,
  numeroProcesso varchar(25) unique not null,
  vara text not null,
  autor varchar(50) not null  default 'Não informado',
  dataCriacao timestamp not null default current_timestamp,
  dataAtualizacao timestamp not null default current_timestamp on update current_timestamp
) engine=innodb default charset=utf8;