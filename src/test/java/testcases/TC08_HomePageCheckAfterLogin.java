package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LandingPageNew;
import pages.SignInPage;
import pages.SignInPageNew;
import pages.CoursesPage;
import pages.HomePage;
import utils.Reporter;
import wrappers.WebApplicationWrappers;

public class TC08_HomePageCheckAfterLogin extends WebApplicationWrappers {
	SignInPageNew signInPagenew;
	LandingPageNew landingpagenew;
	CoursesPage userhomepage;
	HomePage homepage;

	@BeforeClass
	public void startTestCase() {
		testCaseName = " TC08 - Check user new Home page";
		testDescription = " Navigate to user Home page and check Video is Playing and testimonilas scrollable ";
	}

	Boolean bReturn;

	@Test
	public void TC08_HomePage_Check_After_Login() throws InterruptedException {
		initDriver("Windows", "edge");
		Reporter.reportStep("Browser : Edge ", "USER_INFO");
		Reporter.reportStep("Platform : Windows ", "USER_INFO");
		launchApplication(loadProp().getProperty("URL"));
		landingpagenew = new LandingPageNew(driver);
		homepage = new HomePage(driver);
		signInPagenew = new SignInPageNew(driver);

		landingpagenew.clickLoginButton();
		signInPagenew.checkSignInPageTopic("Sign In");
		Thread.sleep(3000);
		signInPagenew.signInUser("iinvsysqa@gmail.com", "Welcome@123");
		homepage.checkUserInUserHomePage();
		// landingpagenew.playPauseVideo();
		bReturn = landingpagenew.checkSemiCircleVideoPlaying(" Semi Circle Video ");
		bReturn = landingpagenew.checkBackGroundVideoPlaying(" Background Video ");
		// bReturn= landingpagenew.checkLandingPageDemoVideoPlaying(" Landing Page Demo
		// Video ");

		landingpagenew.checkTestimonialScroll();
		Assert.assertTrue(bReturn, "One or more steps failed — check the logs.");
	}

}
