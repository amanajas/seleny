package functional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PaybackPage;
import resources.BasicTest;
import resources.Page;

public class LoginFormTest extends BasicTest {

    protected LoginPage page;

    public LoginFormTest() {
        page = new LoginPage();
    }

    private void gotoPage() {
        this.driver.get(this.config.getUrl() + LoginPage.URL);
        page.waitForPageToLoad(this.driver);
    }

    @Test(groups = {"regression"}, testName = "Normal login fields", description = "Check if the form has all the " +
            "fields and buttons for the normal login.")
    public void validate_Classic_Login_Fields() {
        gotoPage();
        Assert.assertTrue(page.isElementPresent(page.getLoginField(this.driver)));
        Assert.assertTrue(page.isElementPresent(page.getPasswordField(this.driver)));
        Assert.assertTrue(page.isForgetPasswordLinkVisible(this.driver));
        Assert.assertTrue(page.isElementPresent(page.getLoginButton(this.driver)));
        Assert.assertTrue(page.isElementPresent(page.getToggleToSecureLogin(this.driver)));
        Assert.assertTrue(page.isElementPresent(page.getPermLoginSecureCheckbox(this.driver)));
        Assert.assertTrue(page.isElementPresent(page.getPermLoginSecureLabel(this.driver)));
        Assert.assertFalse(page.isElementPresent(page.getCardNumberField(this.driver)));
        Assert.assertFalse(page.isElementPresent(page.getBirthdayField(this.driver)));
        Assert.assertFalse(page.isElementPresent(page.getZipField(this.driver)));
    }

    @Test(groups = {"regression"}, testName = "Secure login fields", description = "Check if the form has all the " +
            "fields and buttons for the secure login.")
    public void validate_Secure_Login_Fields() {
        gotoPage();
        page.waitUntilClickable(this.driver,page.getToggleToSecureLogin(this.driver)).click();
        Assert.assertTrue(page.isElementPresent(page.getCardNumberField(this.driver)));
        Assert.assertTrue(page.isElementPresent(page.getBirthdayField(this.driver)));
        Assert.assertTrue(page.isElementPresent(page.getZipField(this.driver)));
        page.waitUntilClickable(this.driver,page.getTabClassicLoginPIN(this.driver)).click();
        Assert.assertTrue(page.isElementPresent(page.getCardNumberClassicPin(this.driver)));
        Assert.assertTrue(page.isElementPresent(page.getPINField(this.driver)));
    }

    @Test(groups = {"regression"}, testName = "Classic login empty fields validation", description = "Cannot login with empty fields")
    public void test_Classic_Login_Validation() {
        gotoPage();
        page.waitUntilClickable(this.driver, page.getLoginButton(this.driver)).click();
        page.waitForPageToLoad(this.driver);
        page.isWarnMessageVisible(this.driver);
    }

}
