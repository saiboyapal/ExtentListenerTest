package com.crm.qa.pages;

import com.crm.qa.base.Testbase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Testbase {

    //Webelements
    @FindBy(xpath="//span[contains(text(),'Log In')]")
    WebElement loginBtn;

    @FindBy(xpath="//a[@title='free crm home']")
    WebElement crmLogo;

    @FindBy(name="email")
    WebElement eMail;

    @FindBy(name="password")
    WebElement password;

    @FindBy(xpath="//div[text()='Login']")
    WebElement signInBtn;


    //initialize the page elements
    public LoginPage () {
        PageFactory.initElements(driver, this);
    }

    public String loginPageTitle() {
        return driver.getTitle();
    }

    public boolean crmLogDisplayed() {
        return crmLogo.isDisplayed();
    }

    public HomePage login(String eMailID, String pwd){
        loginBtn.click();
        eMail.sendKeys(eMailID);
        password.sendKeys(pwd);
        signInBtn.click();
        return new HomePage();
    }

}
