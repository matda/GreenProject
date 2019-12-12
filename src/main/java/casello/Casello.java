package casello;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;

import utility.Constants;
import utility.Database;

/**
 *	Class Casello
 *	Model for casello relation
 */
public class Casello {

	private String localita;
	private int km;
	private int id;
	private int autostradaId;
		
	/**
	 * Casello constructor
	 * Instantiates a new casello object
	 * @param localita
	 * @param km
	 * @param autostradaId
	 */

	
	public Casello ( int id, String localita, int km, int autostradaId ) {
		this.localita = localita;
		this.km = km;	
		this.autostradaId = autostradaId;
		this.id = id;
	}
	
	public Casello (String localita, int km, int autostradaId ) {
		this.localita = localita;
		this.km = km;	
		this.autostradaId = autostradaId;
	}
	
	public Casello (int id) {
		this.id = id;
	}
	
	
	/**
	 * Getter for id
	 * @return id
	 */
	public int getId ( ) {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	/**
	 * Getter for localit�
	 * @return localita
	 */
	public String getLocalita() {
		return localita;
	}
	
	/**
	 * Setter for localita
	 * @param localita
	 */
	public void setLocalita(String localita) {
		this.localita = localita;
	}
	

	/**
	 * Getter for autostradaId
	 * @return autostradaId
	 */
	public int getAutostradaId() {
		return autostradaId;
	}
	
	/**
	 * Setter for autostradaId
	 * @param autostradaId
	 */
	public void setAutostradaId(int autostradaId) {
		this.autostradaId = autostradaId;
	}
	
	/**
	 * Getter for km
	 * @return km
	 */
	public int getKm() {
		return km;
	}

	/**
	 * Setter for km
	 * @param km
	 */
	public void setKm(int km) {
		this.km = km;
	}
	


}
