package Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC005_OrderCreation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
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
	     
         //Navigate to books category and click on Fiction Book  and Add it to the shopping Cart
	     driver.findElement(By.xpath("//ul[@class=\"top-menu\"]/li[1]/child::a[normalize-space()='Books']")).click();
	     
	     driver.findElement(By.xpath("(//input[@value=\"Add to cart\"])[2]")).click();
	     
//  Navigate to Computers category and navigate to accessories click any product, Add it to the Cart
	     
	     driver.findElement(By.xpath("//ul[@class=\"top-menu\"]/li[2]/child::a[normalize-space()='Computers']")).click();
	     driver.findElement(By.xpath("//div/child::h2[@class=\"title\"]/a[@title=\"Show products in category Accessories\"]")).click();
	     driver.findElement(By.xpath("//a[normalize-space()='TCP Public Complete']")).click();
	     driver.findElement(By.xpath("//input[@id='add-to-cart-button-65']")).click();
	     
//Click on Shopping Cart
 	     
	     driver.findElement(By.xpath("//span[normalize-space()='Shopping cart']")).click();
	     driver.findElement(By.xpath("//input[@id=\"termsofservice\"]")).click();
	     driver.findElement(By.xpath("//button[@id=\"checkout\"]")).click();
	     
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	     
	     boolean Firstname = driver.findElement(By.xpath("//input[@id='BillingNewAddress_FirstName']")).isDisplayed();
	     if (Firstname==true) {
	     		driver.findElement(By.xpath("//input[@id='BillingNewAddress_Company']")).sendKeys("Rrootshell Technologies");
	     		driver.findElement(By.xpath("//option[normalize-space(.)='India']")).click();
	     		driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']")).sendKeys("Rayachoty");
	     		driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address1']")).sendKeys("Kadapa");
	     		driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']")).sendKeys("516214");
	     		driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']")).sendKeys("7013916400");
	     		driver.findElement(By.xpath("//input[@onclick='Billing.save()']")).click();
	     		
	     	}else {
	     		driver.findElement(By.xpath("//input[@onclick='Billing.save()']")).click();
	     	}
	     Thread.sleep(3000);
	      //click continue for shipping address
	     driver.findElement(By.cssSelector("input[onclick='Shipping.save()']")).click();
	     Thread.sleep(3000);
	     //select the shipping method
	     driver.findElement(By.xpath("//input[@id=\"shippingoption_0\"]")).click();  //Ground method
	     driver.findElement(By.xpath("(//input[@value=\"Continue\"])[3]")).click();
	     Thread.sleep(3000);
	     
	     //select payment method and click on cash on delivery method
	     driver.findElement(By.xpath("//input[@id=\"paymentmethod_0\"]")).click();
	     driver.findElement(By.xpath("(//input[@value=\"Continue\"])[4]")).click();
	     Thread.sleep(3000);
	     
	     //verifying payment method message
	     driver.findElement(By.xpath("//p[normalize-space()='You will pay by COD']")).isDisplayed();
	     Thread.sleep(3000);
	     
	     driver.findElement(By.xpath("(//input[@value=\"Continue\"])[5]")).click();
	     Thread.sleep(3000);
	     	      	     
	     //confirming order
	     driver.findElement(By.xpath("//input[@value=\"Confirm\"]")).click();
	     Thread.sleep(3000);
	     
	     //printing the Your order has been successfully processed message
	     
	     System.out.println(driver.findElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']")).getText());
	     Thread.sleep(3000);

	     String OnC = driver.findElement(By.xpath("//ul[@class=\"details\"]//li[contains(text(), 'Order number')]")).getText();
	     String OnCS = (OnC.replace("Order number: ", ""));
	     System.out.println("The Order Number in cart Section :"+OnCS);
	     driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
	     
	     //click on email address
	     driver.findElement(By.xpath(" //a[normalize-space()='robertdowney12@gmail.com']")).click();
	     //click on orders
	     driver.findElement(By.xpath("(//a[normalize-space()='Orders'])[1]")).click();
	     String OnO = driver.findElement(By.xpath("(//div[@class='section order-item'])[1]//Strong[contains(text(), 'Order Number')]")).getText();
	     String OnOS = (OnO.replace("Order Number: ", ""));
	     System.out.println("The Order Number in Order's Section :"+OnOS);
	     
	     int OrderNoatCart = Integer.parseInt(OnCS);
	     int OrderNoatOrders = Integer.parseInt(OnOS);
	     
	     if (OrderNoatCart==OrderNoatOrders) {
	     		System.out.println("Order Number in the order section is same as in the cart section");
	      
	     	}else {
	     		System.out.println("Order Number in the orders section is not same as in the cart section");
	     	}
	     driver.findElement(By.xpath("//a[normalize-space()='Log out']")).click();
		    Thread.sleep(3000);
		        
		     // Close Browser
		      driver.close(); 
		     //closes the Multiple tabs in browser
		     driver.quit(); 
	}

}
