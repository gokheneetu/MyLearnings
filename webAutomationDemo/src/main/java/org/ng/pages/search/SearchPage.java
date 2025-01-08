package org.ng.pages.search;

import org.ng.base.DriverProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertTrue;

public class SearchPage extends DriverProvider {
    @FindBy(name = "q")
    WebElement searchField;

    @FindBy(id="")
    WebElement searchButton;

    public SearchPage(){
        PageFactory.initElements(driver,this);
    }

    public boolean verifySearchField(){
       if(searchField.isDisplayed()) {
           return true;
       }
       return false;
    }
}
