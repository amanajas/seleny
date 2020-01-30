package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import resources.Page;

public class PaybackPage extends Page {

    public PaybackPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getLogo() {
        return this.getElement(By.id("logo"));
    }
}
