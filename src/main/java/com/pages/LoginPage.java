package com.pages;

import com.util.ActionWrapper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    Logger logger = Logger.getLogger(LoginPage.class);


    @FindBy(xpath = "//a[@href='/parties' and @aria-label='People & Organisations']")
    public WebElement peopleOrganisationsMenu;

    public void clickPeopleOrganisationsMenu() {
        peopleOrganisationsMenu.click();
    }





    @FindBy(id = "login:usernameDecorate:username")
    private WebElement userName;

    @FindBy(name = "login:passwordDecorate:password")
    private WebElement password;

    @FindBy(name = "login:login")
    private WebElement loginBtn;

    private LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static LoginPage using(WebDriver driver) {
        return new LoginPage(driver);
    }

    public LoginPage setUsername(String username) {
        this.userName.sendKeys(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        this.password.sendKeys(password);
        return this;
    }

    public void login() {
        this.loginBtn.click();
    }

}
