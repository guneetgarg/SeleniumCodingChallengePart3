package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AccountSettingsPage {
    private WebDriver driver;

    private AccountSettingsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public static AccountSettingsPage using(WebDriver driver) {
        return new AccountSettingsPage(driver);
    }

    public WebElement clickMenu(Menu menu) {
        return driver.findElement(By.xpath("//ul[@class='nav-panel']/descendant::a[text()='" + menu + "']"));
    }

    interface Menu {
        String Account = "Account";
        String Invoices = "Invoices";
        String Export = "Export";
        String Appearance = "Appearance";
        String MailDropBox = "Mail Drop Box";
        String Users = "Users";
        String Opportunities = "Opportunities";
        String Tracks = "Tracks";
        String TaskCategories = "Task Categories";
        String CustomFields = "Custom Fields";
        String Tags = "Tags";
        String Integrations = "Integrations";
        String Trash = "Trash";
    }

}
