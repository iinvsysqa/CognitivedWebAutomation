package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LandingPageNew;
import pages.SignInPageNew;
import pages.UserHomePage;
import wrappers.WebApplicationWrappers;

public class TC05_UserHomePageCheck extends WebApplicationWrappers {
	SignInPageNew signInPagenew;
	LandingPageNew landingpagenew;
	UserHomePage userhomepage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = " TC05 - User Home Page functional Check ";
		testDescription = " Login with Valid User and Check Home and Course details Page ";
	}


	@Test
	public void userHomePageCheck() throws InterruptedException {
		
		initDriver("Windows","chrome");
		landingpagenew= new LandingPageNew(driver);
		signInPagenew=new SignInPageNew(driver);
		userhomepage= new UserHomePage(driver);
		launchApplication(loadProp().getProperty("URL"));	
		
		landingpagenew.clickgetStartedButton();
		signInPagenew.signInUser("iinvsysqa@gmail.com","Welcome@123");
		userhomepage.checkUserInUserHomePage();
		userhomepage.clickExploreBtn();
		userhomepage.clickCourseTopicCheck();
		Thread.sleep(2000);
		userhomepage.clickProfileBtn();
		userhomepage.clickLogOutBtn(); 
		
		
	}
}
