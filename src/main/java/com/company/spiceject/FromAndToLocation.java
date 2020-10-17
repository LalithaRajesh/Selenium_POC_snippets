package com.company.spiceject;

//Handling Dynamic Dropdown
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FromAndToLocation {

    public static void main(String[] args) throws InterruptedException {
        String currentDir = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", currentDir + "/src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.spicejet.com");
        driver.findElement(By.xpath("//*[@id='ctl00_mainContent_ddl_originStation1']")).click();
        driver.findElement(By.xpath("//*[@value='MAA']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='ctl00_mainContent_ddl_destinationStation1']")).click();
        driver.findElement(By.xpath("(//*[@value='DEL'])[2]")).click();
    }
}
