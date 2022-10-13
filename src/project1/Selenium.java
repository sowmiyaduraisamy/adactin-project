package project1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

    
public class Selenium {
	public static void main(String[] args) throws InterruptedException, IOException, AWTException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\SOWMIYA\\eclipse-workspace\\project\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		          //LOCATORS
		WebElement email=driver.findElement(By.id("email"));
		email.sendKeys("priya1232gmail.com");
		
		WebElement pass=driver.findElement(By.name("pass"));
		pass.sendKeys("12345678");
		
                  //SINGLE DROPDOWN
		WebElement create=driver.findElement(By.xpath("//a[@rel='async']"));
		create.click();
		Thread.sleep(3000);
		
		WebElement firstname=driver.findElement(By.xpath("//input[@name='firstname']")); 
		firstname.sendKeys("priya");
		
		WebElement lastname=driver.findElement(By.xpath("//input[@name='lastname']"));
		lastname.sendKeys("athi");
		
		WebElement mail=driver.findElement(By.xpath("//input[@name='reg_email__']"));
		mail.sendKeys("priya123@gmail.com");
		
		WebElement pa=driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
		pa.sendKeys("1234564");
	
		WebElement id=driver.findElement(By.xpath("//select[@id='day']"));
		Select s=new Select(id);
		s.selectByIndex(10);
		Thread.sleep(3000);
		
	              //FRAME
		driver.navigate().to("https://demo.automationtesting.in/Frames.html");
		
		WebElement name=driver.findElement(By.xpath("//iframe[@name='SingleFrame']")); 
		driver.switchTo().frame(name);
		
		WebElement type=driver.findElement(By.xpath("//input[@type='text']"));
		type.sendKeys("selenium");
		driver.switchTo().defaultContent();
		
		          //ALERT
		driver.navigate().to("https://demoqa.com/alerts");
		WebElement alert=driver.findElement(By.xpath("//button[@id='alertButton']"));
		alert.click();
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//button[@id='confirmButton']")).click();
	    driver.switchTo().alert().dismiss();
	
		driver.navigate().to("https://demo.automationtesting.in/Alerts.html");
	    driver.manage().window().maximize();
		
		WebElement promt=driver.findElement(By.xpath("//a[text()='Alert with Textbox ']"));
		promt.click();
		WebElement click=driver.findElement(By.xpath("//button[@onclick='promptbox()']"));
		click.click();
		
		driver.switchTo().alert().sendKeys("sowmi");
		driver.switchTo().alert().accept();
		 
		        //JAVASCRIPT EXECUTOR
		driver.navigate().to("https://www.amazon.in/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement amazon=driver.findElement(By.xpath("//a[text()='Amazon Global Selling']"));
		js.executeScript("arguments[0].scrollIntoView();",amazon);
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,-10000);");
		
		       //SCREENSHOT
		TakesScreenshot ref=(TakesScreenshot)driver;
		File g= ref.getScreenshotAs(OutputType.FILE);
		File f=new File("C:\\Users\\SOWMIYA\\eclipse-workspace\\project\\screenshot1\\amazon.png");
		FileHandler.copy(g, f);
		  
		       //KEYBOARD ACTIONS
		Actions ref1=new Actions(driver);
		WebElement mob=driver.findElement(By.xpath("//a[text()='Mobiles']"));
		ref1.contextClick(mob).build().perform();
		
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_T);  
		
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_T);
		
		       //MOUSE ACTIONS
		driver.navigate().to("https://demoqa.com/buttons");
		Actions obj=new Actions(driver);
		
		WebElement dou=driver.findElement(By.xpath("//button[text()='Double Click Me']"));
		obj.doubleClick(dou).build().perform();
		
		WebElement righ=driver.findElement(By.xpath("//button[text()='Right Click Me']"));
		obj.contextClick(righ).build().perform();
		
		WebElement clic=driver.findElement(By.xpath("//button[text()='Click Me']"));
		obj.click(clic).build().perform();
		
		driver.navigate().to("https://www.leafground.com/drag.xhtml");
		Actions ref11=new Actions(driver);
		
		WebElement drag=driver.findElement(By.xpath("//div[@id='form:drag_content']"));
        WebElement drop=driver.findElement(By.xpath("//span[text()='Droppable Target']"));
        ref11.dragAndDrop(drag, drop).build().perform();
        
		WebElement click1=driver.findElement(By.xpath("//span[text()='Drag and Drop']"));
		ref11.clickAndHold(click1).build().perform();
		ref11.moveToElement(click1, 100, 0).build().perform();
		
		          //WEBTABLE
		driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");
		List<WebElement> all=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[2]/td[3]"));
		for (WebElement webElement :all) {
			System.out.println(webElement.getText());
		}
		
	}

}
