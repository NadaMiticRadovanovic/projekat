package com.itbootcamo.bgqa.projekat.testovi;

import com.github.javafaker.Faker;
import com.itbootcamo.bgqa.nedelja6.PropertiesReader;
import com.itbootcamo.bgqa.projekat.PostojeciAccount;
import com.itbootcamo.bgqa.projekat.Registration;
import com.itbootcamo.bgqa.projekat.SignUpForm;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

public class TestHomePageSignUpForma {
    private WebDriver driver;
    private SignUpForm signUp;
    private PostojeciAccount postojeciAccount;
    private Registration registration;

    @BeforeMethod
    public void configure() {
        System.out.println("Ovo se izvrsava pre pokretanja test metode");
        System.setProperty("webdriver.chrome.driver",
                PropertiesReader.getInstance().getValue("WEBDRIVER.CHROMEDRIVER"));
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
        signUp = new SignUpForm(driver);
        postojeciAccount = new PostojeciAccount(driver);
        registration = new Registration(driver);

    }


    @Test
    public void testRegistration() {
        Faker faker = new Faker();
        String conformationPassword = faker.funnyName().name();
        registration.getRegistrationLink();
        registration.enterFirstName(Faker.instance().bothify("????????"));
        registration.enterLastName(Faker.instance().bothify("???????"));
        Actions at = new Actions(driver);
        at.sendKeys(Keys.PAGE_DOWN).build().perform();
        registration.enterEmail(Faker.instance().bothify("?????####@gmail.com"));

        registration.enterConfPassword(registration.inputPassword(conformationPassword));
        registration.enterCreateAccountButton();
        //signUp.inputPassword(Faker.instance().bothify("#########"));
    }

    @Test
    public void loginPostojeciAccount() {
        signUp.clickSingUpButton();
        WebElement element = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[2]/div[1]/input[1]"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", element);
        postojeciAccount.postojeciAccount("miticnada87@yahoo.com","Neronero123");
        postojeciAccount.clickSignUpButton();
       // Assert.assertEquals(driver.getTitle(),"Home Page - Magento eCommerce - website to practice selenium");

    }


    @Test
    public void testSignUpFormWithNonExistingUser() {
        signUp.clickSingUpButton();
        signUp.inputEmail(Faker.instance().bothify("?????####@gmail.com"));
        signUp.inputPassword(Faker.instance().bothify("#########"));
        signUp.clickSingUpButton();
        signUp.getAccountNonExistingUserText();
        //   Assert.assertEquals(signUp.getAccountNonExistingUserText());
    }
    @AfterMethod
    public void closeWebDriver() {
        driver.close();
    }

}


