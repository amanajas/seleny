package resources;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BasicTest {

  protected WebDriver driver;
  protected TestConfig config;

  @Parameters({"selenium.url", "selenium.host", "browser", "headless"})
  @BeforeTest(alwaysRun = true)
  public void beforeTest(String url, String host,
                          @Optional("browser") String browser,
                          @Optional("headless") boolean headless) {
      config = new TestConfig(url, host);
      config.setBrowser(browser);
      driver = Driver.getDriver(config, headless);
  }


  @AfterTest(alwaysRun = true)
  public void afterTest() {
	  if (driver != null) {
          driver.quit();
      }
  }
}
