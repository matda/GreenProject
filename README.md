
Utilizzo del software: il software necessità di una base di dati popolata con dei veicoli e un utente amministratore per funzionare. Sarà poi possibile dal software inserire autostrade, relative tariffe e caselli.

Assieme al software è fornito un database già popolato a sufficienza per permettere un utilizzo dimostrativo del programma. Sarà sufficiente, se in locale, importare il database (db_with_examples.sql) contenuto nel file sql assegnando al database il nome GreenProject. Sarà altrimenti necessario modificare il file di configurazione Settings.config per accedere ad un database remoto o con un nome differente.

All'apertura del software comparirà una schermata di scelta tra uso utente e uso amministratore. Solo per il secondo sarà necessario effettuare un login con queste credenziali;Username:"Yoda",password"Admin".

Nella vista fornita per l'uso utente sarà possibile calcolare il pedaggio. Mentre nella vista fornita per l'amministratore sarà possibile accedere in lettura e scrittura ad autostrade, tariffe e caselli.


Per eseguire il progetto con Eclipse è necessario configurare l'IDE con JDK 10.0.2 e JRE 10.


il comando per far partire l' applicativo è questo;

java  -jar Green_Project-0.0.2-SNAPSHOT-jar-with-dependencies.jar
