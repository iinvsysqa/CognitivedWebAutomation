package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import wrappers.GenericWrappers;

public class CourseContentPageNew extends GenericWrappers{
    
    private WebDriver driver;
    public JavascriptExecutor jsExecutor;
    
    //Locate all elements on the page
    
    @FindBy(xpath = "//div[text()='Go to Course']")
    private WebElement gotoCourseButton;
    
    
    @FindBy(xpath = "(//*[contains(@class,'p-topic-styling-details')])[2]")
    private WebElement firstTopicButton;
    
    @FindBy(xpath = "(//*[contains(@class,'p-topic-styling-details')])[2]")
    private WebElement firstTopicVideoButton;
    
    @FindBy(xpath = "//div[@class='video_container']/div[4]/div[1]//*[@class='videoActive']")
    private WebElement demoCourseVideo;

    @FindBy(xpath = "//div[@class='video_container']/div[1]/video")
    private WebElement CourseVideo;
  
	@FindBy(xpath = "(//div[contains(@class,'Course_Content_topic_Assests_Content_View_After_Buy')])[1]")
	private WebElement playVideoButton;
	
	@FindBy(xpath = "//div[@class='play_progress']")
	private WebElement playProgressBar;
	
    
    public WebElement chapterTitle(int chapternum)
    {
    	return driver.findElement(By.xpath("(//div[contains(@class,'Course_Content_chapter_Name_Text')])["+chapternum+"]"));
    }
    
    public WebElement videoField(int topicnum)
    {
    	return driver.findElement(By.xpath("(//div[contains(@class,'Course_Content_topic_Name_Text_View_after_buy')])["+topicnum+"]"));
    }
    
    public WebElement topicTitle(int chapternum)
    {
    	return driver.findElement(By.xpath("(//div[contains(@class,'Course_Content_topic_Name_Text')]/div)["+chapternum+"]"));
    }
 
    public CourseContentPageNew(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    
    // Methods to interact with elements
    
    public void clickFirstTopicTitle(){
    	driver.navigate().refresh();
    	clickbyXpath(firstTopicButton, " Click on First Topic ");
    }
    
    public void clickFirstTopicVideo(){
    	clickbyXpath(firstTopicVideoButton, " Click on First Topic video ");
    }
    
    public WebElement getChapterField(String num) {
        String xpath = String.format("(//div[contains(@class,'Course_Content_chapter_Name_Text')])["+num+"]");
        return driver.findElement(By.xpath(xpath));
    }
	
	public WebElement getTopicField(String num) {
        String xpath = String.format("(//div[contains(@class,'Course_Content_topic_Name_Text')]/div)["+num+"]");
        return driver.findElement(By.xpath(xpath));
    }

	public void clickChapterTitle(String num) {
		scrollToElements(getChapterField(num));
		clickbyXpath(getChapterField(num)," Chapter Title  "+num+" ");
		
	}
	
	public void clickTopictitle(String num) {
		scrollToElements(getTopicField(num));
		clickbyXpath(getTopicField(num)," Topic Title "+num+" ");
		
	}
	
	 public void playPauseVideo() throws InterruptedException {
	    	Thread.sleep(5000);
	    	scrollToElements(demoCourseVideo);
	    	clickbyXpath(demoCourseVideo, " Topic video Pause " );
	    	Thread.sleep(2000);
	    	clickbyXpath(demoCourseVideo, " Topic video Play " );
	    	Thread.sleep(5000);
	    	clickbyXpath(demoCourseVideo, " Topic video Pause " );
	    }
	 
	 public boolean checkCourseVideoPlaying(String videotype) {
	    	return verifyVideoPlayingByPlayPause(CourseVideo, videotype);
	    }
	 
	 public boolean checkCoursePageDemoVideoPlaying(String videotype) {
	    	return verifyVideoPlayingByPlayPause(CourseVideo, videotype);
	    }
	    
}