package AutomationPracticeProject.TestCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class  BaseTestAP {

        public WebDriver driver;
        Properties p; // Properties file

        Logger logger; // Log4j


        @BeforeClass
        @Parameters({"os","browser"})
        public void Setup(String os, String browser) throws IOException {
            //Loading config.properties file
            FileReader file=new FileReader("./src//test//resources//config.properties");
            p=new Properties();
            p.load(file);

            logger = LogManager.getLogger(this.getClass()); // log4j

            if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {

                DesiredCapabilities capabilities = new DesiredCapabilities();

                if(os.equalsIgnoreCase("windows")) {
                    capabilities.setPlatform(Platform.WIN10);
                    System.out.println("Running tests on Windows OS");
                }

                else if (os.equalsIgnoreCase("mac")) {
                    capabilities.setPlatform(Platform.MAC);
                    System.out.println("Running tests on Mac OS");

                }
                else if (os.equalsIgnoreCase("linux")) {
                    capabilities.setPlatform(Platform.LINUX);
                    System.out.println("Running tests on Linux OS");
                }

                else {
                    System.out.println("Invalid OS given");
                    return;
                }

                switch (browser.toLowerCase()) {
                    case "chrome": capabilities.setBrowserName("chrome");
                        System.out.println("Running tests on Chrome browser"); break;
                    case "edge": capabilities.setBrowserName("MicrosoftEdge");
                        System.out.println("Running tests on Edge browser"); break;
                    case "firefox" : capabilities.setBrowserName("firefox");
                        System.out.println("Running tests on Firefox browser"); break;
                    default:
                        System.out.println("Invalid browser"); return;
                }

                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);

            }

            if (p.getProperty("execution_env").equalsIgnoreCase("local")) {
                switch (browser.toLowerCase())
                {
                    case "chrome" : driver = new ChromeDriver();
                        System.out.println("Running tests on Chrome browser");break;
                    case "edge" : driver = new EdgeDriver();
                        System.out.println("Running tests on Edge browser"); break;
                    case "firefox" : driver = new FirefoxDriver();
                        System.out.println("Running tests on Firefox browser"); break;
                    default :
                        System.out.println("Invalid browser"); return;
                }
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get(p.getProperty("url2"));
            driver.manage().window().maximize();

            logger.info("Driver for "+browser+" is initialized and launched");
        }

        @AfterClass
        public void TearDown () {
            driver.quit();
            logger.info("Driver is closed");
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


    public String captureScreen(String tname, WebDriver driver) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile=new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;

    }

    }


