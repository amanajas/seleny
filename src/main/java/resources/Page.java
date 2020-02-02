package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.Duration.ofSeconds;

public class Page {

    public static final Duration TIMEOUT = ofSeconds(10);

    public boolean elementIsPresent(WebDriver driver, By by) {
        return driver.findElements(by).size() > 0;
    }

    public boolean elementIsPresent(WebElement element) {
        return element.getSize().width > 0;
    }

    public WebElement getElement(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT.getSeconds());
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitUntilClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT.getSeconds());
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public Boolean waitForPageToLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoad = new
                ExpectedCondition <Boolean> () {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };

        Wait<WebDriver> wait = new WebDriverWait(driver, 60);
        return wait.until(pageLoad);
    }

    public boolean waitUntilAttributeContains(WebDriver driver, WebElement search, String attr, String value) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT.getSeconds());
        return wait.until(ExpectedConditions.attributeContains(search, attr, value));
    }
}
