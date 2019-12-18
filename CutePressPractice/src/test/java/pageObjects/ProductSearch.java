package pageObjects;

import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductSearch {
	
	WebDriver ldriver;
	public ProductSearch(WebDriver rdriver)
	{
		ldriver=rdriver;
    	PageFactory.initElements(rdriver,this);
	}
    
	@FindBy(how=How.XPATH,using = "//*[@name='q']")
    @CacheLookup
    WebElement serachTextBox;
	
	@FindBy(how=How.XPATH,using = "//button[@class='vh79eN']")
    @CacheLookup
    WebElement searchButton;
	
	@FindBy(how=How.XPATH,using = "//input[@class='_2zrpKA _1dBPDZ']")
    @CacheLookup
    WebElement userName;
	
	@FindBy(how=How.XPATH,using = "//input[@class='_2zrpKA _3v41xv _1dBPDZ']")
    @CacheLookup
    WebElement passWord;
	
	@FindBy(how=How.XPATH,using = "//button[@class='_2AkmmA _1LctnI _7UHT_c']")
    @CacheLookup
    WebElement loginButton;
	
	
	@FindBy(how=How.XPATH,using = "(//div[1]/div/div/img)[1]")
    @CacheLookup
    WebElement firstProduct;
	
	@FindBy(how=How.XPATH,using = "//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")
    @CacheLookup
    WebElement gotoCartButton;
	
	@FindBy(how=How.XPATH,using = "//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")
    @CacheLookup
    WebElement addCartButton;
	
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
	
	@FindBy(how=How.XPATH,using = "(//div[@class='gdUKd9'])[2]")
    @CacheLookup
    WebElement removeButton;
	
	@FindBy(how=How.XPATH,using = "(//div[@class='gdUKd9 _3Z4XMp _2nQDKB'])")
    @CacheLookup
    WebElement removebutton;
	
	
	//functions required for the test case
	public void enterSKUCode(String product) throws InterruptedException
	{
		//closeButton.click();
	
			
		serachTextBox.clear();
		serachTextBox.sendKeys(product);
		searchButton.click();
		Thread.sleep(4000);
		firstProduct.click();
		Thread.sleep(2000);
		Set<String> allWindowHandles = ldriver.getWindowHandles();
		for(String handle:allWindowHandles)
		{
			ldriver.switchTo().window(handle);
		}
		addCartButton.click();
		Thread.sleep(2000);
		
	}
	
	
	public void LoginInApplication() throws InterruptedException
	{
		userName.sendKeys("mohitit09@gmail.com");
		passWord.sendKeys("Password$123");
		loginButton.click();
		Thread.sleep(4000);
		enterSKUCode("Flipkart SmartBuy Military Keychain with Torch, Screwdriver, Knife & Bottle Opener Key Chain");
	}
	
	
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
		removeButton.click();
		removebutton.click();
	}
}

