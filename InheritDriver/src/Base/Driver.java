package Base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	
	static String driverPath = "C:\\Users\\vnikolic\\Downloads\\Selenium";
	public WebDriver driver;
	
	@Before
	public void setUp() {
		
		//    Open Chrome browser
		System.out.println("*******************");
		System.out.println("launching Chrome browser");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vnikolic\\Downloads\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//     Navigate to QACube education and log in
		
		driver.navigate().to("https://education.qacube.com/qacube/login.htm");
		
		driver.findElement(By.name("j_username")).sendKeys("vladimir.nikolic@sixsentix.com");
		
		driver.findElement(By.name("j_password")).sendKeys("hello");
		
		driver.findElement(By.cssSelector("body > div > div > form > div.c_login-buttons > button")).click();
	}
	
	@After
	public void tearDown() throws InterruptedException {

		 // LOG OUT
		driver.findElement(By.cssSelector("body > div > div.l_central-content.u_overflow-inherit.js-central-content > div.l_header.u_print-hidden >"
				+ " div > div.l_header__secondary.u_position-relative > div:nth-child(6) > button")).click();
		driver.findElement(By.cssSelector("body > div > div.l_central-content.u_overflow-inherit.js-central-content > div.l_header.u_print-hidden >"
				+ " div > div.l_header__secondary.u_position-relative > div.o_popup-container.js-popup-container.u_vertical-align.o_popup--is-active >"
				+ " div > div > ul > li:nth-child(3) > a")).click();
		// Close Browser
		if(driver!=null) {
			System.out.println("Closing Chrome browser");
			
			driver.quit();
		}
	}
}
