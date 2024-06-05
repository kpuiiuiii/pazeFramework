package com.paze.pages;

import com.paze.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class MainPage {

    public MainPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }







}
