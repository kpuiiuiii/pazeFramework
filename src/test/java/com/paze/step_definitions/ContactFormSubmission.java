package com.paze.step_definitions;

import com.github.javafaker.Faker;
import com.paze.pages.ContactUsPage;
import com.paze.utilities.ConfigurationReader;
import com.paze.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactFormSubmission {
    Faker faker;
    ContactUsPage cp = new ContactUsPage();

    Select select;
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));

    @Given("the user is on the {string} page")
    public void the_user_is_on_the_page(String string) {

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        Assert.assertEquals(Driver.getDriver().getTitle(), ("Paze Questions? Want to Contact Us? Visit Our Help Center!"));

    }

    @When("the user enters random test data for the form")
    public void the_user_enters_random_test_data_for_the_form() {
        cp = new ContactUsPage();
        select = new Select(cp.distributorField);
        faker = new Faker();

        wait.until(ExpectedConditions.elementToBeClickable(cp.distributorField));
        select.selectByIndex(1);

        wait.until(ExpectedConditions.elementToBeClickable(cp.fNameField));
        cp.fNameField.sendKeys(faker.name().firstName());

        wait.until(ExpectedConditions.elementToBeClickable(cp.lNameField));
        cp.lNameField.sendKeys(faker.name().lastName());

        wait.until(ExpectedConditions.elementToBeClickable(cp.phoneField));
        cp.phoneField.sendKeys(faker.phoneNumber().cellPhone());

        //wait.until(ExpectedConditions.elementToBeClickable(cp.emailField));
        //cp.emailField.sendKeys(faker.internet().emailAddress());

        wait.until(ExpectedConditions.elementToBeClickable(cp.companyField));
        cp.companyField.sendKeys(faker.company().name());

        wait.until(ExpectedConditions.elementToBeClickable(cp.titleField));
        cp.titleField.sendKeys(faker.name().title());


    }

    @When("the user presses the {string} button")
    public void the_user_presses_the_button(String submit) {
        cp = new ContactUsPage();
        wait.until(ExpectedConditions.elementToBeClickable(cp.submitButton));
        cp.submitButton.click();

    }


    @Then("the user should see a message")
    public void theUserShouldSeeAMessage() throws InterruptedException {
        String message = cp.messageAlert.getText();
        Assert.assertEquals("Please include your Email Address", message);
        Assert.assertEquals(Driver.getDriver().getTitle(), ("Paze Questions? Want to Contact Us? Visit Our Help Center!"));

        Thread.sleep(4000);
        Driver.getDriver().quit();
    }
}
