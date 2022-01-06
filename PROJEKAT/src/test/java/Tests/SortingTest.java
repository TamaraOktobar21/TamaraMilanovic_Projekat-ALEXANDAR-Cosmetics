package Tests;

import Pages.LoginPage;
import Pages.SortingPage;
import Pages.Strings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SortingTest extends BaseTest {
    /**
     * Sorting By Name from A-Š/Kosa section
     * Steps:
     * 1. Navigate to LOGIN_PAGE_URL
     * 2. CLick on Kosa button
     * 3. Click on Sorting Button
     * 4. Choose sort by:"Ime proizvoda A-Š" from a drop down menu
     * <p>
     * Expected result: User is redirected to INVENTORY_PAGE_KOSA and items are sorted by name from A to Š
     */
    @Test
    public void SortingByNameFromAtoS() {
        WebDriver driver = openChromeDriver();
        try {
            SortingPage sortingPage = new SortingPage(driver);
            sortingPage.ClickingOnKosaButton();
            sortingPage.ClickingOnSortingButton();
            sortingPage.ClickingOnImeProizvodaAS();
            assert sortingPage.IsCUrrentURLEqualTo(Strings.INVENTORY_PAGE_KOSA) : "Wrong URL";
            sortingPage.AssertSortingImeProizvodaAS();


        } finally {
            driver.quit();
        }
    }

    /**
     * Sorting items by "Cena opadajuća"/Kosa section
     * Steps:
     * 1. Navigate to LOGIN_PAGE_URL
     * 2. Click on Kosa button
     * 3. Click on Sorting Button
     * 4.Choose  "Cena Opadajuća" from drop down menu
     * <p>
     * Expected result: User shpould be redirected to INVENTORY_PAGE_URL and items should be sorted by price from high to low.
     */
    @Test
    public void SortingByCenaProizvodaOpadajuća() {
        WebDriver driver = openChromeDriver();
        try {
            SortingPage sortingPage = new SortingPage(driver);
            sortingPage.ClickingOnKosaButton();
            sortingPage.ClickingOnSortingButton();
            sortingPage.ClickingCenaOpadajuca();
            assert sortingPage.IsCUrrentURLEqualTo(Strings.INVENTORY_PAGE_KOSA) : "Wrong URL";
            sortingPage.AssertCenaOpadajuca();
            sortingPage.AssertElementCenaOpadajuca();


        } finally {
            //driver.quit();
        }
    }

    /**
     * Sorting by Najnovije
     * Steps:
     * 1. CLick on "Kosa" button
     * 2.Click on Sorting button
     * 3.Choose "Najnovije" from a dropdown menu
     *
     * Expected result: Items on the page are sorted by newest item, and option "Najnovije" is selected.
     */
    @Test
    public void SortingByNajnovije() {
        WebDriver driver = openChromeDriver();
        try {
            SortingPage sortingPage = new SortingPage(driver);
            sortingPage.ClickingOnKosaButton();
            sortingPage.ClickingOnSortingButton();
            sortingPage.CLickingNajnovije();
            assert sortingPage.IsCUrrentURLEqualTo(Strings.INVENTORY_PAGE_KOSA) : "Wrong URL";
            sortingPage.AssertNajnovije();


        } finally {
            //driver.quit();
        }
    }

    /**
     * Filter by Bestsellers
     * Steps:
     * 1. Navigate to LOGIN_PAGE_URL
     * 2. Clicking on "Kosa" button
     * 3. Clicking on Bestsellers filter
     *
     *Expected result: Items on the page are Filtered by Bestsellers, and Bestsellers checkbox is selected, and notification that this option is selected appeared on the screen.
     *
     */
    @Test
    public void FilterByBestseller() {
        WebDriver driver = openChromeDriver();
        try {
            SortingPage sortingPage = new SortingPage(driver);
            sortingPage.ClickingOnKosaButton();
            sortingPage.ClickingOnBestsellerFilter();
            sortingPage.AssertBestseller();
        } finally {
            //driver.quit();
        }


    }

    /**
     * Filter by brand Colourless
     * Steps:
     * 1.Clicking on 'Kosa' button
     * 2. Clicking on checkbox of Colourless filter in Brand filters
     *
     * Expected result: Items on the page should be filtered by brand Colourless, and filter notification should be displayed.
     */
    @Test
    public void FilterByBrandColourless(){
        WebDriver driver = openChromeDriver();
        try{
            SortingPage sortingPage = new SortingPage(driver);
            sortingPage.ClickingOnKosaButton();
            sortingPage.ClickinkCOlourlessFIlter();
            sortingPage.AssertinColourless();

        }finally {
            //driver.quit();
        }

    }
}