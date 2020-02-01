package functional;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PaybackPage;
import resources.BasicTest;

public class PaybackSearchTest extends BasicTest {

    protected PaybackPage page;

    public PaybackSearchTest() {
        page = new PaybackPage();
    }

    @Test(groups = {"regression"}, testName = "Search is present", description = "Check if there is a search button")
    public void has_Search_Button() {

    }

    @Test(groups = {"regression"}, testName = "Valid search", description = "Check if it is possible to search")
    public void valid_Search() {

    }

    @Test(groups = {"regression"}, testName = "Invalid search", description = "Executing an invalid search")
    public void invalid_Search() {

    }
}
