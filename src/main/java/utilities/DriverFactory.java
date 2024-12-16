package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

public class DriverFactory {

    static WebDriver driver;

    public static WebDriver initiateDriver(String browserType) {
        if ("chrome".equalsIgnoreCase(browserType)) {
            System.out.println("Initializing Chrome Browser on OS: " +
                    System.getProperty("os.name") + " and its version is: "
                    + System.getProperty("os.version"));
            driver = new ChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browserType)) {
            System.out.println("Initializing Firefox Browser on OS: " +
                    System.getProperty("os.name") + " and its version is: "
                    + System.getProperty("os.version"));
            driver = new FirefoxDriver();
        } else if ("edge".equalsIgnoreCase(browserType)) {
            System.out.println("Initializing Edge Browser on OS: " +
                    System.getProperty("os.name") + " and its version is: "
                    + System.getProperty("os.version"));
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser type: " + browserType);
        }
        configureDriver(Boolean.parseBoolean(System.getProperty("maximizing")), Integer.parseInt(System.getProperty("waitingTime")));
        return driver;
    }

    private static void configureDriver(boolean maximize, int waitTime) {

        if (maximize) {
            driver.manage().window().maximize();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));

    }


}

