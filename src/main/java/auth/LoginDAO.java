package auth;

public interface LoginDAO {

	Admin getAdmin(String username, String password);

}
