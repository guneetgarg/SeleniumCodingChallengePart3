package com.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoardPage {
    Logger logger = Logger.getLogger(DashBoardPage.class);

    private WebDriver driver;

    @FindBy(xpath = "//a[@href='/parties' and @aria-label='People & Organisations']")
    private WebElement peopleOrganisationsMenu;

    @FindBy(xpath = "//a[@href='/cases']")
    private WebElement casesMenu;

    @FindBy(xpath = "//div[@class='nav-bar-account-details']")
    private WebElement accountDrpDown;

    @FindBy(xpath = "//a[@href='/settings'] ")
    private WebElement accountSettingsMenu;


    private DashBoardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public static DashBoardPage using(WebDriver driver) {
        return new DashBoardPage(driver);
    }

    public void clickPeopleOrganisationsMenu() {
        logger.info("Navigating to People & Organisations By clicking on top menu");
        peopleOrganisationsMenu.click();
    }

    public void clickCasesMenu() {
        logger.info("Navigating to Cases By clicking on top menu");
        casesMenu.click();
    }

    public void clickAccountDrpDown() {
        logger.info("Navigating to Account Setting Page");
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.elementToBeClickable(accountDrpDown));
        accountDrpDown.click();
    }

    public void navigateToAccountSettingPage(){
        clickAccountDrpDown();
        accountSettingsMenu.click();
    }

}
