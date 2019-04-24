package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebUI {

	public void EnterText(WebDriver dr, String objPathType, String objPathValue, String Data) {

		if (objPathType == "Id") {
			dr.findElement(By.id(objPathValue)).sendKeys(Data);
		} else if (objPathType == "xPath") {
			dr.findElement(By.xpath(objPathValue)).sendKeys(Data);
		} else if (objPathType == "Name") {
			dr.findElement(By.name(objPathValue)).sendKeys(Data);
		}
	}

	public void ClickObject(WebDriver driver, String objPathType, String objPathValue) {
		// WebDriverWait wait = new WebDriverWait(driver, 60);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (objPathType == "Id") {
			// wait.until(ExpectedConditions.elementToBeClickable(By.id(objPathType)));
			driver.findElement(By.id(objPathValue)).click();
		} else if (objPathType == "xPath") {
			// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(objPathType)));
			driver.findElement(By.xpath(objPathValue)).click();
		}

	}

	public void ClickObject(WebDriver driver, String objPathType, String objPathValue, boolean waitRequired) {
		WebDriverWait wait = new WebDriverWait(driver, 60);

		if (objPathType == "Id") {
			if (waitRequired == true) {
				WebElement we = driver.findElement(By.id(objPathType));
				wait.until(ExpectedConditions.visibilityOf(we));
			}

		} else if (objPathType == "xPath") {
			System.out.println("i m here /.................");
			System.out.println(waitRequired);

			if (waitRequired) {
				WebElement we = driver.findElement(By.xpath(objPathType));
				System.out.println("waiting/.................");
				wait.until(ExpectedConditions.visibilityOf(we));
				// wait.until(ExpectedConditions.elementToBeSelected(By.xpath(objPathType)));
				System.out.println("Done/.................");
			}
			driver.findElement(By.xpath(objPathValue)).click();
		}

	}

}
