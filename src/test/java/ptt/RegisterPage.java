package ptt;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    // ================= CONSTRUCTOR =================

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
    }

    // ================= LOCATORS =================

    @FindBy(xpath = "//img[@alt='Website for automation practice']")
    WebElement homeLogo;

    @FindBy(xpath = "//a[contains(text(),'Signup / Login')]")
    WebElement signupLoginBtn;

    @FindBy(xpath = "//h2[text()='New User Signup!']")
    WebElement newUserSignupText;

    @FindBy(name = "name")
    WebElement name;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement email;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    WebElement signupBtn;

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
    WebElement newsletter;

    @FindBy(id = "optin")
    WebElement offers;

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

    // ================= REUSABLE SAFE CLICK =================

    public void safeClick(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            js.executeScript("arguments[0].click();", element);
        }
    }

    // ================= BUSINESS METHODS =================

    public boolean isHomePageVisible() {
        return homeLogo.isDisplayed();
    }

    public void clickSignupLogin() {
        safeClick(signupLoginBtn);
    }

    public boolean isNewUserSignupVisible() {
        return newUserSignupText.isDisplayed();
    }

    public void enterSignupDetails(String username, String userEmail) {
        name.sendKeys(username);
        email.sendKeys(userEmail);
        safeClick(signupBtn);
    }

    public boolean isEnterAccountInfoVisible() {
        return enterAccountInfoText.isDisplayed();
    }

    public void fillAccountInformation() {

        safeClick(titleMr);
        password.sendKeys("12345");

        new Select(day).selectByValue("1");
        new Select(month).selectByValue("1");
        new Select(year).selectByValue("2000");

        js.executeScript("arguments[0].scrollIntoView(true);", newsletter);

        safeClick(newsletter);
        safeClick(offers);
    }

    public void fillAddressDetails() {

        firstName.sendKeys("Laxman");
        lastName.sendKeys("Patel");
        company.sendKeys("ABC Pvt Ltd");
        address1.sendKeys("India");
        address2.sendKeys("Near Station");

        new Select(country).selectByVisibleText("India");

        state.sendKeys("Gujarat");
        city.sendKeys("Surat");
        zipcode.sendKeys("395006");
        mobile.sendKeys("9876543210");
    }

    public void clickCreateAccount() {

        js.executeScript("window.scrollBy(0,300)");
        safeClick(createAccountBtn);
    }

    public boolean isAccountCreatedVisible() {
        wait.until(ExpectedConditions.visibilityOf(accountCreatedText));
        return accountCreatedText.isDisplayed();
    }

    public void clickContinue() {
        safeClick(continueBtn);
    }

    public boolean isUserLoggedIn() {
        wait.until(ExpectedConditions.visibilityOf(loggedInUser));
        return loggedInUser.isDisplayed();
    }

    public void deleteAccount() {
        safeClick(deleteAccountBtn);
    }

    public boolean isAccountDeletedVisible() {
        wait.until(ExpectedConditions.visibilityOf(accountDeletedText));
        return accountDeletedText.isDisplayed();
    }
}
