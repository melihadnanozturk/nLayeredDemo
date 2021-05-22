package nLayeredDemo.Business;

import nLayeredDemo.Entities.Users;

public interface UsersService {
	void save(Users user);
	void saveWithGoogle(Users user);
	void enter(String email,String password);
	void enterWithGoogle(String email,String password);
}
