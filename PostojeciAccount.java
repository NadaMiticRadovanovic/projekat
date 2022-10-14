package com.itbootcamo.bgqa.projekat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PostojeciAccount {
    private WebDriver driver;
    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "pass")
    private WebElement password;
    @FindBy(id = "send2")
    private WebElement signUpButton;

    public PostojeciAccount(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void postojeciAccount(String email, String password){
    this.email.sendKeys(email);
    this.password.sendKeys(password);

    }
    public void clickSignUpButton(){
    this.signUpButton.click();
    }
}
