package AutomationPracticeProject.TestCases;

import AutomationPracticeProject.PageObjects.AccountPage;
import AutomationPracticeProject.PageObjects.HomePage;
import AutomationPracticeProject.PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DataProviders;

public class LoginTestDDT extends BaseTestAP{

    @Test(dataProvider="LoginData",dataProviderClass= DataProviders.class)
    public void Test_LoginDDT (String email, String password, String Status, String message) {
        logger.info("========== Starting Test -> Test_LoginDDT ===============");
        // Home page
        HomePage hp = new HomePage(driver);
        hp.ClickSignInBtn();

        // Login Page

        LoginPage lp = new LoginPage(driver);
        lp.EnterEmailAddress(email);
        lp.EnterPassword(password);
        lp.ClickSignInButton();

        logger.info("Entered username as "+email+" and password as "+password);

        //Account Page

        if(Status.equals("Valid")) {
            AccountPage ap = new AccountPage(driver);
            Assert.assertEquals(ap.AccountCreatedMessage().startsWith(message),true,"Test Failed");
            Assert.assertEquals(ap.IsAccountPageVisible(), true, "Account not created");
            System.out.println("Test Case Passed as expected for valid credentials");
            logger.info("Signed in successfully from the login page");
            ap.ClickSignOut();
            logger.info("Logged Out Successfully");

        }
        else if (Status.equals("Invalid Password")) {
            Assert.assertEquals(lp.ReturnPasswordMissingErrorMessage(),message,"Test Failed");
            System.out.println("Test Case Passed as expected for invalid password");
            logger.info("Showed following message for password => "+lp.ReturnPasswordMissingErrorMessage());

        }
        else if (Status.equals("Invalid Email")) {
            Assert.assertEquals(lp.ReturnEmailMissingErrorMessage(),message,"Test Failed");
            System.out.println("Test Case Passed as expected for invalid email");
            logger.info("Showed following message for email => "+lp.ReturnEmailMissingErrorMessage());

        }
        else if (Status.equals("Invalid")) {
            Assert.assertEquals(lp.ReturnAuthFailedErrorMessage(),message, "Test Failed");
            System.out.println("Test Case Passed as expected for invalid credentials");
            logger.info("Showed following message for authentication => "+lp.ReturnAuthFailedErrorMessage());

        }

        logger.info("========== Test -> Test_LoginDDT Ended ===============");

    }

}


