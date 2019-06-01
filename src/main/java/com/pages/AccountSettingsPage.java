package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountSettingsPage {

    private WebDriver driver;

    @FindBy(xpath = "//span[text()='Account Settings']")
    private WebElement accountSettingsPageHeader;


    @FindBy(id = "appearance:uploadDecorate:logoImage")
    private WebElement uploadLogo;

    @FindBy(xpath = "//a[@href=\'/settings/users/new\']")
    private WebElement user_AddNewUserBtn;

    @FindBy(id = "register:firstnameDecorate:firstName")
    private WebElement user_firstName;

    @FindBy(id = "register:lastNameDecorate:lastName")
    private WebElement user_lastNamee;

    @FindBy(id = "register:emailDecorate:email")
    private WebElement user_email;

    @FindBy(id = "register:usernameDecorate:username")
    private WebElement user_username;

    @FindBy(id = "register:save")
    private WebElement user_inviteUser;

    //Opportunities
    @FindBy(className = "btn-primary")
    private WebElement opportunities_AddNewMilestone;

    @FindBy(className = "form-input-text milestone-modal-name")
    private WebElement opportunities_Name;

    @FindBy(className = "form-input-text milestone-modal-description")
    private WebElement opportunities_Description;

    @FindBy(className = "form-input-text milestone-modal-probability")
    private WebElement opportunities_ProbabilityOfWinning;

    @FindBy(className = "form-input-text milestone-modal-days-until-stale")
    private WebElement opportunities_DaysUntilStale;

    @FindBy(id = "ember148")
    private WebElement opportunities_saveBtn;

    //Tracks
    @FindBy(xpath = "//a[@href=\'/settings/tracks/opportunities/new\']")
    private WebElement tracks_AddNewTrack;

    @FindBy(id = "j_id123:trackDescriptionDecorate:trackDescription")
    private WebElement tracks_Name;

    @FindBy(id = "j_id123:trackTagDecorate:trackTag")
    private WebElement tracks_Tag;

    @FindBy(xpath = "//a[text()=\'Save\' and @href=\'#\']")
    private WebElement tracks_SaveBtn;

    //Task Categories

    @FindBy(xpath = "//a[text()=\'Add new Category\' and @href=\'#\']")
    private WebElement taskCategories_AddNewCategory;

    @FindBy(id = "editCategoryForm:taskCategoryNameDecorate:taskCategoryName")
    private WebElement taskCategories_Name;

    @FindBy(id = "editCategoryForm:j_id175")
    private WebElement taskCategories_SaveBtn;


    //Tags
    @FindBy(xpath = "//a[text()=\'Add new Tag\' and @href=\'#\']")
    private WebElement tags_AddNewTag;

    @FindBy(id = "j_id177:tagNameDecorate:tagName")
    private WebElement tags_Name;

    @FindBy(xpath = "//input[@value=\'Save\']")
    private WebElement tags_SaveBtn;


    //Integrations
    @FindBy(xpath = "//table[@class=\'recordList\']/descendant::a[text()=\'Configure\']")
    private List<WebElement> integrations_ConfigureBtn;

    private AccountSettingsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public static AccountSettingsPage using(WebDriver driver) {
        return new AccountSettingsPage(driver);
    }

    public WebElement clickMenu(String menu) {
        return driver.findElement(By.xpath("//ul[@class='nav-panel']/descendant::a[text()='" + menu + "']"));
    }

    public WebElement accountSettingsPageHeader() {
        return accountSettingsPageHeader;
    }


}