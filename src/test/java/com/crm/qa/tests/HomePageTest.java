package com.crm.qa.tests;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest extends Testbase {
    LoginPage loginPage;
    HomePage homePage;
    DealsPage dealsPage;

    public HomePageTest() {
        super();
    }

    @BeforeTest
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("emailID"),prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void validateHomePageTitleTest(){
        String sTitle = homePage.homePageTitle();
        Assert.assertEquals( sTitle,"Cogmento CRM");
    }

    @Test(priority = 2)
    public void validateUsername(){
        String sUserName = homePage.getUsername();
        Assert.assertEquals( sUserName,prop.getProperty("username"));
    }

    @Test(priority = 2)
    public void validateDealsLink(){
        dealsPage = homePage.ckickDealsLink();
    }

    @AfterTest
    public void tearDown(){
		driver.close();
		driver.quit();
    }
}


