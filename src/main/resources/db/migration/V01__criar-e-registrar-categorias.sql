create table categoria(
	codigo bigint(20) primary key auto_increment,
    nome varchar(50) not null
);

insert into categoria (nome) values ('Laser');
insert into categoria (nome) values ('Alimentação');
insert into categoria (nome) values ('Supermercado');
insert into categoria (nome) values ('Farmácia');
insert into categoria (nome) values ('Outros');