package kubedemo;



import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Googlepage extends LaunchBrowser{
	@Test(priority=1)
	public void verifygooglepage() throws InterruptedException{
		driver.get("https://www.google.com/");
		//String act_title = driver.get("https://www.google.com/");
		AssertJUnit.assertEquals(driver.getTitle(), "Google");
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
	}
	@Test(priority = 2, dependsOnMethods = "verifygooglepage")
	public void verifyfacebookpage() throws InterruptedException{
		Thread.sleep(5000);
		driver.get("https://www.facebook.com/");
		AssertJUnit.assertEquals(driver.getTitle(), "Facebook - log in or sign up");
		System.out.println(driver.getTitle());
	}
}
