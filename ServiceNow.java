package week4.day1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev116606.service-now.com/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Jellybelly@46");
		driver.findElement(By.id("sysverb_login")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("filter")).sendKeys("incident");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='sn-widget-list-content']//div[text()='All'])[2]")).click();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
		driver.findElement(By.id("sys_display.incident.caller_id")).sendKeys("admin");
		Thread.sleep(2000);
		driver.findElement(By.id("incident.short_description")).sendKeys("Short Description");
		String incidentNumber = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		driver.findElement(By.xpath("//button[@id='sysverb_insert']")).click();
		WebElement findElement = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		findElement.sendKeys(incidentNumber);
		findElement.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File ("./incident.png");
		FileUtils.copyFile(source, destination);
		
		
		
		
		
		
		
		
	}

}
