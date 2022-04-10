package tests.product;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import tests.TestBase;

public class SearchTests extends TestBase {
    HomePage homePage;

    @BeforeMethod
    public void initTest() {
        homePage = PageFactory.initElements(driver, HomePage.class);
    }


    @Test   //  Unauthorized user can search for a product on the main page existing product
    public void searchProductMainPageSuccess() {
        homePage.fillFieldSearch("Java");
        homePage.clickBTNsearch();
        Assert.assertTrue(homePage.searchResultTextIsDisplayed());
    }

    @Test   //Unauthorized user can search for a product on the main page not an existing product
    public void searchProductMainPageNegative(){
        homePage.fillFieldSearch("War and Peace]");
        homePage.clickBTNsearch();
        Assert.assertTrue(homePage.formResultIsDisplayed());
    }

}
