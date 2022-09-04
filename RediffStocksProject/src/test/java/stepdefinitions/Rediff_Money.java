package stepdefinitions;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Rediff_Money 
{
   public static WebDriver dr;
   
   
   @Before("@signin")
    public void login() {
    	System.out.println("login scenario begins");
    }
   
   @After("@signout")
    public void logout() {
    	System.out.println("logout scenario executed");
    }
	@Given("^I open browser with url \"([^\"]*)\"$")
	public void i_open_browser_with_url(String url) throws InterruptedException 
	{
		System.setProperty("WebDriver.chrome.driver", "chromedriver.exe");
	    dr = new ChromeDriver();
		dr.manage().deleteAllCookies();
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		dr.get(url);
		Thread.sleep(2000);
	}

	@When("^I enter useremail \"([^\"]*)\"$")
	public void i_enter_useremail(String uemail) {
		dr.findElement(By.id("useremail")).sendKeys(uemail);
	}

	@When("^I enter password \"([^\"]*)\"$")
	public void i_enter_password(String pword) {
		dr.findElement(By.id("userpass")).sendKeys(pword);
	}



	@When("^I click on login button$")
	public void i_click_on_login_button() throws InterruptedException
	{
		dr.findElement(By.name("loginsubmit")).click();
		Thread.sleep(3000);
		
	}

	@Then("^I should see My portfolio$")
	public void i_should_see_My_portfolio() throws InterruptedException
	{
	   WebElement portfolio=dr.findElement(By.linkText("My Portfolio"));
	   if(portfolio.isDisplayed()) {
		   System.out.println("my portfolio is didsplayed");
		   Thread.sleep(2000);
	   }
	}

	@When("^I click on signout$")
	public void i_click_on_signout() {
		
		dr.findElement(By.linkText("Sign Out")).click();
	}

	@Then("^I should see logout successful$")
	public void i_should_see_logout_successful() 
	{
		if(dr.findElement(By.linkText("Login again")).isDisplayed()) {
			System.out.println("logout successful");
		}
		
	}
	@When("^I close browser$")
	public void i_close_browser()
	{
		dr.close();
	}

	
	@When("^I click on add stock button$")
	public void i_click_on_add_stock_button() throws InterruptedException
	{
		try {
		dr.findElement(By.id("addStock")).click();
		Thread.sleep(1000);
		}catch(StaleElementReferenceException e) {
			dr.findElement(By.id("addStock"));
		}
		
		}

	@When("^I add stocks entering \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_add_stocks_entering_and_and_and(String stname, String date, String quantity, String price) throws InterruptedException
	{

		WebElement stock=dr.findElement(By.id("addstockname"));
		stock.sendKeys(stname);
		
		Thread.sleep(1500);
		
		stock.sendKeys(Keys.ENTER);
		Thread.sleep(500);
		dr.findElement(By.id("stockAddDate")).sendKeys(date);
		dr.findElement(By.id("addstockqty")).sendKeys(quantity);
		dr.findElement(By.id("addstockprice")).sendKeys(price);
		dr.findElement(By.id("addStockButton")).click();
		Thread.sleep(2000);
		
	
	}
	
	@When("^I click escape$")
	public void i_click_escape() throws InterruptedException 
	{
		Thread.sleep(2000);
		dr.findElement(By.tagName("body")).sendKeys(Keys.ESCAPE);
		
	}
	
	@When("^I click on add mutualfund button$")
	public void i_click_on_add_mutualfund_button() throws InterruptedException
	{
		
		dr.findElement(By.id("addmf")).click();
		Thread.sleep(1000);
	}

	@When("^I add mutualfunds entering \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void i_add_mutualfunds_entering(String mfname, String iniamount, String mfdate) throws InterruptedException
	{
		WebElement fund =dr.findElement(By.name("mfname"));
		fund.sendKeys(mfname);
		
		Thread.sleep(1500);
		fund.sendKeys(Keys.ENTER);
		Thread.sleep(500);
		dr.findElement(By.id("mfinitialAmt")).sendKeys(iniamount);
		dr.findElement(By.id("addMFDate")).sendKeys(mfdate);
	   dr.findElement(By.name("mfprice")).click();
	   Thread.sleep(1000);
	   dr.findElement(By.id("addMFButton")).click();
	   Thread.sleep(1000);
		}
	
	@When("^I click on My Watchlist$")
	public void i_click_on_My_Watchlist() throws InterruptedException
    
	 {
		
		dr.findElement(By.linkText("My Watchlist")).click();
	Thread.sleep(1500);
		}

	@Then("^I should see My Watchlist$")
	public void i_should_see_My_Watchlist() throws InterruptedException 
	{
		WebElement heading=dr.findElement(By.xpath("//*[@id=\"headcontent\"]/div[4]/h1"));
		if(heading.isDisplayed()) {
			System.out.println("my watchlist is displayed");
		}
	
	}

	@When("^I click on AddStock$")
	public void i_click_on_AddStock() throws InterruptedException
	{
		try {
		dr.findElement(By.id("add-stock-button")).click();
		Thread.sleep(1000);
		}catch(StaleElementReferenceException e2) {
			dr.findElement(By.id("add-stock-button")).click();
		}
		}

	@When("^I enter \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void i_enter(String stockname, String aboveprice, String belowprice) throws InterruptedException 
	{
		WebElement watch=dr.findElement(By.id("stocksearch"));
		watch.sendKeys(stockname);
		Thread.sleep(1500);
		watch.sendKeys(Keys.ENTER);
		Thread.sleep(500);
		dr.findElement(By.id("maxprice")).sendKeys(aboveprice);
		dr.findElement(By.id("minprice")).sendKeys(belowprice);
		
	}

	@When("^I click on addstock button$")
	public void i_click_on_addstock_button() throws InterruptedException
	{
		dr.findElement(By.id("add-stock-submit")).click();
        Thread.sleep(1000);
	}

	
	@When("^I delete my portfolio$")
	public void i_delete_my_portfolio() throws InterruptedException 
	{   
		Thread.sleep(1000);
		dr.findElement(By.id("deletePortfolio")).click();
		dr.switchTo().alert().accept();
Thread.sleep(2000);
	}

	@When("^I create new portfolio$")
	public void i_create_new_portfolio() throws InterruptedException
	{
		WebElement crt=dr.findElement(By.id("create"));
		for(int i=1;i<=12;i++) {
			crt.sendKeys(Keys.ARROW_RIGHT);}
		for(int j=1;j<=12;j++) {
			crt.sendKeys(Keys.BACK_SPACE);
		}
		crt.sendKeys("sheshi");
		Thread.sleep(2000);
		dr.findElement(By.id("createPortfolioButton")).click();
		Thread.sleep(3000);
		
	}

	@When("^I delete all stocks in mywatchlist$")
	public void i_delete_all_stocks_in_mywatchlist() throws InterruptedException 
	{
	
		while(true) {
			try {
			dr.findElement(By.xpath("//*[@alt='Delete']")).click();
			dr.findElement(By.linkText("Yes")).click();
			Thread.sleep(2500);
			}catch(StaleElementReferenceException e3) {
				break;
			}catch(Exception e4) {
				System.out.println("stocks deleted");
				break;
			}
			
			
			
			
		}
	}

	
}
