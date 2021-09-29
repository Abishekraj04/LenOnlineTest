package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CommonUtils {
    WebDriver driver;

    public CommonUtils(WebDriver driver) {
        this.driver = driver;
    }

    public String getHeader() {
        String header = driver.getTitle();
        return header;
    }

    public void waitforelementtobeclickable(WebDriver driver, int timeout, WebElement element) {

        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));

    }

    public void clickelemenbyJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public static String getScreenshot(WebDriver driver)
    {
        TakesScreenshot ts=(TakesScreenshot) driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        String path=System.getProperty("user.dir")+"/Screenshot/"+System.currentTimeMillis()+".png";
        File destination=new File(path);
        try
        {
            FileUtils.copyFile(src, destination);
        } catch (IOException e)
        {
            System.out.println("Capture Failed "+e.getMessage());
        }
        return path;
    }
    public static String readpropertyfile(String key) throws IOException {
        Properties prop = new Properties();
        String path = System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties";
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        prop.load(fis);
       return prop.getProperty(key);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(readpropertyfile("browser"));
    }
}
