package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {

    public static WebDriver getDriver(TestConfig config) {
        URL url = null;
        try {
            url = new URL(config.getHost());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        if (config.getBrowser().equalsIgnoreCase("Firefox")) {
            capabilities = DesiredCapabilities.firefox();
        }
        return new RemoteWebDriver(url, capabilities);
    }
}
