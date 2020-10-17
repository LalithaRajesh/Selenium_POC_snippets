package com.company.spiceject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HandlingCalenderUI {

    public static void main(String[] args) throws InterruptedException {

        String currentDir = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", currentDir + "/src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.spicejet.com");
        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='ctl00_mainContent_view_date2']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".ui-datepicker-week-end.ui-datepicker-current-day")).click();
//        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));




    }
}
