package nLayeredDemo.Core;

import nLayeredDemo.Google.GoogleEmail;

public class OtherService implements IOtherService{

	GoogleEmail google=new GoogleEmail();
	
	@Override
	public void saveWithOtherervice(String email, String password) {
		google.enterWithGoogle(email, password);
	}

	@Override
	public void enterWithOtherervice(String email, String password) {
		google.enterWithGoogle(email, password);
		
	}

}
