package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class CartPage {

    WebDriver driver;
    WaitUtils wait;

    By quantityButton = By.xpath("//span[contains(text(),'Qty')]");
    By quantity10 = By.xpath("//div[@id='10']");
    By doneButton = By.xpath("//div[text()='DONE']");

    // Correct cart item total
    By totalPrice = By.xpath("//div[contains(@class,'itemContainer-base-price')]//div[contains(@class,'itemComponents-base-bold')]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
    }

    public String getTotalPrice() {
        return wait.waitForVisibility(totalPrice).getText();
    }

    public void changeQuantityTo10() {

        wait.waitForClickable(quantityButton).click();
        wait.waitForClickable(quantity10).click();
        wait.waitForClickable(doneButton).click();
    }
}