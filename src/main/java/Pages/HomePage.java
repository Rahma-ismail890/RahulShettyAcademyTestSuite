package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    By successMessage = By.xpath("//h2[contains(text(), 'Hello')]");
    public HomePage(WebDriver driver)
    {
        this.driver=driver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    public boolean successMessage()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return driver.findElement(successMessage).isDisplayed();
    }
}
