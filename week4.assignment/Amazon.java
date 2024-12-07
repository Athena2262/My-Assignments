package week4.assignment;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazonautomation {

	public static void main(String[] args) throws IOException, InterruptedException{
		//Initialize
		ChromeDriver driver = new ChromeDriver();
		//Maximize the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Load the URL
		driver.get ("https://www.amazon.in/");
		//Search for 'oneplus 9 pro'
		driver.findElement(By.xpath("//input[@type = 'text']")).sendKeys("oneplus 9 pro");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		//Get the price
		WebElement se = driver.findElement(By.xpath("(//span[@class=\"a-price-whole\"])[1]"));
		String price = se.getText();
		System.out.println("the price is:"+price);
		//Print the ratings
		WebElement vb = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]"));
		String ratings = vb.getText();
		System.out.println("the ratings are:"+ratings);
		//click the first link
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		Thread.sleep(5000);
		Set<String> parentwindow = driver.getWindowHandles();
		List<String> childwindow = new ArrayList<String>(parentwindow);
		driver.switchTo().window(childwindow.get(1));
		//Take a screenshot
		File scr = driver.getScreenshotAs(OutputType.FILE);
		Thread.sleep(4000);
		File trg = new File("./snapshot/takesnap1.png");
		FileUtils.copyFile(scr, trg);
		//Click 'Add to Cart' 
		driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]")).click();
		driver.findElement(By.xpath("//span[contains(@id,'view-cart-button')]//input")).click();
		driver.findElement(By.xpath("(//input[@class='a-button-input'])[4]")).click();
		//Get the cart subtotal
		String text = driver.findElement(By.xpath("(//span[contains(@class,'a-size-medium a-color-base sc-price sc')])[1]")).getText();
		System.out.println("Cart Subtotal:"+text);
		
		driver.close();
		}

}
