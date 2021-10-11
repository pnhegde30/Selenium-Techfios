package variousConcepts;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {
	
	WebDriver driver;
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void loginTest() {
		
		//Storing Web Element 
		//Type name = value
		WebElement userNameElement = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement passwordElement = driver.findElement(By.xpath("//*[id=\"password\"]"));
		WebElement signInButtonElement = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));
		
		By userNameField = By.xpath("//input[@id='username']");
		By passwordField = By.xpath("//*[id=\\\"password\\\"]");
		By signInButtonField = By.xpath("/html/body/div/div/div/form/div[3]/button");
		By dashboardField = By.xpath("//*[@id=\\\"page-wrapper\\\"]/div[2]/div/h2");
		
		//Logging in
		//clear the element
		driver.findElement(userNameField).clear();
		//userNameElement.clear();
		userNameElement.sendKeys("demo@techfios.com");
		passwordElement.sendKeys("abc123");
		signInButtonElement.click();
		
		boolean pageTitleDisplayStatus;
		try {
			WebElement dashboardElement = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2"));
			 pageTitleDisplayStatus = true;
		}
		catch(Exception e) {
			pageTitleDisplayStatus = false;
			e.printStackTrace();
		}
		
		WebDriverWait wait = new WebDriverWait(driver, 10); //Explicit Wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardField)); //Wait for this element 
		
		Assert.assertTrue("Dashboard page not found", pageTitleDisplayStatus);
	}

}
