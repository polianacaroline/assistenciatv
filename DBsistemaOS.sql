/**
Sistema para gestao de OS
@author Thainara Pires
*/

create database dbsistema;
use dbsistema;

create table usuarios (
id int primary key auto_increment,
nome varchar(50) not null,
login varchar(15) not null unique,
senha varchar(250) not null,
perfil varchar(10) not null
 );

insert into usuarios(nome, login, senha, perfil) values ('Administrador', 'admin', md5('admin'), 'Admin');

 create table clientes (
idcli int primary key auto_increment,
nome varchar(50) not null,
cpf varchar(11) not null unique,
rg varchar(9) not null unique,
cnpj varchar(14) unique,
endereco varchar(35) not null,
numero varchar(10) not null,
complemento varchar(20),
bairro varchar(50) not null,
cep varchar(20),
cidade varchar(30) not null,
uf char(2),
fone varchar(12) not null,
email varchar(50) not null unique
 ); 
 

create table servicos (
os int primary key auto_increment,
dataOS timestamp default current_timestamp,
equipamento varchar(200) not null,
marca varchar(45),
modelo varchar(45),
serie varchar(45),
defeito varchar(200) not null,
valor decimal(10,2), 
idcli int not null,
foreign key (idcli) references clientes(idcli)
);

create table fornecedores (
idfornecedor int primary key auto_increment,
razaosocial varchar(50) not null,
nomefantasia varchar(50),
cnpj varchar(14) unique,
logradouro varchar(35) not null,
numero varchar(10) not null,
complemento varchar(20),
cep varchar(20),
bairro varchar(50) not null,
referencia varchar(50),
cidade varchar(30) not null,
uf char(2),
telefone varchar(12),
celular varchar(12) not null,
email varchar(50) not null,
site varchar(45),
vendedor varchar(45),
ie varchar(45)
 ); 
 
create table produtos (
codigo int primary key auto_increment,
barcode varchar(100) unique,
descricao varchar(100) not null,
foto longblob,
estoque int not null,
estoquemin int not null,
valor decimal(10,2) not null,
medida char(2) not null,
armazenagem varchar(50) not null,
idfornecedor int not null,
nome varchar(100) not null,
lote varchar(20) not null,
fabricante varchar(20),
lucro decimal(10,2),
dataent timestamp default current_timestamp,
dataval date,
codigobarras varchar (100),
razaosocial varchar(50) not null,
foreign key (idfornecedor) references fornecedores(idfornecedor)
); 
