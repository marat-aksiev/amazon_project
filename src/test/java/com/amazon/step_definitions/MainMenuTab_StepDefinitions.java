package com.amazon.step_definitions;

import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainMenuTab_StepDefinitions {
    @Given("user is on the homepage")
    public void user_is_on_the_homepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @Then("verify all the main menu items are displayed")
    public void verify_all_the_main_menu_items_are_displayed(List<String> expectedItems) {
        for (String eachExpectedItem : expectedItems) {
            WebElement actualItem = Driver.getDriver().findElement(By.xpath("//div[@id='nav-xshop-container']//a[.='"+eachExpectedItem+"']"));
            Assert.assertTrue(actualItem.isDisplayed());
            Assert.assertTrue(actualItem.isEnabled());
            Assert.assertEquals(eachExpectedItem, actualItem.getText());
        }
    }


}
