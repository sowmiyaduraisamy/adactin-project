package miniproject;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Hotel_booking {
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\SOWMIYA\\eclipse-workspace\\project\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://adactinhotelapp.com/index.php");
		driver.manage().window().maximize();
		
		WebElement user=driver.findElement(By.xpath("//input[@id='username']"));
		user.sendKeys("priyaathi");
		WebElement pass=driver.findElement(By.xpath("//input[@id='password']"));
		pass.sendKeys("123456");
		WebElement login=driver.findElement(By.xpath("//input[@id='login']"));
		login.click();
		
		WebElement loc=driver.findElement(By.xpath("//select[@id='location']"));
		Select s=new Select(loc);
		s.selectByIndex(5);
		WebElement hotel=driver.findElement(By.xpath("//select[@id='hotels']"));
		Select s1=new Select(hotel);
		s1.selectByIndex(2);
		WebElement type =driver.findElement(By.xpath("//select[@id='room_type']"));
		Select s11=new Select(type);
		s11.selectByIndex(4);
		WebElement num=driver.findElement(By.xpath("//select[@id='room_nos']"));
		Select s2=new Select(num);
		s2.selectByIndex(1);
		
		WebElement datein=driver.findElement(By.xpath("//input[@id='datepick_in']"));
		datein.sendKeys("26/08/2022");
		WebElement dateout=driver.findElement(By.xpath("//input[@id='datepick_out']"));
		dateout.sendKeys("27/08/2022");
		
		WebElement adult=driver.findElement(By.xpath("//select[@id='adult_room']"));
		Select s21=new Select(adult);
		s21.selectByIndex(1);
		WebElement child=driver.findElement(By.xpath("//select[@id='child_room']"));
		Select s211=new Select(child);
		s211.selectByIndex(2);
		
		driver.findElement(By.xpath("//input[@id='Submit']")).click();
		driver.findElement(By.xpath("//input[@id='radiobutton_0']")).click();
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		
		driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("priya");
		driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("athi");
		driver.findElement(By.xpath("//textarea[@id='address']")).sendKeys("5,nandha colony,chennai");
		driver.findElement(By.xpath("//input[@id='cc_num']")).sendKeys("1592467852345262");
		
		WebElement cc=driver.findElement(By.xpath("//select[@id='cc_type']"));
		Select d=new Select (cc);
		d.selectByIndex(2);
		WebElement exp =driver.findElement(By.xpath("//select[@id='cc_exp_month']"));
		Select d1=new Select (exp);
		d1.selectByIndex(2);
		WebElement yr=driver.findElement(By.xpath("//select[@id='cc_exp_year']"));
		Select f=new Select(yr);
		f.selectByIndex(12);
		driver.findElement(By.xpath("//input[@id='cc_cvv']")).sendKeys("022");
		driver.findElement(By.xpath("//input[@id='book_now']")).click();
		
		TakesScreenshot ref=(TakesScreenshot)driver;
		File f1=ref.getScreenshotAs(OutputType.FILE);
		File h=new File("C:\\Users\\SOWMIYA\\eclipse-workspace\\project\\screenshot1\\hotel.png");
		FileHandler.copy(f1, h);
		
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
		
		
		
	}

}
