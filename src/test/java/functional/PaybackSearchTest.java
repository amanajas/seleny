package functional;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.PaybackPage;
import resources.BasicTest;

public class PaybackSearchTest extends BasicTest {

    private PaybackPage page;

    @BeforeClass
    public void beforeClass() {
        page = new PaybackPage(driver);
        driver.get(config.getUrl());
    }

    @Test(groups = {"regression"}, testName = "Valid search", description = "Check if it is possible to search")
    public void valid_Search() {

    }

    @Test(groups = {"regression"}, testName = "Invalid search", description = "Executing an invalid search")
    public void invalid_Search() {

    }
}
