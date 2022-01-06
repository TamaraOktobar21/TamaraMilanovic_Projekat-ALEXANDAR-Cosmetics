package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.html.HTMLSelectElement;
import org.openqa.selenium.interactions.Actions;
import javax.swing.*;

public class BasePage {
    WebDriver driver = null;
    //treba nam drajver u svakoj klasi , jer nam je neophpodan u konstruktoru kao atribut klase
    // da ga ne bi pisali u svakoj klasi napisaćemo ga u basepageu jer svaka klasa extenduje base page

    //Print Method
    public void print(String text){
        System.out.println(text);

    }
    //pomocne metode
    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void sleep() {

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void Hover(WebDriver driver, WebElement element){

        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public boolean IsCurrentUrlEqualTo(String expectedURL){
        print("IsCurrentURLEqualTo("+expectedURL+")");
        String currentURL= driver.getCurrentUrl();
        print("User is on"+currentURL);
        if(currentURL.equals(expectedURL)){
            print("Current URL match Expected URL");
        }
        else{
            print("Current URL does not match Expected URL");
        }
        boolean b=currentURL.equals(expectedURL);
        return b;

    }









}

