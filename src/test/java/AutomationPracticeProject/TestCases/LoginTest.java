package AutomationPracticeProject.TestCases;

import AutomationPracticeProject.PageObjects.AccountPage;
import AutomationPracticeProject.PageObjects.HomePage;
import AutomationPracticeProject.PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTestAP{


    @Test(groups={"Sanity","Master"})
    public void TestLoginPage () {

        logger.info("========== Starting Test ----> TestLoginPage ===============");
        // Home page
        HomePage hp = new HomePage(driver);
        hp.ClickSignInBtn();

        String email = p.getProperty("email");
        String password = p.getProperty("password");
        // Login Page

        LoginPage lp = new LoginPage(driver);
        lp.EnterEmailAddress(email);
        lp.EnterPassword(password);
        logger.info("Entered username as "+email+" and password as "+password);
        lp.ClickSignInButton();


        //Account Page

        AccountPage ap = new AccountPage(driver);
        Assert.assertTrue(ap.IsAccountPageVisible(), "Account not created");
        logger.info("Signed in successfully from the login page");

        ap.ClickSignOut();
        logger.info("Logged Out Successfully");

        logger.info("========== Test -> TestLoginPage Ended ===============");

    }


}
