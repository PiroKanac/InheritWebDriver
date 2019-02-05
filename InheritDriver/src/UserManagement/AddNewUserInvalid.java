package UserManagement;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Base.Driver;

public class AddNewUserInvalid extends Driver{
	
	
	
	@Test
	public void AddNewUserInvalidTest2() throws InterruptedException {
		driver.navigate().to("https://education.qacube.com/qacube/users_list.htm");
		// Click on Add New User button
		driver.findElement(By.cssSelector("body > div > div.l_central-content.u_overflow-inherit.js-central-content > "
				+ "div.l_main-content > div.container.users-management > "
				+ "div.grid-24.js-filter-container.table-wrap > span:nth-child(4)")).click();
		
		WebElement popup = driver.findElement(By.id("js-user-new-modal"));
	
		// Save
		popup.findElement(By.id("formErrors"));
		popup.findElement(By.cssSelector("#js-settings-form-save")).click();
		//Error messages
		List<WebElement> elements = driver.findElements(By.id("formErrors"));
		
		for(WebElement element: elements)
		{
		    System.out.println(element.getText());
		}
		popup.findElement(By.cssSelector("#add_new_user > p > i")).click();
	}
	
	
}

