package TestSteps;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import SetupClasses.BaseClass;
import SetupClasses.XlUtilits;
import pageObjects.searchPage;



public class TestCase1 extends BaseClass {
	searchPage sp;
	
	
	@Test
	public void openURL() throws InterruptedException
	{
		logger.info("****** Opening the URL ****************");
		driver.get(super.url);
		driver.manage().window().maximize();
		Thread.sleep(4000);
		
	}
	
	@Test(dataProvider="ProductData",dependsOnMethods = { "openURL" })
	public void SearchResult(String skuCode, String productName, String searchResult,String price) throws InterruptedException
	{
		
		sp = new searchPage(driver);
		logger.info(skuCode+ ": We are searching for the this SKUCode.");
		sp.enterSKUCode(skuCode);
		logger.info("click on the search button.");
		sp.clickOnSearch();
		Thread.sleep(4000);
		if ( productName=="")
		{
			logger.info(productName);
			logger.info("No Product is available for this SKU.");
			//Assert.assertEquals(arg0, arg1);
		}
		else{
			logger.info(sp.getProductName());
			logger.info(sp.getProductPrice());
			Assert.assertEquals(sp.getProductName(),productName,"");
			Assert.assertEquals(sp.getProductPrice(),price);
			
		}
		
		
	}
	
	@DataProvider(name="ProductData")
	String[][] requireProductData() throws IOException
	{
		String path= System.getProperty("user.dir")+"\\src\\test\\java\\TestData\\DataInput.xlsx";
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
