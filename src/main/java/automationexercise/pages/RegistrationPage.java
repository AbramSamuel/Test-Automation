package automationexercise.pages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class RegistrationPage {
    private WebDriver driver;

    //Locators
    private By genderButton = By.id("id_gender1");
    private By passwordField = By.name("password");
    private By dayDropdown = By.id("days");
    private By monthDropdown = By.id("months");
    private By yearDropdown = By.id("years");
    private By firstNameField = By.id("first_name");
    private By lastNameField = By.id("last_name");
    private By companyField = By.id("company");
    private By address1Field = By.id("address1");
    private By address2Field = By.id("address2");
    private By countryDropdown = By.id("country");
    private By stateField = By.id("state");
    private By cityField = By.id("city");
    private By zipCodeField = By.id("zipcode");
    private By mobileNumberField = By.id("mobile_number");
    private By createAccountButton = By.xpath("//button[text()='Create Account']");
    private By successRegisterMessagetext = By.xpath("//h2[@class='title text-center']");
    private By registrationInformationText = By.xpath("//*[@id='form']/div/div/div/div[1]/h2/b");
    private By continueButton = By.xpath("//a[@class='btn btn-primary']");


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Select gender")
    public RegistrationPage selectGender() {
        driver.findElement(genderButton).click();
        return this;
    }

    @Step("Enter password")
    public RegistrationPage enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    @Step("Select birthdate")
    public RegistrationPage selectBirthdate(String day, String month, String year) {
        new Select(driver.findElement(dayDropdown)).selectByValue(day);
        new Select(driver.findElement(monthDropdown)).selectByValue(month);
        new Select(driver.findElement(yearDropdown)).selectByValue(year);
        return this;
    }

    @Step("Fill in address details")
    public RegistrationPage fillAddressDetails(String firstName, String lastName, String company,
                                               String address1, String address2) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(companyField).sendKeys(company);
        driver.findElement(address1Field).sendKeys(address1);
        driver.findElement(address2Field).sendKeys(address2);
        return this;
    }

    @Step("Select country and state")
    public RegistrationPage selectCountryAndState(String country, String state, String city,
                                                  String zipCode, String mobileNumber) {
        new Select(driver.findElement(countryDropdown)).selectByVisibleText(country);
        driver.findElement(stateField).sendKeys(state);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(zipCodeField).sendKeys(zipCode);
        driver.findElement(mobileNumberField).sendKeys(mobileNumber);
        return this;
    }

    @Step("Click on 'Create Account' button")
    public RegistrationPage clickCreateAccount() {
        driver.findElement(createAccountButton).click();
        return this;

    }

    @Step("Click on 'Continue' button")
    public RegistrationPage clickContinueButton() {
        driver.findElement(continueButton).click();
        return this;
    }

    @Step("Display Signup Page")
    public RegistrationPage assertSignupPageIsDisplayed() {
        Assert.assertEquals(driver.findElement(registrationInformationText).getText(),
                "ENTER ACCOUNT INFORMATION");
        Assert.assertEquals(driver.findElement(createAccountButton).getText(),
                "Create Account");
        return this;

    }

    @Step("Assert Account Created Successfully")
    public RegistrationPage assertAccountCreatedSuccessfully() {
        Assert.assertEquals(driver.findElement(successRegisterMessagetext).getText(),
                "ACCOUNT CREATED!");
        return this;
    }
}
