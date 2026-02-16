package ptt;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
    }

    @Test
    public void registerUserTest() {

        Assert.assertTrue(page.isHomePageVisible());
        System.out.println("Home Page Verified");

        page.clickSignupLogin();
        System.out.println("Signup/Login Clicked");

        Assert.assertTrue(page.isNewUserSignupVisible());

        String email = "mohan" + System.currentTimeMillis() + "@mail.com";
        page.enterSignupDetails("Mohan", email);

        Assert.assertTrue(page.isEnterAccountInfoVisible());

        page.fillAccountInformation();
        page.fillAddressDetails();
        page.clickCreateAccount();

        Assert.assertTrue(page.isAccountCreatedVisible());
        System.out.println("Account Created");

        page.clickContinue();

        Assert.assertTrue(page.isUserLoggedIn());
        System.out.println("User Logged In");

        page.deleteAccount();
        Assert.assertTrue(page.isAccountDeletedVisible());
        System.out.println("Account Deleted");

        page.clickContinue();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
