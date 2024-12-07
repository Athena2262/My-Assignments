package week4.assignment;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class Snapdeal {
	public static void main(String[] args) throws IOException, InterruptedException {
		//Initialize the chrome driver
		ChromeDriver driver = new ChromeDriver();
		//Maximize the window
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    //Load the URL
		driver.get("https://www.snapdeal.com/"); 
	    //Perform actions
		WebElement mouseOver = driver.findElement(By.xpath("(//span[@class='catText'])[1]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(mouseOver).perform();
		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();
		//total count
		String count = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
		System.out.println("Total count is:"+count);
	    //Click on "Training Shoes".
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		//Filtering the results
		driver.findElement(By.xpath("//div[@class='sort-selected']")).click();
		//sort by
		driver.findElement(By.xpath("(//li[@class='search-li'])[1]")).click();
	    Thread.sleep(3000);
	    //Check if the displayed items are sorted correctly
		List<WebElement> sort = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		for(int i=0;i<sort.size()-1;i++) {
			System.out.println(" Sort Order:"+sort.get(i).getText());
		}
				//System.out.println(" Sort Order:"+sort.get(i).getText());
				
		//Select range (500-700)
	    WebElement min = driver.findElement(By.xpath("//input[@name='fromVal']"));
	    min.clear();
	    min.sendKeys("500");
	    WebElement max = driver.findElement(By.xpath("//input[@name='toVal']"));
	    max.clear();
	    max.sendKeys("700");
	    driver.findElement(By.xpath("//div[contains(@class,'price-go')]")).click();
	    Thread.sleep(5000);
	    //Filter by any colour
	    WebElement color= driver.findElement(By.xpath("(//div[@class='filter-content ']//label)[1]"));
	    color.click();
	    System.out.println("color choosen");
	            WebElement priceRangeText = driver.findElement(By.xpath("(//a[contains(@class,'clear-filter')])[1]"));
	            System.out.println("Price Range: " + priceRangeText.getText());
	            WebElement colorText = driver.findElement(By.xpath("//a[text()=' Black']"));
	            System.out.println("Color: " + colorText.getText());
	           WebElement firstProduct = driver.findElement(By.xpath("(//div[contains(@class,'product-tuple-listing')])[1]"));
	            Actions actions = new Actions(driver);
	            actions.moveToElement(firstProduct).perform();
	           //Click the "Quick View" button
	            driver.findElement(By.xpath("(//div[@class='clearfix row-disc'])[1]")).click();
	            
	         //print the price and discount
	            WebElement Price = driver.findElement(By.xpath("//span[@class='payBlkBig']"));
	            System.out.println("The price is " +Price.getText());
	            WebElement Discount = driver.findElement(By.xpath("//span[@class='percent-desc']"));
	            System.out.println("Applied discount:"+Discount.getText());
	           
	            Thread.sleep(3000);
	         
	    		//Take a snapshot
	            File src = driver.getScreenshotAs(OutputType.FILE);
	    		File trgt = new File("./snapshot/quickView.png");
	    		FileUtils.copyFile(src, trgt);
	    	//Close all windows 
	            driver.close();
	            driver.quit();
				


		          

	}


}
