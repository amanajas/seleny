package functional;

import pages.PaybackPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import resources.BasicTest;

public class PaybackTest extends BasicTest {

    protected PaybackPage page;

    public PaybackTest() {
        page = new PaybackPage();
    }

    @Test(groups = {"regression"}, testName = "Logo", description = "Check if the logo appears and redirects to homepage")
    public void getElement_Logo() {
        WebElement logo = page.getLogo(this.driver);
        Assert.assertNotNull(logo);
        String url = this.driver.getCurrentUrl();
        logo.click();
        page.waitForPageToLoad(this.driver);
        WebElement logo2 = page.getLogo(this.driver);
        Assert.assertNotNull(logo2);
        Assert.assertEquals(url, this.driver.getCurrentUrl());
    }
}
