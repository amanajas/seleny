package functional;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import resources.BasicTest;

public class LoginFormTest extends BasicTest {

    protected LoginPage page;

    public LoginFormTest() {
        page = new LoginPage();
    }

    @Test(groups = {"regression"}, testName = "Normal login fields",
            description = "Check if the form has all the fields and buttons for the normal login")
    public void validate_Classic_Login_Fields() {
        gotoPage(page, LoginPage.URL);
        Assert.assertTrue(page.elementIsPresent(page.getLoginField(this.driver)));
        Assert.assertTrue(page.elementIsPresent(page.getPasswordField(this.driver)));
        Assert.assertTrue(page.isForgetPasswordLinkVisible(this.driver));
        Assert.assertTrue(page.elementIsPresent(page.getLoginButton(this.driver)));
        Assert.assertTrue(page.elementIsPresent(page.getToggleToSecureLogin(this.driver)));
        Assert.assertTrue(page.elementIsPresent(page.getPermLoginSecureCheckbox(this.driver)));
        Assert.assertTrue(page.elementIsPresent(page.getPermLoginSecureLabel(this.driver)));
        Assert.assertFalse(page.elementIsPresent(page.getCardNumberField(this.driver)));
        Assert.assertFalse(page.elementIsPresent(page.getBirthdayField(this.driver)));
        Assert.assertFalse(page.elementIsPresent(page.getZipField(this.driver)));
    }

    @Test(groups = {"regression"}, testName = "Secure login fields",
            description = "Check if the form has all the fields and buttons for the secure login")
    public void validate_Secure_Login_Fields() {
        gotoPage(page, LoginPage.URL);
        page.waitUntilClickable(this.driver,page.getToggleToSecureLogin(this.driver)).click();
        Assert.assertTrue(page.elementIsPresent(page.getCardNumberField(this.driver)));
        Assert.assertTrue(page.elementIsPresent(page.getBirthdayField(this.driver)));
        Assert.assertTrue(page.elementIsPresent(page.getZipField(this.driver)));
        page.waitUntilClickable(this.driver,page.getTabClassicLoginPIN(this.driver)).click();
        Assert.assertTrue(page.elementIsPresent(page.getCardNumberClassicPin(this.driver)));
        Assert.assertTrue(page.elementIsPresent(page.getPINField(this.driver)));
    }

    @Test(groups = {"regression"}, testName = "Classic login empty fields validation", description = "Cannot login with empty fields")
    public void test_Classic_Login_Validation() {
        gotoPage(page, LoginPage.URL);
        page.waitUntilClickable(this.driver, page.getLoginButton(this.driver)).click();
        page.waitForPageToLoad(this.driver);
        page.isWarnMessageVisible(this.driver);
    }

}
