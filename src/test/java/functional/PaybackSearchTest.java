package functional;

import org.openqa.selenium.Keys;
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

    @Test(groups = {"regression"}, testName = "Search is present and clickable",
            description = "Check if there is a search button")
    public void has_Search_Button() {
        gotoPage(page);
        WebElement search = page.getSearch().get(page, this.driver);
        Assert.assertTrue(page.elementIsPresent(search));
        Assert.assertNotNull(page.waitUntilClickable(this.driver, search));
    }

    @Test(groups = {"regression"}, testName = "Valid search",
            description = "Executing a valid search and displaying results")
    public void valid_Search() {
        gotoPage(page);
        WebElement search = page.waitUntilClickable(this.driver, page.getSearch().get(page, this.driver));
        search.click();
        WebElement searchField = page.getSearch().getField(page, this.driver);
        Assert.assertTrue(page.waitUntilAttributeContains(this.driver, searchField, "class", "focused"));
        searchField.sendKeys("Real");
        searchField.sendKeys(Keys.ENTER);
        Assert.assertTrue(page.getSearch().getSearchResult(page, this.driver).isDisplayed());
        Assert.assertFalse(page.elementIsPresent(page.getSearch().getAlternativeResult(page, this.driver)));
    }

    @Test(groups = {"regression"}, testName = "Invalid search",
            description = "Executing an invalid search displays other options")
    public void invalid_Search() {
        gotoPage(page);
        WebElement search = page.waitUntilClickable(this.driver, page.getSearch().get(page, this.driver));
        search.click();
        WebElement searchField = page.getSearch().getField(page, this.driver);
        Assert.assertTrue(page.waitUntilAttributeContains(this.driver, searchField, "class", "focused"));
        searchField.sendKeys("q12123123");
        searchField.sendKeys(Keys.ENTER);
        Assert.assertTrue(page.getSearch().isSearchResultHidden(page, this.driver));
        Assert.assertTrue(page.getSearch().getAlternativeResult(page, this.driver).isDisplayed());
    }

    @Test(groups = {"regression"}, testName = "(Bug) 404 search", description = "Executing an invalid search causes 404")
    public void error_404() {
        gotoPage(page);
        WebElement search = page.waitUntilClickable(this.driver, page.getSearch().get(page, this.driver));
        search.click();
        WebElement searchField = page.getSearch().getField(page, this.driver);
        Assert.assertTrue(page.waitUntilAttributeContains(this.driver, searchField, "class", "focused"));
        searchField.sendKeys("#$@#$@#$");
        searchField.sendKeys(Keys.ENTER);
        Assert.assertFalse(page.getSearch().get404Image(page, this.driver).isDisplayed());
    }
}
