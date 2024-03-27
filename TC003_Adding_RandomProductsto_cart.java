package Selenium;

import java.util.List;
import java.util.Random;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class TC003_Adding_RandomProductsto_cart {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		   
		String url=driver.getCurrentUrl();
		
       System.out.println(url);   //Printing the URL of the application
       
    // Getting title of the page
		
    		String Title=driver.getTitle();
    		System.out.println(Title);
    		
		
// Click on Login 
		driver.findElement(By.xpath("//a[@class='ico-login']")).click();   
		
// Login with the Valid credentials
	       
         driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("robertdowney12@gmail.com");
		 driver.findElement(By.id("Password")).sendKeys("robert12");
		 
	     driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
	     
         //Navigate to books category and click on any random product , Add it to the Cart
	     driver.findElement(By.xpath("//ul[@class=\"top-menu\"]/li[1]/child::a[normalize-space()='Books']")).click();
	     
	       List<WebElement> totalcount= driver.findElements(By.xpath("//input[@value='Add to cart']"));
	        Random newrandom = new Random();
	        int randomIndex = newrandom.nextInt(totalcount.size());
	        WebElement randomProduct = totalcount.get(randomIndex);
	        randomProduct.click();
	    	    	     
	     //  Navigate to Computers category and navigate to accessories click on random product, Add it to the Cart
	     
	     driver.findElement(By.xpath("//ul[@class=\"top-menu\"]/li[2]/child::a[normalize-space()='Computers']")).click();
	     driver.findElement(By.xpath("//div/child::h2[@class=\"title\"]/a[@title=\"Show products in category Accessories\"]")).click();
	     
	     List<WebElement> totalcount1= driver.findElements(By.xpath("//input[@value='Add to cart']"));
	        Random newrandom1 = new Random();
	        int randomIndex1 = newrandom1.nextInt(totalcount1.size());
	        WebElement randomProduct1 = totalcount1.get(randomIndex1);
	        randomProduct1.click();
	     	      	     
	      //Navigate to Digital Downloads category and click on any random product , Add it to the Cart
	     
	     driver.findElement(By.xpath("//ul[@class=\"top-menu\"]/li[5]/child::a[normalize-space()='Digital downloads']")).click();
	     List<WebElement> totalcount2= driver.findElements(By.xpath("//input[@value='Add to cart']"));
	        Random newrandom2 = new Random();
	        int randomIndex2 = newrandom2.nextInt(totalcount2.size());
	        WebElement randomProduct2 = totalcount2.get(randomIndex2);
	        randomProduct2.click();
	     
	      //Click on Shopping Cart
	     	     
	     driver.findElement(By.xpath("//span[normalize-space()='Shopping cart']")).click();
	    	     
	      //click on the check boxes
	     
	     driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	     driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
	     driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
	     
	     Thread.sleep(3000);
	     	     
	     // screen shot of the WebPage
	     
	     
	    
	     
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
