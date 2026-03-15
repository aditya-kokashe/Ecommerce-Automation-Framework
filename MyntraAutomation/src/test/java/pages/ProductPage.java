package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class ProductPage {

    WebDriver driver;
    WaitUtils wait;

    By firstProduct = By.xpath("(//li[@class='product-base'])[1]");

    // select size 8
    By size8 = By.xpath("//p[text()='8']/parent::button");

    By addToBag = By.xpath("//div[text()='ADD TO BAG']");

    By goToBag = By.xpath("//span[contains(text(),'GO TO BAG')]");

    By price = By.className("pdp-price");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
    }

    public void selectProduct() {
        wait.waitForClickable(firstProduct).click();
    }

    public void selectSize() {
        wait.waitForClickable(size8).click();
    }

    public void addToBag() {
        wait.waitForClickable(addToBag).click();
    }

    public void goToBag() {
        wait.waitForClickable(goToBag).click();
    }

    public String getUnitPrice() {
        return wait.waitForVisibility(price).getText();
    }
}