package AutomationPracticeProject.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseClassAP {
    WebDriver driver;
    WebDriverWait myWait;

    public BaseClassAP(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);

        myWait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

}
