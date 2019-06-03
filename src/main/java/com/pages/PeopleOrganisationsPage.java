package com.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.PageFactory.initElements;

public class PeopleOrganisationsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    Logger logger = Logger.getLogger(PeopleOrganisationsPage.class);

    private PeopleOrganisationsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 1000);
    }

    public static PeopleOrganisationsPage using(WebDriver driver) {
        return new PeopleOrganisationsPage(driver);
    }

    @FindBy(xpath = "//div/a[text()='Add Person']")
    private WebElement addPerson;

    @FindBy(xpath = "//table/descendant::td[@class='list-results-cell is-party is-system is-summary ember-view']/a")
    private List<WebElement> nameTable;

    public void clickAddPerson() {
        wait.until(ExpectedConditions.elementToBeClickable(addPerson));
        addPerson.click();
    }


    public boolean validatePersonCreated(String firtName, String lastName) {
        wait.until(ExpectedConditions.visibilityOfAllElements(nameTable));
        for (WebElement list : nameTable) {
            System.out.println(list.getText());
            if (list.getText().equalsIgnoreCase(firtName + " " + lastName)) {
                return true;
            }
        }
        return false;
    }

    //People & Organisations ->New Person
    @FindBy(id = "party:fnDecorate:fn")
    private WebElement firstName;

    @FindBy(id = "party:j_id108:j_id116")
    private WebElement title;
    @FindBy(id = "party:lnDecorate:ln")
    private WebElement lastName;

    @FindBy(id = "party:roleDecorate:jobTitle")
    private WebElement jobTitle;

    @FindBy(id = "party:orgDecorate:org")
    private WebElement o‌rganisation;

    @FindBy(id = "party:tagsDecorate:tagComboBox")
    private WebElement tags;

    @FindBy(id = "party:tagsDecorate:j_id187")
    private WebElement addTag;

    @FindBy(id = "party:j_id325:0:phnDecorate:number")
    private WebElement phoneNumber;

    @FindBy(id = "party:j_id342:0:emlDecorate:nmbr")
    private WebElement email;

    @FindBy(id = "party:save")
    private WebElement saveBtn;

    public void setTitle(String str) {
        title.sendKeys(str);
    }

    public void setFirstName(String str) {
        logger.info("Entering firstname in textbox: " + str);
        firstName.sendKeys(str);
    }

    public void setLastName(String str) {
        logger.info("Entering last name in textbox: " + str);
        lastName.sendKeys(str);
    }

    public void setJobTitle(String str) {
        jobTitle.sendKeys(str);
    }

    public void setOrganisation(String str) {
        logger.info("Entering company name in textbox: " + str);
        o‌rganisation.sendKeys(str);
    }

    public void setTags(String str) {
        tags.sendKeys(str);
    }

    public void setAddTag(String str) {
        addTag.sendKeys(str);
    }

    public void setPhoneNumber(String str) {
        logger.info("Entering phone number in textbox: " + str);
        phoneNumber.sendKeys(str);
    }

    public void setEmail(String str) {
        logger.info("Entering email id in textbox: " + str);
        email.sendKeys(str);
    }

    public void clickSaveBtn() {
        saveBtn.click();
    }


    public void addPersonDetail(String firstName, String lastName, String company, String phone, String email) {
        logger.info("Adding Person Detail in form");
        setFirstName(firstName);
        setLastName(lastName);
        setOrganisation(company);
        setPhoneNumber(phone);
        setEmail(email);
        clickSaveBtn();
    }

}
