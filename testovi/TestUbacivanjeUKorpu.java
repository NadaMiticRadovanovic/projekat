package com.itbootcamo.bgqa.projekat.testovi;

import com.itbootcamo.bgqa.nedelja6.PropertiesReader;
import com.itbootcamo.bgqa.projekat.WomenLinkTop;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestUbacivanjeUKorpu {


    private WebDriver driver;
    private final static String MODAL_TITLE_EXPECTED ="You need to choose options for your item.";
    private WomenLinkTop womenLinkTop;
    private final String ADD_TO_CART = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[6]/div[1]/div[1]/div[4]/div[1]/div[1]/form[1]/button[1]";

    @BeforeMethod
    public void configure() {
        System.out.println("Ovo se izvrsava pre pokretanja test metode");
        System.setProperty("webdriver.chrome.driver",
                PropertiesReader.getInstance().getValue("WEBDRIVER.CHROMEDRIVER"));
        driver = new ChromeDriver();
        womenLinkTop = new WomenLinkTop(driver);
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void testGetWomenTopInCart() {
        womenLinkTop.getToWomenLink();
        womenLinkTop.scrollToTop(5);
        womenLinkTop.hoverToWomenTop(5);
        Actions at = new Actions(driver);
        at.sendKeys(Keys.PAGE_DOWN).build().perform();
        womenLinkTop.clickToAddCartButtonOnItem();
        womenLinkTop.clikOnSize();

      //  womenLinkTop.clickToAddCartButton();

      //  Assert.assertEquals(womenLinkTop.getModalTitle(),MODAL_TITLE_EXPECTED,"The text should be added");


    }
    @AfterMethod
    public void closeWebDriver() {
        driver.close();
    }

}


