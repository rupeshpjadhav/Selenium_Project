package AutomationPracticeProject.TestCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class BaseTestAP {

        WebDriver driver;
        Properties p;


        @BeforeClass
        @Parameters({"os","browser"})
        public void Setup(String os, String browser) throws IOException {
            //Loading config.properties file
            FileReader file=new FileReader("./src//test//resources//config.properties");
            p=new Properties();
            p.load(file);

            switch (browser.toLowerCase())
            {
                case "chrome" : driver = new ChromeDriver(); break;
                case "edge" : driver = new EdgeDriver(); break;
                case "firefox" : driver = new FirefoxDriver(); break;
                default :
                    System.out.println("Invalid browser"); return;
            }


            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get(p.getProperty("url2"));
            driver.manage().window().maximize();
        }

        @AfterClass
        public void TearDown () {
            driver.quit();
        }


    public String randomString(int count)
    {
        return RandomStringUtils.randomAlphabetic(count);
    }

    public int randomNumber(int count)
    {
        Random r = new Random();
        return (r.nextInt(count)+1);

    }


    public String randomAlphaNumberic(int alpha_cnt, int numeric_cnt)
    {
        String generatedstring=RandomStringUtils.randomAlphabetic(alpha_cnt);
        String generatednumber=RandomStringUtils.randomNumeric(numeric_cnt);
        return (generatedstring+"@"+generatednumber);
    }


    public String captureScreen(String tname) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile=new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;

    }

    }


