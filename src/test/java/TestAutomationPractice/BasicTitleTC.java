package TestAutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

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


    @Test
    public void TestGuiElements1 () {

        driver.findElement(By.xpath("//input[@id='name']")).clear();
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Rupesh Jadhav");
        driver.findElement(By.xpath("//input[@id='email']")).clear();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abc@gmail.com");
        driver.findElement(By.xpath("//input[@id='phone']")).clear();
        driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("123345567889");
        driver.findElement(By.xpath("//textarea[@id='textarea']")).clear();
        driver.findElement(By.xpath("//textarea[@id='textarea']")).sendKeys("Bld A, b town, Pune");

        driver.findElement(By.xpath("//label[normalize-space()='Male']")).click();

        JavascriptExecutor js = (JavascriptExecutor)driver;

        WebElement daysOption = driver.findElement(By.xpath("//label[normalize-space()='Days:']"));
        js.executeScript("arguments[0].scrollIntoView();",daysOption);

        List<WebElement> checkboxes = driver.findElements(By.xpath("//div[@id='post-body-1307673142697428135']/div[4]//div"));

        for (WebElement checkbox:checkboxes) {
            checkbox.click();
            if ((checkbox.getText()).equals("Friday") || (checkbox.getText()).equals("Saturday")) {
                checkbox.click();
            }
        }
        driver.findElement(By.xpath("//label[normalize-space()='Thursday']")).click();
        driver.findElement(By.xpath("//label[normalize-space()='Monday']")).click();

        WebElement countryOption = driver.findElement(By.xpath("//label[normalize-space()='Country:']"));
        js.executeScript("arguments[0].scrollIntoView();",countryOption);
        WebElement countryList= driver.findElement(By.xpath("//select[@id='country']"));

        Select country = new Select(countryList);
        country.selectByVisibleText("India");

        WebElement colorOption = driver.findElement(By.xpath("//label[normalize-space()='Colors:']"));
        js.executeScript("arguments[0].scrollIntoView();",colorOption);

        WebElement color_list = driver.findElement(By.xpath("//select[@id='colors']"));

        Select colors = new Select(color_list);
        colors.selectByValue("yellow");

        WebElement sortOption = driver.findElement(By.xpath("//label[normalize-space()='Sorted List:']"));
        js.executeScript("arguments[0].scrollIntoView();",sortOption);

        WebElement sorted_list = driver.findElement(By.xpath("//select[@id='animals']"));

        Select sorted = new Select(sorted_list);
        sorted.selectByValue("lion");


    }







}
