package com.company;

//Understanding the usage of getText()
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Salesforce {

    public static void main(String[] args) {

        String currentDir =System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", currentDir + "/src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://login.salesforce.com");
        driver.findElement(By.id("username")).sendKeys("My salesforce");
        driver.findElement(By.id("password")).sendKeys("12345");
//        driver.findElement(By.name("Login")).click();
        driver.findElement(By.xpath("//button[@id='Login']")).click();
        //usage of getText()
        System.out.println(driver.findElement(By.cssSelector("div#error.loginError")).getText());
    }


}
