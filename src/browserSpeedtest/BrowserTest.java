package browserSpeedtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserTest {
	public static void main(String[] args) throws InterruptedException {
		WebDriver chrome = new ChromeDriver();
		run(chrome,"https://browserbench.org/Speedometer2.0/");
		
		WebDriver edge = new EdgeDriver();
		run(edge, "https://browserbench.org/Speedometer2.0/");
		
		Thread.sleep(60000);
		
		String cresult = getResult(chrome);
		System.out.println("Google chrome score is : "+cresult);
		chrome.quit();
		
		
		String eresult = getResult(edge);
		System.out.println("Microsoft edge score is : "+eresult);
		edge.quit();
		

		

	}

	static void run(WebDriver driver, String url) {
		driver.navigate().to(url);
		driver.findElement(By.xpath("//div[@class='buttons']/button")).click();
		
	    //driver.findElement(By.className("show-details")).click();
		

	}
	static String getResult(WebDriver driver) {
		String result = driver.findElement(By.xpath("//div[@id='result-number']")).getText();
		return result;
	}

}
