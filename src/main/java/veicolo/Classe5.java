/**
 * 
 */
package veicolo;

/**
 * @author Luca
 *
 */
public class Classe5 extends Veicolo {

	/**
	 * 
	 */
	protected Classe5() {}
	
	//Costruttore fino al 2021
	public Classe5(String targa, String modello, int annoImmatricolazione, int assi) {
		// TODO Auto-generated constructor stub
		super(targa,modello,annoImmatricolazione,assi);
		//if(annoImmatricolazione > 2021) throw new IllegalArgumentException("Costruttore errato per questo anno di immatricolazione");
	}
	
	//Costruttore dal 2021
	public Classe5(String targa, String modello, int annoImmatricolazione, int assi, String classeAmbientale, int inquinamentoAcustico) {
		super(targa, modello, annoImmatricolazione, assi, classeAmbientale, inquinamentoAcustico);
		//if(annoImmatricolazione <= 2021) throw new IllegalArgumentException("Costruttore errato per questo anno di immatricolazione");
	}
}
