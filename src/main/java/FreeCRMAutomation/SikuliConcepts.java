package FreeCRMAutomation;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;



public class SikuliConcepts {

	public static void main(String[] args) throws FindFailed, InterruptedException {

		WebDriver driver;
				
		System.setProperty("webdriver.chrome.driver", "D:\\amit\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://classic.crmpro.com/index.html");
		Screen sc = new Screen();
		
		Pattern signIn = new Pattern("FreeCRM_Sign_In.PNG");
		sc.wait(signIn, 2000);
		sc.click();
		
		driver.navigate().back();
		
		Pattern Pricing = new Pattern("FreeCRM_Pricing.PNG");
		sc.wait(Pricing, 2000);
		sc.click();
		   
		
	}

}
