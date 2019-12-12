/**
 * 
 */
package veicolo;

/**
 * @author Luca
 *
 */
public class ClasseA extends Veicolo {
	
	private int cilindrata;
	public ClasseA() {}
	
	//costruttore fino al 2026
	public ClasseA(String targa, String modello, int annoImmatricolazione, int assi) throws IllegalArgumentException{
		super(targa,modello,annoImmatricolazione,assi);
		//if(annoImmatricolazione > 2026) throw new IllegalArgumentException("Costruttore errato per questo anno di immatricolazione");
	}
	
	//costruttore per moto (senza assi) fino al 2026
	public ClasseA(String targa, int cilindrata, String modello, int annoImmatricolazione) {
		super(targa,modello,annoImmatricolazione);
		this.cilindrata = cilindrata;
		//if(annoImmatricolazione > 2026) throw new IllegalArgumentException("Costruttore errato per questo anno di immatricolazione");
	}
	
	//costruttore dal 2026
	public ClasseA(String targa, String modello, int annoImmatricolazione, int assi, String classeAmbientale, int inquinamentoAcustico) {
		super(targa, modello, annoImmatricolazione, assi, classeAmbientale, inquinamentoAcustico);
		//if(annoImmatricolazione <= 2026) throw new IllegalArgumentException("Costruttore errato per questo anno di immatricolazione");
	}
	
	//costruttore per moto dal 2026
	public ClasseA(String targa, String modello, int annoImmatricolazione, String classeAmbientale, int inquinamentoAcustico, int cilindrata) {
		super(targa, modello,  annoImmatricolazione,  classeAmbientale,  inquinamentoAcustico);
		this.cilindrata = cilindrata;
		//if(annoImmatricolazione <= 2026) throw new IllegalArgumentException("Costruttore errato per questo anno di immatricolazione");
	}

	public int getCilindrata() {
		return cilindrata;
	}

	public void setCilindrata(int cilindrata) {
		this.cilindrata = cilindrata;
	}
	
	
	
	

}
