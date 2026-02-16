package login;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PagesTest {
	WebDriver driver;
	WebDriverWait wait;
	
	public PagesTest(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
	}
	
	 @FindBy(xpath = "//img[@alt='Website for automation practice']")
	 WebElement homeLogo;
	 
	 @FindBy(xpath = "//a[normalize-space()='Signup / Login']")
	 WebElement llClick;
	 
	@FindBy(xpath = "//h2[normalize-space()='Login to your account']")
	WebElement loginlogo;
	
	@FindBy(xpath = "//input[@data-qa='login-email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password;
	
	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement loginClick;
	
	 public boolean isHomePageVisible() {
	        return homeLogo.isDisplayed();
	 }
	 public void clickLoginpage() {
		 llClick.click();
	 }
	 public boolean isLoginPageVisible() {
		 wait.until(ExpectedConditions.visibilityOf(loginlogo));
		    return loginlogo.isDisplayed();
	 }
	 public void login(String emaill, String passwordp) {
		 email.sendKeys(emaill);
		 password.sendKeys(passwordp);
		 loginClick.click();
	 }
}
