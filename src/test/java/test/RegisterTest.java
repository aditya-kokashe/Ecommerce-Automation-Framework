package test;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class RegisterTest {

    WebDriver driver;
    RegisterPage page;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://automationexercise.com");
        page = new RegisterPage(driver);
        System.out.println("Browser Launched & URL Opened");
    }

    @Test
    public void registerUserTest() {

        // Step 3
        Assert.assertTrue(page.homeLogo.isDisplayed());
        System.out.println("Home Page is visible");

        // Step 4
        page.signupLoginBtn.click();
        System.out.println("Clicked Signup/Login");

        // Step 5
        Assert.assertTrue(page.newUserSignupText.isDisplayed());
        System.out.println("New User Signup visible");

        // Step 6
        page.name.sendKeys("Mohan");
        page.email.sendKeys("mohan" + System.currentTimeMillis() + "@mail.com");

        // Step 7
        page.signupBtn.click();
        System.out.println("Signup button clicked");

        // Step 8
        Assert.assertTrue(page.enterAccountInfoText.isDisplayed());
        System.out.println("Enter Account Information visible");

        // Step 9
        page.titleMr.click();
        page.password.sendKeys("12345");
        new Select(page.day).selectByValue("1");
        new Select(page.month).selectByValue("1");
        new Select(page.year).selectByValue("2000");

        // Step 10 & 11
        page.newsletterCheckbox.click();
        page.offersCheckbox.click();

        // Step 12
        page.firstName.sendKeys("Mohan");
        page.lastName.sendKeys("Bhargav");
        page.company.sendKeys("ABC Pvt Ltd");
        page.address1.sendKeys("India");
        page.address2.sendKeys("Near Station");
        new Select(page.country).selectByVisibleText("India");
        page.state.sendKeys("Gujarat");
        page.city.sendKeys("Surat");
        page.zipcode.sendKeys("395006");
        page.mobile.sendKeys("9876543210");

        // Step 13
        page.createAccountBtn.click();
        System.out.println("Create Account clicked");

        // Step 14
        Assert.assertTrue(page.accountCreatedText.isDisplayed());
        System.out.println("Account Created Verified");

        // Step 15
        page.continueBtn.click();

        // Step 16
        Assert.assertTrue(page.loggedInUser.isDisplayed());
        System.out.println("User Logged In Verified");

        // Step 17
        page.deleteAccountBtn.click();

        // Step 18
        Assert.assertTrue(page.accountDeletedText.isDisplayed());
        System.out.println("Account Deleted Verified");

        page.continueBtn.click();
        System.out.println("Test Case Completed Successfully");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
