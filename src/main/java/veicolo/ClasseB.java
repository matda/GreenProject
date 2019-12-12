/**
 * 
 */
package veicolo;

/**
 * @author Luca
 *
 */
public class ClasseB extends Veicolo {

	/**
	 * 
	 */
	protected ClasseB() {}
	
	//Costruttore fino al 2021
	public ClasseB(String targa, String modello, int annoImmatricolazione, int assi) {
		super(targa,modello,annoImmatricolazione,assi);
		//if(annoImmatricolazione > 2021) throw new IllegalArgumentException("Costruttore errato per questo anno di immatricolazione");
	}
	
	//Costruttore dal 2021
	public ClasseB(String targa, String modello, int annoImmatricolazione, int assi, String classeAmbientale, int inquinamentoAcustico) {
		super(targa, modello, annoImmatricolazione, assi, classeAmbientale, inquinamentoAcustico);
		//if(annoImmatricolazione <= 2021) throw new IllegalArgumentException("Costruttore errato per questo anno di immatricolazione");
	}

	

}
