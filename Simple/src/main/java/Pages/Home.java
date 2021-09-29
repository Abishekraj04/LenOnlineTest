package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {
    WebDriver driver;
    public Home(WebDriver driver)
    {
        this.driver=driver;
    }
    By signinlink = By.xpath("//a[contains(text(),'Sign In')]");
    By menu = By.xpath("//div[@class='gor-navigation pull-left gor-menu-container v2-hmaburger-menu-container']");
    By productcatalog = By.linkText("Product Catalog");
    public Login clickSigninLink()
    {
        driver.findElement(signinlink).click();
        return new Login(driver);

    }
    public void clicksignin()
    {
        this.clickSigninLink();
    }
    public  void menu()
    {
        driver.findElement(menu).click();
    }
    public void clickmenu()
    {
        this.menu();
    }
    public ProductCatalog clickProductCatalogLink(String linkname)
    {
        if(linkname.contains("Product Catalog"))
        driver.findElement(productcatalog).click();
        return new ProductCatalog(driver);
    }
}
