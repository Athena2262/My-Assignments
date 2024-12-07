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
import org.openqa.selenium.interactions.Actions;

public class BigBasketAutomation {

	public static void main(String[] args) throws InterruptedException,IOException {
		//Intialize chromedriver
		ChromeDriver driver = new ChromeDriver();
		//Maximize the window 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Load the URL
		driver.get ("https://www.bigbasket.com/");
		//Click on Shop by category
		driver.findElement(By.xpath("//button[@id='headlessui-menu-button-:R5bab6:']")).click();
		//perform actions-mousehover and click
        WebElement mouseOver = driver.findElement(By.xpath("(//a[text() = 'Foodgrains, Oil & Masala'])[2]"));
        Actions builder = new Actions(driver);
        builder.moveToElement(mouseOver).perform(); 
        WebElement mouse2 = driver.findElement(By.linkText("Rice & Rice Products"));
        builder.moveToElement(mouse2).perform();
        driver.findElement(By.xpath("//a[text()='Boiled & Steam Rice']")).click();
        //Filter by brand
        driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("BB Royal");
        WebElement sd = driver.findElement(By.xpath("//input[@id = 'i-BBRoyal']"));
        builder.scrollToElement(sd).perform();
        driver.executeScript("arguments[0].click();",sd);
        //Click on'Tamil ponni'
        driver.findElement(By.xpath("//h3[contains(text(), 'Tamil Ponni')]")).click();
        Thread.sleep(3000);
        //get the childwindow
        Set<String> parent = driver.getWindowHandles();
        List<String> child = new ArrayList<String>(parent);
        driver.switchTo().window(child.get(1));
        //Select the qty and check the price
        driver.findElement(By.xpath("(//div[@class='flex justify-start w-full h-full'])[5]")).click();
		String price = driver.findElement(By.xpath("(//span[contains(@class,'StyledLabel5')])[5]")).getText();
		System.out.println("Price of rice is:"+ price);
		driver.findElement(By.xpath("(//button[text()='Add to basket'])[1]")).click();
		String msg = driver.findElement(By.xpath("//p[contains(text(),'basket successfully')]")).getText();
		System.out.println("The msg is:"+ msg);
		Thread.sleep(5000);
		//Take a snapshot of the current page
		File src = driver.getScreenshotAs(OutputType.FILE);
	    File trgt = new File("./snapshot/bigbasket.png");
	    FileUtils.copyFile(src, trgt);
	    driver.close();
	    driver.quit();

        
	}

}

