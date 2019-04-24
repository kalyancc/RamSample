package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

import org.openqa.*;

public class First {
	public static void main(String args[])  {
		System.setProperty("webdriver.gecko.driver", "C:\\cd\\geckodriver.exe");
		FirefoxOptions opt=new FirefoxOptions();
		opt.setBinary(new FirefoxBinary(new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe")));

		WebDriver driver = new FirefoxDriver(opt);
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
		
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("container_tasks")));

		driver.findElement(By.id("container_tasks")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Add New')]")));
		driver.findElement(By.xpath("//div[contains(text(),'Add New')]")).click();
		
		driver.findElement(By.xpath("//div[@class='item createNewCustomer']")).click();
		driver.findElement(By.xpath("//div[@class='customerNameDiv']//input[@placeholder='Enter Customer Name']")).sendKeys("LondonCustomer");
		driver.findElement(By.xpath("//textarea[@placeholder='Enter Customer Description']")).sendKeys("New Customer Message");
		driver.findElement(By.xpath("//div[contains(text(),'Create Customer')]")).click();
		String txt = driver.getPageSource();
		if (txt.contains("LondonCustomer")){
			System.out.println("Found");
		}
		else
		{
			System.out.println("Not Found");
	
		}
	}
}
