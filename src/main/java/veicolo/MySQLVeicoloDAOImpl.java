package veicolo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import autostrada.Autostrada;
import dao.MySQLDAOFactory;

public class MySQLVeicoloDAOImpl implements VeicoloDAO {
	
	public static final String GET_VEICOLO_BY_TARGA_QUERY = "SELECT id, targa, modello, assi, classe_veicolo, classe_ambientale, anno_immatricolazione, cilindrata, inquinamentoAcustico FROM veicolo where targa = ? ";
	
	
	//GET_VEICOLO_BY_TARGA_QUERY 
	public ConcreteVeicolo getVeicolo(String targa) {
		
		ConcreteVeicolo veicolo= null;
		
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MySQLDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(GET_VEICOLO_BY_TARGA_QUERY);
            
            preparedStatement.setString(1, targa);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
 
            if (result.next() && result != null) {
                veicolo = new ConcreteVeicolo(result.getString(2), result.getString(3), result.getInt(7), result.getInt(4), result.getInt(8), result.getInt(9), result.getString(5), result.getString(6));
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
                rse.printStackTrace();
            }
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                conn.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }
 
        return veicolo;
	}
	
}
