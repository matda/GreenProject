package dao;

import utility.Constants;

public abstract class DaoFactory {

	
	// public abstract AutostradaDAO getAutostradaDAO();
	
	
	
	public static DaoFactory getDaoFactory(int database) {
		// TODO Auto-generated constructor stub
		switch(database) {
		
		case Constants.MYSQL:
				return new MySQLDAOFactory();
				
				
	//con il design pattern Abstract Factory decidiamo quale DB utilizzare			
	/*			
		case Constants.ORACLE:
				return new OracleDAOFactory;
				break;
							*/  
		
		default:
			return null;
			
		}
		
	}

}
