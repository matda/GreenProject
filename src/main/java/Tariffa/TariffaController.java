package Tariffa;

import java.util.HashMap;
import java.util.Map;

import dao.DaoFactory;
import utility.Constants;

public class TariffaController {
	
	
	private DaoFactory mysqlFactory = DaoFactory.getDaoFactory(Constants.MYSQL);
	private TariffaDAO tariffaDAO = new MySQLTariffaDAOImpl();
	
	
	/**
	 * @Override
	 * Saves current object to the database
	 */
	public void save (Tariffa tariffa) {
		/***
		 * DB Schema for Tariffa:
		 *  id BIGINT AUTO_INCREMENT,
      		classe_veicolo ENUM( 'A', 'B', '3', '4', '5' ) NOT NULL,
      		prezzo DECIMAL ( 9, 2 ) NOT NULL,
      		PRIMARY KEY ( id ),
			id_autostrada BIGINT,
		 */
		
		/** Acknowledgement of previous existence of the same instance of Tariffa **/
		
			/// Sostituizione precedente Tariffa con nuova previa eliminazione
			tariffaDAO.deleteTariffa(tariffa);
			//Database.getConnectionStatement ( ).executeUpdate ( "DELETE FROM Tariffa WHERE id_autostrada=" + "'" + this.idAutostrada + "' AND classe_veicolo =" + "'" + this.classeVeicolo + "'" );
			
			/** If result set is empty, go for insert query **/
			tariffaDAO.createTariffa(tariffa);
			/*Database.getConnectionStatement().executeUpdate ("INSERT INTO Tariffa ( id_autostrada, classe_veicolo, prezzo ) "
					+ "VALUES ('" + this.idAutostrada + "','" + this.classeVeicolo + "', '" + this.prezzo + "')");
			*/
	}
	
	/**
	 * Fetches the tariffs from a given Autostrada
	 * @param idAutostrada Autostrada's Id passed from the view
	 * @return This method returns A map that maps  categories (String) to  tariffs (Float)  
	 **/
	public Map<String,Float> getAutostradeTariffe ( int idAutostrada ) {
		HashMap<String,Float> classToTariffs = tariffaDAO.getTariffaFromIdAutostrada(idAutostrada);
		return classToTariffs;
	}
	
	
	
	
	
	
	
	
	
	
	
	

	
//	/**
//	 * Populates current object with database informations
//	 * @Override
//	 */
//
//	public void retrieve ( int id ) {
//		try {
//			ResultSet rs = Database.getConnectionStatement().executeQuery ( "SELECT id, id_autostrada, classe_veicolo, prezzo FROM Tariffa WHERE id='" + id + "' LIMIT 1" );
//			
//			/** If result set is empty, go for insert query **/
//			if ( rs.next() == false ) {
//				throw new Exception ( "Tariffa not found Exception" );
//			} else {
//				/// Result found in query
//				this.idAutostrada = rs.getInt ( "id_autostrada" );
//				this.classeVeicolo = rs.getString ( "classe_veicolo" );
//				this.prezzo = rs.getInt( "prezzo" );
//				this.id = rs.getInt ( "id" );
//			}
//		    
//			rs.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

//	
//	/**
//	 * Deletes current object from database
//	 */
//	public void destroy ( ) {
//		try {
//			Database.getConnectionStatement().executeUpdate ( "DELETE FROM Tariffa WHERE id='" + this.getId() + "'" );
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

}
