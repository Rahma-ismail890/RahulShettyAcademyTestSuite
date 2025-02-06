import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase {
    @Test
    public void test1()        //inter invalid data
    {
          loginPage.login("rahma","123456",true,true);
        Assert.assertTrue(loginPage.errorMessage());
    }
    @Test
    public void test2()        //empty username
    {
        loginPage.login("","123456",true,true);
        Assert.assertTrue(loginPage.errorMessage());
    }

    @Test
    public void test3()        //empty pass
    {
        loginPage.login("test","",true,true);
        Assert.assertTrue(loginPage.errorMessage());

    }
    @Test
    public void test4()        //empty username and pass
    {
        loginPage.login("","",true,true);
        Assert.assertTrue(loginPage.errorMessage());
    }
    @Test
    public void test5()             //valid data
    {
        loginPage.login("test","rahulshettyacademy",true,true);
        homePage = loginPage.signIn();
        Assert.assertTrue(homePage.successMessage());
        // lw 3yza check 3la url
//  Assert.assertEquals(driver.getCurrentUrl(),"https://rahulshettyacademy.com/locatorspractice/");
    }

}
