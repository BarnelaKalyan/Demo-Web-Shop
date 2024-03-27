package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class TC006_Print_theSpecifications_ofa_product {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String url="https://demowebshop.tricentis.com"; 
		WebDriver driver=new ChromeDriver();  
		driver.manage().window().maximize();
		driver.get(url);
// Click on Login 
		driver.findElement(By.xpath("//a[@class='ico-login']")).click();   
		
// Login with the Valid credentials
	       
         driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("kalyanb123@gmail.com");
		 driver.findElement(By.id("Password")).sendKeys("kalyanb123");
	     driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
	     driver.findElement(By.xpath("//input[@id=\"small-searchterms\"]")).click();
	     driver.findElement(By.xpath("//input[@id=\"small-searchterms\"]")).sendKeys("Build your own cheap computer");
	     driver.findElement(By.xpath("//input[@value=\"Search\"]")).click();
	     driver.findElement(By.xpath("//input[@value=\"Add to cart\"]")).click();
	     Thread.sleep(3000);
	     driver.findElement(By.xpath("//input[@id=\"product_attribute_72_6_19_91\"]")).click();
     	 driver.findElement(By.xpath("//input[@id=\"product_attribute_72_8_30_93\"]")).click();
	     driver.findElement(By.xpath("//input[@id=\"product_attribute_72_8_30_94\"]")).click();
	     driver.findElement(By.xpath("//input[@id=\"product_attribute_72_8_30_95\"]")).click();
	     driver.findElement(By.xpath("//input[@id=\"product_attribute_72_3_20_58\"]")).click();
	     WebElement element=driver.findElement(By.xpath("//input[@class='qty-input']"));
	     element.clear();
	     element.sendKeys("3");
	     driver.findElement(By.xpath("//div[@class='add-to-cart']")).click();
	     
	     // Navigate to jewelry category 
	     
	     driver.findElement(By.xpath("//ul[@class=\"top-menu\"]/child::li/a[normalize-space()='Jewelry']")).click();
	     driver.findElement(By.xpath("//a[normalize-space()='Create Your Own Jewelry']")).click();
	     driver.findElement(By.xpath("//select[@id=\"product_attribute_71_9_15\"]")).click();
	     Thread.sleep(3000);
	     Select slt=new Select(driver.findElement(By.id("product_attribute_71_9_15")));
	     slt.selectByValue("46");
	     driver.findElement(By.id("product_attribute_71_10_16")).sendKeys("30");
	     driver.findElement(By.id("product_attribute_71_11_17_49")).click();
	     
	     JavascriptExecutor js=(JavascriptExecutor)driver;
	     js.executeScript("window.scrollBy(0,400)");
	     
	     
	     WebElement Qty=driver.findElement(By.xpath("//input[@value='1']"));
	     Qty.clear();
	     Qty.sendKeys("2");
	     driver.findElement(By.xpath("//div[@class='add-to-cart']")).click();
	     
	 //click on Shoppingcart
	     
	     driver.findElement(By.xpath("//span[normalize-space()='Shopping cart']")).click();
	     
   	     	     //specifications of Products 
	     
	    //String P1 = driver.findElement(By.xpath("//tr[@class='cart-item-row'][1]/td[3]/child::div[@class=\"attributes\"]")).getText();
	   // System.out.println("specifications of first  product is:"+P1);
	     
	    String P2 = driver.findElement(By.xpath("//tr[@class='cart-item-row'][2]/td[3]/child::div[@class=\"attributes\"]")).getText();
	    System.out.println("--------------------------------------");
	    System.out.println("specifications of second product is :" +P2);
	    
	    //edit the product
	    driver.findElement(By.xpath("(//a[normalize-space()='Edit'])[1]")).click();
	    Thread.sleep(3000);
	    
	     driver.findElement(By.xpath("//input[@id=\"product_attribute_72_6_19_55\"]")).click();
    	 driver.findElement(By.xpath("//input[@id=\"product_attribute_72_3_20_57\"]")).click();
	     driver.findElement(By.xpath("//input[@id=\"product_attribute_72_8_30_93\"]")).click();
	     driver.findElement(By.xpath("//input[@value=\"Update\"]")).click();
    	 Thread.sleep(3000);
    	 
	     js.executeScript("window.scrollBy(0,-400)");
	     Thread.sleep(5000);
    	 driver.findElement(By.xpath("//span[normalize-space()='Shopping cart']")).click();
    	 
	     
    	String updated_P1 = driver.findElement(By.xpath("//tr[@class='cart-item-row'][1]/td[3]/child::div[@class=\"attributes\"]")).getText();
    	System.out.println("--------------------------------------");
 	    System.out.println("specifications of updated first product is:"+updated_P1);
    	 
 	 //click on the check boxes
	     
	     driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	     driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
	     
// updating shopping cart items by clicking on update shopping cart
	     
	     driver.findElement(By.xpath("//input[@name=\"updatecart\"]")).click();
	     
//verifying your shopping cart empty message
	     
	     driver.findElement(By.xpath("//div[@class=\"page-body\"]/child::div[normalize-space()=\"Your Shopping Cart is empty!\"]")).isDisplayed();
	     System.out.println(driver.findElement(By.xpath("//div[@class=\"page-body\"]/child::div[normalize-space()=\"Your Shopping Cart is empty!\"]")).getText());
	     
//Clicking on Logout element
	     
	     driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
	     
	    //closes the current window
	     
	     driver.close();
	     
       //closes the Multiple tabs in the window
         
         driver.quit();

	}

}
