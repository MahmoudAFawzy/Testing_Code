package workingWithElements;

import static org.testng.Assert.fail;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithCheckBoxes {

	ChromeDriver driver;
	@BeforeTest 
	public void openURL() {
		String chromePath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);

		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");
		System.out.println(driver.getCurrentUrl());
	}


	@Test (enabled = false)
	
	public void testCheckBox() throws InterruptedException {
		
		WebElement check1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
		check1.click();
		Thread.sleep(3000);
		
		WebElement check2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
		if (check2.isSelected()) {
			check2.click();
			Thread.sleep(3000);
		}
	}
	
	@Test
	
	public void testElementPresent() {
		
		if (isElementPresent(By.xpath("//*[@id=\"checkboxes\"]/input[1]"))) {
			
			WebElement check1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
			
			if (!check1.isSelected()) {
				check1.click();
			}
			
			
		} else {
			Assert.fail("Checkbox 1 doesn't exist");
		}
		
		
	}
	
	
	private boolean isElementPresent(By by) {
		try {
			
			driver.findElement(by);
			return true;
			
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	
	
	


	@AfterTest
	public void closeDriver() {

		driver.quit();

	}

}
