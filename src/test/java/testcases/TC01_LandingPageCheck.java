package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LandingPageNew;
import wrappers.WebApplicationWrappers;

public class TC01_LandingPageCheck extends WebApplicationWrappers {
	LandingPageNew landingpagenew;
	
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = " TC01 - Landing Page Check ";
		testDescription = " Navigate to Landing Page and check Video is Playing and testimonilas scrollable ";
	}


	@Test
	public void landingPageValidation() throws InterruptedException {
		
		launchApplication(loadProp().getProperty("URL"));
		
		landingpagenew= new LandingPageNew(driver);
		
		landingpagenew.clickgetStartedButton();
		driver.navigate().back();
		Thread.sleep(3000);
		landingpagenew.clickgetStartedNowButton();
		driver.navigate().back();
		landingpagenew.playPauseVideo();
		landingpagenew.checkTestimonialScroll();
		
		
	}

}
