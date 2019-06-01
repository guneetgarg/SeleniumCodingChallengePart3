package com;

import com.pages.*;
import com.util.ActionWrapper;
import com.util.BaseTest;
import com.util.DataProviderClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase2 extends BaseTest {

    ActionWrapper actionWrapper;


    @Test(dataProvider = "getNewPersondata", dataProviderClass = DataProviderClass.class)
    public void aa(String title, String firstName, String lastName, String company, String phone, String email) throws InterruptedException {
        driver.get(actionWrapper.readProprtyFile("capsulecrm_url"));

        Thread.sleep(5000);

        LoginPage
                .using(driver)
                .setUsername(actionWrapper.readProprtyFile("capsulecrm_username"))
                .setPassword(actionWrapper.readProprtyFile("capsulecrm_password"))
                .login();


        Thread.sleep(5000);

        DashBoardPage.using(driver).accountDrpDown.click();
        Thread.sleep(5000);
        DashBoardPage.using(driver).accountSettingsMenu.click();

        AccountSettingsPage ASP = AccountSettingsPage.using(driver);
        Assert.assertEquals(ASP.accountSettingsPageHeader().getText(), "Account Settings");


        ASP.clickMenu(AccountSettingsPageMenu.Account).click();
        Thread.sleep(5000);

        ASP.clickMenu(AccountSettingsPageMenu.Invoices).click();
        Thread.sleep(5000);
/*

        ASP.clickMenu(AccountSettingsPage.Menu.Export).click();
        Thread.sleep(5000);

        ASP.clickMenu(AccountSettingsPage.Menu.Appearance).click();
        Thread.sleep(5000);

        ASP.clickMenu(AccountSettingsPage.Menu.MailDropBox).click();
        Thread.sleep(5000);

        ASP.clickMenu(AccountSettingsPage.Menu.Users).click();
        Thread.sleep(5000);

        ASP.clickMenu(AccountSettingsPage.Menu.Opportunities).click();
        Thread.sleep(5000);

        ASP.clickMenu(AccountSettingsPage.Menu.Tracks).click();
        Thread.sleep(5000);

        ASP.clickMenu(AccountSettingsPage.Menu.TaskCategories).click();
        Thread.sleep(5000);

        ASP.clickMenu(AccountSettingsPage.Menu.CustomFields).click();
        Thread.sleep(5000);

        ASP.clickMenu(AccountSettingsPage.Menu.Tags).click();
        Thread.sleep(5000);

        ASP.clickMenu(AccountSettingsPage.Menu.Integrations).click();
        Thread.sleep(5000);

        ASP.clickMenu(AccountSettingsPage.Menu.Trash).click();

*/

    }
}