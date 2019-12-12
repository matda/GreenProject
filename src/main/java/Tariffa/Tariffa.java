package Tariffa;

/**
 *	Class Tariffa
 *	Model for Tariffa relation
 */
public class Tariffa {

	private static String classeVeicolo;
	private static int idAutostrada;
	private int id;
	private double prezzo;
	
	/**
	 * Conctructor method for Tariffa
	 * @param classeVeicolo
	 * @param prezzo
	 * @param idAutostrada
	 */
	public Tariffa ( String classeVeicolo, double prezzo, int idAutostrada ) {
		this.classeVeicolo = classeVeicolo;
		this.prezzo = prezzo;
		this.idAutostrada = idAutostrada;
	}
	/**
	 * Getter for classeVeigolo
	 * @return
	 */
	public static String getClasseVeicolo() {
		return classeVeicolo;
	}
	
	/**
	 * Setter for classe veicolo
	 * @param classeVeicolo
	 */
	public void setClasseVeicolo ( String classeVeicolo ) {
		this.classeVeicolo = classeVeicolo;
	}

	/**
	 * Getter for prezzo
	 * @return prezzo
	 */
	public double getPrezzo ( ) {
		return prezzo;
	}
	
	/**
	 * Setter for prezzo
	 * @param prezzo
	 */
	public void setPrezzo ( double prezzo ) {
		this.prezzo = prezzo;
	}

	/**
	 * Getter for idAutostrada
	 * @return idAutostrada
	 */
	public static int getIdAutostrada() {
		return idAutostrada;
	}
	
	/**
	 * Setter for idAutostrada
	 * @param idAutostrada
	 */
	public void setIdAutostrada ( int idAutostrada ) {
		this.idAutostrada = idAutostrada;
	}

	/**
	 * Getter for id
	 * @return id
	 */
	public int getId ( ) {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
		


	
}
