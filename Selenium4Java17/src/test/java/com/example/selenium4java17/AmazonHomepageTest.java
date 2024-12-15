package com.example.selenium4java17;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class AmazonHomepageTest {
    static WebDriver driver = null;

    @BeforeClass
    public static void getDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-notifications");
        options.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(options);
    }

    @Test
    public void openBrowser() {
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test(dependsOnMethods = {"openBrowser"}, priority = 1)
    public void homePageTest() {
        driver.findElement(By.linkText("Mobiles")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List<WebElement> liEle = driver.findElements(By.xpath("//*[@id=\"s-refinements\"]/div[4]/ul/li"));
        for (WebElement el : liEle) {
            String brandName = el.getText();
            if (brandName.equals("iQOO")) {
                el.click();
                break;
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List<WebElement> brandList = driver.findElements(By.xpath("//*[starts-with(text(),'iQOO')]"));
        System.out.println(brandList.size());
    }

    @Test(priority = 2)
    public void selectLocationTest() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='nav-global-location-slot']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.switchTo().activeElement();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("GLUXZipUpdateInput")).sendKeys("560103");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("GLUXZipUpdate")).click();

        Select sc = new Select(driver.findElement(By.id("quantity-selector")));
    }

    @AfterClass
    public static void close() {
        if (driver != null) {
            driver.close();
        }
    }
}
