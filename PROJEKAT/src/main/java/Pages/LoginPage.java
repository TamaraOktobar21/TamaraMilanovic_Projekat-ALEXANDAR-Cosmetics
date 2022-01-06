package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    // Popisujem Webelemente sa kojima ću da radim
    @FindBy(xpath = "//div[@class=\"user-avatar\"]")
    WebElement UserAvatarButton;

    @FindBy(id = "username")
    WebElement usernameTextField;

    @FindBy(id = "password")
    WebElement passwordTextField;

    @FindBy(id = "_submit")
    WebElement PrijaviteSeButton;

    @FindBy(xpath = "//div[@class=\"user-container\"]/span[contains(.,'Ivana')]")
    WebElement UserName;

    @FindBy(xpath = "//div[@class=\"login-errors\"]")
    WebElement LoginError;

    @FindBy(xpath = "//*[ contains (text(), 'Korisnik nije pronađen' ) ]")
    WebElement KorisnikNijePronadjen;

    @FindBy(xpath = "//*[ contains (text(), 'Lozinka nije validna' ) ]")
    WebElement LozinkaNijeValidna;







    //Moram da definišem konstruktor svake naše klase da bi se kreirali svi web elementi


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);//ovaj deo koda inicijalizuje objekte svih definisanih vebelemenata na ovoj stranici
        driver.get(Strings.LOGIN_PAGE_URL);


    }

    //metode nad webelementima
    public void clickingUserAvatarButton() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(UserAvatarButton));
        print("Klik na dugme prijavi se na početnoj strani");
        UserAvatarButton.click();
    }

    public void enterTextInUsernameField(String text) {
        waitForElement(usernameTextField);
        print("Unos korisničkog imena:" + text + " u Username polje");
        usernameTextField.click();
        usernameTextField.sendKeys(text);

    }


    public void enterTextInPasswordField(String text) {
        waitForElement(passwordTextField);
        print("Unos lozinke:" + text + "u polje Password");
        passwordTextField.click();
        passwordTextField.sendKeys(text);


    }

    public void clickingPrijaviSeButton() {
        print("Klik na dugme Prijavi se");
        PrijaviteSeButton.click();
    }

    public void assertUserName(){
        waitForElement(UserName);
        print("Da li je prijavljivanje na sajt uspešno:");
        assert UserName.isDisplayed();
        if (UserName.isDisplayed()){
            print("Prijavljivanje je uspešno");
        }
    }
    public void assertLoginError(){
        waitForElement(LoginError);
        assert LoginError.isDisplayed();
        if(LoginError.isDisplayed()){
            print("Prijavljivanje je neuspešno");
        }
    }
    public void assertKorisnikNijePronadjen(){
        waitForElement(KorisnikNijePronadjen);
        assert KorisnikNijePronadjen.isDisplayed();
        if (KorisnikNijePronadjen.isDisplayed()){
            print("Korisnik nije pronađen");

        }
    }
    public void assertLozinkNijeValidna(){
        waitForElement(LozinkaNijeValidna);
        assert LozinkaNijeValidna.isDisplayed();
        if (LozinkaNijeValidna.isDisplayed()){
            print("Lozinka nije validna");
        }
    }









    //pomocne metode
    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void sleep() {

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}



