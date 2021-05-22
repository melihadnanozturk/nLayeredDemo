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
		Users kullanýcý=new Users("Ayþe","Uzunkul","1234567","isimsiz@hotmail.com");
		Users kullanýcý2=new Users("Abdullah","Yatan","1234567","isimsiz2@hotmail.com");
		Users kullanýcý3=new Users("Nizam","Sesigüzel","123456","isimsiz3hotmail.com");
		Users kullanýcý4=new Users("Kamil","Güzelseven","123456","isimsiz4hotmail.com");
		Users kullanýcý5=new Users("Fahriye","Bohcacý","123456","isimsiz5hotmail.com");
		//Google
		IOtherService otherService=new OtherService();
		//VT
		UsersDao userDao=new HibernateUsersDao();
		//Kontrol Business
		VerificationUsersService verification=new VerificationUserManager(userDao);
		//Business
		UsersService usersService=new UsersManager(userDao,verification,otherService);
		
		usersService.save(kullanýcý);
		usersService.enter("isimsiz@hotmail.com","1234567");
		
		System.out.println("********2. kullanýcý**********");
		usersService.save(kullanýcý2);
		usersService.enter("isimsiz2@hotmail.com","1234567");
		
		System.out.println("*********3. kullanýcý**********");
		usersService.save(kullanýcý3);
		usersService.enter("isimsiz3hotmail.com","123456");
		
		System.out.println("******4. kullanýcý*******");
		usersService.saveWithGoogle(kullanýcý4);
		usersService.enterWithGoogle("isimsiz4hotmail.com", "12345");
		//System.out.println("*******5. kullanýcý********");,
		//usersService.saveWithGoogle(kullanýcý5);
		
		

	}

}
