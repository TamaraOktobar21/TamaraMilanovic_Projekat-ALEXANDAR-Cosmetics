package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingPage extends BasePage{
@FindBy(xpath = "//*[@id=\"product-results\"]/div[1]/div/div[4]/div[1]/a[contains(text(), 'Fen za kosu INFINITY Typhoon 6300 2600W')]")
WebElement FenZaKosu;

@FindBy(xpath = "//*[@id=\"product-detail-page-content\"]/div/div[2]/div[3]/div[3]/div[2]/div[2]/button/em")
WebElement DodajFenUKorpu;

@FindBy(xpath = "/html/body/header/div/div/div[3]/div[3]/div/a/span")
WebElement CartBadge;

@FindBy(xpath = "/html/body/header/div/div/div[3]/div[3]/div/a")
WebElement ShoppingCart;

@FindBy(xpath = "//*[@id=\"cart_item_table_row_91e69fc9-e33d-43c3-a74e-d06bd7815c20\"]/div[2]/a[contains(text(),'Fen za kosu INFINITY Typhoon 6300 2600W Purple ')]")
WebElement AssertFenInTheCart;

@FindBy(xpath = "//button[@class=\"btn btn-link remove-from-cart-ajax-btn\"]")
WebElement RemovingButton;

@FindBy(xpath = "//*[@id=\"cart-wrapper-empty\"]/div/div/div/span")
WebElement KorpaJePraznaMessage;

@FindBy(xpath = "//button[@class=\"btn btn-link cart-preview-remove-from-cart-ajax-btn\"]")
WebElement ShoppingCartPreviewRemoveButton;

@FindBy(xpath = "//*[@id=\"shoppingcart-preview\"]/div[1]/div/div[2]/div[1]/div[1]/div/a")
WebElement ShoppingCartPreviewItem1;

@FindBy(xpath = "//*[@id=\"shoppingcart-preview\"]/h3 ")
WebElement PreviewKorpaJePrazna;

@FindBy(xpath = "//*[@id=\"product-detail-page-content\"]/div/div[2]/div[3]/div[3]/div[2]/div[1]/div/select")
WebElement QuantityDropDown;

@FindBy(xpath = "//*[@id=\"product-detail-page-content\"]/div/div[2]/div[3]/div[3]/div[2]/div[1]/div/select/option[2]")
WebElement Quantity2;

@FindBy(xpath = "//*[@id=\"shoppingcart-preview\"]/div[1]/div[2]/div[2]/div[2]/div[1]/div/div[2]/span")
WebElement FenQuantity2;

@FindBy(xpath = "//*[@id=\"shoppingcart-preview\"]/div[1]/div[2]/div[2]/div[1]/div[1]/div/a")
WebElement FenShoppingCartPreviewItem2;

@FindBy(xpath = "//*[@id=\"cart_item_remove_btn_91e69fc9-e33d-43c3-a74e-d06bd7815c20\"]")
WebElement RemovingButton2Preview;

@FindBy(xpath = "//*[@id=\"form-autocomplete\"]/div/div/span/input")
WebElement SearchField;

@FindBy(xpath = "//*[@id=\"form-autocomplete\"]/div/span/button")
WebElement SearchSubmitButton;



    //Konstruktor
     public ShoppingPage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        driver.get(Strings.INVENTORY_PAGE_KOSA);
    }

    //Metode nad WebElementima
    public void ClickingFenZaKosu(){
        waitForElement(FenZaKosu);
        FenZaKosu.click();
        print("Klik na proizvod Fen za kosu");
    }

    public void ClickingDodajFenUKorpu(){
         waitForElement(DodajFenUKorpu);
         DodajFenUKorpu.click();
         print("Dodavanje Fena za kosu u Korpu");
    }

    public void AssertCartBadge(){
         waitForElement(CartBadge);
         assert CartBadge.isDisplayed();
             if(CartBadge.isDisplayed()){
                 print("Dodavanje predmeta u korpu je uspešno");
        }
    }
    public void ClickingOnShoppingCart(){

         ShoppingCart.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(ShoppingCart));
         print("Klik na ikonicu korpe");

    }
    public void AssertingFenInTheCart(){
         waitForElement(AssertFenInTheCart);
         AssertFenInTheCart.isDisplayed();
         if (AssertFenInTheCart.isDisplayed()){
             print("Dodavanje Fena za kosu u korpu je uspešno");
         }
    }

    public void RemovingFenZaKosuFromTheCart(){
         waitForElement(RemovingButton);
         RemovingButton.click();
         print("Uklanjanje Fena za kosu iz korpe");
    }

    public void AssertKorpaJePraznaMessage(){
         waitForElement(KorpaJePraznaMessage);
         assert KorpaJePraznaMessage.isDisplayed();
         if(KorpaJePraznaMessage.isDisplayed()){
             print("Vaša korpa je prazna");
         }
    }

    public void RemovingItemFromShoppingCartPreview(){

        Hover(driver,ShoppingCart);
        sleep();
        Hover(driver,ShoppingCartPreviewItem1);
        sleep();
         ShoppingCartPreviewRemoveButton.click();
        print("Klik na dugme 'Ukloni'iz ShoppingCartPreview menija");

    }

    public void AssertKorpaJePraznaPreview(){
         waitForElement(PreviewKorpaJePrazna);
         sleep();
          String Trenutna_vrednost=PreviewKorpaJePrazna.getText();
         assert PreviewKorpaJePrazna.isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"shoppingcart-preview\"]/h3 ")));
        print("Trenutan broj proizvoda u korpi je:  " + PreviewKorpaJePrazna.getText());
        if(Trenutna_vrednost.equals(Strings.OCEKIVANI_BROJ_PROIZVODA_PRAZNAKORPA_PREVIEW)){
            print("Korpa je prazna");
        }
        else{
            print("Korpa nije prazna");
        }

    }

    public void ClickingQuanityDropDown(){
         waitForElement(QuantityDropDown);
         QuantityDropDown.click();
         print("Klik na dugme za količinu");
    }

    public void ClickingOnQuantity2(){
         waitForElement(Quantity2);
         sleep();
         Quantity2.click();
         print("KLik na dugme za količinu: 2");
    }

    public void AssertingAddingTwoIdenticalItemsInTheCart(){
         sleep();
         Hover(driver, ShoppingCart);
         sleep();
         assert ShoppingCartPreviewItem1.isDisplayed();
         if(ShoppingCartPreviewItem1.isDisplayed()){
             print("Fen za kosu je dodat u korpu");
         }
         String FenZaKosuDodataKoličina=FenQuantity2.getText();
         print("Trenutno dodatih artikala 'Fen za kosu' je:  "+FenZaKosuDodataKoličina);
         if(FenZaKosuDodataKoličina.equals(Strings.OCEKIVANI_BROJ_PROIZVODA_FEN_ZA_KOSU_U_KORPI)){
             print("U korpu je uspešno dodat Fen za kosu, količina:"+Strings.OCEKIVANI_BROJ_PROIZVODA_FEN_ZA_KOSU_U_KORPI);

         }
         else{
             print("Neuspešno dodavanje zadatog broja artikla u korpu.");
         }

    }
    public void RemovingItems2(){
         sleep();
         Hover(driver,FenShoppingCartPreviewItem2);
         sleep();
        RemovingButton2Preview.click();
        print("Klik na dugme 'Ukloni'iz ShoppingCartPreview menija");
    }

    public void HowerOverShoppingCartIcon(){
         waitForElement(ShoppingCart);
         Hover(driver,ShoppingCart);
    }

    public void ClickingSearchField(){
         SearchField.click();
         print("Klik na polje za pretragu");
    }

    public void EnteringParametersInSearchField(){
         print("Unos teksta pretrage:  "+Strings.PRETRAGA1 +"u polje za pretragu.");
         SearchField.sendKeys(Strings.PRETRAGA1);

    }
    public void ClickingOnSearchButton(){
         SearchSubmitButton.click();
         print("Klik na dugme za pretragu");
    }

    public void AssertSearchResult(){
         waitForElement(FenZaKosu);
         assert FenZaKosu.isDisplayed();
         if(FenZaKosu.isDisplayed()){
             print("Pretraga je uspešna");
         }
         else{
             print("Pretraga po zadatom elementu nije uspešna");
         }
    }


}
