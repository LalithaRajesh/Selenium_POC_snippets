package com.company;

//CSS and Xpath understandings
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class rediff {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String currentDir =System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", currentDir + "/src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://rediff.com");
        driver.findElement(By.cssSelector("a[title*='Sign in']")).click();
        driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("hello");
        driver.findElement(By.cssSelector("input#password")).sendKeys("goodbye");
        driver.findElement(By.xpath("//input[contains(@name,'procee')]")).click();

    }

}
