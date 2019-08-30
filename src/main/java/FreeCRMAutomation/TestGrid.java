package FreeCRMAutomation;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestGrid {

	public static void main(String[] args) throws MalformedURLException {

		//1. Define Desired Capabilities
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WIN10);
		
		//2. Chrome Options Definitions
		
		ChromeOptions options = new ChromeOptions();
		options.merge(cap);
		
		String hubUrl = "http://192.168.1.8:4444/wd/hub";
		WebDriver driver = new RemoteWebDriver(new URL(hubUrl), cap);
		
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		
				
	}

}
