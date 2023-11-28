package chromeExtensionsAutomation;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestPostScheduler {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.setProperty("webdriver.chrome.driver", "/Users/[your local name]/Documents/chromedriver");
		File classpathRoot = new File(System.getProperty("user.dir"));
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File(classpathRoot, "extensions/postScheduler/1.2.80_0.crx"));
		WebDriver chrome = new ChromeDriver(options);
		chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("Opening extension");
		chrome.get("chrome-extension://hamddmihoepamnkonchjkgbncapmlbea/popup.html");
		chrome.manage().window().maximize();
		chrome.findElement(By.id("email")).sendKeys("dibyajyoti.das@tier5.in");
		chrome.findElement(By.id("password")).sendKeys("123456");
		chrome.findElement(By.xpath("//div[@class='text-center gap1']/button[@type='button']")).click();
		chrome.navigate().to("chrome-extension://hamddmihoepamnkonchjkgbncapmlbea/popup.html#/calendar/");
		chrome.findElement(By.xpath("//li/a[@title='Post Types']/span[@class='sidebarSpanName']")).click();
		//This is a new line
		chrome.findElement(By.xpath("//div[@class='dashboardHeader']/button[@class='blue_btn2']")).click();
		chrome.findElement(By.xpath("//div[@class='popupBody']/input")).sendKeys("AutoTestPostType");
		chrome.findElement(By.xpath("//div[@class='popupBody']/button")).click();
		

	}

}
