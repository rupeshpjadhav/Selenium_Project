package AutomationPracticeProject.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage extends BaseClassAP {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//input[@id='id_gender1']")
    WebElement SelectMaleRadioBtn ;

    @FindBy (xpath = "//input[@id='id_gender2']")
    WebElement SelectFemaleRadioBtn ;


    @FindBy(xpath = "//input[@id='customer_firstname']")
    WebElement EnterFirstNameTxtField;

    @FindBy(xpath = "//input[@id='customer_lastname']")
    WebElement EnterLastNameTxtField;

    @FindBy(xpath = "//input[@id='email']")
    WebElement EnterEmailField;

    @FindBy(xpath = "//input[@id='passwd']")
    WebElement EnterPasswordField;

    @FindBy(xpath = "//select[@id='days']")
    WebElement SelectDaysDropdown;

    @FindBy(xpath = "//select[@id='years']")
    WebElement SelectYearDropdown;

    @FindBy(xpath = "//select[@id='months']")
    WebElement SelectMonthDropdown;

    @FindBy (xpath = "//span[normalize-space()='Register']")
    WebElement ClickRegisterBtn;


    public void SelectMaleRadioButton () {
        SelectMaleRadioBtn.click();
    }


    public void SelectFemaleRadioButton () {
        SelectFemaleRadioBtn.click();
    }

    public void EnterFirstNameText (String fname) {
        EnterFirstNameTxtField.sendKeys(fname);
    }

    public void EnterLastNameText (String lname) {
        EnterLastNameTxtField.sendKeys(lname);
    }

//    public String EnterEmailField () {
//        EnterEmailField.click();
//        return EnterEmailField.getAttribute("value");
//    }


    public String EnterEmailField() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(EnterEmailField));
        return EnterEmailField.getDomAttribute("value");
    }

    public void EnterPasswordField(String password) {
        EnterPasswordField.sendKeys(password);
    }

    public void SelectDaysDropDownButton (int days) {
        //SelectDaysDropdown.click();

        Select s = new Select(SelectDaysDropdown);
        s.selectByValue(String.valueOf(days));

    }

    public void SelectMonthDropDownButton (int month) {
        Select s = new Select(SelectMonthDropdown);
        s.selectByValue(String.valueOf(month));
    }

    public void SelectYearDropDownButton (String year) {
        Select s = new Select(SelectYearDropdown);
        s.selectByValue(year);

    }

    public void ClickRegisterButton () {
        ClickRegisterBtn.click();
    }


}
