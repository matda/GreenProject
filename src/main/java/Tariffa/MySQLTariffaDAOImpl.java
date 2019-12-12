package Tariffa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import Tariffa.Tariffa;
import Tariffa.TariffaDAO;
import autostrada.Autostrada;
import dao.MySQLDAOFactory;

public class MySQLTariffaDAOImpl implements TariffaDAO {
	
	public static final String GET_TARIFFA_FROM_ID_AUTOSTRADA = "SELECT classe_veicolo, prezzo FROM tariffa WHERE id_autostrada = ?";
	public static final String DELETE_QUERY = "DELETE FROM tariffa WHERE id_autostrada= ?  AND classe_veicolo = ?";
	public static final String CREATE_QUERY = "INSERT INTO tariffa ( id_autostrada, classe_veicolo, prezzo ) VALUES (?,?,?)";
	
	
	//DELETE_QUERY
	public boolean deleteTariffa(Tariffa tariffa) {
		Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = MySQLDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(DELETE_QUERY);
            preparedStatement.setInt(1, tariffa.getIdAutostrada());
            preparedStatement.setString(2, tariffa.getClasseVeicolo());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        return false;
	}
	
	//CREATE_QUERY
	public int createTariffa(Tariffa tariffa) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MySQLDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, tariffa.getIdAutostrada());
            preparedStatement.setString(2, tariffa.getClasseVeicolo());
            preparedStatement.setDouble(3, tariffa.getPrezzo());
            preparedStatement.execute();
            result = preparedStatement.getGeneratedKeys();
 
            if (result.next() && result != null) {
                return result.getInt(1);
            } else {
                return -1;
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
 
        return -1;
    }
	
	//GET_TARIFFA_FROM_ID_AUTOSTRADA
	public HashMap<String,Float> getTariffaFromIdAutostrada(int id){
		
		HashMap<String,Float> tariffa= new HashMap<String,Float>();
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MySQLDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(GET_TARIFFA_FROM_ID_AUTOSTRADA);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
 
			if ( result.next() != false ) {
				do {
					tariffa.put ( result.getString("classe_veicolo"), result.getFloat("prezzo") );
				} while( result.next() );
			} else {
				throw new Exception ( "Cant retrieve tariffe from autostrada exception" );
			}
		
			
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
			// TODO Auto-generated catch block
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
 
        return tariffa;
	}
	

}
