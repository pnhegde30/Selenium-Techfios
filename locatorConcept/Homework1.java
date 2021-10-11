package locatorConcept;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework1 {

	WebDriver driver;

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.techfios.com/billing/?ng=admin/");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void runTest() {
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
		//driver.findElement(By.xpath("//a[text() = 'New Account']")).click();
		driver.findElement(By.xpath("//span[@class='nav-label']")).click();
		driver.get("https://techfios.com/billing/?ng=accounts/add/\">New Account/");
		driver.findElement(By.id("account")).sendKeys("Home Payment Loan 2");
		driver.findElement(By.id("description")).sendKeys("A description of the account");
		driver.findElement(By.id("balance")).sendKeys("30,500");
		driver.findElement(By.id("account_number")).sendKeys("1234567890");
		driver.findElement(By.id("contact_person")).sendKeys("Pratik Hegde");
		driver.findElement(By.id("contact_phone")).sendKeys("214-555-8833");
		driver.findElement(By.name("ib_url")).sendKeys("https://techfios.com/register/courses");
		driver.findElement(By.xpath("//button[@class = 'btn btn-primary']")).click();	
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
		driver.quit();
	}
	
}
