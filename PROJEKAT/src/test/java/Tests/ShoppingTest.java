package Tests;

import Pages.ShoppingPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ShoppingTest extends BaseTest{
    /**
     * Adding Fen za kosu to the cart
     * Steps:
     * 1.Navigate to INVENTORY_PAGE_KOSA
     * 2.Cick 'Fen za kosu INFINITY Typhoon' on inventory page
     * 3.Click 'Dodaj u korpu' on the item page
     *
     * Expected result: Item should be added to the cart and Shopping cart badge should be showing number notification.
     */
    @Test
    public void AddingFenZaKosuToCart(){
        WebDriver driver = openChromeDriver();
        try {
            ShoppingPage shoppingPage=new ShoppingPage(driver);
            shoppingPage.ClickingFenZaKosu();
            shoppingPage.ClickingDodajFenUKorpu();
            shoppingPage.AssertCartBadge();
            shoppingPage.ClickingOnShoppingCart();
            shoppingPage.AssertingFenInTheCart();




        }finally {
           // driver.quit();
        }
    }

    /**
     * Removing Fen za Kosu from the Cart
     * Steps:
     * 1.Navigate to INVENTORY_PAGE_KOSA
     * 2. Cick 'Fen za kosu INFINITY Typhoon' on inventory page
     * 3.Click 'Dodaj u korpu' on the item page
     * 4.Click on SHopping cart icon
     * 5.Click on 'x' to remove item from the cart
     *
     * Expected result: Message 'Korpa je prazna' should appear on the screen and item should be removed from the cart.
     */
    @Test
    public void RemovingFenZaKosuFromTheCart(){
        WebDriver driver = openChromeDriver();
        try {
            ShoppingPage shoppingPage=new ShoppingPage(driver);
            shoppingPage.ClickingFenZaKosu();
            shoppingPage.ClickingDodajFenUKorpu();
            shoppingPage.ClickingOnShoppingCart();
            shoppingPage.RemovingFenZaKosuFromTheCart();
            shoppingPage.AssertKorpaJePraznaMessage();

        }finally {
            //driver.quit();
        }

    }

    /** Removing Fen za kosu from the cart from Shopping cart preview
     * Steps:
     * 1. Navigate to INVENTORY_PAGE_KOSA and add Fen za kosu INFINITY Typhoon to the cart.
     * 2. Hover mouse over shopping cart icon to open preview
     * 3. Hover mouse over item in preview
     * 4. Click on 'Ukloni' button next to a item in preview
     *
     * Expected result: Message '0 proizvoda u korpi' should appear and item should be removed from the cart.
     */
    @Test
    public void RemovingFenZaKosuFromTheCartFromCartPrewiew(){
        WebDriver driver = openChromeDriver();
        try{
            ShoppingPage shoppingPage=new ShoppingPage(driver);
            shoppingPage.ClickingFenZaKosu();
            shoppingPage.ClickingDodajFenUKorpu();
            shoppingPage.RemovingItemFromShoppingCartPreview();
            shoppingPage.AssertKorpaJePraznaPreview();


        }finally {
            //driver.quit();
        }
    }

    /** Adding and removing two identical items from the cart
     *Steps:
     * 1.Navigate to INVENTORY_PAGE_KOSA and click on the Fen za kosu INFINITY Typhoon
     * 2. Click on Quantity dropdown meny and choose quantity:2
     * 3. Click on 'Dodaj u korpu' button
     * 4.Hover mouse over SHopping cart icon
     * 5.Hover mouse over item and click on 'Ukloni' button next to item
     *
     * Expected result: Item of quantity 2 should be added in the cart and then removed. Message '0 proizvoda u korpi' should appear.
     */
    @Test
    public void AddingAndRemovingTwoIdenticalProductsFromTheCart(){
        WebDriver driver = openChromeDriver();
        try {
            ShoppingPage shoppingPage=new ShoppingPage(driver);
            shoppingPage.ClickingFenZaKosu();
            shoppingPage.ClickingQuanityDropDown();
            shoppingPage.ClickingOnQuantity2();
            shoppingPage.ClickingDodajFenUKorpu();
            shoppingPage.AssertingAddingTwoIdenticalItemsInTheCart();
            shoppingPage.RemovingItems2();
            shoppingPage.HowerOverShoppingCartIcon();
            shoppingPage.AssertKorpaJePraznaPreview();


        }finally {
            //driver.quit();
        }
    }

    /** SearchAndAddItemToTheCart
     * Steps:
     * 1.Clicking on the search field and entering searching credentials
     * 2.Clicking on searching button
     * 3.Clicking on 'Fen za kosu INFINITY Typhoon 6300 2600W' and adding item to the cart
     *
     *Expected result: Searched item should appear as a result of the search and it should be able add it to the cart.
     *                  As a result of adding item to the cart shopping cart badge will show notification:'1' and item would be added in the shopping cart.
     */
    @Test
    public void SearchAndAddItemToTheCart(){
        WebDriver driver = openChromeDriver();
        try{
            ShoppingPage shoppingPage=new ShoppingPage(driver);
            shoppingPage.ClickingSearchField();
            shoppingPage.EnteringParametersInSearchField();
            shoppingPage.ClickingOnSearchButton();
            shoppingPage.AssertSearchResult();
            shoppingPage.ClickingFenZaKosu();
            shoppingPage.ClickingDodajFenUKorpu();
            shoppingPage.AssertCartBadge();
            shoppingPage.ClickingOnShoppingCart();
            shoppingPage.AssertingFenInTheCart();

        }finally {
            //driver.quit();
        }
    }
}
