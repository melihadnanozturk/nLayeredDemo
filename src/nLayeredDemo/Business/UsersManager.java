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
			System.out.println("Eposta ile l�tfen do�rulay�n-do�ruland�.");
			System.out.println(user.getName()+" "+user.getEmail()+"  Bilgili kullan�c� olu�turuldu");
		}else if(verification.emailCheck(user, userDao.getall())==false){
			System.out.println("L�tfen kullan�lmayan eposta giriniz");
		}
			else {
				System.out.println("L�tfen en az 6 haneli �ifre veya en az 2 basamakl� isim giriniz");
		}
			
		}
		


	@Override
	public void enter(String email, String password) {
		boolean a=true;
		for(Users kullan�c�:userDao.getall()) {
			if(kullan�c�.getEmail()==email && kullan�c�.getPassword()==password) {
				System.out.println(kullan�c�.getName()+" "+kullan�c�.getEmail()+" *Giri� ba�ar�l�*");
			}else {
				a=false;
			}
			
			if(a==false) {
				System.out.println("Ge�ersiz Bilgiler");
			}
		}
		
	}


	@Override
	public void saveWithGoogle(Users user) {
		if(verification.nameCheck(user.getName()) && verification.passwordCheck(user.getPassword())&& verification.emailCheck(user, userDao.getall())) {
			otherService.saveWithOtherervice(user.getEmail(), user.getPassword());
			userDao.save(user);
			System.out.println(user.getName()+" "+user.getEmail()+"  Bilgili kullan�c� olu�turuldu");
		}else if(verification.emailCheck(user, userDao.getall())==false){
			System.out.println("L�tfen kullan�lmayan eposta giriniz");
		}
			else {
				System.out.println("L�tfen en az 6 haneli �ifre veya en az 2 basamakl� isim giriniz");
		}
			
		}


	@Override
	public void enterWithGoogle(String email, String password) {
		for(Users kullan�c�:userDao.getall()) {
			if(kullan�c�.getEmail()==email && kullan�c�.getPassword()==password) {
				System.out.println(kullan�c�.getName()+" "+kullan�c�.getEmail()+" *Google hesap sahibi*");
				otherService.enterWithOtherervice(email, password);
				
			}else {
				System.out.println("Girilen bilgiler yanl��");
			}
		}
		
	}

		
	}
	
