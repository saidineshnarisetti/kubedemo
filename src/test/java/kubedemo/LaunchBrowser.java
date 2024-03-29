package kubedemo;

import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.AfterClass;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LaunchBrowser {

    public static RemoteWebDriver driver = null;

    @Parameters({ "browser", "seleniumHubUrl" })
    @BeforeClass
    public void openDriver(String browser, String seleniumHubUrl) throws MalformedURLException {
		System.out.println("Browser passed as: " + browser);
		System.out.println("Selenium Hub URL: " + seleniumHubUrl);

        if (browser.equalsIgnoreCase("Chrome")) {
            ChromeOptions options = new ChromeOptions();
            URL u = new URL(seleniumHubUrl);
            driver = new RemoteWebDriver(u, options);
        } else if (browser.equalsIgnoreCase("Firefox")) {
            FirefoxOptions foptions = new FirefoxOptions();
            URL u = new URL(seleniumHubUrl);
            driver = new RemoteWebDriver(u, foptions);
        } else if (browser.equalsIgnoreCase("Edge")) {
            EdgeOptions Eoptions = new EdgeOptions();
            URL u = new URL(seleniumHubUrl);
            driver = new RemoteWebDriver(u, Eoptions);
        }
    }

    @AfterClass
    public void terminateBrowser() {
        driver.quit(); // Quitting the browser
    }
}
