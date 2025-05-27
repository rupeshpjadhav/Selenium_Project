package TestAutomationPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    WebDriver driver;
    Properties p;

    @BeforeClass
    public void Setup() throws IOException {

        FileReader file=new FileReader("./src//test//resources//config.properties");
        p=new Properties();
        p.load(file);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("url1"));
        driver.manage().window().maximize();


    }

   @AfterClass
    public void TearDown () {
        driver.quit();
    }
}
