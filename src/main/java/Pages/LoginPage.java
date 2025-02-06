package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    By userName = By.id("inputUsername");
    By password = By.xpath("//input[@name='inputPassword']");
    By rememberMeCheckBox=  By.id("chkboxOne");
    By termsCheckBox = By.id("chkboxTwo");
    By signInBtn= By.cssSelector(".submit.signInBtn");
    By forgotPasswordBtn =By.xpath("//a[text()='Forgot your password?']");
    By visitUsBtn = By.id("visitUsTwo");
    By errorMessage = By.xpath("//p[text()='* Incorrect username or password']");

    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
       this.wait= new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    public void login(String username, String pass ,  boolean rememberMe, boolean acceptTerms)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userName));
        driver.findElement(userName).sendKeys(username);
        driver.findElement(password).sendKeys(pass);
        if(rememberMe) {
            driver.findElement(rememberMeCheckBox).click();
        }
        if(acceptTerms)
        {
            driver.findElement(termsCheckBox).click();
        }

    }
public HomePage signIn()
{
    driver.findElement(signInBtn).click();
    return new HomePage(driver);
}
    public boolean errorMessage()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
          return driver.findElement(errorMessage).isDisplayed();
    }
    public void forgotPassword()
    {
        driver.findElement(forgotPasswordBtn).click();
    }

}
