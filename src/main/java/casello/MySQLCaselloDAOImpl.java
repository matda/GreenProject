package casello;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import autostrada.Autostrada;
import dao.MySQLDAOFactory;

public class MySQLCaselloDAOImpl implements CaselloDAO {

	public static final String GET_BY_ID_QUERY = "SELECT id, id_autostrada, locazione, kilometro FROM casello WHERE id= ? LIMIT 1";
	public static final String CREATE_QUERY="INSERT INTO casello ( locazione, kilometro, id_autostrada ) VALUES (?, ? ,?)";
	public static final String UPDATE_QUERY = "UPDATE casello SET kilometro = ?, locazione = ? WHERE id= ?";
	public static final String GET_ID_BY_AUTOSTRADA_ID_QUERY = "SELECT id FROM casello WHERE id_autostrada = ?";
	public static final String DELETE_QUERY = "DELETE FROM casello WHERE id= ?";
	
	//GET_BY_ID_QUERY
	public Casello getCasello(int id) {
		
		Casello casello= null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MySQLDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(GET_BY_ID_QUERY);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
 
            if (result.next() && result != null) {
            	casello = new Casello(result.getInt(1), result.getString(3), result.getInt(4), result.getInt(2));
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
 
        return casello;
	}
	
	
	
	//CREATE_QUERY
	public int createCasello(Casello casello) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MySQLDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, casello.getLocalita());
            preparedStatement.setInt(2, casello.getKm());
            preparedStatement.setInt(3, casello.getAutostradaId());
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
	
	
	//UPDATE_QUERY
	public boolean updateCasello(Casello casello) {
		
		Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
        	conn = MySQLDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(UPDATE_QUERY);
            preparedStatement.setInt(1, casello.getKm());
            preparedStatement.setString(2, casello.getLocalita());
            preparedStatement.setInt(3, casello.getId());
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
	
	//GET_ID_BY_AUTOSTRADA_ID_QUERY
	public ArrayList<Integer> getIdCaselloByIdAutostrada(int autostradaId) {
		
		ArrayList<Integer> idCaselli = new ArrayList<Integer> ();
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MySQLDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(GET_ID_BY_AUTOSTRADA_ID_QUERY);
            preparedStatement.setInt(1, autostradaId);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
 
    		try {
    			if ( result.next() )
    				do {
    					idCaselli.add ( result.getInt( "id" ));
    				} while ( result.next () );
    		} catch (Exception e) {
    			e.printStackTrace();
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
 
        return idCaselli;
	}
	
	//DELETE_QUERY
	public boolean deleteCasello(int id) {
		Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = MySQLDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(DELETE_QUERY);
            preparedStatement.setInt(1, id);
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
	
	
	
	

}
