package com;

import com.pages.*;
import com.util.ActionWrapper;
import com.util.BaseTest;
import com.util.DataProviderClass;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase1 extends BaseTest {


    DashBoardPage dashBoardPage;
    PeopleOrganisationsPage peopleOrganisations;


    @Test(dataProvider = "getNewPersondata", dataProviderClass = DataProviderClass.class)
    public void aa(String title, String firstName, String lastName, String company, String phone, String email) throws InterruptedException {

        LoginPage
                .using(driver)
                .setUsername(ActionWrapper.getInstance().readProprtyFile("capsulecrm_username"))
                .setPassword(ActionWrapper.getInstance().readProprtyFile("capsulecrm_password"))
                .login();

        dashBoardPage = DashBoardPage.using(driver);
        dashBoardPage.clickPeopleOrganisationsMenu();

        peopleOrganisations = PeopleOrganisationsPage.using(driver);
        peopleOrganisations.clickAddPerson();

        peopleOrganisations.setFirstName(firstName);
        peopleOrganisations.setLastName(lastName);
        peopleOrganisations.setOrganisation(company);
        peopleOrganisations.setPhoneNumber(phone);
        peopleOrganisations.setEmail(email);
        peopleOrganisations.clickSaveBtn();

        dashBoardPage.clickPeopleOrganisationsMenu();


        Thread.sleep(5000);
        System.out.println(peopleOrganisations.validatePersonCreated(firstName, lastName));
        dashBoardPage.clickCasesMenu();
        CasePage casePage = CasePage.using(driver);
        casePage.clickAddCaseBtn();


        Thread.sleep(5000);


        casePage.setCaseRelatesTo(firstName + " " + lastName);
        casePage.setName("test lost cartest");
        casePage.setDescription("test");
        casePage.setTag("car");
        casePage.clickAddTagBtn();
        casePage.clickSaveBtn();

        Assert.assertEquals(casePage.getCaseStatus(), "Open", "Status of new case should be open");
        Assert.assertEquals(casePage.getCaseTitle(), "test lost cartest", "case title should match");
        Assert.assertTrue(casePage.getCaseOwner().contains(ActionWrapper.getInstance().readProprtyFile("capsulecrm_owner")), "Owner Name who created Case should match");

    }
}