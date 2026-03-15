create table humano (
codigo serial primary key,
nome varchar(100)
);

create table pet (
codigo serial primary key,
nome varchar(100),
peso float,
codhumano int,
CONSTRAINT fk_humano_pet FOREIGN KEY (codhumano) REFERENCES humano (codigo)
);