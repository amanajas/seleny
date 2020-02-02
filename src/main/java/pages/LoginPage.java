package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import resources.Page;

public class LoginPage extends Page {

    public static final String URL = "/login";

    public WebElement getLoginField(WebDriver driver) {
        return this.getElement(driver, By.id("aliasInputSecure"));
    }

    public WebElement getPasswordField(WebDriver driver) {
        return this.getElement(driver, By.id("aliasInputSecure"));
    }

    public WebElement getLoginButton(WebDriver driver) {
        return this.getElement(driver, By.id("loginSubmitButtonSecure"));
    }

    public WebElement getCardNumberField(WebDriver driver) {
        return this.getElement(driver, By.id("cardnumberInputClassicDobZip"));
    }

    public WebElement getBirthdayField(WebDriver driver) {
        return this.getElement(driver, By.id("dob"));
    }

    public WebElement getZipField(WebDriver driver) {
        return this.getElement(driver, By.id("zipName"));
    }

    public WebElement getPermLoginSecureCheckbox(WebDriver driver) {
        return this.getElement(driver, By.id("permLoginSecure"));
    }

    public WebElement getPermLoginSecureLabel(WebDriver driver) {
        return this.getElement(driver, By.id("permLoginSecureLabel"));
    }

    public WebElement getPINField(WebDriver driver) {
        return this.getElement(driver, By.id("pinInput"));
    }
    

    public WebElement getTabClassicLoginPIN(WebDriver driver) {
        return this.getElement(driver, By.id("tabclassicLoginPin"));
    }

    public WebElement getToggleToSecureLogin(WebDriver driver) {
        return this.getElement(driver, By.id("toggleSecureLogin"));
    }

    public boolean isForgetPasswordLinkVisible(WebDriver driver) {
        return this.elementIsPresent(driver, By.id("forgotPassword"));
    }

    public boolean isWarnMessageVisible(WebDriver driver) {
        return this.elementIsPresent(driver, By.cssSelector("#secureOrClassicLoginPane > form > div:nth-child(4) > div > div"));
    }

    public WebElement getCardNumberClassicPin(WebDriver driver) {
        return this.getElement(driver, By.id("cardnumberInputClassicPin"));
    }
}
