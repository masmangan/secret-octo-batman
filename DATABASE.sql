-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tempo de Geração: 
-- Versão do Servidor: 5.5.27
-- Versão do PHP: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `projectlp`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `decisoes`
--

CREATE TABLE IF NOT EXISTS decisoes(
  codigo int(11) NOT NULL,
  periodo int(11) DEFAULT NULL,
  preco double DEFAULT NULL,
  marketing double DEFAULT NULL,
  producao int(11) DEFAULT NULL,
  quantidade int(11) DEFAULT NULL,
  codigo_empresa int(11) DEFAULT NULL,
  PRIMARY KEY (codigo),
  KEY decisoes_codigo_empresa_fkey (codigo_empresa)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Restrições para a tabela decisoes
--
ALTER TABLE decisoes
  ADD CONSTRAINT decisoes_codigo_empresa_fkey FOREIGN KEY (codigo_empresa) REFERENCES empresas (empid);

--
-- Extraindo dados da tabela decisoes
--

INSERT INTO decisoes (codigo, periodo, preco, marketing, producao, quantidade, codigo_empresa) VALUES
(1, 1, 1, 80, 20000, 5000, 1),
(2, 2, 1, 90, 10000, 5000, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela empresas
--

CREATE TABLE IF NOT EXISTS empresas (
  empid int(11) NOT NULL,
  nome varchar(20) DEFAULT NULL,
  responsavel varchar(20) DEFAULT NULL,
  PRIMARY KEY (empid),
  UNIQUE KEY empid (empid)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela empresas
--

INSERT INTO empresas (empid, nome, responsavel) VALUES
(1, 'C&A', 'Roberto Carlos'),
(2, 'Renner', 'Erasmo Carlos');

--
-- Restrições para as tabelas dumpadas
--



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
