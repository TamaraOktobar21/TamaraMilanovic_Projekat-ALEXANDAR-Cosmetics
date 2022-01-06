package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;


public class LinkPage extends BasePage{

    @FindBy(xpath = "/html/body/footer/div[1]/div[1]/div/div[5]/div[2]/ul/li[1]/a")
    WebElement FacebookIcon;

    @FindBy(xpath = "/html/body/footer/div[1]/div[1]/div/div[5]/div[2]/ul/li[2]/a")
    WebElement InstagramIcon;

    @FindBy(xpath="/html/body/footer/div[1]/div[2]/div/div/div[2]/ul/li[7]/a")
    WebElement BancaIntesaIcon;

    //Konstruktor
    public LinkPage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        driver.get(Strings.LOGIN_PAGE_URL);
    }

    public void ClickingFacebookIcon(){
        Hover(driver,FacebookIcon);
        String clicklink= Keys.chord(Keys.CONTROL,Keys.ENTER);
        FacebookIcon.sendKeys(clicklink);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/footer/div[1]/div[1]/div/div[5]/div[2]/ul/li[1]/a")));
        print("Klik na Facebook ikonicu na početnoj strani");
        sleep();
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        String URL= driver.getCurrentUrl();

        driver.switchTo().window(newTab.get(1));

        print("Currnet URl: "+URL);

    }

    public void AssertationFacebookLink(){
        sleep();

        IsCurrentUrlEqualTo(Strings.FACEBOOK_LINK_URL);

    }
    public void ClickingInstagramIcon(){
        Hover(driver,InstagramIcon);
        String clicklink= Keys.chord(Keys.CONTROL,Keys.ENTER);
        InstagramIcon.sendKeys(clicklink);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/footer/div[1]/div[1]/div/div[5]/div[2]/ul/li[2]/a")));
        print("Klik na Instagram ikonicu na početnoj strani");
        sleep();
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        String URL= driver.getCurrentUrl();

        driver.switchTo().window(newTab.get(1));

        print("Currnet URl: "+URL);
    }

    public void AssertInstagramLink(){
        sleep();
        IsCurrentUrlEqualTo(Strings.INSTAGRAM_LINK_URL);
    }

    public void ClickingBancaIntesaIcon(){
        Hover(driver,BancaIntesaIcon);
        String clicklink= Keys.chord(Keys.CONTROL,Keys.ENTER);
        BancaIntesaIcon.sendKeys(clicklink);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/footer/div[1]/div[2]/div/div/div[2]/ul/li[7]/a")));
        print("Klik na Instagram ikonicu na početnoj strani");
        sleep();
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        String URL= driver.getCurrentUrl();

        driver.switchTo().window(newTab.get(1));

        print("Currnet URl: "+URL);
    }

    public void AssertingBancaIntesaLink(){
        sleep();
        IsCurrentUrlEqualTo(Strings.BNCA_INTESA_LINK_URL);
    }
}
