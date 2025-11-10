package baseTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;

	public Logger logger; // Log4j

	public Properties prop;

	@BeforeClass(groups = { "Sanity", "Regression", "Master" })
	@Parameters({ "os", "browser" })
	public void setup(String os, String browser) throws IOException {

		// Loading property file
		try {
			FileReader file = new FileReader("./src//test//resources//config.properties");
			prop = new Properties();
			prop.load(file);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

		// LogManager();
		logger = LogManager.getLogger(this.getClass());

		if (prop.getProperty("execution_env").equalsIgnoreCase("remote")) // refer config.properties file
		{
			DesiredCapabilities cap = new DesiredCapabilities();

			// os
			if (os.equalsIgnoreCase("windows")) {
				cap.setPlatform(Platform.WIN11);
			} else if (os.equalsIgnoreCase("mac")) {
				cap.setPlatform(Platform.MAC);
			} else if(os.equalsIgnoreCase("linux")){
				cap.setPlatform(Platform.LINUX);
			}
			else 
			{
				System.out.println("No matching os available");
			}

			// browser

			switch (browser.toLowerCase()) {
			case "chrome":
				cap.setBrowserName("chrome");
				break;
			case "edge":
				cap.setBrowserName("MicrosoftEdge");
				break;
			case "firefox" :
				cap.setBrowserName("firefox");
				break;
			
			default:
				System.out.println("No matching browser");
				return;
			}
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		}

		if (prop.getProperty("execution_env").equalsIgnoreCase("local")) {
			switch (browser.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			default:
				System.out.println("Invalid browswer");
				return;
			}
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("appUrl")); // Reading url from properties file
		driver.manage().window().maximize();

	}

	@AfterClass(groups = { "Sanity", "Regression", "Master" })
	public void tearDown() {
		driver.quit();
	}

	public String randomString() {
		String gen_string = RandomStringUtils.insecure().nextAlphabetic(6);
		return gen_string;
	}

	public String randomNumber() {
		String gen_number = RandomStringUtils.insecure().nextNumeric(10);
		return gen_number;
	}

	public String randomPwd() {
		String s1 = RandomStringUtils.insecure().nextAlphabetic(4);
		String s2 = RandomStringUtils.insecure().nextNumeric(5);

		return (s1 + "@" + s2);
	}

	public String captureScreen(String tname)

	{
		String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		String targetFilePath = ".\\screenshots\\" + tname + " - " + timestamp + ".png";
		File targetFile = new File(targetFilePath);

		source.renameTo(targetFile);

		return targetFilePath;
	}

}
