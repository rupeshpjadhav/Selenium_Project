//package webdriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FirstExample {




    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        String act_title = driver.getTitle();
        String WinId = driver.getWindowHandle();
        System.out.println(WinId);
        System.out.println(act_title);

        if (act_title.equals ("Automation Testing Practice"))
        {
            System.out.println("Test Passed");
        }
        else
        {
            System.out.println("Test Failed");
        }

        driver.close();
    }

}


