package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import wrappers.GenericWrappers;

public class CoursesPage extends GenericWrappers {

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
	
	@FindBy(xpath = "//div[@class='individual-course-card-container-video-details-button-container']/div[1]")
	private WebElement course1ExploreBtn;
	
	@FindBy(xpath = "(//*[text()='Explore'])[1]")
	private WebElement course2ExploreBtn;
	
	@FindBy(xpath = "(//*[text()='Explore'])[2]")
	private WebElement course3ExploreBtn;
	
	@FindBy(xpath = "(//div[@class='arrow right-arrow'])[1]")
	private WebElement exploreCourseArrowBtn;
	
	
	

	@FindBy(xpath = "//div[@class='logout-button-out']/div[1]")
	private WebElement logOutBtn;

	public CoursesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Methods to interact with elements
	public void clickCourseTopicCheck() {
		driver.navigate().refresh();
		scrollToElements(courseTopicCheck);
		clickbyXpath(courseTopicCheck, " Course Topic Check ");
	}

	public void clickExploreBtn() {
		clickbyXpath(exploreBtn, " Explore button ");
	}
	
	public void clickAddtoCartBtn() {
		driver.navigate().refresh();
		clickbyXpath(addCartBtn, " Add to Cart Button  ");
	}
	
	public void clickAddtoCartBtn2() {
		clickbyXpath(addCartBtn, " Add to Cart Button  ");
	}
	
	public void clickCourse1ExploreBtn() {
		clickbyXpath(course1ExploreBtn, " Explore button ");
	}
	
	public void clickCourse2ExploreBtn() {
		try {
			String pointerEvents = course2ExploreBtn.getCssValue("pointer-events");
			if (pointerEvents.equals("auto")) {
				clickbyXpath(course2ExploreBtn, " Explore button ");
			}
			else {
				clickbyXpath(exploreCourseArrowBtn, " Arrow Button ");
				clickbyXpath(course3ExploreBtn, " Explore Button on Course 3 Button");
			}
		}catch (Exception e) {
				// TODO: handle exception
			}
		
	}
	
	public void checkUserInUserCoursesPage() {
		
		isUserOnNextPage(driver,"//*[@class='home-page-header-menu-container-words']/a[1]", "User Home Page");
	}
	
	public void clickProfileBtn() {
		scrollToElements(profileBtn);
		clickbyXpath(profileBtn, " Profile Button ");
	}

	public void clickLogOutBtn() {
		clickbyXpath(logOutBtn, " Log out ");
	}

}
