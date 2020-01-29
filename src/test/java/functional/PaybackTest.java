package functional;

import Pages.PaybackPage;
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
        Assert.assertNotNull(page.getLogo());
    }
}
