package launchBrowser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		//Positive Test
		launchChrome();
		loginTest();
		tearDown();
		
		//Negative Test
		launchChrome();
		negativeLoginTest();
		tearDown();
		
	}
	
	public static void launchChrome() {
		//Launch Chrome and open up a certain link
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
				
		//Maximize the window and delete all Cookies. Also set up a counter
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static void loginTest() { 
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com"); 
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();		
	}
	
	public static void negativeLoginTest() { 
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com"); 
		driver.findElement(By.id("password")).sendKeys("abc1234");
		driver.findElement(By.name("login")).click();		
	}
	
	public static void tearDown() {
		driver.close();
	}
	
	

}
