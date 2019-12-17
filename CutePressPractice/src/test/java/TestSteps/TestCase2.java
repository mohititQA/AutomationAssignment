package TestSteps;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import SetupClasses.BaseClass;
import pageObjects.ProductSearch;

public class TestCase2 extends BaseClass {
	ProductSearch ps;
	
   
    
	@Test
	public void ProductSearchResult() throws InterruptedException
	{
		logger.info("****** Opening the URL ****************");
		driver.get(super.newURL);
		driver.manage().window().maximize();
		Thread.sleep(4000);
		
		 ps = new ProductSearch(driver);
		 ps.enterSKUCode("2062412");
	}
	
	
	@AfterTest
	public void endSetup() 
	{
		
		//driver.quit();
	}
	
}
