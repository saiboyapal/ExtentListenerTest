package com.crm.qa.tests;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.Testutils;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ContactsPageTest extends Testbase{
    LoginPage loginPage;
    HomePage homePage;
    DealsPage dealsPage;
    ContactsPage contactsPage;

    public ContactsPageTest() {
            super();
        }


    @BeforeTest
    public void setUp(){
       initialization();
       loginPage = new LoginPage();
       homePage = loginPage.login(prop.getProperty("emailID"),prop.getProperty("password"));
       contactsPage = homePage.cickContactsLink();
    }


    @Test(priority = 1)
    public void validateHeader(){
        String sHeader = contactsPage.getHeader();
        Assert.assertEquals( sHeader,"Contacts");
    }

   /* @Test(priority = 2, dataProvider="getCRMTestData")
    public void validateAddContacts(String fName, String lName, String cName){
        contactsPage.addContact( fName, lName, cName);
    }*/


    @Test(priority = 3)
    public void validateContactsTable(){
        contactsPage.getTableData();
        Assert.assertTrue(contactsPage.tableVisible());
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
