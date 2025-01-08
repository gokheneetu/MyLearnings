package org.ng.base;

import org.ng.utils.Browsers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static org.ng.utils.Browsers.CHROME;
import static org.ng.utils.Browsers.FIREFOX;

public class DriverProvider {
    Logger log = Logger.getLogger(DriverProvider.class.getName());

    public static WebDriver driver;
    public static Properties prop;

    public DriverProvider() {
        FileInputStream fis = null;
        prop = new Properties();
        try {
            fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/browser.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            prop.load(fis);
        } catch (IOException e) {

        }
    }

    public static void initialization() {

        String browser = prop.getProperty("browser");
        switch (Browsers.valueOf(browser)) {
            case CHROME:
//                System.setProperty("webdriver.chrome.driver", "/Users/neetu.gokhe/Downloads/chromedriver");
                driver = new ChromeDriver(chromeBrowserOptions());
                setupDriverCapabilities();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + browser);
        }

    }

    private static void setupDriverCapabilities() {
        if (driver != null) {
            driver.manage().window().maximize();
            driver.get(prop.getProperty("url"));
            driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
            driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
//            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("container"))));
        }
    }

    public static ChromeOptions chromeBrowserOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("enable-automation");
//        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions");
        options.addArguments("--dns-prefetch-disable");
        options.addArguments("--disable-gpu");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        return options;
    }
}
