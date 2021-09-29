package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Compressors {
    WebDriver driver;
    public Compressors(WebDriver driver)
    {
        this.driver=driver;
    }
    By compressorproduct = By.xpath("//a[contains(text(),'Compressors')]");
    public SelectCompressor selectCompressorProductLink(String linkname)
    {
        if(linkname.contains("Compressors"))
        driver.findElement(compressorproduct).click();
        return new SelectCompressor(driver);
    }

}
