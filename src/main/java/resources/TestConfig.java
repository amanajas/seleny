package resources;

public class TestConfig {
	
	private String addressUrl;
	private Driver.Platform testBrowser;
	private String seleniumHost;
	
	public TestConfig(String url, String host) {
		addressUrl = url;
		testBrowser = Driver.Platform.Chrome;
		seleniumHost = host;
	}
	
	public String getUrl() {
		return addressUrl;
	}
	public Driver.Platform getBrowser() {
		return testBrowser;
	}
	public String getHost() {
		return seleniumHost;
	}

	public void setBrowser(String browser) {
		if (browser != null) {
			testBrowser = Driver.Platform.valueOf(browser);
		}
	}
}
