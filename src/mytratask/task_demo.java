package mytratask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class task_demo {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\SOWMIYA\\eclipse-workspace\\seleniumnew\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		
		Actions ref=new Actions(driver);
		
        WebElement move=driver.findElement(By.xpath("//a[text()='Home & Living']"));
        ref.moveToElement(move).build().perform();
        
        WebElement clock=driver.findElement(By.xpath("//a[text()='Clocks']"));
        clock.click();

}
}
