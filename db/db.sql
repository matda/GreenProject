-- database schema

CREATE DATABASE IF NOT EXISTS GreenProjects;

USE GreenProjects;

CREATE TABLE IF NOT EXISTS veicolo (
      -- Chiave primaria
      id BIGINT AUTO_INCREMENT,

      -- Campi di default obbligatori
      targa VARCHAR ( 23 ) NOT NULL,
      modello VARCHAR ( 60 ) NOT NULL,
      assi INT NOT NULL,
      classe_veicolo ENUM('A', 'B', '3', '4', '5') NOT NULL,

      -- Classe ambientale opzionale
      classe_ambientale VARCHAR ( 90 ),

      -- Anno immatricolazione opzionale
      anno_immatricolazione INT,

      -- Cilindrata opzionale
      cilindrata INT,

      -- Inquinamento acustico opzionale
      inquinamentoAcustico INT,

      UNIQUE(targa),
      PRIMARY KEY ( id )
);

CREATE TABLE IF NOT EXISTS autostrada (
      id BIGINT AUTO_INCREMENT,
      nome VARCHAR ( 144 ) NOT NULL,
      iva DECIMAL ( 6,7 ) NOT NULL,
      PRIMARY KEY ( id )
);

CREATE TABLE IF NOT EXISTS casello (
      id BIGINT AUTO_INCREMENT,
      locazione VARCHAR ( 144 ) NOT NULL,
      kilometro INT NOT NULL,
      PRIMARY KEY ( id ),

       -- Foreign key id_autostrada riferimento a autostrada
      id_autostrada BIGINT,
      FOREIGN KEY ( id_autostrada ) REFERENCES autostrada ( id ) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Tariffa (
      id BIGINT AUTO_INCREMENT,
      classe_veicolo ENUM( 'A', 'B', '3', '4', '5' ) NOT NULL,
      prezzo DECIMAL ( 6,7 ) NOT NULL,
      PRIMARY KEY ( id ),

      -- Foreign key id_autostrada riferimento a autostrada
      id_autostrada BIGINT,
      FOREIGN KEY ( id_autostrada ) REFERENCES autostrada ( id ) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS ticket (
      id BIGINT AUTO_INCREMENT,
      data_ora_emissione TIMESTAMP,
      data_ora_validazione TIMESTAMP,

      -- Foreign key id_casello riferimento a casello
      id_casello BIGINT,
      FOREIGN KEY ( id_casello ) REFERENCES casello ( id ),

      -- Foreign key id_veicolo riferimento a veicolo
      id_veicolo BIGINT,
      FOREIGN KEY ( id_veicolo ) REFERENCES veicolo ( id ),

      PRIMARY KEY ( id )
);

CREATE TABLE IF NOT EXISTS administrator (
      id BIGINT AUTO_INCREMENT,
      username VARCHAR(144) NOT NULL,
      password VARCHAR(144) NOT NULL,
      
      PRIMARY KEY ( id )
);


