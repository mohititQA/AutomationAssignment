package TestSteps;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SetupClasses.BaseClass;
import SetupClasses.XlUtilits;
import pageObjects.ProductSearch;

public class TestCase2 extends BaseClass {
	
	ProductSearch ps ;
	@Test
	public void openURL() throws InterruptedException
	{
		logger.info("****** Opening the URL ****************");
		driver.get(super.newURL);
		driver.manage().window().maximize();
		Thread.sleep(6000);
		ps  = new ProductSearch(driver);
		
		// ps.LoginInApplication();
		
	}
   
    
	@Test(dataProvider="ProductData",dependsOnMethods = { "openURL" })
	public void ProductSearchResult(String quantity,String price, String Totalfee, String productName) throws InterruptedException, IOException
	{
		logger.info("Entering the Product Name : " + productName);
		ps.enterSKUCode(productName);
		 
	}
	
	
	@Test(dependsOnMethods = { "ProductSearchResult" })
	public void viewCartAndVerifyPrice()
	{
		ps.clickOnCart();
		ps.tableData();
	}
	
	@DataProvider(name="ProductData")
	String[][] requireProductData() throws IOException
	{
		String path= System.getProperty("user.dir")+"\\src\\test\\java\\TestData\\ProductInput.xlsx";
		//System.out.println(path);
		int rownum=XlUtilits.getRowCount(path, "Sheet1");
		int colcount=XlUtilits.getCellCount(path,"Sheet1",1);
		
		String productData[][]=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				productData[i-1][j]=XlUtilits.getCellData(path,"Sheet1", i,j);
			}
				
		}
		
		return productData;
	}
	
	@AfterTest
	public void endSetup() 
	{
		driver.quit();
	}
	
}
