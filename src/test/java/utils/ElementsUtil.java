package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ElementsUtil {

    public void sendKeysJs(By locator, String textToSend, RemoteWebDriver driver) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='" + textToSend + "'", element);
    }

    public void clickJs(By locator, RemoteWebDriver driver) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}
