package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PeopleOrganisationsPage {

    @FindBy(xpath = "//div/a[text()='Add Person']")
    private WebElement addPerson;

    private PeopleOrganisationsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static PeopleOrganisationsPage using(WebDriver driver) {
        return new PeopleOrganisationsPage(driver);
    }


    public void clickAddPerson() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        addPerson.click();
    }

}
