package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC002_Adding_Products_to_cart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		   
		String url=driver.getCurrentUrl();
		
		//Printing the URL of the application
		
       System.out.println(url);   
       
    // Getting title of the page
		
    		String Title=driver.getTitle();
    		System.out.println(Title);
    		
		
// Click on Login 
		driver.findElement(By.xpath("//a[@class='ico-login']")).click();   
		
// Login with the Valid credentials
	       
         driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("robertdowney12@gmail.com");
		 driver.findElement(By.id("Password")).sendKeys("robert12");
	     driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
	     
         //Navigate to books category and click on Fiction Book  and Add it to the shopping Cart
	     driver.findElement(By.xpath("//ul[@class=\"top-menu\"]/li[1]/child::a[normalize-space()='Books']")).click();
	     
	     driver.findElement(By.xpath("(//input[@value=\"Add to cart\"])[2]")).click();
	     
	     //  Navigate to Electronics category and click on  SmartPhone, Add it to the Cart
	     
	     driver.findElement(By.xpath("//ul[@class=\"top-menu\"]/li[3]/child::a[normalize-space()='Electronics']")).click();
	     driver.findElement(By.xpath("//img[@alt=\"Picture for category Cell phones\"]")).click();
	     driver.findElement(By.xpath("(//input[@value=\"Add to cart\"])[1]")).click();
	     
	      //Navigate to Apparel & Shoes category and click on HandBag, Add it to the Cart
	     
	     driver.findElement(By.xpath("//ul[@class=\"top-menu\"]/li[4]/child::a[normalize-space()='Apparel & Shoes']")).click();
	     driver.findElement(By.xpath("(//input[@value=\"Add to cart\"])[5]")).click();
	     
	      //Navigate to Digital Downloads category and click on 3rd Album, Add it to the Cart
	     
	     driver.findElement(By.xpath("//ul[@class=\"top-menu\"]/li[5]/child::a[normalize-space()='Digital downloads']")).click();
	     driver.findElement(By.xpath("(//input[@value=\"Add to cart\"])[1]")).click();
	     
	      //Click on Shopping Cart
	     	     
	     driver.findElement(By.xpath("//span[normalize-space()='Shopping cart']")).click();
	    	     
	      //click on the check boxes
	     
	     driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	     driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
	     driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
	     driver.findElement(By.xpath("(//input[@type='checkbox'])[4]")).click();
	     
	      // updating shopping cart items by clicking on update shopping cart
	     
	     driver.findElement(By.xpath("//input[@name=\"updatecart\"]")).click();
	     
	     //verifying your shopping cart empty message
	     
	     driver.findElement(By.xpath("//div[@class=\"page-body\"]/child::div[normalize-space()=\"Your Shopping Cart is empty!\"]")).isDisplayed();
	     System.out.println(driver.findElement(By.xpath("//div[@class=\"page-body\"]/child::div[normalize-space()=\"Your Shopping Cart is empty!\"]")).getText());
	     
         //Clicking  on Logout element
	     
	     driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
	     
	    //closes the current window
         driver.close(); 
       //closes the Multiple  windows
         
         driver.quit();

	}

}
