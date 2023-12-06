package kubedemo;

import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.AfterClass;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class LaunchBrowser {
	public static RemoteWebDriver driver=null;
	@Parameters({ "browser" }) // Used TestNg parameterization concept 
	@BeforeClass 
	public void opendriver(String browser, String seleniumHubUrl)  throws MalformedURLException { 
		System.out.println("browser passed as :- " + browser);
		System.out.println("url :"+ seleniumHubUrl);
		if(browser.equalsIgnoreCase("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			//URL u=new URL("http://127.0.0.1:53908/wd/hub");
			URL u=new URL("seleniumHubUrl");
			driver = new RemoteWebDriver (u,options);	
		}
		if(browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions foptions =new FirefoxOptions();
			//URL u=new URL("http://127.0.0.1:53908/wd/hub");
			URL u=new URL("seleniumHubUrl");
			driver = new RemoteWebDriver(u,foptions);	
			}
		if(browser.equalsIgnoreCase("Edge")) {
			EdgeOptions Eoptions =new EdgeOptions();
			//URL u=new URL("http://127.0.0.1:53908/wd/hub");
			URL u=new URL("seleniumHubUrl");
			driver = new RemoteWebDriver(u,Eoptions);	
			}
	} 
  @AfterClass
  public void terminateBrowser(){
      driver.close();			///Closing browser
	}
}
