package org.ng.extraTest;

import org.ng.base.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static java.awt.SystemColor.window;

public class SelectDemo extends DriverProvider {
    WebDriverWait driverWait;

    @BeforeClass
    public void init() {
        initialization();
        driverWait = new WebDriverWait(driver, Duration.ofMillis(1000));
    }

    @Test(priority = 1)
    public void selectTest() {
        driver.findElement(By.xpath("//button[@class='select_SelectTrigger__zgqgS']")).click();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='radix-:r1:']//div[@role='option']")));
        List<WebElement> ele = driver.findElements(By.xpath("//div[@id='radix-:r1:']//div[@role='option']"));
        for (WebElement e : ele) {
            System.out.println(e.getText());
            if (e.getText().equals("Easiest")) {
                e.click();
                break;
            }
        }
    }

    @Test(priority = 2)
    public void selectTest1() throws InterruptedException {
        boolean checkElement = driver.findElement(By.xpath("//input[@placeholder='Search job titles']")).isEnabled();
        if (checkElement) {
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("suggestions down")));
            List<WebElement> searchList = driver.findElements(By.className("suggestions down"));
            System.out.println(searchList.size());
        } else System.out.println(" element not interactable");
        Thread.sleep(1000);
        boolean CompanySearch = driver.findElement(By.id("CompanySearch")).isEnabled();
        if (CompanySearch) {
            driver.findElement(By.id("CompanySearch")).sendKeys("tc");
            Thread.sleep(1000);
            WebElement menuItem = driver.findElement(By.xpath("//ul[@class='unknown-user-cta_dropdownOptions__KJlk3']/li[7]/button/span[contains(text(),'Hatch Ltd.')]"));
            Actions action = new Actions(driver);
            action.scrollToElement(menuItem).perform();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//ul[@class='unknown-user-cta_dropdownOptions__KJlk3']/li[7]/button/span[contains(text(),'Hatch Ltd.')]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@class='CloseButton']")).click();
            driver.findElement(By.xpath("//*[@class='CloseButton']")).click();
        }

    }

    @Test(priority = 3)
    public void GoogleSearch() {
        driver.findElement(By.xpath("//div/textarea[@title='Search']")).sendKeys("selenium");
        List<WebElement> elementList = driver.findElements(By.xpath("//div[@id='Alh6id']//li"));
        System.out.println(elementList.size());
        for (WebElement ele : elementList) {
            if (ele.getText().contains("webdriver")) {
                ele.click();
                break;
            }
        }
    }

    @Test(priority = 4)
    public void amazonSearch() {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptop");
        List<WebElement> searchlist = driver.findElements(By.xpath("//div[@id='sac-autocomplete-results-container']//div[@role='row']"));
        for (WebElement ele : searchlist) {
            if (ele.getText().contains("legos for boys age 8-12")) {
                ele.click();
                break;
            }
        }
    }

    @Test(priority = 5)
    public void flipkartSearch() throws InterruptedException {
        String home = driver.getCurrentUrl();
        driver.findElement(By.name("q")).sendKeys("iphone");
        driver.findElement(By.xpath("//*[@id='container']//button[@type='submit']")).click();
//        List<WebElement> ll = driver.findElements(By.xpath("//form[@action='/search']/ul/li"));
//        ll.stream().filter(l -> l.getText().contains("15")).findFirst().ifPresent(WebElement::click);
//        ll.stream().map(WebElement::getText).distinct().collect(Collectors.toList());
//        ll.stream().map(l->l.findElement(By.xpath("")).getText().contains("")).collect(Collectors.toList());
//        ll.stream().allMatch(l->l.getText().contains("flipkart"));

//        List<String> allListHref = ll.stream().filter(l->l.getText().contains("href")).map(WebElement::getText).collect(Collectors.toList());
//        for(WebElement ele:ll){
//            if(ele.getText().contains("15")){
//                System.out.println(ele.getText());
//                ele.click();
//                break;
//            }
//        }
        Actions actions = new Actions(driver);
        new WebDriverWait(driver, Duration.ofMillis(6000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='container']//div[@class='cPHDOP col-12-12'][15]")));
        WebElement ele = driver.findElement(By.xpath("//*[@id='container']//div[@class='cPHDOP col-12-12'][15]"));
        actions.scrollToElement(ele);
        actions.perform();
        ele.click();


        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        WebElement addToCartButton = new WebDriverWait(driver,Duration.ofMillis(2000))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Add to cart')]")));
        addToCartButton.click();

    }

    @AfterClass
    public void closeSession() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (driver != null) driver.quit();
    }

}
