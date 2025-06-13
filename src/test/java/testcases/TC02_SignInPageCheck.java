package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LandingPageNew;
import pages.SignInPage;
import pages.SignInPageNew;
import pages.CoursesPage;
import pages.HomePage;
import utils.Reporter;
import wrappers.WebApplicationWrappers;

public class TC02_SignInPageCheck extends WebApplicationWrappers {
	SignInPageNew signInPagenew;
	LandingPageNew landingpagenew;
	CoursesPage coursesPage;
	HomePage homepage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = " TC02 - Sign In Functional Check ";
		testDescription = " Sign In with Invalid and Valid creds ";
	}

	@Test
	public void TC02_SignInPage_Check() throws InterruptedException {
		
		initDriver("Windows","chrome");
		Reporter.reportStep("Browser : Chrome ","USER_INFO");
		Reporter.reportStep("Platform : Windows ","USER_INFO");
		landingpagenew= new LandingPageNew(driver);
		signInPagenew=new SignInPageNew(driver);
		coursesPage= new CoursesPage(driver);
		homepage=new HomePage(driver);
		launchApplication(loadProp().getProperty("URL"));	
		
		landingpagenew.clickgetStartedButton();
		signInPagenew.checkvalidemailandpasswordfield("iinvsysqa@gmail.com", "Welcome@123");
		homepage.checkUserInUserHomePage();
		homepage.clickProfileBtn();
		homepage.clickLogOutBtn(); 
	}
}
