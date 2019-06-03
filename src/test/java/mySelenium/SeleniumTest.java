package mySelenium;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class SeleniumTest {
	public static WebDriver driver;
	String url = "http://www.Google.com";

	@BeforeClass
	public static void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public static void teardown() throws InterruptedException {
//		Thread.sleep(5000);
//		driver.quit();
	}
	
	@Ignore
	@Test
	public void methodTest() {
		driver.get(url);
		WebElement we = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input"));
		we.sendKeys("Cute Kittens");
		we.sendKeys(Keys.ENTER);
		
		we = driver.findElement(By.xpath("//*[@id=\"imagebox_bigimages\"]/g-section-with-header/div[1]/h3/a"));
		assertEquals("Images for Cute Kittens",we.getText());
	}
	
	@Test
	public void methodTest2() {
		driver.get("https://www.youidraw.com/apps/painter/");
		Actions action =  new Actions(driver);
		//x,y
		action.moveToElement(driver.findElement(By.id("brush"))).click().perform();
		action.moveToElement(driver.findElement(By.id("catch")),50,20).clickAndHold().moveByOffset(1,300).release().perform();
		action.moveToElement(driver.findElement(By.id("catch")),200,20).clickAndHold().moveByOffset(1,300).release().perform();
		action.moveToElement(driver.findElement(By.id("catch")),50,150).clickAndHold().moveByOffset(150,0).release().perform();
		
		action.moveToElement(driver.findElement(By.id("catch")),300,20).clickAndHold().moveByOffset(-50,300).release().perform();
		action.moveToElement(driver.findElement(By.id("catch")),300,20).clickAndHold().moveByOffset(50,300).release().perform();
		action.moveToElement(driver.findElement(By.id("catch")),280,220).clickAndHold().moveByOffset(65,0).release().perform();
		
		action.moveToElement(driver.findElement(By.id("catch")),360,310).clickAndHold().moveByOffset(65,-280).release().perform();
		action.moveToElement(driver.findElement(By.id("catch")),280,).clickAndHold().moveByOffset(65,-280).release().perform();
	}

}

