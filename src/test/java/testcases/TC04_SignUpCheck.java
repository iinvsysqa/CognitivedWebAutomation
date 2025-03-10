package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LandingPageNew;
import pages.SignInPageNew;
import pages.SignUpPage;
import utils.Reporter;
import wrappers.WebApplicationWrappers;

public class TC04_SignUpCheck extends WebApplicationWrappers {
	LandingPageNew landingpagenew;
	SignInPageNew signinpagenew;
	SignUpPage signuppage;
	
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = " TC04 -Sign Up Functional Check ";
		testDescription = " Sign Up Page Functional check ";
	}


	@Test
	public void signUpPageCheck() throws Exception {
		
		initDriver("Windows","chrome");
		Reporter.reportStep("Browser : Chrome ","USER_INFO");
		Reporter.reportStep("Platform : Windows ","USER_INFO");
		launchApplication(loadProp().getProperty("URL"));
		
		landingpagenew= new LandingPageNew(driver);
		signinpagenew= new SignInPageNew(driver);
		signuppage= new SignUpPage(driver);
		
		landingpagenew.clickgetStartedButton();
		signinpagenew.clickSignUpBtn();
		signuppage.signUpCheck();
		
		
	}

}
