package automationexercise.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
    private WebDriver driver;
    private By signupLoginButton = By.xpath("//i[@class='fa fa-lock']");
    private By homePageImage = By.xpath("//img[@alt='Website for automation practice']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Go to Signup page")
    public HomePage navigateToSignupLogin() {
        driver.findElement(signupLoginButton).click();
        return this;
    }

    @Step("Assert that the home page is displayed")
    public HomePage assertHomePageIsDisplayed() {
        Assert.assertTrue(driver.findElement(homePageImage).isDisplayed(),
                "Home Page is not displayed.");
        return this;
    }
}

