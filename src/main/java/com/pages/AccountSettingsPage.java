package com.pages;

import com.util.ActionWrapper;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.InputStream;
import java.util.List;

public class AccountSettingsPage {

    private WebDriver driver;
    Logger logger = Logger.getLogger(AccountSettingsPage.class);


    @FindBy(xpath = "//span[text()='Account Settings']")
    private WebElement accountSettingsPageHeader;

    @FindBy(id = "appearance:uploadDecorate:logoImage")
    private WebElement uploadLogo;


    //Users
    @FindBy(xpath = "//a[@href='/settings/users/new']")
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


    public void addNewUser() {
        Fairy fairy = Fairy.create();
        Person person = fairy.person();

        user_AddNewUserBtn.click();
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfAllElements(user_firstName));
        user_firstName.sendKeys(person.getFirstName());
        user_lastNamee.sendKeys(person.getLastName());
        user_email.sendKeys(person.getEmail());
        user_username.sendKeys(person.getUsername());
        user_inviteUser.click();
    }


    //Opportunities
    @FindBy(className = "btn-primary")
    private WebElement opportunities_AddNewMilestone;

    @FindBy(xpath = "//input[@class='form-input-text milestone-modal-name']")
    private WebElement opportunities_Name;

    @FindBy(xpath = "//textarea[@class='form-input-text milestone-modal-description']")
    private WebElement opportunities_Description;

    @FindBy(xpath = "//input[@class='form-input-text milestone-modal-probability']")
    private WebElement opportunities_ProbabilityOfWinning;

    @FindBy(xpath = "//input[@class='form-input-text milestone-modal-days-until-stale']")
    private WebElement opportunities_DaysUntilStale;

    @FindBy(xpath = "//button[@type='submit' and text()='Save']")
    private WebElement opportunities_saveBtn;

    public void opportunitiesAddNewMilestones() {
        Fairy fairy = Fairy.create();
        Person person = fairy.person();

        opportunities_AddNewMilestone.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        opportunities_Name.sendKeys(person.getUsername());
        opportunities_Description.sendKeys(person.getAddress().getAddressLine1());
        opportunities_ProbabilityOfWinning.sendKeys("1");
        opportunities_DaysUntilStale.sendKeys("1");
        opportunities_saveBtn.click();
    }


    //Tracks
    @FindBy(xpath = "//a[@href=\'/settings/tracks/opportunities/new\']")
    private WebElement tracks_AddNewTrack;

    @FindBy(id = "j_id123:trackDescriptionDecorate:trackDescription")
    private WebElement tracks_Name;

    @FindBy(id = "j_id123:trackTagDecorate:trackTag")
    private WebElement tracks_Tag;

    @FindBy(xpath = "//a[text()=\'Save\' and @href=\'#\']")
    private WebElement tracks_SaveBtn;

    public void tracksAddNewTrack() {
        Fairy fairy = Fairy.create();
        Person person = fairy.person();

        tracks_AddNewTrack.click();
        tracks_Name.sendKeys(person.getFirstName());
        tracks_Tag.sendKeys("car");
        tracks_SaveBtn.click();
    }

    //Task Categories

    @FindBy(xpath = "//a[text()='Add new Category' and @href='#']")
    private WebElement taskCategories_AddNewCategory;

    @FindBy(id = "editCategoryForm:taskCategoryNameDecorate:taskCategoryName")
    private WebElement taskCategories_Name;

    @FindBy(id = "editCategoryForm:j_id175")
    private WebElement taskCategories_SaveBtn;

    public void taskCategoriesAddNewCategory() {
        taskCategories_AddNewCategory.click();

        try {
            Thread.sleep(5000);
        } catch (Exception e) {

        }

        taskCategories_Name.sendKeys("aa");
        taskCategories_SaveBtn.click();
    }

    //Tags
    @FindBy(xpath = "//a[text()=\'Add new Tag\' and @href=\'#\']")
    private WebElement tags_AddNewTag;

    @FindBy(id = "j_id177:tagNameDecorate:tagName")
    private WebElement tags_Name;

    @FindBy(xpath = "//input[@value=\'Save\']")
    private WebElement tags_SaveBtn;

    public void tagsAddNewTag() {
        tags_AddNewTag.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tags_Name.sendKeys("aa");
        tags_SaveBtn.click();
    }


    //Integrations
    @FindBy(xpath = "//table[@class=\'recordList\']/descendant::a[text()=\'Configure\']")
    private List<WebElement> integrations_ConfigureBtn;

    public int countIntegrationsConfigure() {
        System.out.println("***************" + integrations_ConfigureBtn.size());
        return integrations_ConfigureBtn.size();
    }


    //header ->account
    @FindBy(xpath = "//h1[@class='settings-page-header']")
    private WebElement accountHeader;

    //header -> invoices
    @FindBy(xpath = "//header[@class='page-box-header']")
    private WebElement invoicesHeader;

    @FindBy(xpath = "//h1[@class='settings-page-header']")
    private WebElement exportHeader;


    //header -> Appearance
    @FindBy(xpath = "//h1[@class='settings-page-header']")
    private WebElement appearanceHeader;

    //header -> Mail Drop Box
    @FindBy(xpath = "//h2[@class='settings-page-header']")
    private WebElement mailDropBoxHeader;

    //header -> Users
    @FindBy(xpath = "//h2[@class='settings-page-header']")
    private WebElement usersHeader;


    //header -> Opportunities
    @FindBy(xpath = "//header[@class='page-box-header']")
    private WebElement opportunitiesHeader;

    //header -> Tracks
    @FindBy(xpath = "//h2[@class='settings-page-header']")
    private WebElement tracksHeader;

    //header -> Task Categories
    @FindBy(xpath = "//h2[@class='settings-page-header']")
    private WebElement taskCategoriesHeader;

    //header -> Custom Fields
    @FindBy(xpath = "//h2[@class='settings-page-header']")
    private WebElement customFieldsHeader;

    //header -> Tags
    @FindBy(xpath = "//h2[@class='settings-page-header']")
    private WebElement tagsAndDataTagsHeader;

    //header -> Integrations
    @FindBy(xpath = "//h2[@class='settings-page-header']")
    private WebElement integrationsHeader;

    //header -> Trash
    @FindBy(xpath = "//h2[@class='settings-page-header']")
    private WebElement trashHeader;


    private AccountSettingsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public static AccountSettingsPage using(WebDriver driver) {
        return new AccountSettingsPage(driver);
    }

    public void clickMenu(String menu) {
        logger.info("Clicking Menu " + menu + " Locator is: " + " //ul/li/a[normalize-space(text()='" + menu + "')]");

        WebElement element = driver.findElement(By.xpath("//ul/li/a[normalize-space(text())='" + menu + "']"));
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public WebElement accountSettingsPageHeader() {
        return accountSettingsPageHeader;
    }


    public String getAccountHeader() {
        return accountHeader.getText();
    }

    public String getInvoicesHeader() {
        return invoicesHeader.getText();
    }

    public String getExportHeader() {
        return exportHeader.getText();
    }

    public String getAppearanceHeader() {
        return appearanceHeader.getText();
    }


    public String getMailDropBoxHeader() {
        return mailDropBoxHeader.getText();
    }


    public String getUsersHeader() {
        return usersHeader.getText();
    }


    public void uploadImageInAppearance() {
        driver
                .findElement(By.id("appearance:uploadDecorate:logoImage"))
                .sendKeys(System.getProperty("user.dir") + "\\src\\main\\resources\\img.jpg");
        driver
                .findElement(By.xpath("//a[contains(text(),'Save')]")).click();

    }


}