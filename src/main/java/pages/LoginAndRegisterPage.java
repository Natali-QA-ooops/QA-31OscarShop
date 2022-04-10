package pages;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginAndRegisterPage extends PageBase {
    public LoginAndRegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "register_form")
    WebElement registerForm;

    @FindBy(id = "id_login-username")
    WebElement emailField;

    @FindBy(id = "id_login-password")
    WebElement passwordField;

    @FindBy(xpath = "//button[@name='login_submit']")
    WebElement btnLogin;

    @FindBy(id = "register_form")
    WebElement formLogin;

    @FindBy(id = "id_registration-email")
    WebElement regEmail;

    @FindBy(id = "id_registration-password1")
    WebElement regPassw1;

    @FindBy(id = "id_registration-password2")
    WebElement regPassw2;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    WebElement logAllert;

    @FindBy(xpath = "//*[contains(text(),'Oops! We found some errors')]")
    WebElement someErrors;

    public boolean loginAndRegistrationFormIsOpened() {
        return registerForm.isDisplayed();
    }


    public void clickOnRegisterButton() {
        click(driver.findElement(By.cssSelector("[name=\"registration_submit\"]")));
    }

//    public void fillEmail(String email) {
//        should(emailField, 20);
//        type(emailField, email);
//    }
//    public void fillEmail(User user) {
//        inputText(driver.findElement(By.id("id_registration-email")), user.getEmail());
//    }
//    public void fillPass(String password) {
//        should(passwordField, 20);
//        type(passwordField, password);
//    }
//    public void fillPass(User user) {
//        inputText(driver.findElement(By.id("id_registration-password1")), user.getPassword());
//    }
//    public void fillConfirmPassw(String password) {
//        inputText(driver.findElement(By.id("id_registration-password2")), password);
//    }

    public void fillRegisteredForm(User user) {
        inputText(regEmail, user.getEmail());
        inputText(regPassw1, user.getPassword());
        inputText(regPassw2, user.getPassword());
    }

    //    public void fillLoginForm(User user){
//        inputText(emailField, user.getEmail());
//        inputText(passwordField, user.getPassword());
//    }
    public void fillLoginForm(String email, String password) {
        inputText(emailField, email);
        inputText(passwordField, password);
    }

    public void clickBTNLogIn() {
        btnLogin.click();
    }

    public void clickBTNRagister() {
        driver.findElement(By.cssSelector("[name='registration_submit']")).click();
    }

    public boolean loginRegisteredFormIsDisplayed() {
        return registerForm.isDisplayed();
    }


    public boolean loginFormIsDisplayed() {
        return formLogin.isDisplayed();
    }

    public boolean allertIsDisplayed() {
        return logAllert.isDisplayed();
    }

    public boolean massageErrorIsDisplaeyd() {
        return someErrors.isDisplayed();
    }

    //    public void fillEmailField(String email) {
//        inputText(driver.findElement(By.id("id_registration-email")), email);
//    }
//
//    public void fillPasswordField(String password) {
//        inputText(driver.findElement(By.id("id_registration-password1")), password);
//    }
//
//    public void fillConfirmPasswordField(String password) {
//        inputText(driver.findElement(By.id("id_registration-password2")), password);
//    }
    public void fillRegisterForm(String email, String password, String confirmPassword) {
        inputText(regEmail, email);
        inputText(regPassw1, password);
        inputText(regPassw2, password);
    }

    @FindBy(xpath = "//div[@style='visibility: visible;']")
    WebElement massWrongFormat;

    public boolean massageWrongFormatIsDisplayed() {
        return massWrongFormat.isDisplayed();
    }
}
