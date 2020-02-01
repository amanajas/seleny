package functional;

import pages.PaybackPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import resources.BasicTest;

public class PaybackTest extends BasicTest {

    private PaybackPage page;

    @BeforeClass
    public void beforeClass() {
        page = new PaybackPage(driver);
        driver.get(config.getUrl());
    }

    @Test(groups = {"regression"}, testName = "Logo", description = "Check if the logo appears and redirects to homepage")
    public void getElement_Logo() {
        WebElement logo = page.getLogo();
        Assert.assertNotNull(logo);
        String url = this.driver.getCurrentUrl();
        logo.click();
        WebElement logo2 = page.getLogo();
        Assert.assertNotNull(logo2);
        Assert.assertEquals(url, this.driver.getCurrentUrl());
    }
}
