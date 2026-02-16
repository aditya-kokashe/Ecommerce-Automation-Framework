package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Home Page
    @FindBy(xpath = "//img[@alt='Website for automation practice']")
    WebElement homeLogo;

    @FindBy(xpath = "//a[contains(text(),'Signup / Login')]")
    WebElement signupLoginBtn;

    // Signup Page
    @FindBy(xpath = "//h2[text()='New User Signup!']")
    WebElement newUserSignupText;

    @FindBy(name = "name")
    WebElement name;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement email;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    WebElement signupBtn;

    // Enter Account Info
    @FindBy(xpath = "//b[text()='Enter Account Information']")
    WebElement enterAccountInfoText;

    @FindBy(id = "id_gender1")
    WebElement titleMr;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "days")
    WebElement day;

    @FindBy(id = "months")
    WebElement month;

    @FindBy(id = "years")
    WebElement year;

    @FindBy(id = "newsletter")
    WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    WebElement offersCheckbox;

    @FindBy(id = "first_name")
    WebElement firstName;

    @FindBy(id = "last_name")
    WebElement lastName;

    @FindBy(id = "company")
    WebElement company;

    @FindBy(id = "address1")
    WebElement address1;

    @FindBy(id = "address2")
    WebElement address2;

    @FindBy(id = "country")
    WebElement country;

    @FindBy(id = "state")
    WebElement state;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "zipcode")
    WebElement zipcode;

    @FindBy(id = "mobile_number")
    WebElement mobile;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    WebElement createAccountBtn;

    @FindBy(xpath = "//b[text()='Account Created!']")
    WebElement accountCreatedText;

    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueBtn;

    @FindBy(xpath = "//a[contains(text(),'Logged in as')]")
    WebElement loggedInUser;

    @FindBy(xpath = "//a[contains(text(),'Delete Account')]")
    WebElement deleteAccountBtn;

    @FindBy(xpath = "//b[text()='Account Deleted!']")
    WebElement accountDeletedText;
}
