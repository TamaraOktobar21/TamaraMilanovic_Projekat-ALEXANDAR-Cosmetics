package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage{
    @FindBy(xpath = "//*[@id=\"form-autocomplete\"]/div/div/span/input")
    WebElement SearchField;

    @FindBy(xpath="//*[@id=\"form-autocomplete\"]/div/span/button")
    WebElement SearchSubmitButton;

    @FindBy(xpath = "//*[@id=\"product-results\"]")
    WebElement ProductResultLIst;

    @FindBy(xpath = "//*[@id=\"product-results\"]/div/div/div[4]/div[1]/a")
    WebElement ArganovoUljeUSpreju;

    @FindBy(xpath = "//*[@id=\"form-autocomplete\"]/div/div[2]/ul/li[2]/a/span")
    WebElement ArganovoULjeQuickSearch;

    @FindBy(xpath = "//*[@id=\"product-results\"]/div")
    WebElement UnknownResult;





    //Konstruktor
    public SearchPage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        driver.get(Strings.LOGIN_PAGE_URL);
    }
    public void ClickingOnSearchField(){
        SearchField.click();
        print("Klik na polje za pretragu");
    }

    public void ClickingOnSearchSubmittButton(){
        SearchSubmitButton.click();
        print("Klik na dugme za pretragu");
    }

    public void testArrayList(){
        List<WebElement> list=driver.findElements(By.xpath("//div[@class=\"product-name\"]/a[@href]"));
        System.out.println("Size of the link:"+list.size());
        ArrayList<String> linkText=new ArrayList<String>();
        for (WebElement ele: list) {
            try {
                linkText.add(ele.getText());
            } catch (Exception e) {

            }
        }
        for(String i:linkText){
            print(i);
        }
        print("*************************************************************************");
         if (linkText.contains("Baza za šminku sa vitaminom C REVUELE Vitanorm 50ml")){
             print("Lista sadrži željeni element");
         }
         else{
             print("Lista ne sadrži željeni element");
         }

    }

    public void AssertingURL(){
        IsCurrentUrlEqualTo(Strings.BLANK_SEARCH_URL);
    }

    public void EnteringSearchTextInSearchField(){
        print("Unos teksta pretrage:"+Strings.PRETRAGA_ARGANOVO_ULJE_USPREJU);
        SearchField.sendKeys(Strings.PRETRAGA_ARGANOVO_ULJE_USPREJU);
    }
    public void AssertingArganovoUlje(){
        waitForElement(ArganovoUljeUSpreju);
        assert ArganovoUljeUSpreju.isDisplayed();
        if(ArganovoUljeUSpreju.isDisplayed()){
            print("Pretraga je uspešna");
        }
    }

    public void AssertingUrlArganovoUlje(){
        IsCurrentUrlEqualTo(Strings.ARGANOVO_ULJE_USPREJU_PRETRAGA_URL);
    }

    public void ClickingArganovoULJeQuickSearch(){
        waitForElement(ArganovoULjeQuickSearch);
        ArganovoULjeQuickSearch.click();
        print("Klik na brzu pretragu ");
    }

    public void AssertingQuickSearch(){
        IsCurrentUrlEqualTo(Strings.ARGANOVO_ULJE_USPREJU_URL);

    }

    public void EnnteringUnknownItemInSearchField(){
        print("Unos nepoznatog testa pretrage u polje za pretragu");
        SearchField.sendKeys(Strings.PRETRAGA_UNKNOWN_ITEM);

    }

    public void AssertUnknownItem(){
        waitForElement(UnknownResult);
        assert UnknownResult.isDisplayed();
        String UnknowResultMessage=UnknownResult.getText();
        if(UnknowResultMessage.equals(Strings.EXPECTED_UNKNOWN_ITEM_ERROR_MESSAGE)){
            print(Strings.EXPECTED_UNKNOWN_ITEM_ERROR_MESSAGE);
        }
        else{
            print(UnknownResult.getText());
        }

    }









}
