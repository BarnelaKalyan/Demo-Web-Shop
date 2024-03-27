package Selenium;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC007_comparing_products {

	public static void main(String[] args) throws InterruptedException {
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
	// Click on Login 
		driver.findElement(By.xpath("//a[@class='ico-login']")).click();   

		// Login with the Valid credentials

		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("robertdowney12@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("robert12");
		driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();		       

		// click on computers catergory from the menu and add any product to the shopping cart

		driver.findElement(By.xpath("(//ul[@class='top-menu']/child::li)[2]")).click();
		driver.findElement(By.xpath("//div[@class='item-box'][2]")).click();

		// click on the any  product and add it  to the compare list 
		driver.findElement(By.xpath("//h2[@class='product-title']")).click();
		driver.findElement(By.xpath("//input[@value='Add to compare list']")).click();

		// Navigate to the compare list 

		driver.findElement(By.xpath("(//div[@class='column customer-service']/child::ul/child::li)[5]")).click();

		//Printing the product name and price of the product

		String name_p1=driver.findElement(By.xpath("(//td[@class='a-center']/child::a)[1]")).getText();
		System.out.println("name of the first product:"+name_p1);

		String price_p1=driver.findElement(By.xpath("//tr[@class='product-price']/child::td[2]")).getText();  
		double first_p1 = Double.parseDouble(price_p1);

		System.out.println("price of first product in INR :"+price_p1);

		System.out.println("********************************");
		
		// navigate to the URL
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://demo.nopcommerce.com/");
		//driver.navigate().to("https://demo.nopcommerce.com/");

		// navigate to the computers category and add random product to the comparelist

		driver.findElement(By.xpath("(//ul[@class='top-menu notmobile']/child::li)[1]")).click();
		driver.findElement(By.xpath("(//div[@class='picture'])[2]")).click(); 

		Thread.sleep(3000);

		List<WebElement> Count_Products = driver.findElements(By.xpath("//div[@class='picture']"));
		Random randomly = new Random();
		int random_no = randomly.nextInt(Count_Products.size());
		WebElement Product= Count_Products.get(random_no);
		Product.click();
		// scroll the webpage

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window,scrollBy(0,300)");

		driver.findElement(By.xpath("//div[@class='compare-products']")).click();
		Thread.sleep(3000);  
		js.executeScript("window,scrollBy(0,3000)");

		driver.findElement(By.xpath("(//ul[@class='list']/child::li)[11]")).click();
		//Printing the product name and price of the second product
		String name_p2=driver.findElement(By.xpath("//tr[@class='product-name']/child::td[2]")).getText();
		System.out.println("Name of the second product:"+name_p2);

		String price_p2=driver.findElement(By.xpath("//tr[@class='product-price']/child::td[2]")).getText();
		String p2 = price_p2.replace("$", "");
		 double second_p2 = Double.parseDouble(p2.replace(",", ""));
		 
		 double price2_INR=second_p2*83.35;
				 
		 //price of the second product
		 System.out.println("price of second product in INR :"+price2_INR);
		 
		if(first_p1>second_p2) {
			System.out.println("price of first product is more than the second product");
			
		}
		else if(first_p1==second_p2){
			System.out.println("price of first product and second product are Equal");
		}else {
			System.out.println("price of first product is less than the second product");
		}
		//closes the current window
	     
	     driver.close();
	     
      //closes the Multiple tabs in the window
        
        driver.quit();
	}

}
