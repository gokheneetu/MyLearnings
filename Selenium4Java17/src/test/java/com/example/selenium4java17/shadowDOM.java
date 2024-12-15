//package com.example.selenium4java17;
//
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.IRetryAnalyzer;
//import org.testng.ITestResult;
//import org.testng.annotations.Test;
//
//import java.util.Iterator;
//import java.util.Set;
//
//import static jdk.internal.org.jline.reader.impl.LineReaderImpl.CompletionType.List;
//
//public class shadowDOM {
//
//    WebDriver driver = new ChromeDriver();
//
//    @Test(retryAnalyzer = IRetryAnalyzer.class)
//    public void shadowTest() throws InterruptedException {
//        driver.manage().window().maximize();
//        driver.manage().deleteAllCookies();
//        driver.get("https://www.htmlelements.com/demos/menu/shadow-dom/index.htm");
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        WebElement  webElement = (WebElement) js.executeAsyncScript("return ");
//        JavascriptExecutor js1 = (JavascriptExecutor) driver;
//        js1.executeAsyncScript("arguments[0].click()", webElement);
//
//
//        Set<String> wins = driver.getWindowHandles();
//        Iterator<String> iterator = wins.iterator();
//        while (iterator.hasNext()) {
//
//            driver.switchTo().window(iterator.next());
//        }
//    }
//
//
//
//}
