package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import resources.Page;

public class LoginPage extends Page {

    public static final String URL = "/login";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getLoginField() {
        return this.getElement(By.id("aliasInputSecure"));
    }

    public WebElement getPasswordField() {
        return this.getElement(By.id("aliasInputSecure"));
    }

    public WebElement getLoginButton() {
        return this.getElement(By.id("loginSubmitButtonSecure"));
    }

    public WebElement getCardNumberField() {
        return this.getElement(By.id("cardnumberInputClassicDobZip"));
    }

    public WebElement getBirthdayField() {
        return this.getElement(By.id("dob"));
    }

    public WebElement getZipField() {
        return this.getElement(By.id("zipName"));
    }

    public WebElement getPINField() {
        return this.getElement(By.id("pinInput"));
    }

    public void clickOnClassicLogin() {
        this.getElement(By.id("toggleClassicLogin")).click();
    }

    public void clickOnClassicLoginPIN() {
        this.getElement(By.id("tabclassicLoginPin")).click();
    }

    public void clickOnClassicLoginDob() {
        this.getElement(By.id("tabclassicLoginDobZip")).click();
    }

    public void clickOnSecureLogin() {
        this.getElement(By.id("toggleSecureLogin")).click();
    }

    public boolean isForgetPasswordLinkVisible() {
        return this.isElementPresent(By.id("forgotPassword"));
    }

    public boolean isWarnMessageVisible() {
        return this.isElementPresent(By.cssSelector("#secureOrClassicLoginPane > form > div:nth-child(4) > div > div"));
    }


}
