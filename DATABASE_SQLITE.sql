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
	periodo INTEGER(11) NOT NULL,
	preco DOUBLE NOT NULL,
	marketing DOUBLE NOT NULL,
	producao INTEGER(11) NOT NULL,
	quantidade INTEGER(11) NOT NULL,
	idempresa INTEGER,
	FOREIGN KEY (idempresa) REFERENCES empresas(empresaid)
);

INSERT INTO decisoes (iddecisao, periodo, preco, marketing, producao, quantidade, idempresa) VALUES (1, 1, 1, 80, 20000, 5000, 1);
INSERT INTO decisoes (iddecisao, periodo, preco, marketing, producao, quantidade, idempresa) VALUES (2, 2, 1, 90, 10000, 5000, 2);

CREATE TABLE demonstrativos (
	iddemonstrativo INTEGER PRIMARY KEY AUTOINCREMENT,
	periodo INTEGER(11) NOT NULL,
	resultado DOUBLE,
	vendas DOUBLE, 
	demanda DOUBLE,
	idempresa INTEGER,
	FOREIGN KEY (idempresa) REFERENCES empresas(empresaid)
);