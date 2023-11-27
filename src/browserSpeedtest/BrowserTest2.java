package browserSpeedtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserTest2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver chrome = new ChromeDriver();
		chrome.navigate().to("https://browserbench.org/Speedometer2.0/");
		chrome.findElement(By.xpath("//div[@class='buttons']/button")).click();
		
		WebDriver edge = new EdgeDriver();
		edge.navigate().to("https://browserbench.org/Speedometer2.0/");
		edge.findElement(By.xpath("//div[@class='buttons']/button")).click();
		
		Thread.sleep(65000);
		
		String cresult = chrome.findElement(By.xpath("//div[@id='result-number']")).getText();
		System.out.println("Google chrome score is : "+cresult);
		chrome.quit();
		
		String eresult = edge.findElement(By.xpath("//div[@id='result-number']")).getText();
		System.out.println("Microsoft edge score is : "+eresult);
		edge.quit();
		

	}

}
