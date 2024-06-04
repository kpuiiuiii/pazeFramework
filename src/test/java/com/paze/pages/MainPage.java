package com.paze.pages;

import com.paze.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class MainPage {

    public MainPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//button[@id='hs-eu-confirmation-button']")
    public WebElement cookieButton;


    @FindBy(xpath = "//iframe[@style='display: none;']")
    public WebElement iframe;







}
