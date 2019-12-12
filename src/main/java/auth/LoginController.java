package auth;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DaoFactory;
import utility.Constants;
import utility.Database;

public class LoginController {
	
	private DaoFactory mysqlFactory = DaoFactory.getDaoFactory(Constants.MYSQL);
	private LoginDAO loginDAO = new MySQLLoginDAOImpl();
	
	public boolean login ( String username, String password ) {

		Admin admin = loginDAO.getAdmin(username,password);
		if(admin != null)
			return (admin.getUsername().equals(username) && admin.getPassword().equals(password)); // per un maggior livello di sicurezza si può introdurre in futuro una HashFunction per la password
		else
			return false;
	}
	
}
