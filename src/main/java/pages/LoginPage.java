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

    public WebElement getPINField(WebDriver driver) {
        return this.getElement(driver, By.id("pinInput"));
    }

    public void clickOnClassicLogin(WebDriver driver) {
        this.getElement(driver, By.id("toggleClassicLogin")).click();
    }

    public void clickOnClassicLoginPIN(WebDriver driver) {
        this.getElement(driver, By.id("tabclassicLoginPin")).click();
    }

    public void clickOnClassicLoginDob(WebDriver driver) {
        this.getElement(driver, By.id("tabclassicLoginDobZip")).click();
    }

    public void clickOnSecureLogin(WebDriver driver) {
        this.getElement(driver, By.id("toggleSecureLogin")).click();
    }

    public boolean isForgetPasswordLinkVisible(WebDriver driver) {
        return this.isElementPresent(driver, By.id("forgotPassword"));
    }

    public boolean isWarnMessageVisible(WebDriver driver) {
        return this.isElementPresent(driver, By.cssSelector("#secureOrClassicLoginPane > form > div:nth-child(4) > div > div"));
    }


}
