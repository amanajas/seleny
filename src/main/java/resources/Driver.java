package resources;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Driver {

    public enum Platform {Firefox, Chrome}

    private static MutableCapabilities getCapabilities(Platform platform, boolean headless) {
        MutableCapabilities options;
        List<String> arguments = Arrays.asList("--start-maximized");
        switch(platform) {
            case Firefox:
                System.out.println("Opening Firefox driver");
                options = new FirefoxOptions();
                ((FirefoxOptions) options).setHeadless(headless);
                ((FirefoxOptions) options).addArguments(arguments);
                break;
            default:
                System.out.println("Opening Chrome driver");
                options = new ChromeOptions();
                ((ChromeOptions) options).setHeadless(headless);
                ((ChromeOptions) options).setExperimentalOption("useAutomationExtension", false);
                ((ChromeOptions) options).addArguments(arguments);
                break;
        }
        options.setCapability(ChromeOptions.CAPABILITY, options);
        options.setCapability("marionette", true);
        return options;
    }

    public static WebDriver getDriver(TestConfig config, boolean headless) {
        URL url = null;
        try {
            url = new URL(config.getHost());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        MutableCapabilities capabilities;
        switch (config.getBrowser()) {
            case Firefox:
                capabilities = getCapabilities(Platform.Firefox, headless);
                break;
            default:
                capabilities = getCapabilities(Platform.Chrome, headless);
                break;
        }

        return new RemoteWebDriver(url, capabilities);
    }
}
