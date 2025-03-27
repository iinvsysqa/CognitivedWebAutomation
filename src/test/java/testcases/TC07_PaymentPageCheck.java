package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.LandingPageNew;
import pages.SignInPageNew;
import pages.CoursesPage;
import pages.HomePage;
import utils.Reporter;
import wrappers.WebApplicationWrappers;

public class TC07_PaymentPageCheck extends WebApplicationWrappers {
	SignInPageNew signInPagenew;
	LandingPageNew landingpagenew;
	CoursesPage userhomepage;
	CartPage cartpage;
	HomePage homepage;
	
	@BeforeClass
	public void startTestCase() {

		testCaseName = " TC07 - Payment Process check";
		testDescription = " Check user able to progress to Payment page and cancel Payment ";

	}


	@Test
	public void paymentCheck() throws InterruptedException {
		
		initDriver("Windows","chrome");
		Reporter.reportStep("Browser : Chrome ","USER_INFO");
		Reporter.reportStep("Platform : Windows ","USER_INFO");
		landingpagenew= new LandingPageNew(driver);
		signInPagenew=new SignInPageNew(driver);
		userhomepage= new CoursesPage(driver);
		cartpage= new CartPage(driver);
		homepage=new HomePage(driver);
		
		launchApplication(loadProp().getProperty("URL"));	
		
		landingpagenew.clickgetStartedButton();
		signInPagenew.signInUser("iinvsysqa@gmail.com","Welcome@123");
		homepage.checkUserInUserHomePage();
		homepage.clickExploreCourseButton();
		
		userhomepage.checkUserInUserCoursesPage();
		userhomepage.clickCourse1ExploreBtn();
		userhomepage.clickAddtoCartBtn();
		Thread.sleep(1000);
		userhomepage.clickAddtoCartBtn();
		cartpage.checkUserInCartPage();
		cartpage.checkPriceInCart("159920");
		cartpage.clickBuyNowBtn();
		cartpage.clickProceedPayBtn();
		cartpage.paymentPageCheck("9750509150");
		cartpage.checkUserInPaymentPage();
		cartpage.clickcartButton();
		cartpage.clickCartItemRemoveBtn();
		cartpage.CheckNoCourseInCartTxt();
		userhomepage.clickProfileBtn();
		userhomepage.clickLogOutBtn(); 
	}
}

