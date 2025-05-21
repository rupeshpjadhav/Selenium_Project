package AutomationPracticeProject.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BaseClassAP{
    public LoginPage(WebDriver driver) {
        super(driver);
    }



    @FindBy(xpath = "//input[@id='email_create']")
    WebElement EnterEmailAddressTextFieldNewAcc;

    @FindBy(xpath = "//span[normalize-space()='Create an account']")
    WebElement CreateAnAccountBtn;


    @FindBy (xpath = "//input[@id='email']")
    WebElement EnterEmailAddressTextField;

    @FindBy (xpath = "//input[@id='passwd']")
    WebElement EnterPasswordTextField;


    @FindBy (xpath = "//span[normalize-space()='Sign in']")
    WebElement SingInBtn;

// Error messages
    @FindBy(xpath = "//li[normalize-space()='Authentication failed.']")
    WebElement AuthFailedErrMessage;

    @FindBy(xpath = "//li[normalize-space()='An email address required.']")
    WebElement EmailMissingErrMessage;


    @FindBy(xpath = "//li[normalize-space()='Password is required.']")
    WebElement PasswordMissingErrMessage;




    public void EnterEmailAddressNewAcc (String NewEmailAddress) {
        EnterEmailAddressTextFieldNewAcc.sendKeys(NewEmailAddress);
    }


    public void CreateAccountButton () {
        CreateAnAccountBtn.click();
    }

    public void EnterEmailAddress (String emailAddress) {

        EnterEmailAddressTextField.sendKeys(emailAddress);

    }


    public void EnterPassword (String password) {

        EnterPasswordTextField.sendKeys(password);

    }

    public void ClickSignInButton () {
        SingInBtn.click();
    }

    public String ReturnAuthFailedErrorMessage () {
        //return AuthFailedErrMessage.getText();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(AuthFailedErrMessage));
        return AuthFailedErrMessage.getText();
    }



    public String ReturnEmailMissingErrorMessage () {
        //return AuthFailedErrMessage.getText();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(EmailMissingErrMessage));
        return EmailMissingErrMessage.getText();
    }


    public String ReturnPasswordMissingErrorMessage () {
        //return AuthFailedErrMessage.getText();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(PasswordMissingErrMessage));
        return PasswordMissingErrMessage.getText();
    }






}
