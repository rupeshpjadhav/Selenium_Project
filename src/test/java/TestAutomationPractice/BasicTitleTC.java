package TestAutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicTitleTC extends BaseTest {


    @Test
    public void basicTitleTest () {
        String title = driver.findElement(By.cssSelector("h1[class='title']")).getText();

        if (title.equals("Automation Testing Practice")) {
            System.out.println("Test Passed");
        }
        else {
            System.out.println("Test Failed");
        }

    }

    @Test
    public void webpageTitleTest () {
        String webPageTitle = driver.getTitle();
        System.out.println(webPageTitle);
        Assert.assertEquals(webPageTitle,"Automation Testing Practice", "Invalid Title");


    }

    ////button[starts-with(@name,'st')]

    @Test
    public void testDynamicText() {

        WebElement str = driver.findElement(By.xpath("//button[starts-with(@name,'st')]"));
        System.out.println(str.getText());
        Assert.assertEquals(str.getText(),"START");
        str.click();
        System.out.println(str.getText());
        Assert.assertEquals(str.getText(),"STOP");
        str.click();
        System.out.println(str.getText());
        Assert.assertEquals(str.getText(),"START");

    }







}
