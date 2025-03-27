package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CourseContentPageNew;
import pages.CoursesPage;
import pages.HomePage;
import pages.LandingPageNew;
import pages.SignInPageNew;
import utils.Reporter;
import wrappers.WebApplicationWrappers;

public class TC09_CourseContentPageCheck extends WebApplicationWrappers {
	SignInPageNew signInPagenew;
	LandingPageNew landingpagenew;
	CoursesPage coursespage;
	CartPage cartpage;
	HomePage homepage;
	CourseContentPageNew coursecontentpage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = " TC09 - Check Purchased course pages";
		testDescription = " Check user able to access Purchased course and Play videos ";
	}


	@Test
	public void userHomePageCheck() throws InterruptedException {
		
		initDriver("Windows","chrome");
		Reporter.reportStep("Browser : Chrome ","USER_INFO");
		Reporter.reportStep("Platform : Windows ","USER_INFO");
		landingpagenew= new LandingPageNew(driver);
		signInPagenew=new SignInPageNew(driver);
		coursespage= new CoursesPage(driver);
		cartpage= new CartPage(driver);
		homepage=new HomePage(driver);
		coursecontentpage= new CourseContentPageNew(driver);
		
		launchApplication(loadProp().getProperty("URL"));	
		
		landingpagenew.clickgetStartedButton();
		signInPagenew.signInUser("dharanidharan099@gmail.com","Welcome@12345");
		homepage.checkUserInUserHomePage();
		homepage.clickExploreCourseButton();
		Thread.sleep(3000);
		coursespage.clickCourse1ExploreBtn();
		coursecontentpage.clickFirstTopicTitle();
		coursecontentpage.clickFirstTopicVideo();
		coursecontentpage.playPauseVideo();
	}
}

