package nLayeredDemo.Entities;

public class Users implements Entity{

	private String name;
	private String lastname;
	private String password;
	private String email;
	
	public Users() {
		
	}
	
	public Users(String name, String lastname, String password, String email) {
		this.name = name;
		this.lastname = lastname;
		this.password = password;
		this.email = email;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name==null || name.length()<2) {
			System.out.println("Lütfen en az iki haneli isim giriniz");
		}else {
			this.name = name;
		}
		
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		if(lastname==null ||lastname.length()<2) {
			System.out.println("Lütfen en az iki haneli soyisim giriniz");
		}else {
			this.lastname = lastname;
		}
		
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if(password==null || password.length()<6) {
		System.out.println("Lütfen en az 6 haneli þifre giriniz");
	}else {
		this.password = password;
	}
		}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if(email==null ) {
			System.out.println("Lütfen e-posta giriniz");
		}else {
			this.email = email;
		}
		
	}
	
	
	
	
}
