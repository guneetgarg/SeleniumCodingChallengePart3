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
    PeopleOrganisationsPage peopleOrg;
    CasePage casePage;

    @Test(dataProvider = "getNewPersondata", dataProviderClass = DataProviderClass.class)
    public void Scenario1(String title, String firstName, String lastName, String company, String phone, String email) {

        //Login to capsulecrm
        LoginPage
                .using(driver)
                .login();

        //Clicking people Organisations menu
        dashBoardPage = DashBoardPage.using(driver);
        dashBoardPage.clickPeopleOrganisationsMenu();

        //Adding new person and validating person added successfully
        peopleOrg = PeopleOrganisationsPage.using(driver);
        peopleOrg.clickAddPerson();
        peopleOrg.addPersonDetail(firstName, lastName, company, phone, email);

        dashBoardPage.clickPeopleOrganisationsMenu();
        Assert.assertTrue(peopleOrg.validatePersonCreated(firstName, lastName), "New Person does not created successfullly");

        //Clickig Case menu
        dashBoardPage.clickCasesMenu();

        //Adding New Case and Validating case status
        casePage = CasePage.using(driver);
        casePage.clickAddCaseBtn();

        casePage.addNewCase(firstName + " " + lastName);

        Assert.assertEquals(casePage.getCaseStatus(), "Open", "Status of new case should be open");
        Assert.assertEquals(casePage.getCaseTitle(), "test lost cartest", "case title should match");
        Assert.assertTrue(casePage.getCaseOwner().contains(ActionWrapper.readProprtyFile("capsulecrm_owner")), "Owner Name who created Case should match");
    }
}