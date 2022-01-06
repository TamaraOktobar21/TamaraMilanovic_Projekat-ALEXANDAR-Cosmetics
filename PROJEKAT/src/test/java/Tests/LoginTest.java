package Tests;

import Pages.LoginPage;
import Pages.Strings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;


public class LoginTest extends BaseTest {
    /**
     * Login test with valid Username and Password
     * Steps:
     * 1. Navigate to loginpageURL
     * 2. Click User Avatar Button
     * 3.Enter valid Username in Username Field
     * 4.Enter valid Password in Password Field
     * 5.Click 'Prijavi se' button
     * <p>
     * Expected result: User is logged in and UserName will appear next to Avatar button
     */


    @Test
    public void LoginWithValidUsernameAndPassword() {
        WebDriver driver = openChromeDriver();
        try {

            LoginPage loginPage = new LoginPage(driver);//da bis e inicijalizovali elementi
            loginPage.clickingUserAvatarButton();
            loginPage.enterTextInUsernameField(Strings.VALID_USERNAME);
            loginPage.enterTextInPasswordField(Strings.VALID_PASSWORD);
            loginPage.clickingPrijaviSeButton();
            loginPage.assertUserName();


        } finally {
            driver.quit();
        }

    }

    /**
     * Login With Invalid Username And Password
     * Steps:
     * 1. Navigate to loginpageURL
     * 2. Click on User Avatar Button
     * 3.Enter Valid Username in Username Field
     * 4.Enter Valid Password in Passwod Field
     * 5.Click on 'Prijavi se' Button
     * <p>
     * Expected result: User is not logged. Error is appeared with text :"Korisnik nije pronađen"
     */
    @Test
    public void LoginWithInvalidUsernameAndPassword() {
        WebDriver driver = openChromeDriver();
        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.clickingUserAvatarButton();
            loginPage.enterTextInUsernameField(Strings.INVALID_USERNAME);
            loginPage.enterTextInPasswordField(Strings.INVALID_PASSWORD);
            loginPage.clickingPrijaviSeButton();
            loginPage.assertLoginError();
            loginPage.assertKorisnikNijePronadjen();


        } finally {
            driver.quit();
        }
    }

    /**
     * Login With Valid Username And Invalid Password
     * Steps:
     * 1.Navigate to loginpageURL
     * 2.Click on User Avatar Button
     * 3.Enter valid Username in Username Field
     * 4.Enter Invalid Password in Password Field
     * 5.Click on "Prijavi se" Button
     * <p>
     * Expected result: User is not logged in. Error message has appeared : "Lozinka nije validna"
     */
    @Test
    public void LoginWithValidUsernameAndInvalidPassword() {
        WebDriver driver = openChromeDriver();
        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.clickingUserAvatarButton();
            loginPage.enterTextInUsernameField(Strings.VALID_USERNAME);
            loginPage.enterTextInPasswordField(Strings.INVALID_PASSWORD);
            loginPage.clickingPrijaviSeButton();
            loginPage.assertLoginError();
            loginPage.assertLozinkNijeValidna();


        } finally {
            driver.quit();
        }

    }

    /**
     * Login with invalid username and valid password
     * Steps:
     * 1.Navigate to loginpageURL
     * 2.CLick on User Avatar Button
     * 3.Enter Invalid Username in Username Field
     * 4.Enter Valid Password in Password Field
     * 5. Click on "Prijavi se" Button
     * <p>
     * Expected result: Error message has appeared: "Korisnik nije pronađen"
     */
    @Test
    public void LoginWithInvalidUsernameAndValidPassword() {
        WebDriver driver = openChromeDriver();
        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.clickingUserAvatarButton();
            loginPage.enterTextInUsernameField(Strings.INVALID_USERNAME);
            loginPage.enterTextInPasswordField(Strings.VALID_PASSWORD);
            loginPage.clickingPrijaviSeButton();
            loginPage.assertLoginError();
            loginPage.assertKorisnikNijePronadjen();
        } finally {
            //driver.quit();
        }
    }

    /**
     * Login with valid username and valis password from different valid account
     * Steps:
     * 1. Navigate to loginpageURL
     * 2.Click on User Avatar Button
     * 3.Enter valid username in Username Field
     * 4.Enter valid password from different valid account
     * 5.CLick on "Prijavi se" Button
     * <p>
     * Expected resuld: User is not logged in. Error message has appeared: lozinka nije validna
     */
    @Test
    public void LoginWithValidUsernameAndValidPasswordFromDifferentValidAccount() {
        WebDriver driver = openChromeDriver();
        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.clickingUserAvatarButton();
            loginPage.enterTextInUsernameField(Strings.INVALID_USERNAME);
            loginPage.enterTextInPasswordField(Strings.VALID_PASSWORD1);
            loginPage.clickingPrijaviSeButton();
            loginPage.assertLoginError();


        } finally {
            driver.quit();
        }
    }
}





