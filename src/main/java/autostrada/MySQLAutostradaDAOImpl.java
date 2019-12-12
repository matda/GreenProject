package autostrada;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.MySQLDAOFactory;

public class MySQLAutostradaDAOImpl implements AutostradaDAO {
	
	public static final String GET_ALL_QUERY = "SELECT id, nome, iva FROM autostrada";
	public static final String GET_BY_ID_QUERY = "SELECT id, nome, iva FROM autostrada WHERE id = ? LIMIT 1";
	public static final String DELETE_QUERY = "DELETE FROM autostrada where id = ?";
	public static final String CREATE_QUERY =  "INSERT INTO autostrada ( nome, iva ) VALUES ( ? , ? )";
	public static final String UPDATE_AUTOSTRADA_QUERY = "UPDATE autostrada SET nome = ?, iva = ? WHERE id= ?";
	public static final String GET_IVA_BY_ID_QUERY = "SELECT iva FROM autostrada WHERE id = ?";
	public static final String GET_ID_BY_NAME_QUERY = "SELECT id FROM autostrada WHERE nome= ? LIMIT 1";
	public static final String UPDATE_IVA_BY_ID = "UPDATE autostrada SET iva = ?  WHERE id= ? "; 
	
	
	// GET_ALL_QUERY
	public List getAllAutostrade() {
		
		List autostrade = new ArrayList();
		
		Autostrada autostrada = null;
		Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MySQLDAOFactory.createConnection();            
            preparedStatement = conn.prepareStatement(GET_ALL_QUERY);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
 
            while (result.next()) {            	
            	autostrada = new Autostrada(result.getInt(1), result.getString(2), result.getDouble(3));
            	autostrade.add(autostrada);
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
        
        return autostrade;
	}
	
	
	//GET_BY_ID_QUERY
	public Autostrada getAutostrada(int id) {
		
		Autostrada autostrada= null;
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
                autostrada = new Autostrada(result.getInt(1), result.getString(2), result.getDouble(3));
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
 
        return autostrada;
	}
	
	
	//DELETE_QUERY
	public boolean deleteAutostrada(int id) {
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
	
	//UPDATE_QUERY
	public boolean updateAutostrada(Autostrada autostrada) {
		
		Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
        	conn = MySQLDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(UPDATE_AUTOSTRADA_QUERY);
            preparedStatement.setString(1, autostrada.getNome());
            preparedStatement.setDouble(2, autostrada.getIva());
            preparedStatement.setInt(3, autostrada.getId());
            
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
	
	//GET_IVA_BY_ID_QUERY
	public Double getIvaAutostradaById(int id) {
		
		Double iva = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MySQLDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(GET_IVA_BY_ID_QUERY);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
 
            if (result.next() && result != null) {
                iva = result.getDouble(1);
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
 
        return iva;
	}
	
	//CREATE_QUERY
	public int createAutostrada(Autostrada autostrada) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MySQLDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, autostrada.getNome());
            preparedStatement.setDouble(2, autostrada.getIva());
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
	
	//GET_ID_BY_NAME_QUERY
	public int getIdAutostradaByName(Autostrada autostrada) {
		
		int id = -1;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MySQLDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(GET_ID_BY_NAME_QUERY);
            preparedStatement.setString(1, autostrada.getNome());
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
 
            if (result.next() && result != null) {
                id = result.getInt(1);
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
 
        return id;
	}
	
	//UPDATE_IVA_BY_ID
	public boolean updateIVA(Autostrada autostrada) {
		
		Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
        	conn = MySQLDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(UPDATE_IVA_BY_ID);
            preparedStatement.setDouble(1, autostrada.getIva());
            preparedStatement.setInt(2, autostrada.getId());
                    
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
