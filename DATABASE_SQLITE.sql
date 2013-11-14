CREATE TABLE IF NOT EXISTS decisoes(
  codigo int(11) NOT NULL,
  periodo int(11) DEFAULT NULL,
  preco double DEFAULT NULL,
  marketing double DEFAULT NULL,
  producao int(11) DEFAULT NULL,
  quantidade int(11) DEFAULT NULL,
  codigo_empresa int(11) DEFAULT NULL,
  PRIMARY KEY (codigo),
  FOREIGN KEY(codigo_empresa) REFERENCES empresas(empid)
)


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
