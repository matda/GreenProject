package autostrada;

import java.util.ArrayList;
import java.util.List;

public interface AutostradaDAO {

	List getAllAutostrade();

	boolean updateAutostrada(Autostrada a);
	
	Double getIvaAutostradaById(int id);

	int getIdAutostradaByName(Autostrada autostrada);

	int createAutostrada(Autostrada autostrada);

	boolean updateIVA(Autostrada autostrada);

	boolean deleteAutostrada(int id);

	Autostrada getAutostrada(int id);
	

}
