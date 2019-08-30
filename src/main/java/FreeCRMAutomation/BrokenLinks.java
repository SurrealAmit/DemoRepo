package FreeCRMAutomation;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks{

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {

		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "D:\\amit\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://makemysushi.com/Recipes/how-to-make-california-sushi-rolls");
		/*
		 * driver.findElement(By.name("username")).sendKeys("amitch");
		 * driver.findElement(By.name("password")).sendKeys("test@123");
		 * Thread.sleep(2000);
		 * driver.findElement(By.xpath("//input[@type='submit']")).click();
		 * 
		 * driver.switchTo().frame("mainpanel");
		 */
		
		List<WebElement> linklist = driver.findElements(By.tagName("a"));
		linklist.addAll(driver.findElements(By.tagName("img")));
		
		System.out.println("Total link and images are:--->" + linklist.size());
		
		List<WebElement> activelinks = new ArrayList();
		
		for(int i=0;i<linklist.size();i++) {
			if(linklist.get(i).getAttribute("href") != null && (! linklist.get(i).getAttribute("href").contains("javascript"))){
				activelinks.add(linklist.get(i));
			}
		}
		System.out.println("Total active links and images are:--->" + activelinks.size());	
		
		for(int j=0; j<activelinks.size();j++) {
			HttpURLConnection connection = 	(HttpURLConnection) new URL(activelinks.get(j).getAttribute("href")).openConnection();
			
			connection.connect();
			String response = connection.getResponseMessage();
			connection.disconnect();
			System.out.println(activelinks.get(j).getAttribute("href") + "-->" + response);
		}

	}

}
