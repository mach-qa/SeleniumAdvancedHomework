package helpers.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class DriverSetup {
    private WebDriver driver;
    private String browserName;

    public WebDriver getDriver() {
        this.browserName = System.getProperty("browserName");
        switch (browserName) {
            case "chrome":
                ChromeOptions optionsChrome = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                optionsChrome.addArguments("--start-maximized");
                driver = new ChromeDriver(optionsChrome);
                break;
            case "firefox":
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                WebDriverManager.firefoxdriver().setup();
                //optionsFirefox.addArguments("--start-maximized");
                driver = new FirefoxDriver(optionsFirefox);
                driver.manage().window().maximize();
                break;
            default:
                InternetExplorerOptions optionsDefault = new InternetExplorerOptions();
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver(optionsDefault);
                driver.manage().window().maximize();
                break;
        }
        return this.driver;
    }
}
