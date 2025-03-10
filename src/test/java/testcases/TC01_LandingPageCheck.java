package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LandingPageNew;
import io.github.cdimascio.dotenv.Dotenv;
import utils.Reporter;
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
		 Dotenv dotenv = Dotenv.load();

	        // Access the environment variables
	     String baseUrl = dotenv.get("URL");
		initDriver("Windows","edge");
		Reporter.reportStep("Browser : Edge ","INFO");
		Reporter.reportStep("Platform : Windows ","INFO");
		launchApplication(baseUrl);
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
