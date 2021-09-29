package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
WebDriver driver;
    public Login(WebDriver driver)
    {
        this.driver=driver;
    }
By username = By.id("signInName");
By password = By.xpath("//input[@id='password']");
By signin = By.xpath("//button[contains(text(),'Sign In')]");


public void enterUsername(String uname)
{
    driver.findElement(username).sendKeys(uname);
}
public void enterPassword(String pwd)
{
        driver.findElement(password).sendKeys(pwd);
}
    public void clickSignin()
    {
        driver.findElement(signin).click();
    }

    public Home signIn(String uname, String pwd)
    {
        this.enterUsername(uname);
        this.enterPassword(pwd);
        this.clickSignin();
     return new Home(driver);
    }


}
