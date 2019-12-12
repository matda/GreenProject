package autostrada;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dao.DaoFactory;
import Tariffa.Tariffa;
import Tariffa.TariffaController;
import utility.Constants;

/**
 * Autostrada's controller
 */
public class AutostradaController {
	
	private DaoFactory mysqlFactory = DaoFactory.getDaoFactory(Constants.MYSQL);
	private AutostradaDAO autostradaDAO = new MySQLAutostradaDAOImpl();

	
	/**
	 * Method that gets every single Autostrada in the database
	 * @return Returns an ArrayList<Autostrada>
	 */
	public List getAutostrade() { 
		ArrayList<Autostrada> autobahn = new ArrayList<Autostrada>();
		autobahn = (ArrayList<Autostrada>) autostradaDAO.getAllAutostrade();
		return autobahn;
	}
	/**
	 * Method to edit an autostrada with the given tariffs
	 * @param idAutostrada: The id of the Autostrada's record to edit
	 * @param nomeNuovo: New name for the highway
	 * @param tariffeNuove: Map of tariffs
	 **/
	public void editAutostradaWithTariff ( int idAutostrada, String nomeNuovo, Map <String,Float> tariffeNuove ) {
		try {
			
			/// Modifica nome autostrada
			Autostrada autostrada = new Autostrada (idAutostrada, nomeNuovo, autostradaDAO.getIvaAutostradaById(idAutostrada));
			this.save(autostrada);
			
			/// Inserimento tariffe
			TariffaController tariffaController = new TariffaController();
			Tariffa ta = new Tariffa ( "A", tariffeNuove.get( "A" ), idAutostrada );
			tariffaController.save(ta);
			
			Tariffa tb = new Tariffa ( "B", tariffeNuove.get( "B" ), idAutostrada );
			tariffaController.save(tb);
			
			Tariffa t3 = new Tariffa ( "3", tariffeNuove.get( "3" ), idAutostrada );
			tariffaController.save(t3);
			
			Tariffa t4 = new Tariffa ( "4", tariffeNuove.get( "4" ), idAutostrada );
			tariffaController.save(t4);
			
			Tariffa t5 = new Tariffa ( "5", tariffeNuove.get( "5" ), idAutostrada );
			tariffaController.save(t5);
			
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		
		
	}
	

	
	/**
	 * Method that adds an Autostrada with the related tariffs
	 * @param nomeNuovo: The Autostrada's name
	 * @param tariffeNuove:A map from the categories (String) to the tariffs (Float)   
	 **/
	public void addAutostradaWithTariff ( String nomeNuovo, Map <String,Float> tariffeNuove ) {
		Autostrada autostrada = new Autostrada ( nomeNuovo, 22 );
		this.save(autostrada);	
		editAutostradaWithTariff ( autostrada.getId(), autostrada.getNome(), tariffeNuove );
	}
	

	
	/**
	 * @Override
	 * Method for the delete of a record
	 * @param id: id of the record that needs to be removed 
	 **/
	public void deleteRecord ( int id ) {
		try {
			Autostrada autostrada = autostradaDAO.getAutostrada(id);
			if(autostrada == null) {
				throw new Exception( "The id that you have supplied does not correspond to an existing Autostrada" );
			}
			autostradaDAO.deleteAutostrada(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void save (Autostrada autostrada) {
		/***
		 * DB Schema for Autostrada:
		 *  id BIGINT AUTO_INCREMENT,
      	 *	nome VARCHAR ( 255 ) NOT NULL,
      	 *  iva NOT NULL,
      	 *  PRIMARY KEY ( id )
		 */
		
		/** Acknowledgement of previous existence of the same instance of autostrada **/
		if ( autostrada.getId() == 0 ) {
			try {
				int id = autostradaDAO.getIdAutostradaByName(autostrada);
				
				/** If result set is empty, go for insert query **/
				if ( id == -1 ) {

					if ( autostradaDAO.createAutostrada(autostrada) != -1) {
						this.save(autostrada);
					} else {
						throw new Exception ( "Cant save Autostada exception!" );
					}
				} else {
					/// Result found in query
					autostrada.setId(id);
					autostradaDAO.updateIVA(autostrada);
					
				}
			    
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
				autostradaDAO.updateAutostrada(autostrada);
		}
	}
	
	
	public Autostrada retrieve ( int id ) {
		
		Autostrada autostrada = autostradaDAO.getAutostrada(id);
		return autostrada;
	}
	


}
