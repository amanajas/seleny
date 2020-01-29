package resources;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BasicTest {

  protected WebDriver driver;
  protected TestConfig config;

  @Parameters({"selenium.url", "selenium.host"})
  @BeforeSuite(alwaysRun = true)
  public void beforeSuite(String url, String host) {
      config = new TestConfig(url, host);
  }

  @Parameters({"browser"})
  @BeforeTest(alwaysRun = true)
  public void beforeTest(String browser) {
      config.setBrowser(browser);
      driver = Driver.getDriver(config);
  }

  @AfterTest(alwaysRun = true)
  public void afterTest() {
	  if (driver != null) {
          driver.quit();
      }
  }
}
