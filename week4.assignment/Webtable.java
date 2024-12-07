package week4.assignment;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class Webtable {
	public static void main(String[] args) {
		//Initialize ChromeDriver
		ChromeDriver driver = new ChromeDriver();
		//Load URL 
		driver.get("https://finance.yahoo.com/");
		//Maximize the browser window
		driver.manage().window().maximize();
		//Add an implicit wait to ensure the webpage elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Click on Crypto tab
		WebElement market = driver.findElement(By.xpath("//span[text()='Markets']"));
		Actions act = new Actions(driver);
		act.moveToElement(market).perform();
		driver.findElement(By.xpath("(//div[text()='Crypto'])[2]")).click();
		//count of row
		List<WebElement> row = driver.findElements(By.xpath("//table[contains(@class,'markets-table')]/tbody/tr"));
	    int rowc = row.size();
		System.out.println("Rows :" +rowc);
		//count of column
		List<WebElement> column = driver.findElements(By.xpath("//table[contains(@class,'markets-table')]/tbody/tr[1]/td"));
		int colc = column.size();
		System.out.println("Columns:"+colc);
		//Print the cryptocurrency
		 List<WebElement> cryptocurrency = driver.findElements(By.xpath("//table[contains(@class,'markets-table')]/tbody/tr/td[2]")); 
         for (int i = 0; i <= cryptocurrency.size()-1 ; i++) {
         System.out.println(cryptocurrency.get(i).getText());
         }
         driver.close();
	}	

}
