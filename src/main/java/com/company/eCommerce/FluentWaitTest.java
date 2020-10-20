package com.company.eCommerce;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class FluentWaitTest {

    public static void main(String[] args) {

        String currentDir = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", currentDir + "/src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//*[@id='start']/button")).click();
//        driver.findElement(By.cssSelector("[id='start'] button")); -- >Alternative to the above step

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);
        WebElement waitMethod = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                if (driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed()){
                    return driver.findElement(By.cssSelector("[id='finish'] h4"));
                }
                else {
                    return null;
                }
            }
        });
        //The below step returns false although the web element was found on the first step on the HTML but not on the visible mode.
        //ie.. element is present on the page. Until the element is clickable, it will return false
        System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed());

    }
}


