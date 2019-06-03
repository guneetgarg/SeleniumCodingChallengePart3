package com;

import com.pages.*;
import com.util.ActionWrapper;
import com.util.BaseTest;
import com.util.DataProviderClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase2 extends BaseTest {

    AccountSettingsPage ASP;

    @Test
    public void Scenario2() throws InterruptedException {

        //Login to capsulecrm
        LoginPage
                .using(driver)
                .login();

        //Navigating to Account Setting Page
        DashBoardPage
                .using(driver)
                .navigateToAccountSettingPage();

        ASP = AccountSettingsPage
                .using(driver);

        //Validating Account Setting Header
        Assert.assertEquals(ASP.accountSettingsPageHeader().getText(), "Account Settings", "Verify Account Setting Page Header");

        //Clicking Account Menu and Validating Header
        ASP.clickMenu(AccountSettingsPageMenu.Account);
        Assert.assertEquals(ASP.getAccountHeader(), AccountSettingsPageMenu.Account, "Verifying Accounts Header");

        //Clicking Invoices Menu and Validating Header
        ASP.clickMenu(AccountSettingsPageMenu.Invoices);
        Assert.assertEquals(ASP.getInvoicesHeader(), AccountSettingsPageMenu.Invoices, "Verifying Invoices Header");

        //Clicking Export Menu and Validating Header
        ASP.clickMenu(AccountSettingsPageMenu.Export);
        Assert.assertEquals(ASP.getExportHeader(), AccountSettingsPageMenu.Export, "Verifying Export Header");

        //Clicking Appearance Menu and Validating Header
        ASP.clickMenu(AccountSettingsPageMenu.Appearance);
        Assert.assertEquals(ASP.getAppearanceHeader(), AccountSettingsPageMenu.Appearance, "Verifying Appearance Header");

        //Uploading image
        ASP.uploadImageInAppearance();

        //Clicking Mail Drop Box Menu and Validating Header
        ASP.clickMenu(AccountSettingsPageMenu.MailDropBox);
        Assert.assertEquals(ASP.getMailDropBoxHeader(), AccountSettingsPageMenu.MailDropBox, "Verifying Mail Drop Box Header");

        //Clicking UserMenu and Validating Header
        ASP.clickMenu(AccountSettingsPageMenu.Users);
        Assert.assertEquals(ASP.getUsersHeader(), AccountSettingsPageMenu.Users, "Verifying Users Header");
        //Adding New User
        ASP.addNewUser();

        ASP.clickMenu(AccountSettingsPageMenu.Opportunities);
        ASP.opportunitiesAddNewMilestones();

        ASP.clickMenu(AccountSettingsPageMenu.Tracks);
        ASP.tracksAddNewTrack();

        ASP.clickMenu(AccountSettingsPageMenu.TaskCategories);
        ASP.taskCategoriesAddNewCategory();

        ASP.clickMenu(AccountSettingsPageMenu.CustomFields);

        ASP.clickMenu(AccountSettingsPageMenu.Tags);
        ASP.tagsAddNewTag();

        ASP.clickMenu(AccountSettingsPageMenu.Integrations);

        ASP.clickMenu(AccountSettingsPageMenu.Trash);

    }
}