package nLayeredDemo.Business;

import java.util.List;

import nLayeredDemo.Entities.Users;

public interface VerificationUsersService {
	boolean nameCheck(String name);
	boolean passwordCheck(String password);
	boolean emailCheck(Users user,List<Users> kullanýcýlar);
}
