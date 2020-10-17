package com.company.spiceject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

    public static void main(String[] args) {

        String currentDir = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", currentDir + "/src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.spicejet.com");
        driver.findElement(By.id("divpaxinfo")).click();

        // For Choosing the number of adults:
        Select s = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
        s.selectByValue("3");
        // The below also can be selected instead of the above
        // s.selectByIndex(2);
        // s.selectByVisibleText("3");
    }
}
