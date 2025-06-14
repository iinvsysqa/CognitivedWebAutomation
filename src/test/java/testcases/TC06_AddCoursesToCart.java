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

public class TC06_AddCoursesToCart extends WebApplicationWrappers {
	SignInPageNew signInPagenew;
	LandingPageNew landingpagenew;
	CoursesPage userhomepage;
	CartPage cartpage;
	HomePage homepage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = " TC06 - Add and Remove course to cart";
		testDescription = " Add course and remove courses to Cart ";
	}


	@Test
	public void TC06_AddCourses_To_Cart_Check() throws InterruptedException {
		
		initDriver("Windows","chrome");
		Reporter.reportStep("Browser : Firfox ","USER_INFO");
		Reporter.reportStep("Platform : Windows ","USER_INFO");
		landingpagenew= new LandingPageNew(driver);
		signInPagenew=new SignInPageNew(driver);
		userhomepage= new CoursesPage(driver);
		homepage=new HomePage(driver);
		
		cartpage= new CartPage(driver);
		launchApplication(loadProp().getProperty("URL"));	
		
		landingpagenew.clickgetStartedButton();
		signInPagenew.signInUser("iinvsysqa@gmail.com","Welcome@123");
		homepage.checkUserInUserHomePage();
		homepage.clickExploreCourseButton();
		Thread.sleep(5000);
		userhomepage.checkUserInUserCoursesPage();
		userhomepage.clickCourse1ExploreBtn();
		userhomepage.clickAddtoCartBtn();
		Thread.sleep(1000);
		userhomepage.clickAddtoCartBtn2();
		cartpage.checkUserInCartPage();
		cartpage.clickCoursesButton();
		Thread.sleep(5000);
		userhomepage.clickCourse2ExploreBtn();
		Thread.sleep(2000);
		userhomepage.clickAddtoCartBtn();
		Thread.sleep(1000);
		userhomepage.clickAddtoCartBtn2();
		cartpage.checkUserInCartPage();
		cartpage.checkPriceInCart("204920");
		cartpage.clickCartItemRemoveBtn();
		cartpage.checkItemremoveToast("Item removed from cart");
		Thread.sleep(5000);
		cartpage.clickCartItemRemoveBtn();
		cartpage.CheckNoCourseInCartTxt();
		
		
	}
}
