package veicolo;

import java.sql.ResultSet;

import autostrada.AutostradaDAO;
import autostrada.MySQLAutostradaDAOImpl;
import dao.DaoFactory;
import utility.Constants;
import utility.Database;
/**
 *Veicolo's Controller
 **/
public class VeicoloController {
	
	private DaoFactory mysqlFactory = DaoFactory.getDaoFactory(Constants.MYSQL);
	private static VeicoloDAO veicoloDAO = new MySQLVeicoloDAOImpl();
	
	/**
	 *Get a vehicle from a given license plate
	 *@param targa: license plate that is used for the researcj
	 *@return Veicolo ret: object of type Veicolo (Vehicle) 
	 **/
	public static Veicolo getVeicolo (String targa ) {
		ConcreteVeicolo concreteVeicolo=null;
		Veicolo veicolo = null;
		try {
			concreteVeicolo = veicoloDAO.getVeicolo(targa);
			veicolo = FactoryConcreteVeicolo.getVeicolo(concreteVeicolo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return veicolo;
	}
}
	
	

