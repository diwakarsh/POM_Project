package GUIUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	public static WebDriver StartApp(WebDriver driver,String browserName,String URL)
	{
		//chrome
		if (browserName.equals("Chrome")) {
			DesiredCapabilities caps=DesiredCapabilities.chrome();
			ChromeOptions options= new ChromeOptions();
			options.addArguments("--incognito");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");

			caps.setCapability(ChromeOptions.CAPABILITY,options);
			options.merge(caps);
			WebDriverManager.chromedriver().setup();
			
			//System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			if(configDataProvider.getRemote().equalsIgnoreCase("True"))
				try {
					driver=new RemoteWebDriver(new URL(configDataProvider.getHUBURL()),options);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			else
				driver = new ChromeDriver(options);
			
		}
		else if (browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver","./Drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else
		{
			System.out.println("We do not support this browser.");
		}
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public static void QuitDriver(WebDriver driver)
	{
		driver.quit();
	}
}


