package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import resources.Page;

public class Search {

    private static final String xpath = "//*[@id=\"mainNav\"]/div[2]/div[2]/div/ul/li[8]/div/pbc-searchfield/form";

    public WebElement get(Page page) {
        return page.getElement(By.xpath(xpath));
    }
}
