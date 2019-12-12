package autostrada;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import utility.Database;

/**
 *	Class Autostrada
 *	Model for autostrada relation
 */
public class Autostrada {
	
	private String nome;
	private int id;
	private double iva;
	
	/**
	 * Constructor method that creates a new Autostrada in database
	 * @param nome
	 * @param iva
	 */
	public Autostrada ( int id, String nome, double iva ) {
		this.id = id;
		this.nome = nome;
		this.iva = iva;
	}
	
	public Autostrada (int id) {
		this.id = id;
	}
	
	public Autostrada (String nome, double iva) {
		this.nome = nome;
		this.iva = iva;
	}
	
	/**
	 * Getter for nome
	 * @return nome
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Getter for id
	 * @return id
	 */
	public int getId ( ) {
		return this.id;
	}
	
	/**
	 * Getter for iva
	 * @return iva
	 */
	public Double getIva( ) {
		return this.iva;
	}

	/**
	 * Setter for nome
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	/** 
	 * Setter for iva
	 * @param iva
	 */
	public void setIva ( Double iva ) {
			this.iva = iva;
	}
	
	public void setId (int id) {
		this.id = id;
	}

}
