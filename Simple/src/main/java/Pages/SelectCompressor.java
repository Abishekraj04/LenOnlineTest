package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectCompressor {
    WebDriver driver;
    java.lang.String text = null;
    java.lang.String proddetails=null;
    public SelectCompressor(WebDriver driver)
    {
        this.driver=driver;
    }
    By compressortitle1 = By.xpath("//h1[contains(text(),'Compressors')]");
    By compressortitle2 = By.xpath("//p[contains(text(),'Replace your compressor')]");
    By productslist = By.xpath("//div[@class=' productListItem ']");

    public void validateCompressorTitle()
    {
        String title1 = driver.findElement(compressortitle1).getText();
        String title2 = driver.findElement(compressortitle2).getText();
      if(title2.equals("Compressors") && (title2.equals("Replace your compressor at LennoxPros.com")))
      {
          System.out.println("Compressor title is validated");
      }
    }
    public void selectCompressorModel(String catalogid, String modelno,String price) throws InterruptedException {
        validateCompressorTitle();
        boolean flag = false;
        for (int i = 2; i <= 19; i++) {
            if(searchelement(catalogid))
            {
                if((text.contains(modelno)) && (text.contains(price)))
                {

                    System.out.println("Model/Part# is validated");
                    System.out.println("Price is validated");
                }
                System.out.println("element found");
                break;
            }
            else
            {
                WebElement page = driver.findElement(By.xpath("//strong[contains(text(),'"+i+"')]"));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();",page);
               WebElement alert = driver.findElement(By.xpath("(//button[contains(text(),'Save')])[2]"));
                js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();",alert);
               searchelement(catalogid);
                Thread.sleep(2000);
            }
        }
    }
    public  Boolean searchelement(String catalogid) {
        List<WebElement> el = driver.findElements(productslist);
        for (int j = 0; j < el.size(); j++) {
            text = el.get(j).getText();
            if (text.contains(catalogid)) {
                return true;
            }
            else
            {
                return  false;
            }
        }
        return null;
    }
}
