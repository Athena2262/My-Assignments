package week4.assignment;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frameauto {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get ("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt ");
		driver.manage().window().maximize();
		//switch to frame
		driver.switchTo().frame("iframeResult");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		//click the button
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		//Handling the alert
		Alert act = driver.switchTo().alert();
		act.sendKeys("Nisha");
		act.accept();
		//Verify the text displayed
		WebElement nn = driver.findElement(By.xpath("//p[contains(text(),'Nisha')]"));
		boolean displayed = nn.isDisplayed();
		System.out.println(displayed);
		//text output
		WebElement ot = driver.findElement(By.id("demo"));
		String out = ot.getText();
		System.out.println(out);
		driver.close();
		


	}

}
