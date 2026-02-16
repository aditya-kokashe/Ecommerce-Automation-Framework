package testCase_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test1 {
	WebDriver driver;
	Testp pp;
	
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
//		driver.manage().window().maximize();
		driver.get("http://eaapp.somee.com/");
		pp = new Testp(driver);
		
	}
	
	@Test
	public void LoginTest() {
		Assert.assertTrue(pp.isHomePageVisible());
		System.out.println("Home page is verified");
		
		pp.clickLogin();
		System.out.println("Login in page click");
		
		Assert.assertTrue(pp.isLoginpageVisible());
		System.out.println("login page is verified");
		
		pp.performLogin("admin", "password");
		
	
	}
	
	@AfterClass
	public void ll() {
		pp.logout();
	}
	
}
