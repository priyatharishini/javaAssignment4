package javaAssignment1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']")).sendKeys(" oneplus 9 pro", Keys.ENTER);
String phonerate = driver.findElement(By.xpath("//span[@class='a-price']")).getText();
System.out.println(phonerate);
String  rate1= phonerate.replaceAll("₹","");
phonerate.trim();
System.out.println(rate1);
  String rate = driver.findElement(By.xpath("//span[@class='a-size-base']")).getText();
 System.out.println(rate);
 Thread.sleep(2000);
 driver.findElement(By.xpath("//div[contains(@class,'a-section aok-relative')]//img")).click();
Set<String> window= driver.getWindowHandles();
List<String>window1=new ArrayList<String>(window);
driver.switchTo().window(window1.get(1));
File screeshotAs = driver .getScreenshotAs(OutputType.FILE);
File dest=new File("./snap/shot.png");
FileUtils.copyFile(screeshotAs, dest);
Thread.sleep(2000);
driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
Thread.sleep(3000);
 WebElement cart = driver.findElement(By.id("nav-cart-count-container"));
 driver.executeScript("arguments[0].click();", cart);
	String subTotal = driver.findElement(By.xpath("(//span[contains(@class,'a-size-medium a-color-base')])[2]")).getText();
System.out.println(subTotal);
String sub = subTotal.replaceAll(".00","");
String trim = sub.trim();
System.out.println(sub);
	if(rate1.equals(trim))
	{
		System.out.println("same price");
	}
	else
	{
		System.out.println("different price");
	}
	driver.quit();
}
}
