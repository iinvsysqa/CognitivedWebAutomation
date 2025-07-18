package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Reporter;
import wrappers.GenericWrappers;

public class LandingPageNew extends GenericWrappers{
    
    private WebDriver driver;
    
 //Locate all elements on the page
    
    @FindBy(xpath = "//div[@class='get-started-button hide-mobile-tab']")
    private WebElement getStartedButton;
    
    @FindBy(xpath = "//div[@class='get-started-container-button']")
    private WebElement getStartedNowButton;

    @FindBy(xpath = "//p[@class='testimonial-section-main-title']")
    private WebElement testimonialTitle;
    
    @FindBy(xpath = "(//div[@class='leftandrightarrow '])[1]")
    private WebElement testimonialArrowButton;

    @FindBy(xpath = "//video[@class='img-cont']")
    private WebElement demoCourseVideo;
    
    @FindBy(xpath = "//h3[contains(text(),'Tailored Resources')]")
    private WebElement tailoredResourcesTopic;
    
    @FindBy(xpath = "//div[@class='logo-container ']/div[1]/div[1]")
    private WebElement loginBtn;
    
    @FindBy(xpath = "//div[@class='logo-container ']/div[1]/div[2]")
    private WebElement signUpBtn;
    
    @FindBy(xpath = "//*[@class='background-video']")
    private WebElement backGroundVideo;
    
    @FindBy(xpath = "//*[@class='semi-circle-img video']/video")
    private WebElement semicircleVideo; 
    
   // @FindBy(xpath = " //*[@class='video-player-view']")
   // private WebElement landingPageSampleVideo; 
    
    
    @FindBy(xpath = "//*[text()='Designed to meet individual needs']/following-sibling::div/div[1]")
    private WebElement landingPageSampleVideo; 
    
   // @FindBy(xpath = "(//video)[3]")
  //  private WebElement landingPageSampleVideo; 
 
    
    public LandingPageNew(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        this.jsExecutor = (JavascriptExecutor) driver;
    }
    
    public void clickgetStartedButton() {
    	
    	clickbyXpath(getStartedButton," Get Started ");
    }
    
    public void clickgetStartedNowButton() {
    	scrollToElements(getStartedNowButton);
    	scrollToElements(getStartedNowButton);
    	clickbyXpath(getStartedNowButton," Get Started Now");
    }
    
    public void playPauseVideo() throws InterruptedException {
    	driver.navigate().refresh();
    	Thread.sleep(3000);
    	scrollToElements(tailoredResourcesTopic);
    	//scrollToElements(demoCourseVideo);
    	clickbyXpath(demoCourseVideo, " Demo video Pause " );
    	Thread.sleep(2000);
    	clickbyXpath(demoCourseVideo, " Demo video Play " );
    	Reporter.reportStep("Video Player started time Screenshot", "INFO");
    	Thread.sleep(5000);
    	clickbyXpath(demoCourseVideo, " Demo video Pause " );
    	Reporter.reportStep("Video Player after 5 seconds Screenshot", "INFO");
    }
    
    public void checkTestimonialScroll() throws InterruptedException {
    	scrollToElements(testimonialTitle);
    	clickbyXpath(testimonialArrowButton, " Scroll Testimonial " );
    	Thread.sleep(1000);
    	Reporter.reportStep(" Move to Next Testimonial Successfully ", "PASS");
    }
    
    public void clickLoginButton() {
    	clickbyXpath(loginBtn, "Landing Page Sign in Button ");
    }

    public void clickSignupButton() {
    	clickbyXpath(signUpBtn, "Landing Page Sign in Button ");
    }

    public boolean checkSemiCircleVideoPlaying(String videotype) {
    	scrollPageDown();
    	return checkVideoIsplayingNew(semicircleVideo,videotype);
    }
    
    public boolean checkBackGroundVideoPlaying(String videotype) {
    	return checkVideoIsplayingNew(backGroundVideo,videotype);
    }
    
    public boolean checkLandingPageDemoVideoPlaying(String videotype) {
    	return verifyVideoPlayingByPlayPause(driver.findElement(By.xpath("//*[@class='vjs-tech']")), videotype);
    }
    
  
    
}
