package Tariffa;

import java.util.HashMap;

public interface TariffaDAO {

	boolean deleteTariffa(Tariffa tariffa);

	int createTariffa(Tariffa tariffa);

	HashMap<String, Float> getTariffaFromIdAutostrada(int idAutostrada);

}
