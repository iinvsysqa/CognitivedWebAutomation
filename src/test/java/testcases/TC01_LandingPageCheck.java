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
<<<<<<< HEAD
		Reporter.reportStep("Browser : Edge ","INFO");
		Reporter.reportStep("Platform : Windows ","INFO");
		launchApplication(baseUrl);
=======
		Reporter.reportStep("Browser : Edge ","USER_INFO");
		Reporter.reportStep("Platform : Windows ","USER_INFO");
		launchApplication(loadProp().getProperty("URL"));
>>>>>>> 168e6fec064d4fff4dc56a630b4be6d9624d5c31
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
