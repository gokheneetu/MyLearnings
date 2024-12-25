package com.example.selenium4java17;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.time.Duration;
import java.util.List;

public class AmazonTest {

    WebDriver driver;

    @Test
    public void addtoCart() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("headless");
        driver = new ChromeDriver(chromeOptions);
        String wd = driver.getWindowHandle();

        driver.get("https://www.amazon.in/ref=nav_logo");
//        driver.manage().window().maximize();

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"nav-flyout-searchAjax\"]/div[2]/div[1]/div[1]/div[1]/div/div[1]/span")).click();
        Thread.sleep(1000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        jse.executeScript("window.scrollBy(0,1000)");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("a-autoid-1-announce")).click();
        Thread.sleep(5000);
        System.out.println(driver.findElement(By.xpath("//*[@id=\"nav-cart-count-container\"]")).getText());
        driver.findElement(By.xpath("//*[@id=\"nav-cart-count-container\"]")).click();

        System.out.println(new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By
                        .xpath("/html/body/div[1]/div[1]/div[3]/div[5]/div/div[2]/div[1]/div/form/div[2]/div[3]/div[4]/div/div[2]/ul/li/span/a/span[1]/h4/span/span[2]")))
                .getText());
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"nav-logo\"]")).click();

    }

    @Test
    public void checkEle(){
        driver.get("https://www.amazon.in/ref=nav_logo");
        driver.manage().window().maximize();
        String wd = driver.getWindowHandle();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> ll = driver.findElements(By.xpath("//*[@id=\"nav-flyout-searchAjax\"]/div[2]/div[1]/div[1]/div/div[1]/div[1]/span"));
        System.out.println(ll.size());
        for (int i = 0; i < ll.size(); i++) {
//            WebElement ele = driver.findElement(By.xpath(ll.get(i)+"/div/div[1]/span"));
//            String iphoneName = ele.getText();
            System.out.println(ll.get(i).getText());
            if(ll.get(i).getText().equals("15 128gb")){
                driver.findElement(By.xpath(String.valueOf(ll.get(i)))).click();
            }
        }
    }

    @AfterClass
    public void CloseTest(){
        driver.quit();
    }
}


