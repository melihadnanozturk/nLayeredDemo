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
		
		//V.T olmadýðý için sanki V.T de çekiyormuþ gibi düþün ama sýkýntý þu ki
		//V.T den almadýðýn için veriyi bir yerden çekmen lazým
		//buda oluþturduðun List ile gerçekleþiyor
		
		for(Users users:liste) {
			if(users.getEmail()==email && users.getPassword()==password) {
				return users;
			}
		}
		return null;
	}


}
