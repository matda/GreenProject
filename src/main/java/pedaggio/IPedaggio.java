package pedaggio;

import java.util.Map;

import casello.Casello;
import veicolo.Veicolo;

public interface IPedaggio {
	public String calcoloPedaggio(Veicolo veicolo, Casello puntoPagamentoIn, Casello puntoPagamentoOut, Map<String,Float> tariffaUnitaria, double iva);
		
}
