import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends TestBase {
    @Test
    public void ResetPassword()
    {
        loginPage.forgotPassword();
        String password = forgotPasswordPage.resetPassword("rahma","rahma@gmail.com","0123454322");
        forgotPasswordPage.relogin();
        loginPage.login("rahma",password,true,true);
         homePage = loginPage.signIn();
        Assert.assertTrue(homePage.successMessage());

    }
}
