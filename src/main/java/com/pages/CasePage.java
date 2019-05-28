package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CasePage {

    @FindBy(xpath = "//a[text()='Add Case']")
    private WebElement addCaseBtn;

    @FindBy(id = "partySearch")
    public WebElement caseRelatesTo;

    @FindBy(id = "caseNameDecorate:name")
    private WebElement name;

    @FindBy(id = "caseDescriptionDecorate:description")
    private WebElement description;

    @FindBy(id = "tagsDecorate:tagComboBox")
    private WebElement tag;

    @FindBy(id = "save")
    private WebElement saveBtn;

    private CasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static CasePage using(WebDriver driver) {
        return new CasePage(driver);
    }

    public void clickAddCaseBtn() {
        addCaseBtn.click();
    }

}
