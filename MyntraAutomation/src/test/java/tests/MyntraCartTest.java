package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import utils.PriceUtils;
import utils.WindowUtils;

public class MyntraCartTest extends BaseTest {

    @Test
    public void verifyPriceCalculation() throws InterruptedException {

        HomePage home = new HomePage(driver);
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);

        home.searchProduct("Women Sneakers");

        product.selectProduct();

        WindowUtils.switchToNewTab(driver);

        // capture price
        String priceText = product.getUnitPrice();
        int unitPrice = PriceUtils.convertPrice(priceText);

        // select size
        product.selectSize();

        // add to bag
        product.addToBag();
        
        product.goToBag();
        
        cart.changeQuantityTo10();
        
        Thread.sleep(2000);
        
        String totalPriceText = cart.getTotalPrice();
        int totalPrice = PriceUtils.convertPrice(totalPriceText);
        
        //expected
        int expectedTotal = unitPrice * 10;

        Assert.assertEquals(totalPrice, expectedTotal, "Price calculation failed");
    }
}