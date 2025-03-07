package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import wrappers.GenericWrappers;

public class UserHomePage extends GenericWrappers {

	private WebDriver driver;

	// Locate all elements on the page

	@FindBy(xpath = "(//div[@class='individual-course-card-container-video-details-button'])[1]")
	private WebElement exploreBtn;

	@FindBy(xpath = "//div[text()='All Courses']")
	private WebElement allCourseButton;

	@FindBy(xpath = "//div[@class='add-cart-btn']")
	private WebElement addCartBtn;

	@FindBy(xpath = "(//div[@class='topic-title-container-field-wrapup'])[1]/div[2]")
	private WebElement courseTopicCheck;

	@FindBy(xpath = "//div[@class='home-page-header-menu-container-svg-circle home-page-header-menu-container-words-hideable profile-icon-container']")
	private WebElement profileBtn;
	
	@FindBy(xpath = "(//div[@class='individual-course-card-container-video-details-button'])[1]")
	private WebElement course1ExploreBtn;
	
	@FindBy(xpath = "(//div[@class='individual-course-card-container-video-details-button'])[2]")
	private WebElement course2ExploreBtn;
	

	@FindBy(xpath = "//div[@class='logout-button']/div")
	private WebElement logOutBtn;

	public UserHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Methods to interact with elements
	public void clickCourseTopicCheck() {
		scrollToElements(courseTopicCheck);
		clickbyXpath(courseTopicCheck, " Course Topic Check ");
	}

	public void clickExploreBtn() {
		clickbyXpath(exploreBtn, " Explore button ");
	}
	
	public void clickAddtoCartBtn() {
		clickbyXpath(addCartBtn, " Add to Cart Button  ");
	}
	
	public void clickCourse1ExploreBtn() {
		clickbyXpath(course1ExploreBtn, " Explore button ");
	}
	
	public void clickCourse2ExploreBtn() {
		clickbyXpath(course2ExploreBtn, " Explore button ");
	}
	
	public void checkUserInUserHomePage() {
		
		isUserOnNextPage(driver,"//div[@class='home-page-header-menu-container-svg-circle home-page-header-menu-container-words-hideable profile-icon-container']", "User Home Page");
	}
	
	public void clickProfileBtn() {
		scrollToElements(profileBtn);
		clickbyXpath(profileBtn, " Profile Button ");
	}

	public void clickLogOutBtn() {
		clickbyXpath(logOutBtn, " Log out ");
	}

}
