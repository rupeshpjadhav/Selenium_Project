package AutomationPracticeProject.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseClassAP {
    WebDriver driver;
    public BaseClassAP(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
