package test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class CalculatorTest {

	public static WindowsDriver<WindowsElement> driver;
	public static WebElement CalculatorResult;

	@BeforeClass
	public static void setup() {
		try {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
//			capabilities.setCapability("platformName", "Windows");
			capabilities.setCapability("deviceName", "Windows");
//			capabilities.setCapability("appTopLevelWindow", "0x10010");
			driver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), capabilities);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			System.out.println("Started");
			CalculatorResult = driver.findElementByAccessibilityId("CalculatorResults");
			Assert.assertNotNull(CalculatorResult);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Executed The Finally Block");
		}
	}

//	@Before
	public void Clear() {
		driver.findElementByName("Clear").click();
		Assert.assertEquals("0", _GetCalculatorResultText());
	}

	@AfterClass
	public static void TearDown() {
		CalculatorResult = null;
		if (driver != null) {
			driver.quit();
		}
		driver = null;
	}

	@Test
	public void Addition() {
		driver.findElement(By.name("One")).click();
		driver.findElementByName("Plus").click();
		driver.findElementByName("Eight").click();
		driver.findElementByName("Equals").click();
		Assert.assertEquals("12", _GetCalculatorResultText());
	}

//	@Test
	public void Combination() {
		driver.findElementByName("Seven").click();
		driver.findElementByName("Multiply by").click();
		driver.findElementByName("Nine").click();
		driver.findElementByName("Plus").click();
		driver.findElementByName("One").click();
		driver.findElementByName("Equals").click();
		driver.findElementByName("Divide by").click();
		driver.findElementByName("Eight").click();
		driver.findElementByName("Equals").click();
		Assert.assertEquals("8", _GetCalculatorResultText());
	}

//	@Test
	public void Division() {
		driver.findElementByName("Eight").click();
		driver.findElementByName("Eight").click();
		driver.findElementByName("Divide by").click();
		driver.findElementByName("One").click();
		driver.findElementByName("One").click();
		driver.findElementByName("Equals").click();
		Assert.assertEquals("8", _GetCalculatorResultText());
	}

//	@Test
	public void Multiplication() {
		driver.findElementByName("Nine").click();
		driver.findElementByName("Multiply by").click();
		driver.findElementByName("Nine").click();
		driver.findElementByName("Equals").click();
		Assert.assertEquals("81", _GetCalculatorResultText());
	}

//	@Test
	public void Subtraction() {
		driver.findElementByName("Nine").click();
		driver.findElementByName("Minus").click();
		driver.findElementByName("One").click();
		driver.findElementByName("Equals").click();
		Assert.assertEquals("8", _GetCalculatorResultText());
	}

	protected String _GetCalculatorResultText() {
		// trim extra text and whitespace off of the display value
		return CalculatorResult.getText().replace("Display is", "").trim();
	}

}