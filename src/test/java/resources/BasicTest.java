package resources;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BasicTest {

  protected WebDriver driver;
  protected TestConfig config;

  protected void gotoPage(Page page) {
      this.gotoPage(page, "");
  }

  protected void gotoPage(Page page, String path) {
      this.driver.get(this.config.getUrl() + path);
      page.waitForPageToLoad(this.driver);
  }

  @Parameters({"selenium.url", "selenium.host", "headless", "browser"})
  @BeforeClass(alwaysRun = true)
  public void beforeClass(String url, String host, boolean headless,
                          @Optional("browser") String browser) {
      config = new TestConfig(url, host);
      config.setBrowser(browser);
      driver = Driver.getDriver(config, headless);
      driver.get(url);
  }


  @AfterClass(alwaysRun = true)
  public void afterClass() {
	  if (driver != null) {
          driver.quit();
      }
  }
}
