package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC001_Login_Verification {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
	
		//launching  application in Chrome browser
		
				driver.get("https://demowebshop.tricentis.com/");
				
				String url=driver.getCurrentUrl();
				
			     System.out.println(url);  //Printing the url of the application
				
				//Maximize chrome Browser
				
				driver.manage().window().maximize();
				
				// Getting title of the page
				
				String Title=driver.getTitle();
				System.out.println(Title);
				
				// Providing valid Email with invalid password
				
				driver.findElement(By.id("Email")).sendKeys("robertdowney12@gmail.com");
				driver.findElement(By.id("Password")).sendKeys("kalyan");
				driver.findElement(By.xpath("//input[@value=\"Log in\"]")).click();
				
				// verifying the message
				
				driver.findElement(By.xpath("//span[contains(text(),'Login was unsuccessful. Please correct the errors ')]")).isDisplayed(); 
				driver.findElement(By.xpath("//li[normalize-space()='The credentials provided are incorrect']")).isDisplayed();
				
				// Providing invalid Email and Valid password
				
				driver.findElement(By.id("Email")).clear();
				driver.findElement(By.id("Email")).sendKeys("rishi12343@gmail.com");
				driver.findElement(By.id("Password")).sendKeys("robert12");
				driver.findElement(By.xpath("//input[@value=\"Log in\"]")).click();
				//verifying the message
				driver.findElement(By.xpath("//span[contains(text(),'Login was unsuccessful. Please correct the errors ')]")).isDisplayed();
				driver.findElement(By.xpath("//li[normalize-space()='No customer account found']")).isDisplayed();
				driver.findElement(By.id("Email")).clear();
				
				// Input Email Field with only name
				
				driver.findElement(By.id("Email")).sendKeys("rishikumar");
				driver.findElement(By.xpath("//input[@value=\"Log in\"]")).click();
				
				//verifying the message
				
				driver.findElement(By.xpath("//span[@for=\"Email\"]")).isDisplayed();
				String s1 = driver.findElement(By.xpath("//span[@for=\"Email\"]")).getText();
				System.out.println(s1);
				driver.findElement(By.id("Email")).clear();
				
				//Providing valid EMAIL and VALID Password
				
				driver.findElement(By.id("Email")).sendKeys("robertdowney12@gmail.com");
				driver.findElement(By.id("Password")).sendKeys("robert12");
				driver.findElement(By.xpath("//input[@value=\"Log in\"]")).click();
				driver.findElement(By.xpath("//a[normalize-space()='robertdowney12@gmail.com']")).isDisplayed(); //verification of the Email whether it is diplayed or not
				driver.findElement(By.xpath("//a[normalize-space()='Log out']")).click(); //Logout successfully from the apllication
				driver.close();	
				driver.quit();
		

	}

}
