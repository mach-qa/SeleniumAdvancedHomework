package setup;

import helpers.configuration.factory.DriverSetup;
import helpers.configuration.factory.PropertiesFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    public static WebDriver driver;
    private static DriverSetup driverSetup;
    private static PropertiesFactory propertiesFactory;

    @BeforeAll
    static void setupDriver(){
        propertiesFactory = PropertiesFactory.getInstance();
        driverSetup = new DriverSetup();
        driver.get("http://146.59.32.4/index.php");
    }

    @BeforeEach
    void beforeEach() {
        driver = driverSetup.getDriver();
    }

    @AfterEach
    void exit() {
        driver.quit();
    }
}
