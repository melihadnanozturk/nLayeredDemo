package nLayeredDemo.Dao;

import java.util.List;

import nLayeredDemo.Entities.Users;

public interface UsersDao {

	void save(Users user);
	List<Users> getall();
	Users getByEmailAndPassword(String email,String password);
	
}
