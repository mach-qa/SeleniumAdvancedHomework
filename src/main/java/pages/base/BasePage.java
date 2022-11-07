package pages.base;

import helpers.locators.ByFinder;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage {

    public BasePage(WebDriver driver) {
        PageFactory.initElements(new FieldContextDecorator(new ElementContextLocatorFactory(
                driver, Duration.ofSeconds(20), Arrays.asList(StaleElementReferenceException.class,
                ElementNotSelectableException.class ))), this);;
        this.driver = driver;
        action = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(System.getProperty("timeout"))));
        random = new Random();
    }

    public WebDriver driver;
    public Actions action;
    public WebDriverWait wait;
    public Random random;


    //SendKeys
    public void sendKeys(WebElement element, String textToSet) {
        element.sendKeys(textToSet);
    }
    public void sendKeysAndClear(WebElement element, String textToSet) {
        element.clear();
        sendKeys(element, textToSet);
    }

    //Features for List Type
    public int sizeOfList(List<WebElement> element) {
        return element.size();
    }
    public WebElement randomPositionFromList(List<WebElement> element) {
        int sizeOfList = sizeOfList(element);
        return element.get(random.nextInt(sizeOfList));
    }
    public boolean compareProductsInList(List<WebElement> element) {
        for (WebElement product : element) {
            if (product.getText().contains(System.getProperty("searchInput"))) {
                System.out.println("Product on List: " + product.getText());
                continue;
            } else return false;
        }
        return true;
    }
    public List<String> stringListOfProducts(List<WebElement> elementList) {
        List<String> productList = null;
        for (WebElement product : elementList) {
            product.getText();
            productList.add(product.getText());
        }
        return productList;
    }

    //GET Features
    public double getPrice(WebElement element) {
        return Double.parseDouble(element.getText().replace(System.getProperty("currencySymbol"), ""));
    }
    public String getValue(WebElement element) {
        return element.getAttribute("value");
    }

    //Wait Methods
    public void waitToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitOfElementLocated (WebElement element) {
        By byFromWebElement = new ByFinder().getByFromWebElement(element);
        wait.until(ExpectedConditions.presenceOfElementLocated(byFromWebElement));
    }

    //Slider Methods
    public void moveSlider(WebElement slider, WebElement button, int position) {
        Actions move = new Actions(driver);

        int width = slider.getSize().getWidth();
        move.clickAndHold(button).moveByOffset(((width * (-100 + position)) / 100), 0).release().build().perform();
    }

    public void moveFilterSliderToRequestedValue (WebElement sliderButton, WebElement priceRange) {
        for (int i = 0; i < 50; i++) {
            waitOfElementLocated(sliderButton);
            action.clickAndHold(sliderButton).sendKeys(Keys.ARROW_LEFT).perform();
            if (priceRange.getText().equals(System.getProperty("priceFilterTag"))) {
                break;
            }
        }
    }

    //Action Methods
}
