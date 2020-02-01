package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.components.Search;
import resources.Page;

public class PaybackPage extends Page {

    private Search search;

    public PaybackPage(WebDriver driver) {
        super(driver);
        this.search = new Search();
    }

    public WebElement getLogo() {
        return this.getElement(By.id("logo"));
    }

    public WebElement getSearch() {
        return this.search.get(this);
    }
}
