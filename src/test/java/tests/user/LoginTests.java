package tests.user;

import models.User;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginAndRegisterPage;
import tests.TestBase;

public class LoginTests extends TestBase {
    HomePage homePage;
    LoginAndRegisterPage loginAndRegisterPage;

    @BeforeMethod
    public void initTest() {
        loginAndRegisterPage = PageFactory.initElements(driver, LoginAndRegisterPage.class);
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test
    public void loginSuccessTest() {
        homePage.openLoginRegForm();
        Assert.assertTrue(loginAndRegisterPage.loginFormIsDisplayed());
        loginAndRegisterPage.fillLoginForm(User.builder().email("zaitsevaooops2022@gmail.com").password("ZPthgievRi295nu").build());
        loginAndRegisterPage.clickBTNLogIn();
        Assert.assertTrue(homePage.loginSuccessMassageIsDiplayed());
        homePage.logOut();
    }


    @Test   //Registered user can't login with incorrect email and valid password
    public void wrongEmailValidPassTest() {
        homePage.openLoginRegForm();
        Assert.assertTrue(loginAndRegisterPage.loginFormIsDisplayed());
        loginAndRegisterPage.fillLoginForm(User.builder().email("zaitsevaooops2022@gmail").password("ZPthgievRi295nu").build());
        loginAndRegisterPage.clickBTNLogIn();
        Assert.assertTrue(loginAndRegisterPage.allertIsDisplayed());
        Assert.assertTrue(loginAndRegisterPage.massageErrorIsDisplaeyd());
    }


    @Test   //Registered user can't login with incorrect password and valid email
    public void wrongPasswValidEmailTest() {
        homePage.openLoginRegForm();
        Assert.assertTrue(loginAndRegisterPage.loginFormIsDisplayed());
        loginAndRegisterPage.fillLoginForm(User.builder().email("zaitsevaooops2022@gmail").password("ZPthgie").build());
        loginAndRegisterPage.clickBTNLogIn();
        Assert.assertTrue(loginAndRegisterPage.allertIsDisplayed());
        Assert.assertTrue(loginAndRegisterPage.massageErrorIsDisplaeyd());
    }

}
