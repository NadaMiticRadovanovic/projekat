package com.itbootcamo.bgqa.projekat;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WomenLinkTop {
    private WebDriver driver;
    private final String MODAL_HEADING_XPATH = "//div[contains(text(),'You need to choose options for your item.')]";
    private final String MODAL_HEADING_TEXT = "You need to choose options for your item.";
    private final String ADD_TO_CART ="/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[5]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/button[1]";
    @FindBy (id = "option-label-size-143-item-166")
    private WebElement size;
    @FindBy (xpath = "//button[@id='product-addtocart-button']")
    private WebElement addCart;
    public WomenLinkTop(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);

    }
    public String getModalTitle() {
        boolean elementFound = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.textToBe(By.xpath(MODAL_HEADING_XPATH), MODAL_HEADING_TEXT));
        WebElement addedText = driver.findElement(By.xpath(MODAL_HEADING_XPATH));
        return addedText.getText();
    }

    public void getToWomenLink() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement women = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[2]/a[1]/span[2]"));
        Actions action = new Actions(driver);
        action.moveToElement(women).perform();
        WebElement top = driver.findElement(By.id("ui-id-9"));
        action.moveToElement(top).click().perform();

    }
    private WebElement getTop(int topNumber) {
        if (topNumber < 2 || topNumber > 12) {
            throw new IllegalArgumentException(String.format("The top number %d is not available", topNumber));
        }
        return driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/ul[1]/li[3]/strong[1]"));
        }
    public void scrollToTop(int topNumber) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", getTop(topNumber));
    }
    public void hoverToWomenTop(int topNumber) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getTop(topNumber)).perform();
    }
    public void clickToAddCartButtonOnItem() {
        Actions actions = new Actions(driver);

        WebElement addToCard = driver.findElement(By.xpath(ADD_TO_CART));
        actions.moveToElement(addToCard).click().perform();
    }
    public void clikOnSize(){
        Actions actions = new Actions(driver);
        actions.moveToElement(size).click().perform();
    }
    public void clickToAddCartButton(){
        Actions actions = new Actions(driver);
        actions.moveToElement(addCart).click().perform();
    }

}
