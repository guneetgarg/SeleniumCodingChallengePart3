package com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CasePage {

    @FindBy(xpath = "//a[text()='Add Case']")
    private WebElement addCaseBtn;

    @FindBy(id = "partySearch")
    private WebElement caseRelatesTo;

    @FindBy(id = "caseNameDecorate:name")
    private WebElement name;

    @FindBy(id = "caseDescriptionDecorate:description")
    private WebElement description;

    @FindBy(id = "tagsDecorate:tagComboBox")
    private WebElement tag;

    @FindBy(xpath = "//input[@class='btn-secondary btn-small addTagButton']")
    private WebElement addTagBtn;

    @FindBy(id = "save")
    private WebElement saveBtn;


    @FindBy(xpath = "//div[@class='kase-summary-status float-left']/span")
    private WebElement caseStatus;

    @FindBy(xpath = "//div[@class='entity-details-title']")
    private WebElement caseTitle;



    @FindBy(xpath = "//div[@class='entity-details-owner']")
    private WebElement caseOwner;




    private CasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static CasePage using(WebDriver driver) {
        return new CasePage(driver);
    }

    public void clickAddCaseBtn() {
        addCaseBtn.click();
    }












    public void setCaseRelatesTo(String str) {
        caseRelatesTo.sendKeys(str);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        caseRelatesTo.sendKeys(Keys.ARROW_DOWN);
        caseRelatesTo.sendKeys(Keys.ENTER);
    }

    public void setName(String str) {
        name.sendKeys(str);
    }

    public void clickSaveBtn() {
        saveBtn.click();
    }
    public void setDescription(String str){
        description.sendKeys(str);
    }

    public void setTag(String str){
        tag.sendKeys(str);
    }
    public void clickAddTagBtn(){
        addTagBtn.click();
    }

    public String getCaseStatus(){
       return caseStatus.getText();
    }

    public String getCaseTitle(){
        return  caseTitle.getText();
    }

    public String getCaseOwner(){
        return caseOwner.getText();
    }

}
