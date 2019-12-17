package pageObjects;

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
    
	@FindBy(how=How.XPATH,using = "//*[@id='site_search_input']")
    @CacheLookup
    WebElement serachTextBox;
	
	@FindBy(how=How.XPATH,using = "//*[@id='modalDialog']/button")
    @CacheLookup
    WebElement closeButton;
	
	public void enterSKUCode(String code) throws InterruptedException
	{
		closeButton.click();
		
		Actions builder = new Actions(ldriver); 
		
		serachTextBox.clear();
		serachTextBox.sendKeys(code);
		serachTextBox.sendKeys(Keys.ENTER);
		
		builder.sendKeys(Keys.ENTER);
		
	}
	
	
}
