package pages.base;

import helpers.WebListener;
import models.Product;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.internal.EventFiringMouse;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasePage {

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        action = new Actions(driver);
        wait = new WebDriverWait
                (driver, Duration.ofSeconds(Integer.parseInt(System.getProperty("timeout"))));
        random = new Random();
        webListener = new WebListener();
        eventFiringMouse = new EventFiringMouse(driver, webListener);
        js = (JavascriptExecutor) driver;
        logger = LoggerFactory.getLogger(BasePage.class);
    }

    public WebDriver driver;
    public Actions action;
    public WebDriverWait wait;
    public Random random;
    private WebListener webListener;
    public EventFiringMouse eventFiringMouse;
    protected static Logger logger;
    private JavascriptExecutor js;

    public String getPageTitle() {
        return driver.getTitle().toUpperCase();
    }

    public void sendKeys(WebElement element, String textToSet) {
        element.sendKeys(textToSet);
    }

    public void sendKeysAndClear(WebElement element, String textToSet) {
        element.clear();
        sendKeys(element, textToSet);
    }

    public Select selectForWebElement(WebElement element) {
        return new Select(element);
    }

    public void selectRequestedValue(WebElement element, String value) {
        selectForWebElement(element).selectByVisibleText(value);
    }

    public int randomNumber(int range) {
        return random.nextInt(range);
    }

    public WebElement randomPositionFromList(List<WebElement> element) {
        return element.get(randomNumber(element.size()));
    }

    public List<String> getTextFromElements(List<WebElement> elementList) {
        List<String> newList = new ArrayList<>();
        for (WebElement singleElement : elementList) {
            newList.add(singleElement.getText());
        }
        return newList;
    }

    public Double getPrice(WebElement element) {
        return Double.parseDouble(element.getText().replace(System.getProperty("currencySymbol"), ""));
    }

    public Double getPriceFromFilter(WebElement element, int i) {
        return Double.parseDouble(element.getText()
                .replace(System.getProperty("currencySymbol"), "")
                .split("-")[i]);
    }

    public String getValue(WebElement element) {
        return element.getAttribute("value");
    }

    public void waitToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilDisappear(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public Product createNewProductObject(String productName, Double price, int quantity) {
        return new Product(productName, price, quantity);
    }

    public boolean isElementPresent(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void mouseHover(WebElement element) {
        waitToBeVisible(element);
        Locatable item =(Locatable) element;
        Coordinates coordinates = item.getCoordinates();
        eventFiringMouse.mouseMove(coordinates);
        logger.info("Mouse hover on element " + element.getText());
    }
}
