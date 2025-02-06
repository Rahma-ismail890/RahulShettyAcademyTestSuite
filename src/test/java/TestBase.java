import Pages.ForgotPasswordPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    ForgotPasswordPage forgotPasswordPage;
    @BeforeMethod
    public void initialization()
    {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        forgotPasswordPage =new ForgotPasswordPage(driver);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void threadDown()
    {
        driver.quit();

    }
}
