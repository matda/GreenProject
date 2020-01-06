
CREATE DATABASE db_with_examples;
USE db_with_examples;

Class.forName("com.mysql.jdbc.Driver");

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";



-- Struttura della tabella `administrator`
CREATE TABLE `administrator` (
  `id` bigint(20) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- credenziali
INSERT INTO `administrator` (`id`, `username`, `password`) VALUES
(1, 'yoda', 'admin');

-- Struttura della tabella `autostrada`

CREATE TABLE `autostrada` (
  `id` bigint(20) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `iva` decimal(9,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dump dei dati per la tabella `autostrada`

INSERT INTO `autostrada` (`id`, `nome`, `iva`) VALUES
(1, 'A18', '22.00'),
(17, 'A45', '22.00'),
(18, 'A1', '22.00'),
(19, 'A2', '22.00'),
(20, 'A24', '22.00');

-- Struttura della tabella `casello`

CREATE TABLE `casello` (
  `id` bigint(20) NOT NULL,
  `id_autostrada` bigint(20) NOT NULL,
  `locazione` varchar(255) NOT NULL,
  `kilometro` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dump dei dati per la tabella `casello`

INSERT INTO `casello` (`id`, `id_autostrada`, `locazione`, `kilometro`) VALUES
(1, 1, 'Teramo Ovest', 25),
(2, 1, 'Teramo ovest', 150),
(3, 1, 'Teramo Ovest', 400),
(74, 18, 'Napoli nord', 0),
(75, 18, 'Bologna sud', 500),
(76, 18, 'Milano sud', 700),
(77, 18, 'Milano nord', 740),
(78, 19, 'Cosenza sud', 25),
(79, 19, 'Catanzaro', 50);

-- Struttura della tabella `tariffa`

CREATE TABLE `tariffa` (
  `id` bigint(20) NOT NULL,
  `classe_veicolo` enum('A','B','3','4','5') NOT NULL,
  `prezzo` decimal(9,2) NOT NULL,
  `id_autostrada` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dump dei dati per la tabella `tariffa`

INSERT INTO `tariffa` (`id`, `classe_veicolo`, `prezzo`, `id_autostrada`) VALUES
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

-- Struttura della tabella `veicolo`

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

-- Dump dei dati per la tabella `veicolo`

INSERT INTO `veicolo` (`id`, `targa`, `modello`, `assi`, `classe_veicolo`, `classe_ambientale`, `anno_immatricolazione`, `cilindrata`, `inquinamentoAcustico`) VALUES
(1, 'EA123456', 'Audi RS6', 2, 'A', 'ECO 6', 2019, 3000, 50);


-- Indici per le tabelle scaricate

-- Indici per le tabelle `administrator`
ALTER TABLE `administrator`
  ADD PRIMARY KEY (`id`);

-- Indici per le tabelle `autostrada`
ALTER TABLE `autostrada`
  ADD PRIMARY KEY (`id`);

-- Indici per le tabelle `casello`
ALTER TABLE `casello`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_autostrada` (`id_autostrada`);

-- Indici per le tabelle `tariffa`
ALTER TABLE `tariffa`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tariffa_ibfk_1` (`id_autostrada`);

-- Indici per le tabelle `veicolo`
ALTER TABLE `veicolo`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `targa` (`targa`);



-- AUTO_INCREMENT per le tabelle scaricate

-- AUTO_INCREMENT per la tabella `administrator`
ALTER TABLE `administrator`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

-- AUTO_INCREMENT per la tabella `autostrada`
ALTER TABLE `autostrada`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

-- AUTO_INCREMENT per la tabella `casello`
ALTER TABLE `casello`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=80;

-- AUTO_INCREMENT per la tabella `tariffa`
ALTER TABLE `tariffa`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=116;

-- AUTO_INCREMENT per la tabella `veicolo`
ALTER TABLE `veicolo`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;


-- Limiti per le tabelle scaricate

-- Limiti per la tabella `casello`
ALTER TABLE `casello`
  ADD CONSTRAINT `casello_ibfk_1` FOREIGN KEY (`id_autostrada`) REFERENCES `autostrada` (`id`) ON DELETE CASCADE;


-- Limiti per la tabella `tariffa`
ALTER TABLE `tariffa`
  ADD CONSTRAINT `tariffa_ibfk_1` FOREIGN KEY (`id_autostrada`) REFERENCES `autostrada` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
