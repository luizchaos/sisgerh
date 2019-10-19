-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Tempo de geração: 15/12/2018 às 04:17
-- Versão do servidor: 10.1.37-MariaDB
-- Versão do PHP: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `sisgerh`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `Contrato`
--

CREATE TABLE `Contrato` (
  `id` bigint(20) NOT NULL,
  `empresa_id` bigint(20) DEFAULT NULL,
  `empresa_terceirizada_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `Contrato`
--

INSERT INTO `Contrato` (`id`, `empresa_id`, `empresa_terceirizada_id`) VALUES
(1, 1, 1),
(2, 2, 2);

-- --------------------------------------------------------

--
-- Estrutura para tabela `Empresa`
--

CREATE TABLE `Empresa` (
  `id` bigint(20) NOT NULL,
  `cnpj` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `Empresa`
--

INSERT INTO `Empresa` (`id`, `cnpj`, `nome`) VALUES
(1, '82.980.737/0001-82', 'Teixeira SA'),
(2, '47.717.808/0001-58', 'Carvalho Ltda');

-- --------------------------------------------------------

--
-- Estrutura para tabela `EmpresaTerceirizada`
--

CREATE TABLE `EmpresaTerceirizada` (
  `id` bigint(20) NOT NULL,
  `cnpj` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `EmpresaTerceirizada`
--

INSERT INTO `EmpresaTerceirizada` (`id`, `cnpj`, `nome`) VALUES
(1, '76.428.415/0001-22', 'Assoc. das Rosas'),
(2, '10.629.938/0001-29', 'Distribuição. Pedro');

-- --------------------------------------------------------

--
-- Estrutura para tabela `Ferias`
--

CREATE TABLE `Ferias` (
  `id` bigint(20) NOT NULL,
  `data_fim` datetime DEFAULT NULL,
  `data_inicio` datetime DEFAULT NULL,
  `funcionario_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `Ferias`
--

INSERT INTO `Ferias` (`id`, `data_fim`, `data_inicio`, `funcionario_id`) VALUES
(1, '2018-12-01 00:00:00', '2018-12-30 00:00:00', 1),
(2, '2019-01-01 00:00:00', '2018-12-30 00:00:00', 2);

-- --------------------------------------------------------

--
-- Estrutura para tabela `FolhaPagamento`
--

CREATE TABLE `FolhaPagamento` (
  `id` bigint(20) NOT NULL,
  `data_criacao` datetime DEFAULT NULL,
  `data_referencia` datetime DEFAULT NULL,
  `valor` double DEFAULT NULL,
  `funcionario_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `FolhaPagamento`
--

INSERT INTO `FolhaPagamento` (`id`, `data_criacao`, `data_referencia`, `valor`, `funcionario_id`) VALUES
(1, '2018-12-15 00:00:00', '2018-12-30 00:00:00', 5000, 1),
(2, '2018-12-15 00:00:00', '2019-01-30 00:00:00', 4000, 2);

-- --------------------------------------------------------

--
-- Estrutura para tabela `Funcionario`
--

CREATE TABLE `Funcionario` (
  `id` bigint(20) NOT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `empresa_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `Funcionario`
--

INSERT INTO `Funcionario` (`id`, `cpf`, `nome`, `empresa_id`) VALUES
(1, '197.142.200-25', 'Luiz', 1),
(2, '249.039.120-86', 'Henrique', 2);

-- --------------------------------------------------------

--
-- Estrutura para tabela `FuncionarioTerceirizado`
--

CREATE TABLE `FuncionarioTerceirizado` (
  `id` bigint(20) NOT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `empresa_id` bigint(20) DEFAULT NULL,
  `contrato_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `FuncionarioTerceirizado`
--

INSERT INTO `FuncionarioTerceirizado` (`id`, `cpf`, `nome`, `empresa_id`, `contrato_id`) VALUES
(1, '426.867.380-65', 'Joao', 1, 1),
(2, '772.457.990-32', 'Denis', 2, 2);

-- --------------------------------------------------------

--
-- Estrutura para tabela `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(5),
(5),
(5),
(5),
(5),
(5),
(5);

-- --------------------------------------------------------

--
-- Estrutura para tabela `Perfil`
--

CREATE TABLE `Perfil` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `Perfil`
--

INSERT INTO `Perfil` (`id`, `name`) VALUES
(1, 'Administrativo'),
(2, 'Publico');

-- --------------------------------------------------------

--
-- Estrutura para tabela `Usuario`
--

CREATE TABLE `Usuario` (
  `id` bigint(20) NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `perfil_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `Usuario`
--

INSERT INTO `Usuario` (`id`, `login`, `nome`, `senha`, `perfil_id`) VALUES
(1, 'admin', 'Administrador', 'admin', 1),
(2, 'publico', 'Publico', '123456', 2),
(3, 'henrique', 'Henrique', '123456', 1);

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `Contrato`
--
ALTER TABLE `Contrato`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK2p5dkuxlto0d7ky2opoufabt7` (`empresa_terceirizada_id`);

--
-- Índices de tabela `Empresa`
--
ALTER TABLE `Empresa`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `EmpresaTerceirizada`
--
ALTER TABLE `EmpresaTerceirizada`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `Ferias`
--
ALTER TABLE `Ferias`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `FolhaPagamento`
--
ALTER TABLE `FolhaPagamento`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `Funcionario`
--
ALTER TABLE `Funcionario`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `FuncionarioTerceirizado`
--
ALTER TABLE `FuncionarioTerceirizado`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKebq44rsjv7c5gq0fywtoq6viw` (`contrato_id`);

--
-- Índices de tabela `Perfil`
--
ALTER TABLE `Perfil`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `Usuario`
--
ALTER TABLE `Usuario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKb0s6qtq0ga0u7y0nxqd4x6133` (`perfil_id`);

--
-- Restrições para dumps de tabelas
--

--
-- Restrições para tabelas `Contrato`
--
ALTER TABLE `Contrato`
  ADD CONSTRAINT `FK2p5dkuxlto0d7ky2opoufabt7` FOREIGN KEY (`empresa_terceirizada_id`) REFERENCES `EmpresaTerceirizada` (`id`);

--
-- Restrições para tabelas `FuncionarioTerceirizado`
--
ALTER TABLE `FuncionarioTerceirizado`
  ADD CONSTRAINT `FKebq44rsjv7c5gq0fywtoq6viw` FOREIGN KEY (`contrato_id`) REFERENCES `Contrato` (`id`);

--
-- Restrições para tabelas `Usuario`
--
ALTER TABLE `Usuario`
  ADD CONSTRAINT `FKb0s6qtq0ga0u7y0nxqd4x6133` FOREIGN KEY (`perfil_id`) REFERENCES `Perfil` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
