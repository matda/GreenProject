package casello;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import autostrada.AutostradaDAO;
import autostrada.MySQLAutostradaDAOImpl;
import dao.DaoFactory;
import utility.Constants;
import utility.Database;

public class CaselloController {
	
	private DaoFactory mysqlFactory = DaoFactory.getDaoFactory(Constants.MYSQL);
	private CaselloDAO caselloDAO = new MySQLCaselloDAOImpl();
	
	public ArrayList<Casello> getCaselliFromAutostrada ( int autostradaId ) {
		
		ArrayList<Integer> idCaselli = caselloDAO.getIdCaselloByIdAutostrada(autostradaId);
		
		ArrayList<Casello> caselli = new ArrayList<Casello> ();
		for(Integer id : idCaselli) {
			caselli.add(caselloDAO.getCasello(id));
		}
		
		return caselli;
	}
	
	
	
	/**
	 * @Override
	 * Saves current object to the database
	 */
	public void save(Casello casello) {

		Casello c;
		if ( casello.getId() != 0 ) {
				 c = caselloDAO.getCasello(casello.getId());

			try {
				if ( c == null) {
					c = new Casello(casello.getLocalita(), casello.getKm(), casello.getAutostradaId());
					if ( caselloDAO.createCasello(c) != 0 )
						this.save(casello);
					else 
						throw new Exception ( "Can not create casello exception" );
				} else {
					/// Result found in query
					caselloDAO.updateCasello(casello);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else 			
				caselloDAO.createCasello(casello);
	}

	/**
	 * Populates current object with database informations
	 * @Override
	 */
	public Casello retrieve ( int id ) throws SQLException{
		
		Casello casello = caselloDAO.getCasello(id);
		if(casello == null) throw new SQLException(Constants.CASELLO_NOT_FOUND_ERROR);
		return casello;
	}

	/**
	 * Deletes current object from database
	 */
	public void destroy(int id) {
		caselloDAO.deleteCasello(id);
	}
}
