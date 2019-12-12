package veicolo;

public class ConcreteVeicolo extends Veicolo {
	

	private int cilindrata;
	private int inquinamentoAcustico;
	private String classeVeicolo;
	private String classeAmbientale;
	
	public ConcreteVeicolo(String targa, String modello, int annoImmatricolazione, int assi, int cilindrata, int inquinamentoAcustico, String classeVeicolo, String classeAmbientale) {
		super(targa,modello,annoImmatricolazione,assi);
		this.cilindrata = cilindrata;
		this.inquinamentoAcustico = inquinamentoAcustico;
		this.classeVeicolo = classeVeicolo;
		this.classeAmbientale = classeAmbientale;
		
	}

	public int getCilindrata() {
		return cilindrata;
	}

	public void setCilindrata(int cilindrata) {
		this.cilindrata = cilindrata;
	}

	public int getInquinamentoAcustico() {
		return inquinamentoAcustico;
	}

	public void setInquinamentoAcustico(int inquinamentoAcustico) {
		this.inquinamentoAcustico = inquinamentoAcustico;
	}

	public String getClasseVeicolo() {
		return classeVeicolo;
	}

	public void setClasseVeicolo(String classeVeicolo) {
		this.classeVeicolo = classeVeicolo;
	}

	public String getClasseAmbientale() {
		return classeAmbientale;
	}

	public void setClasseAmbientale(String classeAmbientale) {
		this.classeAmbientale = classeAmbientale;
	}
	
	
	
	

}
