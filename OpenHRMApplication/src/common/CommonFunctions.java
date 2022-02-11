package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class CommonFunctions {

	public static Properties properties;
	public static WebDriver driver;
	
	Logger logger =Logger.getLogger(CommonFunctions.class);

	// Gets config.property file data
	public Properties loadPropertyFile() throws IOException {

		FileInputStream fileInputStream = new FileInputStream("config.properties"); // To fetch
		properties = new Properties(); // To load
		properties.load(fileInputStream);

		return properties;

	}

	@BeforeSuite
	public void launchBrowser() throws IOException {
		
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Orange HRM Application Test Begins...");
		
		logger.info("Loading the property file");
		properties=loadPropertyFile();
		
		String browser=properties.getProperty("browser");
		String url=properties.getProperty("url");
		String driverLocation=properties.getProperty("driverLocation");
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverLocation);
			logger.info("Launching Chrome...");
			driver=new ChromeDriver();
		 
		}else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", driverLocation);
			logger.info("Launching Firefox...");
			driver =new FirefoxDriver();
			
		}
		driver.manage().window().maximize();
		logger.info("Navigating to Application");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}

	@AfterSuite
	public void closeBrowser() {
		
		logger.info("Execution Done. Closing the Application...");
		driver.quit();

	}

}
