package BasePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetUpClass{
	
	static ThreadLocal<WebDriver> driverLocal = new ThreadLocal<WebDriver>();
	
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driverLocal.set(new ChromeDriver());
		
	}

	public static WebDriver getBrowser() {
		 return driverLocal.get();
	}
}
