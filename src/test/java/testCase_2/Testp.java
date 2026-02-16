package testCase_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testp {
	WebDriver driver;
	public Testp(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath = "//tbody//tr//td//img")
	WebElement hopage;
	
	@FindBy(id="loginLink")
	WebElement loginbuttion;
	
	@FindBy(xpath="//h2[normalize-space()='Login.']")
	WebElement loginPage;
	
	@FindBy(id="UserName")
	WebElement Uname;
	
	@FindBy(id="Password")
	WebElement password;
	
	@FindBy(xpath="//input[@id='loginIn']")
	WebElement loginClick;
	
	@FindBy(id="//a[normalize-space()='Log off']")
	WebElement logoff;
	
	public boolean isHomePageVisible() {
		return hopage.isDisplayed();
		
	}
	public void clickLogin() {
		loginbuttion.click();
	}
	
	public boolean isLoginpageVisible() {
		return loginPage.isDisplayed();
	}
	public void performLogin(String unn,String pss) {
		Uname.sendKeys("admin");
		password.sendKeys("password");
		loginClick.click();
		
		
	}
	public void logout() {
		logoff.click();
	}
}
