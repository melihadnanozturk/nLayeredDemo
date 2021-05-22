package nLayeredDemo.Business;

import java.util.List;

import nLayeredDemo.Core.IOtherService;
import nLayeredDemo.Dao.UsersDao;
import nLayeredDemo.Entities.Users;

public class UsersManager implements UsersService{
	
	public UsersDao userDao;
	public VerificationUsersService verification;
	public IOtherService otherService;
		
	
	public UsersManager(UsersDao userDao,VerificationUsersService verification,IOtherService otherService) {
		this.userDao = userDao;
		this.verification=verification;
		this.otherService=otherService;
	}


	@Override
	public void save(Users user) {
		
		
		if(verification.nameCheck(user.getName()) && verification.passwordCheck(user.getPassword())&& verification.emailCheck(user, userDao.getall())) {
			userDao.save(user);
			System.out.println("Eposta ile lütfen doðrulayýn-doðrulandý.");
			System.out.println(user.getName()+" "+user.getEmail()+"  Bilgili kullanýcý oluþturuldu");
		}else if(verification.emailCheck(user, userDao.getall())==false){
			System.out.println("Lütfen kullanýlmayan eposta giriniz");
		}
			else {
				System.out.println("Lütfen en az 6 haneli þifre veya en az 2 basamaklý isim giriniz");
		}
			
		}
		


	@Override
	public void enter(String email, String password) {
		boolean a=true;
		for(Users kullanýcý:userDao.getall()) {
			if(kullanýcý.getEmail()==email && kullanýcý.getPassword()==password) {
				System.out.println(kullanýcý.getName()+" "+kullanýcý.getEmail()+" *Giriþ baþarýlý*");
			}else {
				a=false;
			}
			
			if(a==false) {
				System.out.println("Geçersiz Bilgiler");
			}
		}
		
	}


	@Override
	public void saveWithGoogle(Users user) {
		if(verification.nameCheck(user.getName()) && verification.passwordCheck(user.getPassword())&& verification.emailCheck(user, userDao.getall())) {
			otherService.saveWithOtherervice(user.getEmail(), user.getPassword());
			userDao.save(user);
			System.out.println(user.getName()+" "+user.getEmail()+"  Bilgili kullanýcý oluþturuldu");
		}else if(verification.emailCheck(user, userDao.getall())==false){
			System.out.println("Lütfen kullanýlmayan eposta giriniz");
		}
			else {
				System.out.println("Lütfen en az 6 haneli þifre veya en az 2 basamaklý isim giriniz");
		}
			
		}


	@Override
	public void enterWithGoogle(String email, String password) {
		for(Users kullanýcý:userDao.getall()) {
			if(kullanýcý.getEmail()==email && kullanýcý.getPassword()==password) {
				System.out.println(kullanýcý.getName()+" "+kullanýcý.getEmail()+" *Google hesap sahibi*");
				otherService.enterWithOtherervice(email, password);
				
			}else {
				System.out.println("Girilen bilgiler yanlýþ");
			}
		}
		
	}

		
	}
	
