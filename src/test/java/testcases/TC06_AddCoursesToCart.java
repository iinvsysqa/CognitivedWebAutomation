package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.LandingPageNew;
import pages.SignInPageNew;
import pages.UserHomePage;
import utils.Reporter;
import wrappers.WebApplicationWrappers;

public class TC06_AddCoursesToCart extends WebApplicationWrappers {
	SignInPageNew signInPagenew;
	LandingPageNew landingpagenew;
	UserHomePage userhomepage;
	CartPage cartpage;
	@BeforeClass
	public void startTestCase() {
		testCaseName = " TC06 - Add and Remove course to cart";
		testDescription = " Add course and remove courses to Cart ";
	}


	@Test
	public void addCoursesToCart() throws InterruptedException {
		
		initDriver("Windows","firefox");
		Reporter.reportStep("Browser : Firfox ","USER_INFO");
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
		cartpage.clickHomeBtn();
		userhomepage.clickCourse2ExploreBtn();
		userhomepage.clickAddtoCartBtn();
		Thread.sleep(1000);
		userhomepage.clickAddtoCartBtn();
		cartpage.checkUserInCartPage();
		cartpage.checkPriceInCart("204920");
		cartpage.clickCartItemRemoveBtn();
		cartpage.checkItemremoveToast("Item removed from cart");
		Thread.sleep(5000);
		cartpage.clickCartItemRemoveBtn();
		cartpage.CheckNoCourseInCartTxt();
		
		
	}
}
