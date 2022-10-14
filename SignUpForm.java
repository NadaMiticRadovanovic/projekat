package com.itbootcamo.bgqa.projekat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

public class SignUpForm {
    private WebDriver driver;
    @FindBy(id = "email")
    private WebElement email1;

    @FindBy(id = "pass")
    private WebElement password;
    @FindBy(id = "send2")
    private WebElement signUpButton;
    @FindBy(xpath = "//body/div[2]/main[1]/div[2]/div[2]/div[1]/div[1]")
    private WebElement accountWrongCredencial;
    public SignUpForm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this); // ucitaj sve elemente na web stranici
    }
    public void inputEmail(String email) {
        this.email1.sendKeys(email);
    }
    public void inputPassword(String password) {
        this.password.sendKeys(password);
    }
    public void clickSingUpButton(){
        this.signUpButton.click();
    }
    public void getAccountNonExistingUserText(){
        this.accountWrongCredencial.getCssValue("message-error error message");

    }

    @AfterMethod
    public void close() {
        driver.close();
    }

}