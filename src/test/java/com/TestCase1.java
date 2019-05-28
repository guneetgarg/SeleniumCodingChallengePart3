package com;

import com.pages.*;
import com.util.ActionWrapper;
import com.util.BaseTest;
import com.util.DataProviderClass;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class TestCase1 extends BaseTest {

    ActionWrapper actionWrapper = new ActionWrapper();


    @Test(dataProvider = "getNewPersondata", dataProviderClass = DataProviderClass.class)
    public void aa(String title, String firstName, String lastName, String company, String phone, String email) throws InterruptedException {
        driver.get(actionWrapper.readProprtyFile("capsulecrm_url"));

        Thread.sleep(5000);

        LoginPage
                .using(driver)
                .setUsername(actionWrapper.readProprtyFile("capsulecrm_username"))
                .setPassword(actionWrapper.readProprtyFile("capsulecrm_password"))
                .login();

        DashBoardPage
                .using(driver)
                .clickPeopleOrganisationsMenu();

        PeopleOrganisationsPage.using(driver).clickAddPerson();

        NewPersonPage page = NewPersonPage
                .using(driver);

        page.setFirstName(firstName);
        page.setLastName(lastName);
        page.setOrganisation(company);
        page.setPhoneNumber(phone);
        page.setEmail(email);
        page.clickSaveBtn();

        Thread.sleep(5000);
        DashBoardPage.using(driver).clickCasesMenu();

        Thread.sleep(5000);

        CasePage casePage = CasePage.using(driver);
        casePage.clickAddCaseBtn();
        Thread.sleep(5000);

        casePage.caseRelatesTo.sendKeys("Guneet Garg");
        Thread.sleep(5000);

        casePage.caseRelatesTo.sendKeys(Keys.ARROW_DOWN);
        casePage.caseRelatesTo.sendKeys(Keys.ENTER);



    }
}
