package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PartsandSupplies {
    WebDriver driver;
    public PartsandSupplies(WebDriver driver)
    {
        this.driver=driver;
    }
    By compressor = By.xpath("//a[contains(text(),'Compressors')]");
    public Compressors selectCompressor(String linkname) {
        if (linkname.contains("Compressors")) {
            driver.findElement(compressor).click();
            return new Compressors(driver);
        }
        return null;
    }
}
