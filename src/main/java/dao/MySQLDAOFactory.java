package dao;



import java.sql.*;

import auth.LoginDAO;
import auth.MySQLLoginDAOImpl;
import autostrada.AutostradaDAO;
import autostrada.MySQLAutostradaDAOImpl;
import casello.CaselloDAO;
import casello.MySQLCaselloDAOImpl;
import Tariffa.MySQLTariffaDAOImpl;
import Tariffa.TariffaDAO;
import veicolo.MySQLVeicoloDAOImpl;
import veicolo.VeicoloDAO;


public class MySQLDAOFactory extends DaoFactory {

	

	public static Connection createConnection() {
		
		Connection conn = null; 
        try {
        	
            conn = DriverManager.getConnection(
            		"jdbc:mysql://" 
 						   + settings.Config.DB_CONNECTION_SERVER + "/" 
 						   + settings.Config.DB_CONNECTION_DBNAME 
 						   + "?useSSL=false" 
 						   + "&user=" + settings.Config.DB_CONNECTION_DBUSERNAME 
 						   + "&password=" + settings.Config.DB_CONNECTION_DBPASSWORD
            		);
            return conn;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
	}
	
	public AutostradaDAO getAutostradaDao() {
		return new MySQLAutostradaDAOImpl();
	}
	
	public CaselloDAO getCaselloDao() {
		return new MySQLCaselloDAOImpl();
	}
	
	public TariffaDAO getTariffaDao() {
		return new MySQLTariffaDAOImpl();
	}
	
	public VeicoloDAO getVeicoloDao() {
		return new MySQLVeicoloDAOImpl();
	}
	
	public LoginDAO getLoginDao() {
		return new MySQLLoginDAOImpl();
	}

}
