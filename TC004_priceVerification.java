package Selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC004_priceVerification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="https://demowebshop.tricentis.com"; 
		WebDriver driver=new ChromeDriver();  
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(url);
// Click on Login 
		driver.findElement(By.xpath("//a[@class='ico-login']")).click();   
		
// Login with the Valid credentials
	       
         driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("kalyanb123@gmail.com");
		 driver.findElement(By.id("Password")).sendKeys("kalyanb123");
	     driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
	     
	 	   
	   //Navigate to books category and click on Fiction Book  and Add it to the shopping Cart
	     driver.findElement(By.xpath("//ul[@class=\"top-menu\"]/li[1]/child::a[normalize-space()='Books']")).click();
	     
	     driver.findElement(By.xpath("//a[normalize-space()='Computing and Internet']")).click();
	     
	     WebElement element=driver.findElement(By.xpath("//input[@class='qty-input']"));
	     element.clear();
	     element.sendKeys("3");
	     driver.findElement(By.xpath("//div[@class='add-to-cart']")).click();

	    //  Navigate to Computers category and navigate to accessories click any product, Add it to the Cart
	     
	     driver.findElement(By.xpath("//ul[@class=\"top-menu\"]/li[2]/child::a[normalize-space()='Computers']")).click();
	     driver.findElement(By.xpath("//div/child::h2[@class=\"title\"]/a[@title=\"Show products in category Accessories\"]")).click();
	     driver.findElement(By.xpath("//a[normalize-space()='TCP Public Complete']")).click();
	    WebElement element1=driver.findElement(By.xpath("//input[@data-val='true']"));
	     element1.clear();
	     element1.sendKeys("4");
	     driver.findElement(By.xpath("//input[@id='add-to-cart-button-65']")).click();
	     
	     //Click on Shopping Cart
 	     
	     driver.findElement(By.xpath("//span[normalize-space()='Shopping cart']")).click();
 
    	 
  // Retrieve price and quantity values from the table 
     	String P1 = driver.findElement(By.xpath("//span[@class='product-unit-price']")).getText();
     	String Q1 = driver.findElement(By.xpath("(//input[@class='qty-input'])[1]")).getAttribute("value");
     	double Price_1 = Double.parseDouble(P1.replace("$", "")); 
     	int Quantity_1 = Integer.parseInt(Q1);
      
// Calculate total price by multiplying Price and Quantity
     	double totalPrice_1 = Price_1 * Quantity_1;
     	System.out.println("The details of first product");
     	System.out.println("Price of first product: " + Price_1);
     	System.out.println("Quantity of first product = " + Quantity_1);
     	System.out.println("Total Price of first product: " + totalPrice_1);
        System.out.println(" ");  
  
 // Retrieve price and quantity values
     	String P2 = driver.findElement(By.xpath("(//span[@class='product-unit-price'])[2]")).getText();  
     	String Q2 = driver.findElement(By.xpath("(//input[@class='qty-input'])[2]")).getAttribute("value");
      
 // Convert the retrieved strings to numerical types
     	double Price_2 = Double.parseDouble(P2.replace("$", ""));
     	int Quantity_2 = Integer.parseInt(Q2);
      
// Calculate total price by multiplying price and quantity
     	double totalPrice_2 = Price_2 * Quantity_2;
     	System.out.println("The details of second product");
     	System.out.println("Price of second product:= " +Price_2);
     	System.out.println("Quantity of second product = " +Quantity_2);
     	System.out.println("Total Price	of second product:= " + totalPrice_2);
     	
     	double totalPrice_3 = totalPrice_1 + totalPrice_2;
     	System.out.println("  ");
     	System.out.println("Total Price of Two Products := "+(totalPrice_3));
     	
     	     	     	
     	String subprice = driver.findElement(By.xpath("//span[@class='product-price order-total']")).getText();
     	double SubTotal = Double.parseDouble(subprice.replace("$", ""));
     	System.out.println("Sub total price present at end : Rs = " + SubTotal);
     	 System.out.println("--------------------------------------------");
     	if(totalPrice_3==SubTotal){
     		System.out.println("Sub Total price and sum of prices of 2 products are equal");
     	}else {
			System.out.println("Sub Total price and sum of prices of 2 products are not equal");
     	}
     	
     	 //click on the check boxes
	     
	     driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	     driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
	     
// updating shopping cart items by clicking on update shopping cart
	     
	     driver.findElement(By.xpath("//input[@name=\"updatecart\"]")).click();
	     
     	//Clicking  on Logout element
	     
	     driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
	     
	    //closes the current window
        driver.close(); 
      //closes the Multiple tabs in browser
        
        driver.quit();
	}

}
