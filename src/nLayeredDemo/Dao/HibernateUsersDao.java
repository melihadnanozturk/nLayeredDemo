package nLayeredDemo.Dao;

import java.util.ArrayList;
import java.util.List;

import nLayeredDemo.Entities.Users;

public class HibernateUsersDao implements UsersDao{
	
	public List<Users> liste=new ArrayList<>();
	

	@Override
	public void save(Users user) {
		liste.add(user);
		
	}

	@Override
	public List<Users> getall() {
		return liste;
	}

	@Override
	public Users getByEmailAndPassword(String email, String password) {
		
		//V.T olmad��� i�in sanki V.T de �ekiyormu� gibi d���n ama s�k�nt� �u ki
		//V.T den almad���n i�in veriyi bir yerden �ekmen laz�m
		//buda olu�turdu�un List ile ger�ekle�iyor
		
		for(Users users:liste) {
			if(users.getEmail()==email && users.getPassword()==password) {
				return users;
			}
		}
		return null;
	}


}
