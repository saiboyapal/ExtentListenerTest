package com.crm.qa.tests;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class loginPageTest extends Testbase {
    LoginPage loginPage;
    HomePage homePage;

    public loginPageTest() {
        super();
    }

    @BeforeTest
    public void setUp(){
        System.out.println("this is before test");
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority = 1, description = "Validate login page title")
    public void validateLoginPageTitleTest() throws IOException {
        //test.createNode("validateLoginPageTitleTest");
        String sTitle = loginPage.loginPageTitle();
        //String sFile = TestUtil.getScreenshotAtName("validateLoginPageTitleTest");
        //System.out.println("The screenshot is at " + sFile);
        Assert.assertEquals( sTitle,"Free CRM #1 cloud software for any business big or small");
    }

    @Test(priority = 2, description = "Validate CRM logo")
    public void validateCRMLogoTest(){
        //test.createNode("validateCRMLogoTest");
        Assert.assertTrue(loginPage.crmLogDisplayed());
    }

    @Test(priority = 3, description = "Validate Login feature")
    public void validateLoginTest(){
        //test.createNode("validateLoginTest");
        homePage = loginPage.login(prop.getProperty("emailID"),prop.getProperty("password"));
        String sTitle = homePage.homePageTitle();
        Assert.assertEquals( sTitle,"Cogmento CRM");
    }
    
    @AfterTest
    public void tearDown(){
		driver.close();
		driver.quit();
    }

}
