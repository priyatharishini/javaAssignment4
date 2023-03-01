package javaAssignment1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class MergeContact {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
	driver.findElement(By.id("password")).sendKeys("crmsfa");
	driver.findElement(By.className("decorativeSubmit")).click();
	driver.findElement(By.linkText("CRM/SFA")).click();
	driver.findElement(By.linkText("Contacts")).click();
	driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
	driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
	Set<String> window = driver.getWindowHandles();
	List<String>win1=new ArrayList<String>(window);
	driver.switchTo().window(win1.get(1));
	driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
	driver.switchTo().window(win1.get(0));
	driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
	 Set<String> window1 = driver.getWindowHandles();
	List<String>win2=new ArrayList<String>(window1);
	driver.switchTo().window(win2.get(1));
	driver.findElement(By.xpath("(//a[@class='linktext'])[6]")).click();
	driver.switchTo().window(win2.get(0));
	driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
	Alert a1=driver.switchTo().alert();
	a1.accept();
	System.out.println(driver.getTitle());
	
	}

}
