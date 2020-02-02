package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.PaybackPage;
import resources.Page;

public class Search {

    private static final String xpath = "//*[@id=\"mainNav\"]/div[2]/div[2]/div/ul/li[8]/div/pbc-searchfield/form";
    private static final String field = "input[name=q]";
    private static final String searchResults = "//*[@id=\"search-slider-112080\"]";
    private static final String error404 = "/html/body/div[1]/div[3]/div/div/div/div[1]/img";

    public WebElement get(Page page, WebDriver driver) {
        return page.getElement(driver, By.xpath(xpath));
    }

    public WebElement getField(Page page, WebDriver driver) {
        WebElement search = this.get(page, driver);
        return search.findElement(By.cssSelector(field));
    }

    public WebElement getSearchResult(Page page, WebDriver driver) {
        return page.getElement(driver, By.xpath(searchResults + "/div[1]"));
    }

    public WebElement getAlternativeResult(Page page, WebDriver driver) {
        return page.getElement(driver, By.xpath(searchResults + "/div[2]"));
    }

    public WebElement get404Image (Page page, WebDriver driver) {
        return page.getElement(driver, By.xpath(error404));
    }

    public boolean isSearchResultHidden(PaybackPage page, WebDriver driver) {
        return page.waitUntilAttributeContains(
                driver,
                this.getSearchResult(page, driver),
                "class",
                "hidden");
    }
}
