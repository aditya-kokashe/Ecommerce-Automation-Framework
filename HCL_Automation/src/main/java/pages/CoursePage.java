package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class CoursePage {
	
	WebDriver driver;
	
	public CoursePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[normalize-space()='Dr. Angela Yu, Developer and Lead Instructor']")
	WebElement name;
	
	@FindBy(xpath="//span[@class='ud-heading-xl'][normalize-space()='4.7']")
	WebElement ratings;
	
	@FindBy(xpath="//title[contains(text(),'100 Days of Code™: The Complete Python Pro Bootcam')]")
	WebElement title;
	
	public void validateName(String givenName) {
		Assert.assertEquals(givenName, name);
		
	}
	public void validateRating(String givenRating) {
		
	}
	public void validateTitle(String givenTitle) {
		
	}
	
	
}
