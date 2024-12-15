package com.example.selenium4java17;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class SelectDemo {

    ChromeDriver driver = new ChromeDriver();

    @Test(priority = 0)
    public void selectTest() throws InterruptedException {
        driver.get("https://semantic-ui.com/modules/dropdown.html");
        driver.manage().window().maximize();

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeAsyncScript("window.scrollBy(0,1500)");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
        driver.findElement(By.xpath("//*[@class='ui dropdown']")).click();
        Thread.sleep(3000);
//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
//        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='menu transition visible']")));
//        ele.click();
        driver.findElement(By.xpath("//*[@id=\"example\"]/div[4]/div/div[2]/div[4]/div[1]/div[2]/div/div[2]/div[1]']")).click();

    }
}
