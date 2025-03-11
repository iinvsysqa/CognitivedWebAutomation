package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.LandingPageNew;
import pages.SignInPageNew;
import pages.UserHomePage;
import utils.Reporter;
import wrappers.WebApplicationWrappers;

public class TC07_PaymentPageCheck extends WebApplicationWrappers {
	SignInPageNew signInPagenew;
	LandingPageNew landingpagenew;
	UserHomePage userhomepage;
	CartPage cartpage;
	@BeforeClass
	public void startTestCase() {
		testCaseName = " TC07 - Payment Page check";
		testDescription = " Check user able to process Payment Page ";
	}


	@Test
	public void paymentCheck() throws InterruptedException {
		
		initDriver("Windows","chrome");
		Reporter.reportStep("Browser : Chrome ","USER_INFO");
		Reporter.reportStep("Platform : Windows ","USER_INFO");
		landingpagenew= new LandingPageNew(driver);
		signInPagenew=new SignInPageNew(driver);
		userhomepage= new UserHomePage(driver);
		cartpage= new CartPage(driver);
		launchApplication(loadProp().getProperty("URL"));	
		
		landingpagenew.clickgetStartedButton();
		signInPagenew.signInUser("iinvsysqa@gmail.com","Welcome@123");
		userhomepage.checkUserInUserHomePage();
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

