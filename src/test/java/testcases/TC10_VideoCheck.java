package testcases;

import org.testng.Assert;
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

public class TC10_VideoCheck extends WebApplicationWrappers {
	SignInPageNew signInPagenew;
	LandingPageNew landingpagenew;
	CoursesPage coursespage;
	CartPage cartpage;
	HomePage homepage;
	CourseContentPageNew coursecontentpage;
	CoursesPage coursepage;
	boolean bReturn;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = " TC10 - Check Demo and Purchased Video is Playing";
		testDescription = " Check Demo and Purchase video is palying after Course Purchase ";
	}


	@Test
	public void TC10_Video_Play_Check () throws InterruptedException {
		
		initDriver("Windows","chrome");
		Reporter.reportStep("Browser : Chrome ","USER_INFO");
		Reporter.reportStep("Platform : Windows ","USER_INFO");
		landingpagenew= new LandingPageNew(driver);
		signInPagenew=new SignInPageNew(driver);
		coursespage= new CoursesPage(driver);
		cartpage= new CartPage(driver);
		homepage=new HomePage(driver);
		coursepage= new CoursesPage(driver);
		coursecontentpage= new CourseContentPageNew(driver);
		
		launchApplication(loadProp().getProperty("URL"));	
		landingpagenew.clickgetStartedButton();
		signInPagenew.signInUser("iinvsysqa@gmail.com","Welcome@123");
		homepage.checkUserInUserHomePage();
		cartpage.checkItemsAddedtoCart();
		homepage.clickExploreCourseButton();
		Thread.sleep(3000);
		coursespage.clickCourse1ExploreBtn();
		bReturn=coursecontentpage.checkCoursePageDemoVideoPlaying(" Course Demo Video ");
		Thread.sleep(2000);
		coursepage.clickProfileBtn();
		coursepage.clickLogOutBtn(); 
		landingpagenew.clickgetStartedButton();
		signInPagenew.signInUser("dharanidharan099@gmail.com","Welcome@12345");
		homepage.checkUserInUserHomePage();
		homepage.clickExploreCourseButton();
		Thread.sleep(3000);
		coursespage.clickCourse1ExploreBtn();
		coursecontentpage.clickFirstTopicTitle();
		coursecontentpage.clickFirstTopicVideo();
		//coursecontentpage.playPauseVideo();
		bReturn=coursecontentpage.checkCourseVideoPlaying(" Course Video ");
		Assert.assertTrue(bReturn, "One or more steps failed — check the reports.");
}
}
