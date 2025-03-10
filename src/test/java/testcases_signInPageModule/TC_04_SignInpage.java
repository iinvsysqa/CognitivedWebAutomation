package testcases_signInPageModule;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.SignUpPage;
import pages.LandingPage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.SignInPage;
import wrappers.WebApplicationWrappers;

public class TC_04_SignInpage extends WebApplicationWrappers {

	LoginPage loginpage;
	LandingPage LandingPage;
	SignUpPage createacpage;
	ProfilePage profilepage;
	CartPage cartPage;
	SignInPage signinpage;
	

	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC_04_check SignIN- Password page  ";
		testDescription = "To check SignIN- Password page and its all fields and error messages";
	}


	@Test
	public void SignInpage() throws Exception {
		

		invokeApp("Chrome",loadProp().getProperty("URL"));
		loginpage= new LoginPage(driver);
		LandingPage= new LandingPage(driver);
		createacpage= new SignUpPage(driver);
		profilepage=new ProfilePage(driver);
		cartPage= new CartPage(driver);
		signinpage= new SignInPage(driver);
		
		
		signinpage.checkChangePasswordpageerrormessage();
		signinpage.Resetnewpassword();
		
	}
}
