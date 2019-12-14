package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import SetupClasses.BaseClass;

public class searchPage  {

	WebDriver ldriver;
	public searchPage(WebDriver rdriver)
	{
		ldriver=rdriver;
    	PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(how=How.XPATH,using = "//*[@id='search']")
    @CacheLookup
    WebElement serachTextBox;
	
	@FindBy(how=How.XPATH,using ="//*[@id='search_mini_form']/div/button")
    @CacheLookup
    WebElement searchButton;
	
	@FindBy(how=How.XPATH,using= "//h2[@class='product-name']/a")
	@CacheLookup
	WebElement productName;
	
	@FindBy(how=How.XPATH,using= "//span[@class='price']")
	@CacheLookup
	WebElement price;
	
	@FindBy(how=How.XPATH,using= "//article/p")
	@CacheLookup
	WebElement noProductText;
	
	
	@FindBy(how=How.XPATH,using= "(//p/strong)[1]")
	@CacheLookup
	WebElement avilableProduct;
	
	
	public void enterSKUCode(String code)
	{
		serachTextBox.clear();
		serachTextBox.sendKeys(code);
	}
	
	public void clickOnSearch()
	{
		searchButton.click();
	}
	
	public String getProductName()
	{
		return productName.getText();
	}
	
	public String getProductPrice()
	{
		return price.getText();
	}
	
	public boolean noProductDisplay()
	{
		return noProductText.isDisplayed();
	}
	
	public boolean productDisplay()
	{
		return avilableProduct.isDisplayed();
	}
}
