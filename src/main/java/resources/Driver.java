package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {

    public WebDriver getDriver(String name) {
        if (name.equalsIgnoreCase("Firefox")) {
            return new FirefoxDriver();
        }
        else if (name.equalsIgnoreCase("Safari")) {
            return new SafariDriver();
        }
        else if (name.equalsIgnoreCase("IE")) {
            return new InternetExplorerDriver();
        }
        return new ChromeDriver();
    }
}
