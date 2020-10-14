package com.pom.qa.base;


	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.pom.qa.utils.TestUtils;
import com.pom.qa.utils.WebEventListener;

	public class TestBase {

		public static WebDriver driver;
		public static Properties prop;
		public static EventFiringWebDriver e_driver;
		public static WebEventListener eventListener;


		public TestBase(){

			try {
				prop = new Properties();
				FileInputStream ip = new FileInputStream("C:\\Selenium_Workspace_Dhruv\\PageObjectModelProject\\src\\main\\java\\com"
						+ "\\pom\\qa\\config\\config.properties");
				
				prop.load(ip);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		public static void initialization() {
			String browserName = prop.getProperty("browser");
			
			if (browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if(browserName.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
				   driver = new FirefoxDriver();
			} else  {
				System.setProperty("webdriver.edge.driver", "C:\\SeleniumJars\\msedgedriver.exe");
				driver = new EdgeDriver();
			}
			
			e_driver = new EventFiringWebDriver(driver);
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver = e_driver;
			
			
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);  // directly from testUtils class which is in Utitls package
			driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
			

		}
	}



