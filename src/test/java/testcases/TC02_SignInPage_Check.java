package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LandingPageNew;
import pages.SignInPage;
import pages.SignInPageNew;
import pages.UserHomePage;
import utils.Reporter;
import wrappers.WebApplicationWrappers;

public class TC02_SignInPage_Check extends WebApplicationWrappers {
	SignInPageNew signInPagenew;
	LandingPageNew landingpagenew;
	UserHomePage userhomepage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = " TC02 - Sign In Functional Check ";
		testDescription = " Sign In with Invalid and Valid creds ";
	}


	@Test
	public void signInPageCheck() throws InterruptedException {
		
		initDriver("Windows","chrome");
		Reporter.reportStep("Browser : Chrome ","USER_INFO");
		Reporter.reportStep("Platform : Windows ","USER_INFO");
		landingpagenew= new LandingPageNew(driver);
		signInPagenew=new SignInPageNew(driver);
		userhomepage= new UserHomePage(driver);
		launchApplication(loadProp().getProperty("URL"));	
		
		landingpagenew.clickgetStartedButton();
		signInPagenew.checkvalidemailandpasswordfield("iinvsysqa@gmail.com", "Welcome@123");
		userhomepage.checkUserInUserHomePage();
		userhomepage.clickProfileBtn();
		userhomepage.clickLogOutBtn(); 
	}
}
