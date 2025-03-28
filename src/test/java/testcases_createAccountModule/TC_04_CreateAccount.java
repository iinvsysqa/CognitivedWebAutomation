package testcases_createAccountModule;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.SignUpPage;
import pages.LandingPage;
import pages.LoginPage;
import wrappers.WebApplicationWrappers;

public class TC_04_CreateAccount extends WebApplicationWrappers {

	LoginPage loginpage;
	LandingPage LandingPage;
	SignUpPage createacpage;
	
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = " TC04 - Checking error toast of Name field ";
		testDescription = "Checking error toast of Name field in Create Account page ";
	}


	@Test
	public void createAccount() throws Exception {
		

		invokeApp("Chrome",loadProp().getProperty("URL"));
		loginpage= new LoginPage(driver);
		LandingPage= new LandingPage(driver);
		createacpage= new SignUpPage(driver);
		
		LandingPage.clickSignUpButton();
		createacpage.clickSignUpButton();
		createacpage.checkNameErrMsg0();
		createacpage.enterUserName("123456");
		createacpage.clickSignUpButton();
		createacpage.checkNameErrMsg1();
		createacpage.clearnamefield();
		createacpage.enterUserName("@#$%*");
		createacpage.clickSignUpButton();
		createacpage.checkNameErrMsg1();
		createacpage.clearnamefield();
		createacpage.enterUserName("12asdj");
		createacpage.clickSignUpButton();
		createacpage.checkNameErrMsg1();
		createacpage.clearnamefield();
		createacpage.enterUserName("a1");
		createacpage.clickSignUpButton();
		createacpage.checkNameErrMsg1();
		createacpage.clearnamefield();
		createacpage.enterUserName("      ");
		createacpage.clickSignUpButton();
		createacpage.checkNameErrMsg2();
		createacpage.clearnamefield();
		
		
	
	}
		
}
