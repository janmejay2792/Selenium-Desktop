package com.api.desktopAutomation;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.annotations.Test;

public class calc {
	public static  WiniumDriver driver;
	public static WebElement CalculatorResult;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesktopOptions option = new DesktopOptions();
		option.setApplicationPath("C:\\Windows\\System32\\calc.exe");
//		option.setApplicationPath("C:\\Users\\janme\\Downloads\\WhatsAppSetup.exe");
		driver = new WiniumDriver(new URL("http://localhost:9999"), option);

		Adding();
		Combination();
		Division();
		Multiplication();
		
	
		Thread.sleep(15000);

	}

	private static void Adding() throws InterruptedException {

		driver.findElement(By.name("Seven")).click();
		driver.findElement(By.name("Plus")).click();
		driver.findElement(By.name("Eight")).click();
		driver.findElement(By.name("Equals")).click();
		
	}
	@Test
	public static void Combination() {
		driver.findElementByName("Clear").click();
		driver.findElementByName("Seven").click();
		driver.findElementByName("Multiply by").click();
		driver.findElementByName("Nine").click();
		driver.findElementByName("Plus").click();
		driver.findElementByName("One").click();
		driver.findElementByName("Equals").click();
		driver.findElementByName("Divide by").click();
		driver.findElementByName("Eight").click();
		driver.findElementByName("Equals").click();
//		Assert.assertEquals("8", _GetCalculatorResultText());
	}

	@Test
	public static void Division() {
		driver.findElementByName("Clear").click();
		driver.findElementByName("Eight").click();
		driver.findElementByName("Eight").click();
		driver.findElementByName("Divide by").click();
		driver.findElementByName("One").click();
		driver.findElementByName("One").click();
		driver.findElementByName("Equals").click();
//		Assert.assertEquals("8", _GetCalculatorResultText());
	}

	@Test
	public static void Multiplication() {
		driver.findElementByName("Clear").click();
		driver.findElementByName("Nine").click();
		driver.findElementByName("Multiply by").click();
		driver.findElementByName("Nine").click();
		driver.findElementByName("Equals").click();
//		Assert.assertEquals("81", _GetCalculatorResultText());
	}

//	@Test
	public void Subtraction() {
		driver.findElementByName("Clear").click(); 
		driver.findElementByName("Nine").click();
		driver.findElementByName("Minus").click();
		driver.findElementByName("One").click();
		driver.findElementByName("Equals").click();
		Assert.assertEquals("8", _GetCalculatorResultText());
	}
	protected static String _GetCalculatorResultText() {
		// trim extra text and whitespace off of the display value
		return CalculatorResult.getText().replace("Display is", "").trim();
	}

}
