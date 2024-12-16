package automationexercise.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DeleteAccountPage {
    private WebDriver driver;

    // Locators
    private By deleteAccountButton = By.xpath("//i[@class='fa fa-trash-o']");
    private By continueButton = By.xpath("//a[@class='btn btn-primary']");
    private By deletePageImage = By.xpath("//*[@id='header']/div/div/div/div[1]/div/a/img");
    private By successDeleteMessageText = By.xpath("//h2[@class='title text-center']");


    // Constructor
    public DeleteAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click on 'Delete Account' button")
    public DeleteAccountPage clickDeleteAccountButton() {
        driver.findElement(deleteAccountButton).click();
        return this;
    }


    @Step("Click on 'Continue' button")
    public DeleteAccountPage clickContinueButton() {
        driver.findElement(continueButton).click();
        return this;
    }

    public DeleteAccountPage assertDeleteAccountPageIsDisplayed() {
        Assert.assertTrue(driver.findElement(deleteAccountButton).isDisplayed(),
                "Delete Account Page is not displayed.");
        Assert.assertTrue(driver.findElement(deletePageImage).isDisplayed(),
                "Delete Account Page is not displayed.");
        return this;
    }

    @Step("Assert account deleted successfully")
    public DeleteAccountPage assertAccountDeletedSuccessfully() {
        Assert.assertEquals(driver.findElement(successDeleteMessageText).getText(),
                "ACCOUNT DELETED!");
        return this;

    }
}
