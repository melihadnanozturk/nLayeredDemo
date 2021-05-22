package nLayeredDemo;

import java.util.ArrayList;
import java.util.List;

import nLayeredDemo.Business.UsersManager;
import nLayeredDemo.Business.UsersService;
import nLayeredDemo.Business.VerificationUserManager;
import nLayeredDemo.Business.VerificationUsersService;
import nLayeredDemo.Core.IOtherService;
import nLayeredDemo.Core.OtherService;
import nLayeredDemo.Dao.HibernateUsersDao;
import nLayeredDemo.Dao.UsersDao;
import nLayeredDemo.Entities.Users;

public class Main {

	public static void main(String[] args) {
		Users kullan�c�=new Users("Ay�e","Uzunkul","1234567","isimsiz@hotmail.com");
		Users kullan�c�2=new Users("Abdullah","Yatan","1234567","isimsiz2@hotmail.com");
		Users kullan�c�3=new Users("Nizam","Sesig�zel","123456","isimsiz3hotmail.com");
		Users kullan�c�4=new Users("Kamil","G�zelseven","123456","isimsiz4hotmail.com");
		Users kullan�c�5=new Users("Fahriye","Bohcac�","123456","isimsiz5hotmail.com");
		//Google
		IOtherService otherService=new OtherService();
		//VT
		UsersDao userDao=new HibernateUsersDao();
		//Kontrol Business
		VerificationUsersService verification=new VerificationUserManager(userDao);
		//Business
		UsersService usersService=new UsersManager(userDao,verification,otherService);
		
		usersService.save(kullan�c�);
		usersService.enter("isimsiz@hotmail.com","1234567");
		
		System.out.println("********2. kullan�c�**********");
		usersService.save(kullan�c�2);
		usersService.enter("isimsiz2@hotmail.com","1234567");
		
		System.out.println("*********3. kullan�c�**********");
		usersService.save(kullan�c�3);
		usersService.enter("isimsiz3hotmail.com","123456");
		
		System.out.println("******4. kullan�c�*******");
		usersService.saveWithGoogle(kullan�c�4);
		usersService.enterWithGoogle("isimsiz4hotmail.com", "12345");
		//System.out.println("*******5. kullan�c�********");,
		//usersService.saveWithGoogle(kullan�c�5);
		
		

	}

}
