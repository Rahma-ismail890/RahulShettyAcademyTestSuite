package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForgotPasswordPage {
    WebDriver driver;
    WebDriverWait wait;
    By name = By.xpath("//input[@placeholder='Name']");
    By email = By.xpath("//input[@placeholder='Email']");
    By phone = By.xpath("//input[@placeholder='Phone Number']");
    By resetLoginBtn =By.xpath("//button[text()='Reset Login']");
    By goToLoginBtn = By.xpath("//button[normalize-space()='Go to Login']");
    By password = By.xpath("//p[@class='infoMsg']");
    public ForgotPasswordPage(WebDriver driver)
    {
        this.driver=driver;
      wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    private String getPassword ()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        String text = driver.findElement(password).getText();
        int startIndex = text.indexOf("'")+1;
        int endInd = text.lastIndexOf("'");
        return text.substring(startIndex,endInd);
    }
    public String resetPassword(String Name , String Email , String Phone)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(name));
        driver.findElement(name).sendKeys(Name);
        driver.findElement(email).sendKeys(Email);
        driver.findElement(phone).sendKeys(Phone);
        driver.findElement(resetLoginBtn).click();
        return getPassword();
    }
    public void relogin()
    {
        driver.findElement(goToLoginBtn).click();
    }
}
