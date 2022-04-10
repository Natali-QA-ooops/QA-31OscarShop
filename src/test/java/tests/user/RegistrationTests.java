package tests.user;

import helpers.MyDataProvider;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginAndRegisterPage;
import tests.TestBase;

import static helpers.DataHelper.generateRandomEmail;
import static helpers.DataHelper.randomNumeric;

public class RegistrationTests extends TestBase {
    HomePage homePage;
    LoginAndRegisterPage loginAndRegisterPage;
    String password = "Qwe123456!";
    String email= "testemail" + randomNumeric(3) + "@gmail.com";

    @BeforeMethod
    public void initTest(){
        homePage = PageFactory.initElements(driver, HomePage.class);
        loginAndRegisterPage = PageFactory.initElements(driver, LoginAndRegisterPage.class);
    }


    @Test (dataProvider = "registerValidDataCSV", dataProviderClass = MyDataProvider.class)
    public void registrationPositiveTest(String email, String password, String confirmPassword){
        homePage.openLoginRegForm();
        Assert.assertTrue(loginAndRegisterPage.loginAndRegistrationFormIsOpened());
        loginAndRegisterPage.fillRegisterForm(email,password,confirmPassword);
        loginAndRegisterPage.clickOnRegisterButton();
        Assert.assertTrue(homePage.registerSuccessMessageIsDisplayed());
    }
}
