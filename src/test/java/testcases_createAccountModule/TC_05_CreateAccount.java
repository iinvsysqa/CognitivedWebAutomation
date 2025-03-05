package testcases_createAccountModule;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.SignUpPage;
import pages.LandingPage;
import pages.LoginPage;
import wrappers.WebApplicationWrappers;

public class TC_05_CreateAccount  extends WebApplicationWrappers {

	LoginPage loginpage;
	LandingPage LandingPage;
	SignUpPage createacpage;
	
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = " TC04 - Checking error toast of Password field ";
		testDescription = "Checking error toast of Password field in Create Account page  \n*wihtout entering any characters  \n *only entering less than 8 characters \n *only entering space";
	}


	@Test
	public void createAccount() throws Exception {
		

		invokeApp("Chrome",loadProp().getProperty("URL"));
		loginpage= new LoginPage(driver);
		LandingPage= new LandingPage(driver);
		createacpage= new SignUpPage(driver);
		
		LandingPage.clickSignUpButton();
		createacpage.clickSignUpButton();
		createacpage.checkPasswordErrMsg0();
		createacpage.enterPassword("abcdefg");
		createacpage.checkPasswordErrMsg0();
		createacpage.clearPasswordfield();
		
		createacpage.enterPassword("        ");
		createacpage.checkPasswordErrMsg2();
		createacpage.clearPasswordfield();
		
		
		
	}
}
