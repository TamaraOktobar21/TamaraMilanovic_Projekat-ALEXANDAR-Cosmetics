package Tests;

import Pages.SearchPage;
import Pages.ShoppingPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest{
    /**
     * Searching Without Searching Credetials
     * Steps:
     * 1. Click on a search field
     * 2. Click on a Search Submitt Button
     *
     * Expectected result: Search result will be shown by relevance with URL:"https://www.alexandar-cosmetics.com/pretraga?term="
     */

    @Test
    public void SearchingWhithoutCredentials(){
        WebDriver driver = openChromeDriver();
        try{
            SearchPage searchPage=new SearchPage(driver);
            searchPage.ClickingOnSearchField();
            searchPage.ClickingOnSearchSubmittButton();
            searchPage.testArrayList();
            searchPage.AssertingURL();

        }finally {
            driver.quit();
        }
    }

    /**
     * Searching Arganovo Ulje U Spreju
     * Steps:
     * 1. Clicking on a searching field
     * 2.Entering searching parameters in searching field:Arganovo ulje u spreju za sjaj kose OSMO Berber Oil 125ml
     * 3.Clicking Search Submitt Button
     *
     * Expected result: User will be redirected to URL:https://www.alexandar-cosmetics.com/pretraga?term=Arganovo+ulje+u+spreju+za+sjaj+kose+OSMO+Berber+Oil+125ml and item will be shown on that page
     */

    @Test
    public void SearchingArganovoUljeUspreju(){
        WebDriver driver = openChromeDriver();
        try {
            SearchPage searchPage=new SearchPage(driver);
            searchPage.ClickingOnSearchField();
            searchPage.EnteringSearchTextInSearchField();
            searchPage.ClickingOnSearchSubmittButton();
            searchPage.AssertingArganovoUlje();
            searchPage.AssertingUrlArganovoUlje();

        }finally {
            driver.quit();
        }
    }

    /**
     * Searching Arganovo ulje u spreju -Quick Search
     * Steps:
     * 1.Clicking on a Searching field and entering text:Arganovo ulje u spreju za sjaj kose OSMO Berber Oil 125ml
     * 2. Clicking on a Quick Search link
     *
     * Expected result: User will be redirected to a item page with URL:www.alexandar-cosmetics.com/proizvod/arganovo-ulje-u-spreju-za-sjaj-kose-osmo-berber-oil-125ml
     */

    @Test
    public void SearchingAreganovoUljeUSprejuQuickSearch(){
        WebDriver driver = openChromeDriver();
        try {
            SearchPage searchPage=new SearchPage(driver);
            searchPage.ClickingOnSearchField();
            searchPage.EnteringSearchTextInSearchField();
            searchPage.ClickingArganovoULJeQuickSearch();
            searchPage.AssertingQuickSearch();
        }finally {
            driver.quit();
        }

    }

    /**
     * Searching Item That Does Not Exist
     * Steps:
     * 1. Clicking on a search field and entering text: Unknown Item
     * 2. Clicking on a search submitt button
     *
     * Expected result: An Error message will be shown : Nije moguće pronaći proizvod po zadatom kriterijumu. Molimo Vas da promenite neki od zadatih uslova.
     */

    @Test
    public void SearcingUnknownItem(){
        WebDriver driver = openChromeDriver();
        try{
            SearchPage searchPage=new SearchPage(driver);
            searchPage.ClickingOnSearchField();
            searchPage.EnnteringUnknownItemInSearchField();
            searchPage.ClickingOnSearchSubmittButton();
            searchPage.AssertUnknownItem();


        }finally {
            driver.quit();
        }
    }

}
