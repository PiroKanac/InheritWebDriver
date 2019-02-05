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


public class AddNewUser extends Driver {
	
	

	
	@Test 
	public void AddNewUserValidTest1() throws InterruptedException{
		
		// Navigate to User Management and add a new user with valid inputs
		
		driver.navigate().to("https://education.qacube.com/qacube/users_list.htm");
		
		// Click on Add New User button
		driver.findElement(By.cssSelector("body > div > div.l_central-content.u_overflow-inherit.js-central-content > "
				+ "div.l_main-content > div.container.users-management > "
				+ "div.grid-24.js-filter-container.table-wrap > span:nth-child(4)")).click();
		WebElement popup = driver.findElement(By.id("js-user-new-modal"));
		//   Input Full Name 
		popup.findElement(By.id("full-name")).sendKeys("Tester1");
		//   Input email address
	    popup.findElement(By.id("user-email")).sendKeys("tester1@sixsentix.com");
		//   Input password
		popup.findElement(By.id("password")).sendKeys("test1234");
		//   Repeat password
		popup.findElement(By.id("password_confirmation")).sendKeys("test1234");
		// Select user role 
		popup.findElement(By.id("userRole_chosen")).click();
		popup.findElement(By.cssSelector("#userRole_chosen > div > ul > li:nth-child(1)")).click(); 
		// Save
		popup.findElement(By.cssSelector("#js-settings-form-save")).click();	
		// Find newly created user
		driver.findElement(By.id("search-user")).sendKeys("Tester1");	
		// Verify data for newly created user
		Thread.sleep(2000);	
		List<WebElement> elements = driver.findElements(By.id("js-users-tbody-list"));		
		for(WebElement element: elements)
		{	    System.out.println(element.getText());	}
		// DELETE USER
		Thread.sleep(2000);
		WebElement table = driver.findElement(By.id("user-list"));
		List<WebElement> rows = table.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
		for (WebElement row : rows ) {			
			String classname = row.getAttribute("class");			
			if (!classname.contains("hide")) {
				List<WebElement> cells = row.findElements(By.tagName("td"));
					WebElement settingsCell = cells.get(cells.size()-1). findElement(By.tagName("div"));
					settingsCell.click();
					WebElement editOptions = settingsCell.findElement(By.className("dropdown"));
					WebElement deleteOption = editOptions.findElements(By.tagName("li")).get(1);
					deleteOption.click();	}
			} 	
		// OK Button
		WebElement fancyBox = driver.findElement(By.className("popup-options"));
		fancyBox.click();
		WebElement alert = fancyBox.findElement(By.className("button-holder"));
		alert.findElement(By.tagName("span")).click();
		// Verify empty table
		Thread.sleep(2000);
		WebElement tableEmpty = driver.findElement(By.id("user-list"));
		List<WebElement> result = tableEmpty.findElements(By.id("js-users-tbody-list"));		
		for(WebElement element: result)
		{	    System.out.println(element.getText());	}
	}

	

	
}
