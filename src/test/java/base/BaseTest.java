package base;

import helpers.driver.DriverSetup;
import providers.PropertiesFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    public WebDriver driver;
    private static DriverSetup driverSetup;
    private static PropertiesFactory propertiesFactory;

    @BeforeAll
    static void setupDriver(){
        propertiesFactory = PropertiesFactory.getInstance();
        driverSetup = new DriverSetup();
    }

    @BeforeEach
    void beforeEach() {
        driver = driverSetup.getDriver();
        driver.get("http://146.59.32.4/index.php");
    }

    @AfterEach
    void exit() {
        driver.quit();
    }
}
