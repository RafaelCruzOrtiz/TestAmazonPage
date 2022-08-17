
// Test by Rafael Cruz Ortiz. Login to amazon and verify url, page name, logo, and login.
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.junit.Assert;

public class OpenAmazonPage {

	public static void main(String[] args) {
		
		// Set the ChromeDriver Executable
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ortiz\\Documents\\chromedriver_win32\\chromedriver.exe");

	      // Configure Chrome Driver to open Chrome in Incognito Mode due to Amazon's barriers
	      ChromeOptions Incognito= new ChromeOptions();
	      Incognito.addArguments("--incognito");
	      DesiredCapabilities Capabilities = DesiredCapabilities.chrome();
	      Capabilities.setCapability(ChromeOptions.CAPABILITY, Incognito);
	      WebDriver driver = new ChromeDriver(Incognito);
		
		// Initiate Chrome Driver, this opens Chrome in normal mode, comment incognito mode (5 lines of code immediately above)
	    // and uncomment this line below if amazon is not blocking you.
		//WebDriver driver=new ChromeDriver();

		// Wait a few seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Maximize the Window
		driver.manage().window().maximize();

		// Open the target URL in the Chrome Browser
		driver.get("https://www.amazon.com");
		
		
		
		// Verify that the name of the page is correct
		Assert.assertEquals("Amazon.com. Spend less. Smile more.", driver.getTitle());  
		System.out.println("The page title is correct: Amazon.com. Spend less. Smile more."); 
		
		// Verify that the URL of the page is correct
		Assert.assertEquals("https://www.amazon.com/", driver.getCurrentUrl());
		System.out.println("The page URL is correct: ");
		System.out.println(driver.getCurrentUrl());
		    
		// Wait another few seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Verify that the Div for the Amazon Logo is presented
		WebElement DivAmazonLogo = driver.findElement(By.id("nav-logo"));
		Assert.assertEquals(true, DivAmazonLogo.isDisplayed());
		System.out.println("The Div for the Amazon Logo is present");

		// Wait another few seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Verify that the Amazon Logo is Presented
		WebElement AmazonLogo = driver.findElement(By.id("nav-logo-sprites"));
		Assert.assertEquals(true, AmazonLogo.isDisplayed());
		System.out.println("The Amazon Logo is Presented");
		
		// Wait another few seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Hover Over the Hello Sign In Accounts & Lists Button
		WebElement AccountsListsButton = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		Actions MovingThrough = new Actions(driver);
		MovingThrough.moveToElement(AccountsListsButton).perform();

		// Wait another few seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Click on the Login Button
		// WebElement FirstSignInButton = driver.findElement(By.xpath("//span[contains(@class,'nav-action-inner')]"));
		//  TRY THE CODE BELOW TODAY BECAUSE AMAZON GOT MAD YESTERDAY
		WebElement FirstSignInButton = driver.findElement(By.id("nav-flyout-ya-signin"));
		Actions MovingThrough2 = new Actions(driver);
		MovingThrough2.moveToElement(FirstSignInButton).perform();
		MovingThrough2.click(FirstSignInButton).perform();
		
		// Wait another few seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Find UserName field, enter and submit username.
		WebElement username = driver.findElement(By.id("ap_email"));
		username.sendKeys("ortiz.rafael@outlook.com");
		WebElement continuebutton = driver.findElement(By.id("continue"));
		continuebutton.click();
		
		// Wait another few seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Find password field, enter and submit the password.
		WebElement password = driver.findElement(By.id("ap_password"));
		password.sendKeys("Test123");
		WebElement signIn = driver.findElement(By.id("signInSubmit"));
		signIn.click();
		
		// Wait another few seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Make sure login worked
		WebElement LoginConfirmation = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		//WebElement LoginConfirmation = driver.findElement(By.className("nav-line-1 nav-progressive-content"));
		System.out.println(LoginConfirmation.getText());
		Assert.assertEquals("Hello, Rafa", LoginConfirmation.getText());
		System.out.println("LOGIN WAS SUCCESSFUL");

		// Wait another few seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Close the Chrome Browser
		driver.close();
		
	}
		
}
