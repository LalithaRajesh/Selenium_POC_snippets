package com.company.spiceject;

//How to use Assertions
//TestNG is one of the testing framework

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assertions {

    public static void main(String[] args) throws InterruptedException {

        String currentDir = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", currentDir + "/src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.spicejet.com");

        driver.findElement(By.id("divpaxinfo")).click();
        // For Choosing the number of adults:
        Select s = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
        s.selectByValue("3");
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        Thread.sleep(3000);

        //To check if the method has selected the check box or not (using assertFalse)
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

        //To check if the method has selected the check box using Assert True
        //System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

        //To count the check boxes
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

        for(int i =0; i<6; i++){
            Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"3 Adult");
        }

    }
}
