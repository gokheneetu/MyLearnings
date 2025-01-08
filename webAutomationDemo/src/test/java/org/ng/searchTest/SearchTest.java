package org.ng.searchTest;

import org.ng.base.DriverProvider;
import org.ng.pages.search.SearchPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.ng.base.DriverProvider.initialization;
import static org.testng.Assert.assertTrue;

public class SearchTest extends DriverProvider {
    SearchPage searchPage;

    @BeforeMethod
    public void init(){
        initialization();
        searchPage = new SearchPage();
    }

    @Test
    public void checkSearchField(){
       assertTrue(searchPage.verifySearchField());

    }
}
