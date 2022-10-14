package com.itbootcamo.bgqa.projekat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage1 {
    private WebDriver driver;

    public HomePage1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }



}
