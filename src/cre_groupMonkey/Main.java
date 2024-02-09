package cre_groupMonkey;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;

public class Main {

	public static void main(String[] args) throws InterruptedException, IOException {
		File classpathRoot = new File(System.getProperty("user.dir"));
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File(classpathRoot, "extensions/groupMonkey/Group Monkey 1.1.45.0.crx"));
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("chrome-extension://goflgkgffmekeedmfdinbbchpfgboijg/popup.html");
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys("user3@email.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.linkText("Login")).click();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.open()");
		Thread.sleep(1000);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		driver.get("https://portal.groupmonkey.io/");
		WebElement footer = driver.findElement(By.className("footerSection"));
		List<WebElement> links = footer.findElements(By.tagName("a"));
		SoftAssert sa = new SoftAssert();
		for (WebElement link : links) {
			int rescode = Connection.getResponse(link);
			System.out.println(rescode);
			sa.assertTrue(rescode < 400, "response is broken for link of " + "\"" + link.getText() + "\"");
		}
		sa.assertAll();
		Thread.sleep(2000);
		driver.switchTo().window(parentWindow);
		Thread.sleep(1000);
		footer = driver.findElement(By.className("footer"));
		links = footer.findElements(By.tagName("a"));
		for (WebElement link : links) {
			int rescode = Connection.getResponse(link);
			System.out.println(rescode);
			sa.assertTrue(rescode < 400, "response is broken for link of " + "\"" + link.getText() + "\"");
			}
		
		sa.assertAll();
		
		
	}

	
}
