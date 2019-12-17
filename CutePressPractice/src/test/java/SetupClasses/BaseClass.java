package SetupClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;







public class BaseClass {
	public WebDriver driver;
	public Properties configProp;
	public static Logger logger;
	public String  url;
	public String newURL;

	
	@BeforeClass
	public void Setup() throws IOException
	{
		configProp = new Properties();
		FileInputStream fileInput = new FileInputStream("config.properties");
		configProp.load(fileInput);
		logger = Logger.getLogger("CutePressDemo");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
		url = configProp.getProperty("url");
		newURL = configProp.getProperty("newUrl");
		String br = configProp.getProperty("browser");
		if (br.equals("Chrome"))
		{
			logger.info("****** Launching the chrome browser ****************");
			System.setProperty("webdriver.chrome.driver",configProp.getProperty("chromeDriverPath"));
			System.out.println(configProp.getProperty("chromeDriverPath"));
			driver = new ChromeDriver();
			
		}
		else if(br.equals("Firefox"))
		{
			logger.info("****** Launching the FireFox browser ****************");
			System.setProperty("webdriver.gecko.driver",configProp.getProperty("firefoxDriverPath"));		
			driver = new FirefoxDriver();
		}
		else if(br.equals("IE"))
		{
			logger.info("****** Launching the Internet Explorer browser ****************");
			System.setProperty("webdriver.ie.driver",configProp.getProperty("ieDriverPath"));		
			driver = new ChromeDriver();
		}
		
	}
	
	
	
	
}
