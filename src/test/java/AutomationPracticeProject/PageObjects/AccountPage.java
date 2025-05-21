package AutomationPracticeProject.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage extends BaseClassAP{
    public AccountPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//p[@class='alert alert-success']")
    WebElement AccountSuccessMsg;

    @FindBy(xpath = "//h1[normalize-space()='My account']")
    WebElement AccountPageVisible;

    //Welcome to your account. Here you can manage all of your personal information and orders.

    @FindBy(xpath="//p[@class='info-account']")
    WebElement NewAccountMessage;


    @FindBy(xpath="//a[@title='Log me out']")
    WebElement SignOutOption;


    public String AccountSuccessMessage () {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(AccountSuccessMsg));
        return AccountSuccessMsg.getText();
    }

    public boolean IsAccountPageVisible () {
       return AccountPageVisible.isDisplayed();
    }

    public String AccountCreatedMessage () {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(NewAccountMessage));
        return NewAccountMessage.getText();
    }


    public void ClickSignOut () {
        SignOutOption.click();
    }
}
