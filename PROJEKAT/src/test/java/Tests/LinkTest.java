package Tests;

import Pages.LinkPage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LinkTest extends BaseTest{
    /**
     * Facebook Link test
     * Steps:
     * 1. Click on Facebook button in footer of the main page
     *
     * Expected result: User will be redirected to a new Facebook page with URL:"https://www.facebook.com/alexandar.cosmetics"
     */
    @Test
    public void FaceebokLinkTest(){
        WebDriver driver = openChromeDriver();
        try {
            LinkPage linkPage=new LinkPage(driver);
            linkPage.ClickingFacebookIcon();
            linkPage.AssertationFacebookLink();

        }finally {
            driver.quit();
        }
    }

    /**
     * Instagram Link Test
     * Steps:
     * 1. Click on Instagram Button on the main page
     *
     * Expected result: User will be redirected to a new Instagram page with URL: "https://www.instagram.com/alexandarcosmetics/"
     *
     */

    @Test
    public void InstagramLinkTest(){
        WebDriver driver = openChromeDriver();
        try {
            LinkPage linkPage=new LinkPage(driver);
            linkPage.ClickingInstagramIcon();
            linkPage.AssertInstagramLink();


        }finally {
            driver.quit();
        }

    }

    /**
     * BancaIntesa Link Test
     * 1. Click on the BancaIntesa button on the footer of the main page
     *
     * Expected result: User will be rediredted on a new window with URL:"https://www.bancaintesa.rs/"
     */

    @Test
    public void BancaIntesaLinkTest(){
        WebDriver driver = openChromeDriver();
        try {
            LinkPage linkPage=new LinkPage(driver);
            linkPage.ClickingBancaIntesaIcon();
            linkPage.AssertingBancaIntesaLink();


        }finally {
            driver.quit();
        }
    }
}
