package nLayeredDemo.Business;

import java.util.ArrayList;
import java.util.List;

import nLayeredDemo.Dao.UsersDao;
import nLayeredDemo.Entities.Users;

public class VerificationUserManager implements VerificationUsersService{

	public UsersDao users;
	public List<String> emails=new ArrayList<>();

	public VerificationUserManager(UsersDao users) {
		this.users = users;
	}

	@Override
	public boolean nameCheck(String name) {
		if(name.length()>=2) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean passwordCheck(String password) {
		if(password.length()>=6) {
			return true;
		}else {
			return false;
			}}


	@Override
	public boolean emailCheck(Users user, List<Users> kullanýcýlar) {
				List<String>emailList=new ArrayList<String>();
				
				for(Users listeK:kullanýcýlar) {
					emailList.add(listeK.getEmail());
				}
				
				if(emailList.contains(user.getEmail())) {
					return false;
				}else {
					return true;
				}
	}
	
}