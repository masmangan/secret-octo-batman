CREATE TABLE IF NOT EXISTS decisoes(
    codigo INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    periodo INTEGER(11) NOT NULL,
    preco DOUBLE NOT NULL,
    marketing DOUBLE NOT NULL,
    producao INTEGER(11) NOT NULL,
    quantidade INTEGER(11) NOT NULL,
    codigo_empresa INTEGER ,
   FOREIGN KEY (codigo_empresa) REFERENCES empresas(empid)
);


INSERT INTO decisoes (codigo, periodo, preco, marketing, producao, quantidade, codigo_empresa) VALUES (1, 1, 1, 80, 20000, 5000, 1)
INSERT INTO decisoes (codigo, periodo, preco, marketing, producao, quantidade, codigo_empresa) VALUES (2, 2, 1, 90, 10000, 5000, 2)


CREATE TABLE IF NOT EXISTS empresas (
  empid int(11) NOT NULL UNIQUE,
  nome varchar(20) DEFAULT NULL,
  responsavel varchar(20) DEFAULT NULL,
  PRIMARY KEY (empid)
) 

INSERT INTO empresas (empid, nome, responsavel) VALUES (1, 'C&A', 'Roberto Carlos')
INSERT INTO empresas (empid, nome, responsavel) VALUES  (2, 'Renner', 'Erasmo Carlos')
