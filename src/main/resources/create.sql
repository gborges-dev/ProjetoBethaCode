CREATE DATABASE "ProjetoFullStack"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;


--inserts para popular tabela de receita para testes

insert into receita values(1, NOW(), NOW(), 'Despesa 1', 100.00);
insert into receita values(2, NOW(), NOW(), 'Despesa 2', 932.15);
insert into receita values(3, NOW(), NOW(), 'Despesa 3', 230.28);