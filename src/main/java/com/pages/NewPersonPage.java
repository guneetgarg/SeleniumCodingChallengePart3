package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewPersonPage {

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


    private NewPersonPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static NewPersonPage using(WebDriver driver) {
        return new NewPersonPage(driver);
    }

    public void setTitle(String str) {
        title.sendKeys(str);
    }

    public void setFirstName(String str) {
        firstName.sendKeys(str);
    }

    public void setLastName(String str) {
        lastName.sendKeys(str);
    }

    public void setJobTitle(String str) {
        jobTitle.sendKeys(str);
    }

    public void setOrganisation(String str) {
        o‌rganisation.sendKeys(str);
    }

    public void setTags(String str) {
        tags.sendKeys(str);
    }

    public void setAddTag(String str) {
        addTag.sendKeys(str);
    }

    public void setPhoneNumber(String str) {
        phoneNumber.sendKeys(str);
    }

    public void setEmail(String str) {
        email.sendKeys(str);
    }

    public void clickSaveBtn() {
        saveBtn.click();
    }
}
