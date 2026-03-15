package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class HomePage {

    WebDriver driver;
    WaitUtils wait;

    By searchBox = By.className("desktop-searchBar");
    By searchButton = By.className("desktop-submit");

    public HomePage(WebDriver driver) {

        this.driver = driver;
        wait = new WaitUtils(driver);
    }

    public void searchProduct(String product) {

        wait.waitForVisibility(searchBox).sendKeys(product);
        driver.findElement(searchButton).click();
    }
}