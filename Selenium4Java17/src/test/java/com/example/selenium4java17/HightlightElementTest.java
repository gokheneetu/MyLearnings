package com.example.selenium4java17;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class HightlightElementTest {

    WebDriver driver = new ChromeDriver();

    @Test
    public void highLightElement(){
        driver.manage().window().maximize();
//        driver.get("https://www.youtube.com/watch?v=mVIWw59tj84&t=934s");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        WebElement ele = driver.findElement(By.xpath("//*[div[@id='above-the-fold']]/div/div[1]"));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("arguments[0].setAttribute('sytle','background:green');",ele);


        driver.get("https://www.gmail.com");
//Collecting the webelement
        WebElement ele = driver.findElement(By.id("identifierId"));
//Calling the highlighter method
        highLighterMethod(driver, ele);
        ele.sendKeys("demo@gmail.com");
    }
    //Creating my own method
    public void highLighterMethod(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: green; border: 3px solid blue;');", element);
    }

}
