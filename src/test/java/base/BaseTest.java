package base;

import helpers.driver.DriverSetup;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import providers.PropertiesFactory;
import providers.UrlProvider;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    private static PropertiesFactory propertiesFactory;

    @BeforeAll
    static void setupDriver() {
        propertiesFactory = PropertiesFactory.getInstance();
    }

    @BeforeEach
    void beforeEach() {
        driver = new DriverSetup().getDriver();
        driver.get(UrlProvider.homePage);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }

    @AfterEach
    void exit() {
        driver.quit();
    }
}
