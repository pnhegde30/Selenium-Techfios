package launchBrowser;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest_JUnit {

	WebDriver driver;

	@BeforeClass
	public static void beforeClass() {
		System.out.println("I am Before Class");
	}

	@Before
	public void launchChrome() {
		System.out.println("I am Before Method");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.techfios.com/billing/?ng=admin/");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void loginTest() {
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
		//driver.findElement(By.className("btn btn-success block full-width")).click();
	}

	@Test
	public void negativeLoginTest() {
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc1234");
		driver.findElement(By.name("login")).click();
	}

	@After
	public void tearDown() {
		System.out.println("I am After Method");
		driver.close();
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("I am After Class");
	}

}
