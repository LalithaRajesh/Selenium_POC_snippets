package com.company.spiceject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class E2ESpiceJetAutomation {

    public static void main(String[] args) throws InterruptedException {

        String currentDir = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", currentDir + "/src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.spicejet.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='ctl00_mainContent_ddl_originStation1']")).click();
        driver.findElement(By.xpath("//*[@value='MAA']")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id='ctl00_mainContent_ddl_destinationStation1']")).click();
        driver.findElement(By.xpath("(//*[@value='DEL'])[2]")).click();
        Thread.sleep(4000);
        driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='ctl00_mainContent_view_date2']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".ui-datepicker-week-end.ui-datepicker-current-day")).click();
        Thread.sleep(4000);
        driver.findElement(By.id("divpaxinfo")).click();
        Select s = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
        s.selectByValue("3");
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")).click();
        Select s1 = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
        s1.selectByValue("GBP");
        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

    }
}
