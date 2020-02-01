package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.Duration.ofSeconds;

public class Page {

    public static final Duration TIMEOUT = ofSeconds(10);

    public boolean isElementPresent(WebDriver driver, By by) {
        return driver.findElements(by).size() > 0;
    }

    public WebElement getElement(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT.getSeconds());
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement getElement(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT.getSeconds());
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement getElement(WebDriver driver, String selector) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT.getSeconds());
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector)));
    }

}
