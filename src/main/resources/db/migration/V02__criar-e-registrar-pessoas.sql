create table pessoa(
	id bigint(20) primary key auto_increment,
    nome varchar(100) not null,
    ativo boolean not null,
    logradouro varchar(150),
    numero varchar(20),
    complemento varchar(80),
    bairro varchar(30),
    cep varchar(9),
    cidade varchar(30),
    estado varchar(2)
);

insert into pessoa (nome, ativo, logradouro, numero,bairro, cep, cidade, estado) values ('Marcio Brito', true, 'Rua Isael Fernandes', '219', 'PQ Eldorado', '13052-729', 'Campinas', 'SP');
insert into pessoa (nome, ativo, logradouro, numero,bairro, cep, cidade, estado) values ('Adriana Matiuzzo', true, 'Rua Isael Fernandes', '219', 'PQ Eldorado', '13052-729', 'Campinas', 'SP');
insert into pessoa (nome, ativo, logradouro, numero,bairro, cep, cidade, estado) values ('Felipe Brito', true, 'Rua Isael Fernandes', '219', 'PQ Eldorado', '13052-729', 'Campinas', 'SP');
insert into pessoa (nome, ativo, logradouro, numero,bairro, cep, cidade, estado) values ('Alaide Teixeira', true, 'Manoel Oliveira Rocha', '150', 'Vila Dutra', '13030-425', 'Campinas', 'SP');
insert into pessoa (nome, ativo, logradouro, numero,bairro, cep, cidade, estado) values ('Cleide Barozzi', true, 'Rua dos Cataguases', '122', 'Vl Costa e Silva', '13081-330', 'Campinas', 'SP');
insert into pessoa (nome, ativo, logradouro, numero,bairro, cep, cidade, estado) values ('Leandro de Lima', true, 'Av Imigrandes', '400', 'Jd Rosario', '13052-729', 'Diadema', 'SP');
insert into pessoa (nome, ativo, logradouro, numero,bairro, cep, cidade, estado) values ('Joao da Silva', true, 'Rua das Flores', '334', 'Jardim Primavera', '55644-729', 'Salto', 'SP');
insert into pessoa (nome, ativo, logradouro, numero,bairro, cep, cidade, estado) values ('Maria das Dores', true, 'Rua Sonridor', '330', 'Remedios', '65434-432', 'Campinas', 'SP');
insert into pessoa (nome, ativo, logradouro, numero,bairro, cep, cidade, estado) values ('Jose Dorflex', true, 'Rua dos Comprimidos', '87', 'Jardim Uiui', '93553-442', 'Sao Paulo', 'SP');
insert into pessoa (nome, ativo, logradouro, numero,bairro, cep, cidade, estado) values ('Rubio do Alem', true, 'Av Ibirapuera', '2300', 'Pq Higienopolis', '11049-009', 'Barueri', 'SP');

