package resources;

import org.openqa.selenium.WebDriver;

public class Page {

    private WebDriver driver;
    private String browser;

    public Page() {
        driver = null;
    }

    public void openUrl(String url) {
        this.driver = this.getDriver(null);
    }

    public void openUrl(String url, String browser) {
        this.driver = this.getDriver(browser);
    }

    public void openUrlChrome(String url) {
        this.openUrl(url, "Chrome");
    }

    public void openUrlFirefox(String url) {
        this.openUrl(url, "Firefox");
    }

    public void openUrlSafari(String url) {
        this.openUrl(url, "Safari");
    }

    public void openUrlIE(String url) {
        this.openUrl(url, "IE");
    }

    public WebDriver getDriver(String browser) {
        if (this.driver == null) {
            this.driver = new Driver().getDriver(browser);
        }
        return driver;
    }

    public void quit() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

}
