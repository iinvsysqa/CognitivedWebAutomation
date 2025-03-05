package testcases_createAccountModule;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.SignUpPage;
import pages.LandingPage;
import pages.LoginPage;
import wrappers.WebApplicationWrappers;

public class TC_02_CreateAccount extends WebApplicationWrappers {

	LoginPage loginpage;
	LandingPage LandingPage;
	SignUpPage createacpage;
	
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = " TC02 - Checking placeholders of Create Account ";
		testDescription = " Checking placeholders of Create Account in Student Website ";
	}


	@Test
	public void createAccount() throws Exception {
		invokeApp("Chrome",loadProp().getProperty("URL"));
		loginpage= new LoginPage(driver);
		LandingPage= new LandingPage(driver);
		createacpage= new SignUpPage(driver);
		
		LandingPage.clickSignUpButton();
		//createacpage.checkacnttxt();
		createacpage.checkemailtxt();
		createacpage.checknametxt();
		createacpage.checkpasswordtxt();;
		createacpage.checkconfirmpasswordtxt();;
		createacpage.checkTCtext();
				
     }
}
