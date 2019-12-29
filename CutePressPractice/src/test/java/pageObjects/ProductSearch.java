package pageObjects;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import SetupClasses.BaseClass;
import SetupClasses.XlUtilits;

public class ProductSearch extends BaseClass {
	
	WebDriver ldriver;
	WebDriverWait wait;
	public ProductSearch(WebDriver rdriver)
	{
		ldriver=rdriver;
    	PageFactory.initElements(rdriver,this);
    	 wait = new WebDriverWait(ldriver,30);
	}
    
	@FindBy(how=How.XPATH,using = "//input[@name='q']")
    @CacheLookup
    WebElement serachTextBox;
	
	@FindBy(how=How.XPATH,using = "//button[@class='button']")
    @CacheLookup
    WebElement searchButton;
	
	/*
	@FindBy(how=How.XPATH,using = "//input[@class='_2zrpKA _1dBPDZ']")
    @CacheLookup
    WebElement userName;
	
	@FindBy(how=How.XPATH,using = "//input[@class='_2zrpKA _3v41xv _1dBPDZ']")
    @CacheLookup
    WebElement passWord;
	
	@FindBy(how=How.XPATH,using = "//button[@class='_2AkmmA _1LctnI _7UHT_c']")
    @CacheLookup
    WebElement loginButton;
	
	*/
	
	//@FindBy(xpath =  "//a[text()='"+productName+"']")
    @CacheLookup
    WebElement firstProduct;
	
	/*
	@FindBy(how=How.XPATH,using = "//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")
    @CacheLookup
    WebElement gotoCartButton;
	
	*/
	@FindBy(how=How.XPATH,using = "//button[@class='button btn-cart']//span/i")
    @CacheLookup
    WebElement addCartButton;
	
	@FindBy(how=How.XPATH,using = "//img[@class='cart-img']")
    @CacheLookup
	WebElement viewCartOption;
	
	@FindBy(how=How.XPATH,using = "//a/i[@class='icon-basket']/..")
	@CacheLookup
	WebElement ViewCartButton; 
	
	@FindBy(how=How.XPATH,using = "(//div[@class='hJYgKM']//span)[1]")
    @CacheLookup
    WebElement price;
	
	@FindBy(how=How.XPATH,using = "(//div[@class='hJYgKM']//span)[2]")
    @CacheLookup
    WebElement deliveryFee;
	
	@FindBy(how=How.XPATH,using = "(//div[@class='hJYgKM']//span)[3]")
    @CacheLookup
    WebElement TotalPay;
	
	@FindBy(how=How.XPATH,using = "(//div[@class='hJYgKM']//span)[4]")
    @CacheLookup
    WebElement TotalPay2;
	
	@FindBy(how=How.XPATH,using = "(//button[@class='wNrY5O'])[2]")
    @CacheLookup
    WebElement quantity;
	
	/*@FindBy(how=How.XPATH,using = "(//div[@class='gdUKd9'])[2]")
    @CacheLookup
    WebElement removeButton;
*/
	@FindBy(how=How.XPATH,using = "//button[@class='button btn-empty']")
    @CacheLookup
    WebElement removebutton;
	
	@FindBy(how=How.XPATH,using = "//table[@id='shopping-cart-table']//tbody")
    @CacheLookup
    WebElement shoppingCartTable;
	
	@FindBy(how=How.XPATH,using = "//table[@id='shopping-cart-table']//tbody/tr")
    @CacheLookup
    WebElement tableRows;
	
	//functions required for the test case
	public void enterSKUCode(String productName) throws InterruptedException, IOException
	{
		if(productName.equals("Ultimate Renewal Revitalising Night Cream"))
		{	
						
			//wait.until(ExpectedConditions.presenceOfElementLocated((By) serachTextBox));

				try{
				    serachTextBox.clear();
					System.out.println(productName);
					serachTextBox.sendKeys(productName);
					searchButton.click();
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+productName+"']")));
					ldriver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
					wait.until(ExpectedConditions.presenceOfElementLocated((By) addCartButton));	
					addCartButton.click();	
				
				}
				catch(Exception e)
				   {
					    serachTextBox = ldriver.findElement(By.xpath("//input[@class='input-text']"));
					    serachTextBox.clear();
						serachTextBox.sendKeys(productName);
						searchButton = ldriver.findElement(By.xpath("//button[@class='button']"));
						searchButton.click();
						wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+productName+"']")));
						ldriver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
						addCartButton = ldriver.findElement(By.xpath("//button[@class='button btn-cart']//span/i"));
						//wait.until(ExpectedConditions.presenceOfElementLocated((By) addCartButton));	
						addCartButton.click();
						Thread.sleep(3000);
				   		
	
				   }
			
		}
		
		else
		{
			serachTextBox.clear();
			System.out.println(productName);
			serachTextBox.sendKeys(productName);
			searchButton.click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+productName+"']")));
			ldriver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
			
			addCartButton.click();
			Thread.sleep(3000);
			//navigatetoBack();
		}
								
	}
	
	
	/*public void LoginInApplication() throws InterruptedException
	{
		userName.sendKeys("mohitit09@gmail.com");
		passWord.sendKeys("Password$123");
		loginButton.click();
		Thread.sleep(4000);
		enterSKUCode("Flipkart SmartBuy Military Keychain with Torch, Screwdriver, Knife & Bottle Opener Key Chain");
	}
	
	*/
	public void clickOnQuantity(String qty) throws InterruptedException
	{
			
		quantity.click();
		Thread.sleep(2000);
	}
	
	public String getProductPrice()
	{
		return price.getText();
	}
	
	
	public String getDeliveryFee()
	{
		return deliveryFee.getText();
	}
	
	//if quantity is 1
	public String getTotalPrice()
	{
		return TotalPay.getText();
	}
	
	//if quantity is 2
		public String getTotalPrice1()
		{
			return TotalPay2.getText();
		}
		
	public void clickRemoveButton()
	{
		//removeButton.click();
		removebutton.click();
	}

public void navigatetoBack()
{
	ldriver.navigate().back();
	ldriver.navigate().back();
	ldriver.navigate().refresh();
}
	

	public void clickOnCart()
	{
		viewCartOption.click();
		ViewCartButton.click();
		
	}
	
	public void tableData()
	 {
		//No. of Columns
		String text="";
        List<WebElement>  rows = ldriver.findElements(By.xpath("//table[@id='shopping-cart-table']//tbody/tr"));
        List<WebElement>  cols = ldriver.findElements(By.xpath("//table[@id='shopping-cart-table']//tbody/tr[1]/td"));
        for(int i =1;i<=rows.size();i++)
        	for(int j =1;j<=cols.size();j++)
        	{
        		
				if(j>2 && j!=5)
				{
        			 text = ldriver.findElement(By.xpath("//table[@id='shopping-cart-table']//tbody/tr["+i+"]/td["+j+"]")).getText();
				     logger.info("*******************************************************");
				     logger.info(text);
				}
        	}
	 }
	
}

