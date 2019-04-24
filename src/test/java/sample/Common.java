package sample;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.LoginPage;
import pages.TaskPage;

public class Common {

	public WebDriver OpenBrowser(String BrowserName){
		
		if (BrowserName == "FireFox") {
			System.setProperty("webdriver.gecko.driver", "C:\\cd\\geckodriver.exe");
			FirefoxOptions opt=new FirefoxOptions();
			opt.setBinary(new FirefoxBinary(new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe")));
			WebDriver driver = new FirefoxDriver(opt);
			return driver;
		}
		return null;
	}

	public void Login( WebDriver driver) {
		CommonVarialbes cv = new CommonVarialbes();
		WebUI wu = new WebUI();
		LoginPage lp = new LoginPage();
		
		driver.get(cv.appURL);
		wu.EnterText(driver, "Id", lp.username, cv.Admin);
		wu.EnterText(driver, "Name", lp.password, cv.PwdForAdmin);
		wu.ClickObject(driver,"Id",lp.loginbutton);

	}

	public void CreateNewCustomer(WebDriver driver) {
		WebUI wu = new WebUI();
		TaskPage tp = new TaskPage();
		CommonVarialbes cv = new CommonVarialbes();
		wu.ClickObject(driver,"xPath",tp.container_tasks);
		wu.ClickObject(driver,"xPath",tp.AddNewButton);
		wu.ClickObject(driver,"xPath",tp.AddNewCustomer);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wu.EnterText(driver, "xPath", tp.EnterCustomerName, cv.NewCustomerName );
		wu.EnterText(driver, "xPath", tp.NewCustomerMessage, cv.NewCustomerName );
		wu.ClickObject(driver, "xPath", tp.CreateCuster);
				
		
		//driver.findElement(By.xpath("//div[@class='item createNewCustomer']")).click();
		//driver.findElement(By.xpath("//div[@class='customerNameDiv']//input[@placeholder='Enter Customer Name']")).sendKeys("LondonCustomer1");
		//driver.findElement(By.xpath("//textarea[@placeholder='Enter Customer Description']")).sendKeys("New Customer Message");
		//driver.findElement(By.xpath("//div[contains(text(),'Create Customer')]")).click();
		
	}
}
