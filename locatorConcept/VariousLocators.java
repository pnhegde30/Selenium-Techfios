package locatorConcept;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VariousLocators {
	
	WebDriver driver;
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe" );
		driver = new ChromeDriver();
		driver.get("https://objectspy.space/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void learnLocators() {
		//locator Name
		driver.findElement(By.name("firstname")).sendKeys("selenium");
		//locator ID
		driver.findElement(By.id("sex-1")).click();
		//locator ClassName
		//uploading a file - use sendKeys or Robot Class if the tag is not input
		driver.findElement(By.className("input-file")).sendKeys("C:\\Users\\ncheg\\OneDrive\\Pictures\\Random Pics\\Techfios.png");
		
		//locator LinkText
		driver.findElement(By.linkText("OS-API Product FrontEnd")).click();
		//navigate back to previous page
		driver.navigate().back();
		//locator partialLinkText
		driver.findElement(By.partialLinkText("TF-API Product")).click();
		driver.navigate().back();
		
		//locator CSS
		driver.findElement(By.cssSelector("input#profession-1")).click();
		driver.findElement(By.cssSelector("input[value='5']")).click();
		driver.findElement(By.cssSelector("input[name='exp'][id='exp-4']")).click();
		
		//locator XPath
		//Absolute 
		driver.findElement(By.xpath("html/body/div/div[2]/div[2]/form/div[10]/input")).sendKeys("Selenium is fun");
		//Relative
		//These two are the same thing
		driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("xpath is easy");
		driver.findElement(By.xpath("//input[@name='Password' and @type='password']")).sendKeys(("xpath is easy"));
		
		//These two are the same thing
		driver.findElement(By.xpath("//strong[text()='Link Test : New Page']")).click();
		driver.findElement(By.xpath("//strong[contains(text(), 'Link Test : New Page')]")).click();
	}
	
	//@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	

}
