package launchBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {
	
	public static void main(String[] args) throws InterruptedException {
		
		//Scanner scn = new Scanner(System.in);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ncheg\\July2021Selenium\\First_Selenium\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); //driver is an industry standard name
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		Thread.sleep(20000);
		
		driver.close();
	}
}
