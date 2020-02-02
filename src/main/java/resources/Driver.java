package resources;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class Driver {

    public enum Platform {Firefox, Chrome}

    public static final String CHROME_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_2) AppleWebKit/537.36 " +
            "(KHTML, like Gecko) Chrome/79.0.3945.117 Safari/537.36";

    private static final String FIREFOX_AGENT = "Mozilla/5.0 (X11; Linux i686; rv:64.0) Gecko/20100101 Firefox/64.0";

    private static String getServerProxy(Platform platform) {
        BrowserMobProxy proxy = new BrowserMobProxyServer();
        proxy.start(0);
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);

        // put our custom header to each request
        proxy.addRequestFilter((request, contents, messageInfo)->{
            request.headers().add("Referrer Policy", "no-referrer-when-downgrade");
            request.headers().add("Cache-Control", "no-cache");
            request.headers().add("User-Agent", getAgent(platform));
            System.out.println(request.headers().entries().toString());
            return null;
        });

        return "--proxy-server=" + seleniumProxy.getHttpProxy();
    }

    private static MutableCapabilities getCapabilities(Platform platform, boolean headless) {
        MutableCapabilities options;
        List<String> arguments = Arrays.asList("--start-maximized", "--user-agent=" + getAgent(platform));
        String proxy = getServerProxy(platform);
        switch(platform) {
            case Firefox:
                System.out.println("Opening Firefox driver");
                options = new FirefoxOptions();
                FirefoxProfile profile = new FirefoxProfile();
                ((FirefoxOptions) options).setHeadless(headless);
                ((FirefoxOptions) options).addArguments(arguments);
                ((FirefoxOptions) options).addArguments(proxy);
                options.setCapability(FirefoxDriver.PROFILE, profile);
                break;
            default:
                System.out.println("Opening Chrome driver");
                options = new ChromeOptions();
                ((ChromeOptions) options).setHeadless(headless);
                ((ChromeOptions) options).setExperimentalOption("useAutomationExtension", false);
                ((ChromeOptions) options).setExperimentalOption("excludeSwitches",
                        Collections.singletonList("enable-automation"));
                ((ChromeOptions) options).addArguments(arguments);
                ((ChromeOptions) options).addArguments(proxy);
                break;
        }
        options.setCapability(ChromeOptions.CAPABILITY, options);
        options.setCapability("marionette", true);
        return options;
    }

    private static String getAgent(Platform platform) {
        String agent;
        switch(platform) {
            case Firefox:
                agent = FIREFOX_AGENT;
                break;
            default:
                agent = CHROME_AGENT;
                break;
        }
        return agent;

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
