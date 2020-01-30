package resources;

public class TestConfig {
	
	private String addressUrl;
	private String testBrowser;
	private String seleniumHost;
	
	public TestConfig(String url, String host) {
		addressUrl = url;
		testBrowser = Driver.getPlatform(Driver.Platform.Chrome);
		seleniumHost = host;
	}
	
	public String getUrl() {
		return addressUrl;
	}
	public String getBrowser() {
		return testBrowser;
	}
	public String getHost() {
		return seleniumHost;
	}

	public void setBrowser(String browser) {
		if (browser != null) {
			testBrowser = browser;
		}
	}
}
