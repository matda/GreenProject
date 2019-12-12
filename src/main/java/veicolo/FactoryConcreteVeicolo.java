package veicolo;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *Abstract factory used for generating an object of type "Veicolo"
 **/
public class FactoryConcreteVeicolo {
	public FactoryConcreteVeicolo() {}
	/***
	 *Method that generates a Veicolo of a certain type trough the abstract class Veicolo; this method also populates the instance generated
	 *@param ResultSet ogg: This method takes a result set of a single record that describes a Veicolo and uses the data for generating the object
	 *@throws Exception
	 *@return  Veicolo returnVal: It returns a generic Veicolo that has a Veicolo of a certain category inside
	 **/
	public static Veicolo getVeicolo(ConcreteVeicolo concreteVeicolo) throws Exception {
		
		String type = concreteVeicolo.getClasseVeicolo();
		Veicolo veicolo = null;

		switch(type) {
		case "A":
			veicolo=new ClasseA();
			break;
		case "B":
			veicolo=new ClasseB();
			break;
		case "3":
			veicolo=new Classe3();
			break;
		case "4":
			veicolo=new Classe4();
			break;
		case "5":
			veicolo=new Classe5();
			break;
		default: throw new Exception("No type of vehicle exception");
	}
	
		veicolo.setTarga(concreteVeicolo.getTarga());
		veicolo.setModello(concreteVeicolo.getModello());
		veicolo.setAssi(concreteVeicolo.getAssi());
		veicolo.setClasseAmbientale(concreteVeicolo.getClasseAmbientale());
		veicolo.setAnnoImmatricolazione(concreteVeicolo.getAnnoImmatricolazione());
		veicolo.setClasseAmbientale(concreteVeicolo.getClasseAmbientale());
		veicolo.setInquinamentoAcustico(concreteVeicolo.getInquinamentoAcustico());
		
		return veicolo;
}}
