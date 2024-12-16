package automationexercise.tests;

import automationexercise.pages.DeleteAccountPage;
import automationexercise.pages.HomePage;
import automationexercise.pages.RegistrationPage;
import automationexercise.pages.SignupPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.DriverFactory;
import utilities.JsonFileManager;
import utilities.PropertiesReader;

public class UserRegistrationTest {

    private WebDriver driver;
    private JsonFileManager userTestData;

    @BeforeClass
    public void setUp() {
        PropertiesReader.loadProperties();
        driver = DriverFactory.initiateDriver(System.getProperty("browser"));
        driver.get(System.getProperty("baseUrl"));
        // Load JSON data
        userTestData = new JsonFileManager(System.getProperty("jsonFilePath"));
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("User Registration Test Cases")
    @Test
    public void userShouldRegisterSuccessfully() {

        // Fluent Design for Test Flow
        new HomePage(driver)
                .assertHomePageIsDisplayed()
                .navigateToSignupLogin()
                .assertHomePageIsDisplayed();

        new SignupPage(driver)
                .assertSignupPageIsDisplayed()
                .enterNameAndEmail(userTestData.getTestData("userSignupData.name"),
                        userTestData.getTestData("userSignupData.email"))
                .clickSignupButton();

        new RegistrationPage(driver)
                .assertSignupPageIsDisplayed()
                .selectGender()
                .enterPassword(userTestData.getTestData("userRegistrationData.password"))
                .selectBirthdate(userTestData.getTestData("userRegistrationData.userBirthdateData.dayOfBirth"),
                        userTestData.getTestData("userRegistrationData.userBirthdateData.monthOfBirth"),
                        userTestData.getTestData("userRegistrationData.userBirthdateData.yearOfBirth"))
                .fillAddressDetails(userTestData.getTestData("userRegistrationData.firstName"),
                        userTestData.getTestData("userRegistrationData.lastName"),
                        userTestData.getTestData("userRegistrationData.companyName"),
                        userTestData.getTestData("userRegistrationData.address1"),
                        userTestData.getTestData("userRegistrationData.address2"))
                .selectCountryAndState(userTestData.getTestData("userRegistrationData.country"),
                        userTestData.getTestData("userRegistrationData.state"),
                        userTestData.getTestData("userRegistrationData.city"),
                        userTestData.getTestData("userRegistrationData.zipCode"),
                        userTestData.getTestData("userRegistrationData.mobileNumber"))
                .clickCreateAccount()
                .assertAccountCreatedSuccessfully()
                .clickContinueButton();

        new DeleteAccountPage(driver)
                .assertDeleteAccountPageIsDisplayed()
                .clickDeleteAccountButton()
                .assertAccountDeletedSuccessfully()
                .clickContinueButton();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}