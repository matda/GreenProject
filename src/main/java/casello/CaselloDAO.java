package casello;

import java.util.ArrayList;

public interface CaselloDAO {

	Casello getCasello(int id);

	int createCasello(Casello c);

	boolean updateCasello(Casello casello);

	ArrayList<Integer> getIdCaselloByIdAutostrada(int autostradaId);

	boolean deleteCasello(int id);

}
