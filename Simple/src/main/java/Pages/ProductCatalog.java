package Pages;

import Utils.CommonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductCatalog {
    WebDriver driver;
    CommonUtils utils;
    public ProductCatalog(WebDriver driver)
    {
        this.driver=driver;
    }
    By partsandsupplies = By.xpath("//a[contains(text(),'Parts and Supplies')]");
    public void clickpartsandsupplies()
    {
        WebElement ps = driver.findElement(By.linkText("Parts and Supplies"));
        utils = new CommonUtils(driver);
        utils.clickelemenbyJS(ps);
       // driver.findElement(partsandsupplies).click();
    }
    public PartsandSupplies selectPartsAndSuppies()
    {

        this.clickpartsandsupplies();
        return new PartsandSupplies(driver);
    }

}
