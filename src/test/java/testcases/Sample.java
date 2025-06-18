package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LandingPageNew;
import utils.Reporter;
import wrappers.WebApplicationWrappers;

public class Sample extends WebApplicationWrappers {
	LandingPageNew landingpagenew;
	
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = " TC01 - Landing Page Check ";
		testDescription = " Navigate to Landing Page and check Video is Playing and testimonilas scrollable ";
	}


	@Test(retryAnalyzer = utils.RetryListener.class)
	public void TC01_Landing_Page_Check() throws InterruptedException {
		initDriver("Windows","edge");
		Reporter.reportStep("Browser : Edge ","USER_INFO");
		Reporter.reportStep("Platform : Windows ","USER_INFO");
		launchApplication("https://pixabay.com/videos/desert-dunes-sand-namibia-nature-284566/");
		landingpagenew= new LandingPageNew(driver);
		
		/*
		 * landingpagenew.clickgetStartedButton(); driver.navigate().back();
		 * Thread.sleep(3000); landingpagenew.clickgetStartedNowButton();
		 * driver.navigate().back(); landingpagenew.playPauseVideo();
		 */
		
		landingpagenew.checkSemiCircleVideoPlaying(" Semi Circle Video ");
	//	landingpagenew.checkBackGroundVideoPlaying(" Background Video ");
	//	landingpagenew.checkTestimonialScroll();
		
		
		
	}

}
