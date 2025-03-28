package testcases_createAccountModule;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.SignUpPage;
import pages.LandingPage;
import pages.LoginPage;
import wrappers.WebApplicationWrappers;

public class TC_03_CreateAccount extends WebApplicationWrappers{

	LoginPage loginpage;
	LandingPage LandingPage;
	SignUpPage createacpage;
	
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = " TC03 - Checking error toast of Email field ";
		testDescription = "Checking error toast  of Email field in Create Account page";
	}


	@Test
	public void createAccount() throws Exception {
		invokeApp("Chrome",loadProp().getProperty("URL"));
		loginpage= new LoginPage(driver);
		LandingPage= new LandingPage(driver);
		createacpage= new SignUpPage(driver);
		
		LandingPage.clickSignUpButton();
		createacpage.clickSignUpButton();
		createacpage.checkEmailErrMsg0();
		createacpage.enterEmailId("ash@gmailcom");
		createacpage.clickSignUpButton();
		createacpage.checkEmailErrMsg1();
		createacpage.clearemailfield();
		createacpage.enterEmailId("ash.gmail.com");
		createacpage.clickSignUpButton();
		createacpage.checkEmailErrMsg1();
		createacpage.clearemailfield();
		createacpage.enterEmailId("ashgmailcom");
		createacpage.clickSignUpButton();
		createacpage.checkEmailErrMsg1();
		createacpage.clearemailfield();
	
    }
}