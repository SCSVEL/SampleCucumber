package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FBLoginSteps{
	private WebDriver driver;
	private WebDriverWait wait;
	
	public FBLoginSteps(){		
	}
	
	/*
	 * CUCUMBER HOOKS - Should be inside STEP DEFINITIONS classes
	 * Only supported hooks are Before and After. For every scenario, it will execute.
	 * If it is SCENARIO OUTLINE, for each data it will execute.
	 * If you need different functionalities, you can implement based on application behavior and condition
	 * @Before hook will execute before Background from feature file
	 */
	@Before
	public void beforeEachScenario(){
		System.out.println("BEFORE HOOK");
		
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);		
		driver.manage().window().maximize();
	}
	
	@After
	public void afterEachScenario(){
		System.out.println("AFTER HOOK");
		
		driver.close();
	}
	
	@Given("^FB page is in open$")	
	public void fb_Page_is_in_open(){					
		driver.get("https://www.facebook.com/");
		wait.until(ExpectedConditions.elementToBeClickable(By.name("firstname")));
	}
	
	@When("^I enter values$")
	public void i_enter_values(){
		driver.findElement(By.name("firstname")).sendKeys("FirstName HARDCODED");
		driver.findElement(By.name("lastname")).sendKeys("LastName HARDCODED");
	}
	
	@When("^I enter values (.*) and (.*)$")     //WITH PARAMETER
	public void i_enter_values(String firstName, String lastName){
		driver.findElement(By.name("firstname")).sendKeys(firstName);
		driver.findElement(By.name("lastname")).sendKeys(lastName);
	}
	
	@Then("^I Should see the values$")
	public void i_Should_see_the_values(){
		System.out.println("ACTUAL VALUE: " + driver.findElement(By.name("firstname")).getAttribute("value"));
		Assert.assertEquals(driver.findElement(By.name("firstname")).getAttribute("value").isEmpty(), false);		
		
	}
}
