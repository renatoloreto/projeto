

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;



--
-- Database: `aula_17.05.2022`
--

-- --------------------------------------------------------

--
-- Table structure for table `alunos`
--

CREATE TABLE `alunos` (
  `ra` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nome` varchar(150) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `telefone` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `endereco` varchar(150) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `data_nascimento` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `alunos`
--

INSERT INTO `alunos` (`ra`, `nome`, `telefone`, `endereco`, `data_nascimento`) VALUES
('202200001', 'Alexsandro', '123456', 'Rua da Folha Verde, 777', '1985-04-27'),
('202200002', 'Bruno', '123123', 'Rua da Folha Verde, 1522', '1991-06-02'),
('202200003', 'Cesar', '001122', 'Avenida Boa Viagem, 322', '1991-06-02'),
('202200004', 'Decio', '000111', 'Rua da Folha Verde, 1001', '1992-06-11'),
('202200005', 'Eduardo', '456123', 'Avenida Boa Viagem, 1220', '1989-12-12'),
('202200006', 'Felipe', '777888', 'Rua da Folha Verde, 137', '1992-12-25'),
('202200007', 'Gustavo', '998877', 'Avenida Boa Viagem, 789', '1993-01-01'),
('202200008', 'Hepaminondas', '123045', 'Rua da Folha Verde, 555', '1993-04-21'),
('202200009', 'Italo', '996633', 'Rua da Folha Verde, 777', '1995-09-07'),
('202200010', 'Justino', '885522', 'Rua da Folha Verde, 999', '1996-09-07'),
('202200011', 'Klaus', '774411', 'Avenida Boa Viagem 1177', '1996-10-11'),
('202200012', 'Lucas', '112233', 'Rua da Folha Verde, 159', '1991-06-25'),
('202200013', 'Matheus', '445566', 'Rua da Folha Verde, 951', '1997-12-31'),
('202200014', 'Nivaldo', '778899', 'Rua da Folha Verde, 789', '1988-02-28'),
('202200015', 'Otávio', '995511', 'Avenida Engenheiro Domingos, 1234', '1987-11-17'),
('202200016', 'Petrúcio', '775533', 'Avenida Engenheiro Domingos, 1345', '1986-05-01'),
('202200017', 'Quixote', '338811', 'Avenida Engenheiro Domingos, 2041', '1987-10-15'),
('202200018', 'Ricardo', '118833', 'Rua da Folha Verde, 963', '1993-03-20'),
('202200019', 'Samuel', '227799', 'Avenida Engenheiro Domingos 789', '1988-07-17'),
('202200020', 'Tulio', '101010', 'Avenida Engenheiro Domingos 1010', '1988-12-01'),
('202200021', 'Ulísses', '998870', 'Avenida Engenheiro Domingos 7766', '1987-03-12'),
('202200022', 'Valter', '111000', 'Avenida Engenheiro Domingos 111', '1989-01-12'),
('202200023', 'Xande', '102030', 'Avenida Engenheiro Domingos 1020', '1989-02-02'),
('202200024', 'Yago', '300123', 'Avenida Engenheiro Domingos 1048', '1989-03-03'),
('202200025', 'Zion', '557733', 'Avenida Engenheiro Domingos 700', '1985-07-07'),
('202200026', 'Walace', '667733', 'Avenida Engenheiro Domingos 800', '1986-09-09');

-- --------------------------------------------------------

--
-- Table structure for table `alunos_cursos_professores`
--

CREATE TABLE `alunos_cursos_professores` (
  `cod_matricula` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `fk_alunos_ra` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `fk_cursos_cod_curso` int(11) DEFAULT NULL,
  `fk_professores_cpf` varchar(11) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `alunos_cursos_professores`
--

INSERT INTO `alunos_cursos_professores` (`cod_matricula`, `fk_alunos_ra`, `fk_cursos_cod_curso`, `fk_professores_cpf`) VALUES
('202200001', '202200001', 1, '12345678903'),
('202200002', '202200002', 1, '12345678906');

-- --------------------------------------------------------

--
-- Table structure for table `cursos`
--

CREATE TABLE `cursos` (
  `cod_curso` int(11) NOT NULL,
  `nome` varchar(150) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `descricao` varchar(2000) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `valor` double DEFAULT NULL,
  `data_inicio` date DEFAULT NULL,
  `data_fim` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `cursos`
--

INSERT INTO `cursos` (`cod_curso`, `nome`, `descricao`, `valor`, `data_inicio`, `data_fim`) VALUES
(1, 'Java Básico', 'Curso de desenvolvimento geral com foco em Java', 3000, '2022-02-08', '2022-07-15'),
(2, 'Excel básico ao avançado', 'Excel do básico ao avançado com introdução a macros', 6000, '2022-04-12', '2022-10-15'),
(3, 'Java Avançado', 'Curso Voltado Evoluir no mundo Java', 7000, '2022-07-14', '2022-12-20');

-- --------------------------------------------------------

--
-- Table structure for table `professores`
--

CREATE TABLE `professores` (
  `cpf` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nome` varchar(150) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `telefone` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `conta_bancaria` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `professores`
--

INSERT INTO `professores` (`cpf`, `nome`, `telefone`, `conta_bancaria`) VALUES
('12345678901', 'Albert Einstein', '5555555', 'AG. 777 Conta 123456'),
('12345678902', 'Charles Darwin', '0255555', 'AG. 1809 Conta 0001'),
('12345678903', 'Stephen Hawking', '0355555', 'AG. 1942 Conta 0011'),
('12345678904', 'Isaac Newton', '0455555', 'AG. 1643 Conta 0111'),
('12345678905', 'Thomas Edison', '0555555', 'AG. 1847 Conta 1111'),
('12345678906', 'Nikola Tesla', '0655555', 'AG. 1856 Conta 0002');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `alunos`
--
ALTER TABLE `alunos`
  ADD PRIMARY KEY (`ra`);

--
-- Indexes for table `alunos_cursos_professores`
--
ALTER TABLE `alunos_cursos_professores`
  ADD PRIMARY KEY (`cod_matricula`),
  ADD KEY `FK_alunos_cursos_professores_1` (`fk_alunos_ra`),
  ADD KEY `FK_alunos_cursos_professores_2` (`fk_cursos_cod_curso`),
  ADD KEY `FK_alunos_cursos_professores_3` (`fk_professores_cpf`);

--
-- Indexes for table `cursos`
--
ALTER TABLE `cursos`
  ADD PRIMARY KEY (`cod_curso`);

--
-- Indexes for table `professores`
--
ALTER TABLE `professores`
  ADD PRIMARY KEY (`cpf`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `alunos_cursos_professores`
--
ALTER TABLE `alunos_cursos_professores`
  ADD CONSTRAINT `FK_alunos_cursos_professores_1` FOREIGN KEY (`fk_alunos_ra`) REFERENCES `alunos` (`ra`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_alunos_cursos_professores_2` FOREIGN KEY (`fk_cursos_cod_curso`) REFERENCES `cursos` (`cod_curso`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_alunos_cursos_professores_3` FOREIGN KEY (`fk_professores_cpf`) REFERENCES `professores` (`cpf`) ON DELETE CASCADE;
COMMIT;


