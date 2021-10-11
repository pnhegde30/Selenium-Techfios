package launchBrowser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestDupe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//This is all the same code to setProperty. Different variations
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\ncheg\\July2021Selenium\\crm\\drivers\\chromedriver.exe");
//		System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
//		System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
		
		//Launch Chrome and open up a certain link
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		
		//Maximize the window and delete all Cookies. Also set up a counter
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//identify an element in a website
		//In this case: username from the link above
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		//Identify the password element 
		driver.findElement(By.id("password")).sendKeys("abc123");
		//Identify Login element 
		driver.findElement(By.name("login")).click();
		
		//close the webpage 
		driver.close();

	}

}
