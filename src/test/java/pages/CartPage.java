package pages;

import java.time.Duration;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.Reporter;
import java.util.List;

import wrappers.WebApplicationWrappers;

public class CartPage extends WebApplicationWrappers {
	private WebDriver driver;

	static ExtentTest test;
	static ExtentReports report;
	private WebDriverWait wait;

	public CartPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.jsExecutor = (JavascriptExecutor) driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	


	@FindBy(xpath = "//div[contains(@class,'Cart_Screen_cart_Title__')]")
	private WebElement PaymentOption;

	@FindBy(xpath = "//button[contains(@class,'Paypal_Payment_cancelButton__')]")
	private WebElement paymentCancelbtn;

	@FindBy(xpath = "//a[text()='Home']")
	private WebElement homeBtn;

	@FindBy(xpath = "//div[@class='billing-card-total-number-of-courses-right']/p")
	private WebElement totalPriceField;
	
	@FindBy(xpath = "(//*[@class='course-cart-price-styling-remove'])[1]")
	private WebElement cartItemRemoveBtn;
	
	@FindBy(xpath = "//p[text()='No Courses in the Cart']")
	private WebElement noCourseInCartTxt;
	
	@FindBy(xpath = "//div[@class='billing-card-view-content-container-section2']")
	private WebElement buyNowBtn;
	
	@FindBy(xpath = "//button[@class='proceed-btn']")
	private WebElement proceedPayBtn;
	
	@FindBy(xpath = "//input[@name='contact']")
	private WebElement razerPayContactTextBox;
	
	@FindBy(xpath = "//*[@data-testid='checkout-close']")
	private WebElement razorPayCloseBtn;
	
	@FindBy(xpath = "//*[@data-testid='confirm-positive']")
	private WebElement paymentExitBtn;
	
	@FindBy(xpath = "(//*[@class='home-page-header-menu-svg'])[1]")
	private WebElement cartButton;
	
	@FindBy(xpath = "//iframe[@class='razorpay-checkout-frame']")
	private WebElement razorPayiframe;
	
	@FindBy(xpath = "//div[@id='contact-submit']/button")
	private WebElement razorPayContinueBtn;
	
	
	
	public void clickProceedPayBtn() {
		clickbyXpath(proceedPayBtn, " Buy now button  ");
	}

	public void clickBuyNowBtn() {
		clickbyXpath(buyNowBtn, " Buy now button  ");
	}

	public void clickcartButton() {
		clickbyXpath(cartButton, " Buy now button  ");
	}
	public void clickHomeBtn() {
		clickbyXpath(homeBtn, " Home button  ");
	}

	public void checkUserInCartPage() {

		isUserOnNextPage(driver, "//div[text()='Buy Now']", " Cart Page ");
	}

	public void checkPriceInCart(String price) {
		verifyTextContainsByXpath(totalPriceField, price," Total price ");
	}
	

	public void checkItemremoveToast(String toast) {
		verifyDynamicContentByXpath("//*[@role='status']", toast," Toast message ");
	}
	
	public void clickCartItemRemoveBtn() {
		clickbyXpath(cartItemRemoveBtn, " Cart Item Remove  ");
	}
	public void CheckNoCourseInCartTxt() {
		verifyTextContainsByXpath(noCourseInCartTxt, "No Courses in the Cart", " Empty Cart");
	}
	

	public void paymentPageCheck(String mobileno) {
		driver.switchTo().frame(razorPayiframe);
		isUserOnNextPage(driver, "//input[@name='contact']", " Razor Pay Page ");
		enterValuebyXpath(razerPayContactTextBox," Enter Mobile Number ",mobileno);
		try {
			if(razorPayContinueBtn.isDisplayed()) {
				clickbyXpath(razorPayContinueBtn, " Continue Button ");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		clickbyXpath(razorPayCloseBtn, " Cart Item Remove  ");
		clickbyXpath(paymentExitBtn, " Buy now button  ");
		driver.switchTo().defaultContent();
	}
	

	public void checkUserInPaymentPage() {

		isUserOnNextPage(driver, "//button[@class='proceed-btn']", " Proceed to Payment Page ");
	}
	

	public void verifycoursecontentpage() throws Exception {

		// Locate cart elements
		List<WebElement> cartList = driver
				.findElements(By.xpath("//div[contains(@class,'Cart_Screen_cart_Card_View')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// If cart is empty, exit
		if (cartList.size() == 0) {
			System.out.println("Cart is empty, no items to remove.");
			return;
		}

		for (int i = 0; i < cartList.size(); i++) {

			try {
				// Refresh the cart list to avoid stale elements
				cartList = driver.findElements(By.xpath("//div[contains(@class,'Cart_Screen_cart_Card_View')]"));

				// Get the first item in the cart list (start removing from the first element)
				WebElement cartItem = cartList.get(i); // Always start from the first element
				js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", cartItem);

				WebElement courseName = cartItem
						.findElement(By.xpath(".//div[contains(@class,'Cart_Screen_courseName_Text')]"));

				String before = courseName.getText();

				jsExecutor.executeScript("window.scrollTo(0, 0);");
				Thread.sleep(2000);
				scrollToElementAndClick(courseName);

				// Now find the course title on the new page
				WebElement overallCartTitle = driver
						.findElement(By.xpath("//div[contains(@class,'Course_Content_course_Title_View')]"));
				WebElement courseTitle = overallCartTitle
						.findElement(By.xpath("//div[contains(@class,'Course_Content_course_Title')]"));

				String after = courseTitle.getText();

				// Compare before and after course names
				if (before.equals(after)) {
					pass("Clicked on " + before + " in the cart and navigated to " + after
							+ " on the course content page as expected.");
				} else {
					fail("Clicked on " + before + " in the cart but navigated to " + after + " instead.");
				}

				Thread.sleep(3000);
				driver.navigate().back();
				// Wait for the cart page to reload
				Thread.sleep(3000);
				// Check if navigated back to the cart successfully
				WebElement cartPage = driver
						.findElement(By.xpath("//div[contains(@class,'Cart_Screen_cart_Section_2_Title')]"));
				String text = cartPage.getText();
				if (text.contains("Billing Details")) {
					pass("Navigated back to the cart successfully.");
				} else {
					fail("Back navigation failed.");
				}
			} catch (StaleElementReferenceException e) {
				System.out.println("Stale Element encountered. Retrying...");
				// Continue the loop and re-fetch elements
				continue;
			} catch (Exception e) {
				fail("An error occurred: " + e.getMessage());
				e.printStackTrace();
				return;
			}
			// Refresh the cart list after an item is removed
			cartList = driver.findElements(By.xpath("//div[contains(@class,'Cart_Screen_cart_Card_View')]"));
		}
	}

}
