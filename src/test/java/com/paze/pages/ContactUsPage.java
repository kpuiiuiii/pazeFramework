package com.paze.pages;

import com.paze.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends MainPage {


    public ContactUsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//select[@name='paze_segmentSelect']")
    public WebElement distributorField;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement fNameField;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lNameField;

    @FindBy(xpath = "//input[@name='mobilePhone']")
    public WebElement phoneField;

    @FindBy(xpath = "//input[@name='emailAddress']")
    public WebElement emailField;

    @FindBy(xpath = "//input[@name='company']")
    public WebElement companyField;

    @FindBy(xpath = "//input[@name='title']")
    public WebElement titleField;
    @FindBy(xpath = "//input[@value='Submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//span[contains(text(), 'Please use a business email address.')]")
    public WebElement messageAlert;


}
