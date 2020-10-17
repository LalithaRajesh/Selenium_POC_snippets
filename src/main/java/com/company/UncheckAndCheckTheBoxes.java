package com.company;

//how to check and uncheck a checkbox

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UncheckAndCheckTheBoxes {


    public static void main(String[] args) throws InterruptedException {
        String currentDir = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", currentDir + "/src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //To check the checkbox
        driver.findElement(By.id("checkBoxOption1")).click();
        System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
        Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
        //to uncheck the checkbox
        driver.findElement(By.id("checkBoxOption1")).click();
        System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
        Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
        //To count the number of check boxes
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

    }
}
