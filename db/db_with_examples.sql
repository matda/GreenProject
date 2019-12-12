-- phpMyAdmin SQL Dump
-- version 4.9.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

-- Struttura della tabella `administrator`
--

CREATE TABLE `administrator` (
  `id` bigint(70) NOT NULL,
  `username` varchar(144) NOT NULL,
  `password` varchar(144) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `administrator`
--

INSERT INTO `administrator` (`id`, `username`, `password`) VALUES
(1, 'jimmy', 'admin');

-- --------------------------------------------------------

--
-- Struttura della tabella `autostrada`
--

CREATE TABLE `autostrada` (
  `id` bigint(70) NOT NULL,
  `nome` varchar(144) NOT NULL,
  `iva` decimal(6,7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `autostrada`
--

INSERT INTO `autostrada` (`id`, `nome`, `iva`) VALUES
(5, 'B23', '22.00'),
(16, 'A89', '22.00'),
(19, 'A1', '22.00'),
(25, 'A26', '22.00'),
(30, 'A34', '22.00');

-- --------------------------------------------------------

--
-- Struttura della tabella `casello`
--

CREATE TABLE `casello` (
  `id` bigint(70) NOT NULL,
  `id_autostrada` bigint(70) NOT NULL,
  `locazione` varchar(144) NOT NULL,
  `kilometro` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `casello`
--

INSERT INTO `casello` (`id`, `id_autostrada`, `locazione`, `kilometro`) VALUES
(1, 1, 'Topolinia', 60),
(2, 1, 'Neverland', 10),
(3, 1, 'Molise', 40000),
(74, 18, 'Runeterra', 90),
(75, 18, 'Assurdopoli', 400),
(76, 18, 'Mixera', 900),
(77, 18, 'Mongolia', 700),
(78, 19, 'Busso', 258),
(79, 19, 'Catalo', 550);

-- --------------------------------------------------------

--
-- Struttura della tabella `Tariffa`
--

CREATE TABLE `tassa` (
  `id` bigint(20) NOT NULL,
  `classe_veicolo` enum('A','B','3','4','5') NOT NULL,
  `prezzo` decimal(9,2) NOT NULL,
  `id_autostrada` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `Tariffa`
--

INSERT INTO `tassa` (`id`, `classe_veicolo`, `prezzo`, `id_autostrada`) VALUES
(81, 'A', '0.45', 1),
(82, 'B', '0.45', 1),
(83, '3', '3.80', 1),
(84, '4', '2.80', 1),
(85, '5', '1.40', 1),
(96, 'A', '0.36', 17),
(97, 'B', '0.15', 17),
(98, '3', '0.27', 17),
(99, '4', '0.20', 17),
(100, '5', '0.90', 17),
(101, 'A', '0.20', 18),
(102, 'B', '0.14', 18),
(103, '3', '0.22', 18),
(104, '4', '0.30', 18),
(105, '5', '0.35', 18),
(106, 'A', '0.03', 19),
(107, 'B', '0.04', 19),
(108, '3', '0.05', 19),
(109, '4', '0.06', 19),
(110, '5', '0.07', 19),
(111, 'A', '0.07', 20),
(112, 'B', '0.05', 20),
(113, '3', '0.06', 20),
(114, '4', '0.06', 20),
(115, '5', '0.10', 20);

-- --------------------------------------------------------

--
-- Struttura della tabella `veicolo`
--

CREATE TABLE `veicolo` (
  `id` bigint(20) NOT NULL,
  `targa` varchar(32) NOT NULL,
  `modello` varchar(128) NOT NULL,
  `assi` int(11) NOT NULL,
  `classe_veicolo` enum('A','B','3','4','5') NOT NULL,
  `classe_ambientale` varchar(64) DEFAULT NULL,
  `anno_immatricolazione` int(11) DEFAULT NULL,
  `cilindrata` int(11) DEFAULT NULL,
  `inquinamentoAcustico` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `veicolo`
--

INSERT INTO `veicolo` (`id`, `targa`, `modello`, `assi`, `classe_veicolo`, `classe_ambientale`, `anno_immatricolazione`, `cilindrata`, `inquinamentoAcustico`) VALUES
(1, 'EA123456', 'Audi RS6', 2, 'A', 'ECO 6', 2019, 3000, 50);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `administrator`
--
ALTER TABLE `administrator`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `autostrada`
--
ALTER TABLE `autostrada`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `casello`
--
ALTER TABLE `casello`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_autostrada` (`id_autostrada`);

--
-- Indici per le tabelle `Tariffa`
--
ALTER TABLE `tassa`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tariffa_ibfk_1` (`id_autostrada`);

--
-- Indici per le tabelle `veicolo`
--
ALTER TABLE `veicolo`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `targa` (`targa`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `administrator`
--
ALTER TABLE `administrator`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT per la tabella `autostrada`
--
ALTER TABLE `autostrada`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT per la tabella `casello`
--
ALTER TABLE `casello`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=80;

--
-- AUTO_INCREMENT per la tabella `Tariffa`
--
ALTER TABLE `tassa`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=116;

--
-- AUTO_INCREMENT per la tabella `veicolo`
--
ALTER TABLE `veicolo`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `casello`
--
ALTER TABLE `casello`
  ADD CONSTRAINT `casello_ibfk_1` FOREIGN KEY (`id_autostrada`) REFERENCES `autostrada` (`id`) ON DELETE CASCADE;

--
-- Limiti per la tabella `Tariffa`
--
ALTER TABLE `tariffa`
  ADD CONSTRAINT `tariffa_ibfk_1` FOREIGN KEY (`id_autostrada`) REFERENCES `autostrada` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
