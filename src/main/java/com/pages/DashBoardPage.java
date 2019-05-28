package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {

    @FindBy(xpath = "//a[@id='ember18' and @aria-label='People & Organisations']")
    private WebElement peopleOrganisationsMenu;

    @FindBy(xpath = "//a[@href='/cases']")
    private WebElement casesMenu;

    @FindBy(xpath = "//li[@class='menu']")
    private WebElement menu;

    @FindBy(xpath = "//li/a[text()='Account Settings']")
    private WebElement accountSettingsMenu;


    private DashBoardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static DashBoardPage using(WebDriver driver) {
        return new DashBoardPage(driver);
    }

    public void clickPeopleOrganisationsMenu() {
        peopleOrganisationsMenu.click();
    }


    public void clickCasesMenu() {
        casesMenu.click();
    }
}
