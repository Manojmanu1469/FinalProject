package TestCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class BaseClass {

  public static	ChromeDriver driver;
	public Logger logger; // log4j
	public Properties p;
	
	
	@BeforeClass(groups = {"Sanity , Agression","Master"})
	@Parameters({"os","browser","owner"})
	public void setup(String os , String br , String own) throws InterruptedException, IOException {
		
		FileReader file = new FileReader("C:\\Users\\Dell\\eclipse-workspace\\finalproject\\src\\test\\resources\\config.properites");
		p = new Properties();
		p.load(file);
		
		driver = new ChromeDriver();
		logger = LogManager.getLogger(this.getClass());
		
		switch(own.toLowerCase()) {
		case "manu" : own = new String(); break;
		case "Manoj" : own = new String(); break;
		}
		switch (br.toLowerCase()) {
		case "chrome" : driver = new ChromeDriver();break;
		case "edge" : driver = new ChromeDriver();break; 
		}
		
		Thread.sleep(3000);
		
		driver.get(p.getProperty("URL")); // reading url from the properites files
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
		public String randomly() {
			String generatedmail= RandomStringUtils.randomAlphabetic(8);  // it will create random string
			
			return generatedmail;
		}
		
		
		public String randomnum() {
			String num= RandomStringUtils.randomAlphanumeric(8);  // it will create random string
			
			return num;
		}
		
		public String randompass() {
			String password= RandomStringUtils.randomAlphabetic(4);// it will create random string
			String pass =  RandomStringUtils.randomAlphanumeric(4);
			
			return (password +"#"+ pass);
		}
		
		public String captureScreen(String tname) throws IOException {
		    String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		    TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		    File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		    String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		    File targetFile = new File(targetFilePath);

		    sourceFile.renameTo(targetFile);

		    return targetFilePath;
		}

	
}
