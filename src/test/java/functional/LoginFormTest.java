package functional;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PaybackPage;
import resources.BasicTest;

public class LoginFormTest extends BasicTest {

    private LoginPage page;

    @BeforeClass
    public void beforeClass() {
        page = new LoginPage(driver);
        driver.get(config.getUrl() + LoginPage.URL);
    }

    @Test(groups = {"regression"}, testName = "Form fields", description = "Check if the form has all the fields")
    public void login_Fields() {

    }

    @Test(groups = {"regression"}, testName = "Classic login validation", description = "Test classic login validation")
    public void test_Classic_Login_Validation() {

    }

    @Test(groups = {"regression"}, testName = "Secure login validation", description = "Test classic login validation")
    public void test_Secure_Login_Validation() {

    }

}
