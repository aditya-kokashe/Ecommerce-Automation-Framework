package utils;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WindowUtils {

    public static void switchToNewTab(WebDriver driver) {

        String currentWindow = driver.getWindowHandle();

        Set<String> windows = driver.getWindowHandles();

        for (String window : windows) {

            if (!window.equals(currentWindow)) {

                driver.switchTo().window(window);
            }
        }
    }
}