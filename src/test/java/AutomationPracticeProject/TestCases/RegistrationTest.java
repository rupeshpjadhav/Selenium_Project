package AutomationPracticeProject.TestCases;

import AutomationPracticeProject.PageObjects.AccountPage;
import AutomationPracticeProject.PageObjects.HomePage;
import AutomationPracticeProject.PageObjects.LoginPage;
import AutomationPracticeProject.PageObjects.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v134.fedcm.model.AccountUrlType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTestAP {

    @Test
    public void TestRegistration () throws InterruptedException {
        //homepage
        HomePage hp = new HomePage(driver);
        hp.ClickSignInBtn();

        // login page

        String newEmailAddress = randomString(6)+randomNumber(3)+"@gmail.com";
        System.out.println(newEmailAddress);
        LoginPage lp = new LoginPage(driver);
        lp.EnterEmailAddressNewAcc(newEmailAddress);
        lp.CreateAccountButton();

        //Registration page
        RegistrationPage rp = new RegistrationPage(driver);
        //Thread.sleep(5000);

        rp.SelectMaleRadioButton();
        rp.EnterFirstNameText(randomString(7));
        rp.EnterLastNameText(randomString(5));
        rp.EnterEmailField();
        System.out.println("Actual is "+rp.EnterEmailField());
        Assert.assertEquals(rp.EnterEmailField(),newEmailAddress,"Improper Email given");
        String password = randomAlphaNumberic(7,5);
        rp.EnterPasswordField(password);
        System.out.println("Password is "+password);
        rp.SelectDaysDropDownButton(randomNumber(28));
        rp.SelectMonthDropDownButton(randomNumber(11));
        rp.SelectYearDropDownButton("2024");
        rp.ClickRegisterButton();

        // Account page
        AccountPage ap = new AccountPage(driver);
        System.out.println(ap.AccountSuccessMessage());
        Assert.assertEquals(ap.AccountSuccessMessage(),"Your account has been created.","Account not created");






    }


}
