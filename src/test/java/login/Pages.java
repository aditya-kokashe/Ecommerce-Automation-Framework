package login;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import login.PagesTest;

public class Pages {
	WebDriver driver;
	PagesTest ppp;
	@BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://automationexercise.com");

        ppp = new PagesTest(driver);
    }
	@Test
    public void LoginTest() {

        Assert.assertTrue(ppp.isHomePageVisible());
        System.out.println("Home Page Verified");
        
        ppp.clickLoginpage();
        System.out.println("login buttion click");
        Assert.assertTrue(ppp.isLoginPageVisible());
        System.out.println("login Page Verified");
        ppp.login("mohan@mail.com","12345");
        System.out.println("login the website");
	}

}
