package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.components.Search;
import resources.Page;

public class PaybackPage extends Page {

    private Search search;

    public PaybackPage() {
        this.search = new Search();
    }

    public WebElement getLogo(WebDriver driver) {
        return this.getElement(driver, By.id("logo"));
    }

    public WebElement getSearch(WebDriver driver) {
        return this.search.get(this, driver);
    }
}
