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
    private WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isElementPresent(By by) {
        return driver.findElements(by).size() > 0;
    }

    public WebElement getElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT.getSeconds());
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement getElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT.getSeconds());
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement getElement(String selector) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT.getSeconds());
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector)));
    }

}
