package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	@FindBy(id ="//input[@placeholder='Search for anything']")
	WebElement searchBar;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchCourse(String course) {
		searchBar.sendKeys(course);
		searchBar.sendKeys(Keys.ENTER);
	}

	public void handlePopup() {
		// TODO Auto-generated method stub
		
	}

	
}
