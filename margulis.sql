drop table decisoes;
drop table demonstrativos;
drop table empresas;

CREATE TABLE IF NOT EXISTS empresas (
	idempresa INTEGER PRIMARY KEY AUTOINCREMENT,
	nome VARCHAR(36) NOT NULL UNIQUE,
	responsavel VARCHAR(36) NOT NULL
); 

INSERT INTO empresas (idempresa, nome, responsavel) VALUES (1, 'C&A',    'Roberto Carlos');
INSERT INTO empresas (idempresa, nome, responsavel) VALUES (2, 'Renner', 'Erasmo Carlos');

CREATE TABLE decisoes (
	iddecisao INTEGER PRIMARY KEY AUTOINCREMENT,
	idempresa INTEGER,	
	periodo INTEGER(11) NOT NULL,
	preco DOUBLE NOT NULL,
	marketing DOUBLE NOT NULL,
	producao INTEGER(11) NOT NULL,
	FOREIGN KEY (idempresa) REFERENCES empresas(empresaid)
);

INSERT INTO decisoes (iddecisao, idempresa, periodo, preco, marketing, producao) VALUES (1, 1, 0, 80, 20000, 5000);
INSERT INTO decisoes (iddecisao, idempresa, periodo, preco, marketing, producao) VALUES (2, 2, 0, 80, 20000, 5000);

INSERT INTO decisoes (iddecisao, idempresa, periodo, preco, marketing, producao) VALUES (3, 1, 1, 80, 20000, 5000);
INSERT INTO decisoes (iddecisao, idempresa, periodo, preco, marketing, producao) VALUES (4, 2, 1, 90, 10000, 5000);

CREATE TABLE demonstrativos (
	iddemonstrativo INTEGER PRIMARY KEY AUTOINCREMENT,
	periodo INTEGER(11) NOT NULL,
	resultado DOUBLE,
	vendas DOUBLE, 
	demanda DOUBLE,
	idempresa INTEGER,
	FOREIGN KEY (idempresa) REFERENCES empresas(empresaid)
);