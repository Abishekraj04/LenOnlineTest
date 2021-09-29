package SearchAndValidateProduct;

import Pages.*;
import Utils.CommonUtils;
import Utils.DataProviderUtil;
import Utils.readDataFromExcel;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class RunTests {
    WebDriver driver;
    ExtentReports report;
    ExtentTest logger;
    readDataFromExcel readDataFromExcel = new readDataFromExcel();
@BeforeMethod
public void setup()
{
    ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"\\Reports\\test.html"));
    report = new ExtentReports();
    report.attachReporter(extent);

}


@Test(dataProvider="testdata",dataProviderClass = DataProviderUtil.class)
    public void Test01(Map<String, String> data) throws Exception {
    logger = report.createTest("Test01");
    String browsername = CommonUtils.readpropertyfile("browser");
    if(browsername.equalsIgnoreCase("chrome")) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    if(CommonUtils.readpropertyfile("browser").equals("firefox"))
    {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ "\\src\\main\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();
    }
    driver = new ChromeDriver();
    Home home = new Home(driver);
    Login login = new Login(driver);
    ProductCatalog productCatalog = new ProductCatalog(driver);
    PartsandSupplies partsandSupplies = new PartsandSupplies(driver);
    Compressors compressors = new Compressors(driver);
    SelectCompressor selectCompressor = new SelectCompressor(driver);
    logger.info("Starting the test");
    driver.get("https://www.liidaveqa.com/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    logger.info("Test started successfully");
    home.clicksignin();
    logger.info("Sign in click successful");
    Thread.sleep(10000);
    login.signIn(data.get("EMAILID"),data.get("PASSWORD"));
    logger.info("Sign in successful");
    Thread.sleep(10000);
    home.clickmenu();
    logger.info("Menu click successful");
    Thread.sleep(5000);
    home.clickProductCatalogLink(data.get("LinkName"));
    logger.info("ProductCatalogLink click successful");
    Thread.sleep(5000);
    productCatalog.clickpartsandsupplies();
    logger.info("PartsAndSupplieslink click successful");
    partsandSupplies.selectCompressor(data.get("PageNavigation"));
    logger.info("Compressorlink click successful");
    compressors.selectCompressorProductLink(data.get("PageNavigation"));
    logger.info("CompressorProductlink click successful");
    logger.info("CompressorModel validation started");
    selectCompressor.selectCompressorModel("Catalog#","Model/Part#","Price");
    logger.info("CompressorModel validation ended");
    driver.close();
}
@AfterMethod
    public void teardown(ITestResult result) throws IOException {
    if(result.getStatus() == ITestResult.FAILURE)
    {
        logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(CommonUtils.getScreenshot(driver)).build());
    }
    else if(result.getStatus() == ITestResult.SUCCESS)
    {
        logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(CommonUtils.getScreenshot(driver)).build());
    }
    report.flush();
}
}
