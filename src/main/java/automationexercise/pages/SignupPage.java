package automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignupPage {
    private WebDriver driver;
    private By nameField = By.name("name");
    private By emailField = By.xpath("//*[@id='form']/div/div/div[3]/div/form/input[3]");
    private By signupButton = By.xpath("//button[@data-qa='signup-button']");
    private By signupPageTitle = By.xpath("//h2[contains(text(),'New User Signup!')]");

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    public SignupPage enterNameAndEmail(String name, String email) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        return this;

    }

    public SignupPage clickSignupButton() {
        driver.findElement(signupButton).click();
        return this;

    }

    public SignupPage assertSignupPageIsDisplayed() {
        Assert.assertTrue(driver.findElement(signupPageTitle).isDisplayed(),
                "Signup Page is not displayed.");
        return this;

    }
}
