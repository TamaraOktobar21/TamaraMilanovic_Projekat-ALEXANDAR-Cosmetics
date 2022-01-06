package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class SortingPage extends BasePage {
    //Popisujem elemente s akojima ću da radim

    @FindBy(xpath = "//a[@href='/kosa']/span")
    WebElement KosaButton;

    @FindBy(id = "Filter_sort")
    WebElement SortingButton;


    @FindBy(xpath = "//select[@id=\"Filter_sort\"]/option[@value=\"name_asc\"]")
    WebElement ImeProizvodaAS;

    @FindBy(xpath = "//span[ contains (text(), 'Ime proizvoda A-Š' ) ]")
    WebElement AssertImeProizvodaAS;

    @FindBy(xpath = "//select[@id=\"Filter_sort\"]/option[@value=\"price_desc\"]")
    WebElement CenaOpadajuca;

    @FindBy(xpath = "//*[ contains (text(), 'Klimazon za hemijske tretmane kose Harmony TSM1000' ) ]")
    WebElement OpadajucaPrviElement;

    @FindBy(xpath = "//select[@id=\"Filter_sort\"]/option[@value=\"vp_id_desc\"]")
    WebElement Najnovije;

    @FindBy(xpath = "//*[@id=\"Filter_offer\"]/div[3]/label/div")
    WebElement BestsellerFilter;

    @FindBy(xpath = "//*[@id=\"new-filter-Filter_offer\"]/div/span[contains(text(),'Bestsellers')]")
    WebElement AssertBestseller;

    @FindBy(xpath = "//*[@id=\"Filter_brand\"]/div[18]/label/span[contains(text(),'COLOURLESS')]")
    WebElement ColourlessFilter;

    @FindBy(xpath = "//*[@id=\"new-filter-Filter_brand\"]/div/span[contains(text(),'COLOURLESS')]")
    WebElement AssertingColourless;






    //Konstruktor
    public SortingPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        driver.get(Strings.LOGIN_PAGE_URL);
    }
    //Metode nad webelementima
    public void ClickingOnKosaButton() {
        waitForElement(KosaButton);
        KosaButton.click();
        print("Klik na KosaButton");

    }
    public void ClickingOnSortingButton(){

        SortingButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Filter_sort")));
        print("Klik na dugme za sortiranje");


    }

    public void ClickingOnImeProizvodaAS(){
        ImeProizvodaAS.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeSelected(ImeProizvodaAS));
        print("Sortiranje po imenu od A-Š");
    }

    public void AssertSortingImeProizvodaAS(){
        assert ImeProizvodaAS.isDisplayed();
            if(ImeProizvodaAS.isDisplayed()){
                print("Sortiranje po imenu od A-Š je uspešno");
        }

    }

    public void ClickingCenaOpadajuca(){
        CenaOpadajuca.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeSelected(CenaOpadajuca));
        print("Sortiranje po opadajućoj ceni");

    }

    public void AssertCenaOpadajuca() {
        assert CenaOpadajuca.isDisplayed();
        if (CenaOpadajuca.isDisplayed()) {
            print("Sortiranje po opadajućoj ceni je uspešno");
        }
    }

    public void AssertElementCenaOpadajuca(){
        waitForElement(OpadajucaPrviElement);
        assert OpadajucaPrviElement.isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[ contains (text(), 'Klimazon za hemijske tretmane kose Harmony TSM1000' ) ]")));

    }



    public boolean IsCUrrentURLEqualTo(String expectedurl){
        return driver.getCurrentUrl().equals(expectedurl);
    }

    public void CLickingNajnovije(){
        Najnovije.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeSelected(Najnovije));
        print("Sortiranje po opciji Najnovije");
    }
    public void AssertNajnovije(){
        assert Najnovije.isDisplayed();
        if (Najnovije.isDisplayed()){
            print("Sortiranje po opciji Najnovije je uspešno");
        }


    }
    public void ClickingOnBestsellerFilter(){

        BestsellerFilter.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(BestsellerFilter));
        print("Filtriranje po opciji Bestseller");

    }

    public void AssertBestseller(){
        assert AssertBestseller.isDisplayed();
        if(AssertBestseller.isDisplayed()){
            print("Filtriranje po opciji Bestseller je uspešno ");
        }

    }

    public void ClickinkCOlourlessFIlter(){
        ColourlessFilter.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(ColourlessFilter));
        print("Filtriranje po brendu Colourless");

    }
    public void AssertinColourless(){
        assert AssertingColourless.isDisplayed();
        if(AssertingColourless.isDisplayed()){
            print("Filtriranje po brendu Colourless je uspešno");
        }
    }







}