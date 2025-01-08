package org.ng;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ScrollAndStitchScreenshot {
    public static void main(String[] args) throws Exception {
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.flipkart.com/");
            driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(100));
            driver.manage().window().maximize();


            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Get total height of the page
            Long totalHeight = (Long) js.executeScript("return document.documentElement.scrollHeight");
            Long viewportHeight = (Long) js.executeScript("return window.innerHeight");
            Long scrollPosition = 0L;

            List<File> screenshots = new ArrayList<>();

            while (scrollPosition < totalHeight) {
                // Take screenshot
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                screenshots.add(screenshot);

                // Scroll down
                scrollPosition += viewportHeight;
                js.executeScript("window.scrollTo(0, arguments[0]);", scrollPosition);
                Thread.sleep(5000); // Wait for scrolling to finish
            }

            // Combine screenshots using an external library (e.g., ImageMagick or OpenCV)

        } finally {
            driver.quit();
        }
    }
}
