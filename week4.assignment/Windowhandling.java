package week4.assignment;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
public class Windowhandle {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		//Load the URL 
		driver.get("http://leaftaps.com/opentaps/control/login");
		//Maximize the browser window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Enter a username and password
		driver.findElement(By.id("username")).sendKeys("demosalesmanager"); 
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		//Click the "Login"
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		//Click the Contacts 
		driver.findElement(By.linkText("Contacts")).click();
		//Click on Merge Contacts. 
		driver.findElement(By.linkText("Merge Contacts")).click();
		//Click on the widget. 
		driver.findElement(By.xpath("(//input[@id='partyIdFrom']/following::img)[1]")).click(); 				
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> element1 = new ArrayList<String>(windowHandles);
		driver.switchTo().window(element1.get(1));
		//Click on the contact in the child window
		driver.findElement(By.xpath("//div[contains(@class,'x-grid3-col-partyId')]/a")).click();
		driver.switchTo().window(element1.get(0));
		//Click on the widget 
		driver.findElement(By.xpath("(//input[@id='partyIdFrom']/following::img)[2]")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String>element2 = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(element2.get(1));
		//click on the contact
		driver.findElement(By.xpath("//div[contains(@class,'x-grid3-col-partyId')]/a")).click();
		driver.switchTo().window(element2.get(0));
		//Click on the Merge button. 
		driver.findElement(By.linkText("Merge")).click();
		//Print the alert msg
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert msg is : "+ alert.getText());
		alert.accept();
		//Verify the title
		String title = driver.getTitle();
		System.out.println(title);
		if (title.contains("Contact")) {
			System.out.println("Title is verified");
		} else {System.out.println("Title is not verified");}
		
		
		driver.quit();
}

}
