package Execute;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class Appium {
	
	public static WebElement odriver;
	public static AndroidDriver<WebElement> driver;
	
	public static void main (String args[]) throws  InterruptedException, IOException {
		
		
		String FilePath = "D:\\Softwares\\Demo\\LoginDetails.xlsx";
		
		XSSFWorkbook wb = new XSSFWorkbook(FilePath);
		XSSFSheet sheet= wb.getSheetAt(0);
		int totalNoOfRow = sheet.getLastRowNum();
		int noOfColumns = sheet.getRow(0).getPhysicalNumberOfCells();
		
		XSSFCell username,password,Scenario;
		for(int i=1;i <= totalNoOfRow;i++){
			Scenario = sheet.getRow(i).getCell(0);
			username = sheet.getRow(i).getCell(1);
			password = sheet.getRow(i).getCell(2);

	DesiredCapabilities capabilities = new DesiredCapabilities();
	//capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
	capabilities.setCapability("deviceName", "Galaxy S8");
	capabilities.setCapability("deviceid", "R9EN204DQDJ");
//	capabilities.setCapability("UDID", "988a1b44485a42545830");
//	capabilities.setCapability("UDID", "ce071717899bb46f0b");
	capabilities.setCapability("platformVersion", "10");
	capabilities.setCapability("platformName", "Android");
	capabilities.setCapability("appPackage", "com.azam.sarafu");
	capabilities.setCapability("appActivity", "com.azam.sarafu.MainActivity");
	capabilities.setCapability("noReset", "true");

	driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	
	if(Scenario.toString().equals("Valid")){
	odriver=driver.findElementByXPath("//android.widget.TextView[@text='Ingia']");
	odriver.click();
	
	
	odriver=driver.findElementByXPath("//android.widget.TextView[@text='Namba ya Simu  *']");
	odriver.sendKeys(username.toString());
    driver.hideKeyboard();
	Thread.sleep(500);
	
	odriver=driver.findElementByXPath("//android.widget.TextView[@text='Ingiza Nywila  *']");
	odriver.clear();
	odriver.sendKeys(password.toString());
    driver.hideKeyboard();
	Thread.sleep(500);
	
	List<WebElement> elements = driver.findElements(By.xpath("//android.widget.TextView[@text='Ingia']"));
    elements.get(1).click();
    elements.get(1).click();
	
	
    odriver=driver.findElementByXPath("//android.widget.TextView[@text='Huduma']");
	String Actual = odriver.getText();
	String Expected = "Huduma";
	
		if (Actual.equals(Expected)) {
	        System.out.println("Successfully Verified the Dashboard");
	} else {
	        System.out.println("Failed to Verify the Dashboard");
	}
	
	odriver=driver.findElementByXPath("//android.widget.TextView[@index='0']");
	odriver.click();
	Thread.sleep(500);
	odriver=driver.findElementByXPath("//android.widget.TextView[@text='0    Mipangilio']");
	odriver.click();
	Thread.sleep(500);
	odriver=driver.findElementByXPath("//android.widget.TextView[@text='ONDOKA']");
	odriver.click();
	Thread.sleep(500);
	odriver=driver.findElementByXPath("//android.widget.TextView[@text='THIBITISHA']");
	odriver.click();
	
	
	}
	else if(Scenario.toString().equals("InValid")){
		odriver=driver.findElementByXPath("//android.widget.TextView[@text='Ingia']");
		odriver.click();
		
		
		odriver=driver.findElementByXPath("//android.widget.TextView[@text='Namba ya Simu  *']");
		odriver.sendKeys(username.toString());
	    driver.hideKeyboard();
		Thread.sleep(500);
		
		odriver=driver.findElementByXPath("//android.widget.TextView[@text='Ingiza Nywila  *']");
		odriver.clear();
		odriver.sendKeys(password.toString());
	    driver.hideKeyboard();
		Thread.sleep(500);
		
		List<WebElement> elements = driver.findElements(By.xpath("//android.widget.TextView[@text='Ingia']"));
	    elements.get(1).click();
	    elements.get(1).click();
	    
	    odriver=driver.findElementByXPath("//android.widget.TextView[@text='namba ya simu au nywila sio sahihi']");
		String Status = odriver.getText();
		System.out.println(Status);
		
		odriver=driver.findElementByXPath("//android.widget.TextView[@text='Ondoa']");
		odriver.click();
		
		
	}
	driver.closeApp();
	 }
	
  }

}
