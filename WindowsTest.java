package week4.day1;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();

		driver.findElement(By.id("home")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> handles = new ArrayList<String>(windowHandles);
		driver.switchTo().window(handles.get(1));
		
		Set<String> windowHandles1 = driver.getWindowHandles();
		ArrayList<String> handles1 = new ArrayList<String>(windowHandles1);
		driver.switchTo().window(handles1.get(0));
		
		
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		
		Set<String> windowHandles2 = driver.getWindowHandles();
		int noOfFrames= windowHandles2.size();
		System.out.println("No of Frames is " + noOfFrames);
		ArrayList<String> handles2 = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(handles2.get(0));
		
	    driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();
	    
	    Set<String> windowHandles3 = driver.getWindowHandles();
	    int noOfFrames1 = windowHandles3.size();
		ArrayList<String> handles3 = new ArrayList<String>(windowHandles3);
		for (int i =1; i<noOfFrames1 ; i++) {
			driver.switchTo().window(handles3.get(i)).close();
		}
		driver.switchTo().window(handles3.get(0));
		
		
	   driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
	   Thread.sleep(5000);
		
	}
	

}
